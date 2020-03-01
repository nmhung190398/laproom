package com.nmhung.controller;

import com.nmhung.model.ClassModel;
import com.nmhung.model.SubjectModel;
import com.nmhung.model.UserModel;
import com.nmhung.service.ClassService;
import com.nmhung.service.SubjectService;
import com.nmhung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ClassController {
    @Autowired
    ClassService classService;

    @Autowired
    SubjectService subjectService;
    @Autowired
    UserService userService;

    @GetMapping("/admin/class")
    public ModelAndView view(){
        ModelAndView modelAndView = new ModelAndView("admin/class");
        List<ClassModel> classes = classService.findAll();
        List<SubjectModel> subjects = subjectService.findAll();
        List<UserModel> teachers = userService.findAll();
        modelAndView.addObject("teachers",teachers);
        modelAndView.addObject("subjects",subjects);
        modelAndView.addObject("classes",classes);
        return modelAndView;
    }

    @GetMapping("/admin/class/del/{id}")
    public String del(@PathVariable Integer id){
        String redirect = "/admin/class";
        String msg = "?msg=";
        msg+= classService.del(id)? "del-sus" : "del-err";
        return "redirect:" + redirect + msg;
    }

    @PostMapping("/admin/class/add")
    public String add(ClassModel model,@RequestParam Integer idSubject,@RequestParam Integer idTeacher){
        String redirect = "/admin/class";
        String msg = "?msg=";
        model.setSubject(new SubjectModel());
        model.setTeacher(new UserModel());
        model.getTeacher().setId(idTeacher);
        model.getSubject().setId(idSubject);
        msg+= classService.add(model)? "add-sus" : "add-err";
        return "redirect:" + redirect + msg;
    }

    @PostMapping("/admin/class/edit")
    public String edit(ClassModel model,@RequestParam Integer idTeacher,@RequestParam Integer idSubject){
        String redirect = "/admin/class";
        String msg = "?msg=";
        model.setSubject(new SubjectModel());
        model.setTeacher(new UserModel());
        model.getTeacher().setId(idTeacher);
        model.getSubject().setId(idSubject);
        msg+= classService.add(model)? "edit-sus" : "edit-err";
        return "redirect:" + redirect + msg;
    }
}
