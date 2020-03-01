package com.nmhung.controller;

import com.nmhung.constant.RoleConstant;
import com.nmhung.constant.WebConstant;
import com.nmhung.model.UserModel;
import com.nmhung.service.UserService;
import com.nmhung.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public ModelAndView login(
            @RequestParam(name = "msg",defaultValue = "")String msg,
            HttpSession session
    ){
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public String login(UserModel model, HttpServletRequest request){
        UserModel userLogin = userService.login(model.getUsername(), model.getPassword());
        String redirect = "";
        String msg = "";
        if(userLogin == null) {
            msg = "get-data-err";
            redirect = "/login?msg=err";
//            WebUtils.sendRedirect(response, request.getContextPath() + "/login?msg=err");
        }else {
            SessionUtil.getInstance().put(request, WebConstant.USER_LOGIN,userLogin);
            if(userLogin.getRole().getCode().equalsIgnoreCase(RoleConstant.ADMIN)) {
                redirect =  "/admin/home";
            }else if(userLogin.getRole().getCode().equalsIgnoreCase(RoleConstant.TEACHER)) {
                redirect =  "/teacher/home";
            }else {
                redirect =  "/403";
            }
        }
        return "redirect:" + redirect;
    }
}
