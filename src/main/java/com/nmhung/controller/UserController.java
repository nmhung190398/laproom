package com.nmhung.controller;

import com.nmhung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/admin/user")
    public ModelAndView view(){
        ModelAndView modelAndView = new ModelAndView("admin/user");
        modelAndView.addObject("users",userService.findAll());
        return modelAndView;
    }
}
