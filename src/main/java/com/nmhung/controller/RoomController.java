package com.nmhung.controller;

import com.nmhung.model.RoomModel;
import com.nmhung.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoomController {
    @Autowired
    RoomService roomService;


    @GetMapping("/admin/room")
    public ModelAndView view(){
        ModelAndView modelAndView = new ModelAndView("admin/room");
        modelAndView.addObject("roomModels",roomService.findAll());
        return modelAndView;
    }

    @PostMapping("/admin/room")
    public String add(RoomModel model, @RequestParam String type){
//        request.setCharacterEncoding("UTF-8");
//        String type = request.getParameter("type");
        String msg = "";
        String redirect = "";
        if(type.equals("0")) {// delete
            msg = delete(model.getId());
        }else if(type.equals("1")){ // edit
            msg = update(model);
        }else { //add

            if(model != null) {
                if(roomService.add(model)) {
                    msg = "add-suss";
                }else {
                    msg = "add-err";
                }
            }else {
                msg = "add-not-data";
            }
        }
        redirect = "/admin/room?msg=" + msg;
        return "redirect:" + redirect;
    }

    protected String delete(Integer id) {
        // TODO Auto-generated method stub
        RoomModel model = new RoomModel();
        model.setId(id);
        String msg;
        if(roomService.del(id)) {
            msg = "del-suss";
        }else {
            msg = "del-err";
        }
        return msg;
    }

    protected String update(RoomModel model) {

        String msg = "";
        if(model != null) {
            if(roomService.eidt(model)) {
                msg = "edit-suss";
            }else {
                msg = "edit-err";
            }


        }else {
            msg = "edit-not-data";
        }
        return msg;

    }



}
