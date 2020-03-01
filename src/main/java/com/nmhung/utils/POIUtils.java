package com.nmhung.utils;

import com.nmhung.model.RoomTimeModel;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

public class POIUtils {


    public static boolean writeTKB(String pathname, Map<String, RoomTimeModel> roomTimeModels, String title, String sheetName) throws Exception {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);
        Cell cell;
        Row row;
        row = sheet.createRow(0);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue(title);
        cell.setCellStyle(createStyleForHeader(workbook));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
        String headers[] = {"#", "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "Chủ nhật"};
        setHeader(headers, createStyleForHeader(workbook), sheet.createRow(1));
        for (int i = 0; i < headers.length; i++) {
            sheet.setColumnWidth(i, 25 * 256);
        }
        Map<String, Cell> mapCell = setCellTKB(workbook, sheet, 2);
        if (roomTimeModels != null) {
            for (String key : roomTimeModels.keySet()) {
                Cell cellData = mapCell.get(key);
                cellData.setCellValue(writeValue(roomTimeModels.get(key)));
            }
        }
        try {
            FileOutputStream out = new FileOutputStream(new File(pathname));
            workbook.write(out);
            out.close();
            System.out.println(pathname + " written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static String writeValue(RoomTimeModel model) {
        String rs = "";
        rs += "GV : " + model.getClasS().getTeacher().getFullname() + "\n";
        rs += "Mã Lớp : " + model.getClasS().getCode() + "\n";
        rs += "Môn : " + model.getClasS().getSubject().getName() + "\n";
        return rs;
    }

    private static Map<String, Cell> setCellTKB(XSSFWorkbook workbook, XSSFSheet sheet, int rowStart) {
        Map<String, Cell> mapCell = new HashMap<>();
        for (int shift = 0; shift < 3; ++shift) {
            String tmp = "Tối";
            if (shift == 0) {
                tmp = "Sáng";
            } else if (shift == 1) {
                tmp = "Chiều";
            }
            Row rowData = sheet.createRow(rowStart + shift);
            Cell cellData = rowData.createCell(0);
            cellData.setCellStyle(createStyleCenter(workbook));
            cellData.setCellValue(tmp);
            for (int i = 1; i < 8; ++i) {
                String key = (i + 1) + "-" + shift;
                cellData = rowData.createCell(i);
//                cellData.setCellValue(key);
                cellData.setCellStyle(createStyleData(workbook));
                mapCell.put(key, cellData);
            }
        }

        return mapCell;
    }


    public static void setHeader(String[] header, CellStyle style, Row row) {
        for (int i = 0; i < header.length; ++i) {
            Cell cell;
            cell = row.createCell(i, CellType.STRING);
            cell.setCellValue(header[i]);
            cell.setCellStyle(style);
        }
    }

    private static CellStyle createStyleForHeader(XSSFWorkbook workbook) {
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        XSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }

    private static CellStyle createStyleData(XSSFWorkbook workbook) {
        CellStyle cs = workbook.createCellStyle();
        cs.setWrapText(true);
        cs.setVerticalAlignment(VerticalAlignment.TOP);
        return cs;
    }

    private static CellStyle createStyleCenter(XSSFWorkbook workbook) {
        CellStyle cs = workbook.createCellStyle();
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        return cs;
    }

    public static boolean writeTabsInfo(String pathname, List<RoomTimeModel> models, String title, String sheetName) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);

        Cell cell;
        Row row;
        row = sheet.createRow(0);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue(title);
        cell.setCellStyle(createStyleForHeader(workbook));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
        String headers[] = {"STT", "Tên Giáo Viên", "Phòng Máy", "Môn", "Ca"};
        for (int i = 1; i < headers.length; i++) {
            sheet.setColumnWidth(i, 30 * 256);
        }
        setHeader(headers, createStyleForHeader(workbook), sheet.createRow(1));
        addDataInfoTabs(models, sheet, 2);
        try {
            FileOutputStream out = new FileOutputStream(new File(pathname));
            workbook.write(out);
            out.close();
            System.out.println(pathname + " written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static void addDataInfoTabs(List<RoomTimeModel> models, XSSFSheet sheet, int indexStart) {
        for (int i = 0; i < models.size(); ++i) {
            RoomTimeModel model = models.get(0);
            Row row = sheet.createRow(i + indexStart);
            Cell stt = createCell(row,0,i + 1);
            Cell gv = createCell(row,1,model.getClasS().getTeacher().getFullname());
            Cell pm = createCell(row,2,model.getRoom().getName() + "," + model.getRoom().getLocation());
            Cell mom = createCell(row,3,model.getClasS().getSubject().getName() + "," + model.getClasS().getCode());
            String tmp = "Tối";
            if (model.getShift() == 0) {
                tmp = "Sáng";
            } else if (model.getShift() == 1) {
                tmp = "Chiều";
            }
            Cell ca = createCell(row,4,tmp);
        }
    }

    public static Cell createCell(Row row, int index, Object value) {
        Cell cell = row.createCell(index);
        if (value instanceof Double) {
            cell.setCellValue((Double) value);
        } else if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Date) {
            cell.setCellValue((Date) value);
        } else if (value instanceof Calendar) {
            cell.setCellValue((Calendar) value);
        }else{
            cell.setCellValue((String) value);
        }
        return cell;
    }
}
