package com.nmhung.api;

import com.nmhung.config.FileConfig;
import com.nmhung.model.ClassModel;
import com.nmhung.model.RoomModel;
import com.nmhung.model.RoomTimeModel;
import com.nmhung.service.ClassService;
import com.nmhung.service.RoomService;
import com.nmhung.service.RoomTimeService;
import com.nmhung.utils.DateUtils;
import com.nmhung.utils.POIUtils;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;

@RestController
public class DownloadAPI {
    @Autowired
    private ServletContext context;

    @Autowired
    private RoomTimeService roomTimeService;

    @Autowired
    RoomService roomService;

    @Autowired
    ClassService classService;

    @GetMapping("/api/download/thong-ke")
    public String dowloadInfoTabs(@RequestParam(value = "class", defaultValue = "") Integer idClass,
                                  HttpServletResponse response
    ) {
        ClassModel classModel = classService.findById(idClass);
        String filename = "lich-thuc-hanh-lop-" + classModel.getCode();
        String pathname = com.nmhung.utils.FileUtils.getFullPathname(filename);
        String title = "Lịch thực hành môn " + classModel.getSubject().getName() + " Mã lớp " + classModel.getCode();
        List<RoomTimeModel> models = roomTimeService.findStatisticalByClass(idClass);
        POIUtils.writeStatistical(pathname, models, title, "mã lớp " + classModel.getCode());
        try {
            File file = new File(pathname);
            byte[] data = FileUtils.readFileToByteArray(file);
            // Thiết lập thông tin trả về
            setHeaderData(data, response, filename);
            InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "close";
    }

    @GetMapping("/api/download/tabs-info")
    public String dowloadInfoTabs(@RequestParam(value = "date", defaultValue = "") String dateInput,
                                  HttpServletResponse response
    ) {
        Date date = DateUtils.parse(dateInput);
        String filename = "lich-thuc-hanh-ngay-" + DateUtils.format(date);
        String pathname = com.nmhung.utils.FileUtils.getFullPathname(filename);
        String title = "Lịch thực hành ngày " + DateUtils.format(date);
        List<RoomTimeModel> models = roomTimeService.findByDate(date);
        POIUtils.writeTabsInfo(pathname, models, title, "sheetname");
        try {
            File file = new File(pathname);
            byte[] data = FileUtils.readFileToByteArray(file);
            // Thiết lập thông tin trả về
            setHeaderData(data, response, filename);
            InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "close";
    }

    private void setHeaderData(byte[] data, HttpServletResponse response, String filename) {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment; filename=" + filename + FileConfig.MIME_EXCEL);
        response.setContentLength(data.length);
    }

    @GetMapping("/api/download/roomtime/week")
    public String dowloadRoomTimeByWeek(@RequestParam(value = "date", defaultValue = "") String dateInput,
                                        @RequestParam(value = "room") Integer room,
                                        HttpServletResponse response) throws Exception {
        // reads input file from an absolute path
        Date date = DateUtils.parse(dateInput);
        RoomModel roomModel = roomService.findById(room);
        if (roomModel == null) {
            return "close";
        }
        Date monday = DateUtils.getMonDay(date);
        Date sunday = DateUtils.getSunDay(date);
        String filename = "tkb-thuc-hanh-tuan" + com.nmhung.utils.DateUtils.weekOfYear(date);
        String pathname = com.nmhung.utils.FileUtils.getFullPathname(filename);
        String title = "Lịch thực hành phòng máy " + roomModel.getName() + "từ ngày " + DateUtils.format(monday) + " đến " + DateUtils.format(sunday);
        Map<String, RoomTimeModel> roomTimeModelMap = roomTimeService.getMapByDate(date, room, true);
        POIUtils.writeTKB(pathname, roomTimeModelMap, title, roomModel.getName());
        try {
            File file = new File(pathname);
            byte[] data = FileUtils.readFileToByteArray(file);
            // Thiết lập thông tin trả về
            setHeaderData(data, response, filename);
            InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "close";
    }
}
