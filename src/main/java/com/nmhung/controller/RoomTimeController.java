package com.nmhung.controller;

import com.google.gson.Gson;
import com.nmhung.model.ClassModel;
import com.nmhung.model.RoomModel;
import com.nmhung.model.RoomTimeModel;
import com.nmhung.model.UserModel;
import com.nmhung.service.RoomService;
import com.nmhung.service.RoomTimeService;
import com.nmhung.service.UserService;
import com.nmhung.utils.DateUtils;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class RoomTimeController {

    @Autowired
    RoomService roomService;

    @Autowired
    RoomTimeService roomTimeService;

    @Autowired
    UserService userService;

    @GetMapping("/admin/tabs")
    ModelAndView view(@RequestParam(value = "room", defaultValue = "0") Integer room,
                      @RequestParam(value = "date",defaultValue = "")
//                      @DateTimeFormat(pattern = "dd-MM-yyyy")
                              String date
    ) {
        ModelAndView modelAndView = new ModelAndView("admin/tabs");
        List<RoomModel> rooms = roomService.findAll();
        List<UserModel> teachers = userService.findAll();
        Date dateNow = DateUtils.parse(date);
        if (room == 0) {
            room = rooms.get(0).getId();
        }
        String dateWeekStr[] = DateUtils.getArrayDate(dateNow);


        boolean isDangKy = (DateUtils.weekOfYear(dateNow) - DateUtils.weekOfYear(DateUtils.getDateNow())) == 1;
        boolean isWeekNow = (DateUtils.weekOfYear(dateNow) - DateUtils.weekOfYear(DateUtils.getDateNow())) == 0;
//        List<RoomTimeModel> roomTimes = roomTimeService.findByDate(dateNow);
        Map<String, RoomTimeModel> roomTimes = roomTimeService.getMapByDate(dateNow,room);
        modelAndView.addObject("dateWeek", dateWeekStr);
        modelAndView.addObject("roomTimes", new Gson().toJson(roomTimes));
        modelAndView.addObject("roomActive", room);
        modelAndView.addObject("teachers", teachers);
        modelAndView.addObject("rooms", rooms);
        modelAndView.addObject("isWeekNow", isWeekNow);
        modelAndView.addObject("isDangKy", isDangKy);
        return modelAndView;
    }

    @PostMapping("/admin/tabs")
    String add(RoomTimeModel model,@RequestParam Integer idClass,@RequestParam Integer idRoom){
        String redirect = "/admin/tabs";
        model.setClasS(new ClassModel());
        model.getClasS().setId(idClass);
        model.setRoom(new RoomModel());
        model.getRoom().setId(idRoom);
        roomTimeService.add(model);
        return "redirect:" + redirect;
    }

    @GetMapping("/admin/tabs/active/{id}")
    String add(@PathVariable Integer id){
        String redirect = "/admin/tabs";
        roomTimeService.active(id);
        return "redirect:" + redirect;
    }

    @GetMapping("/admin/info")
    public ModelAndView viewByDate(@RequestParam(value = "date",defaultValue = "") String dateInput){
        ModelAndView modelAndView = new ModelAndView("admin/tabs-info");
        Date date = DateUtils.parse(dateInput);
        List<RoomTimeModel> roomTimes = roomTimeService.findByDate(date);
        modelAndView.addObject("roomTimes",roomTimes);
        modelAndView.addObject("date",date);
        return modelAndView;
    }

}
