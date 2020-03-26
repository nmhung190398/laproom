<%@ page import="com.nmhung.model.UserModel" %>
<%@ page import="com.nmhung.constant.WebConstant" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="home">HaUI HN</a>
            </div>
            <div style="color: #4285f4;
            padding: 15px 50px 5px 50px;
            float: right;
            font-size: 16px;">
            <%= ((UserModel)session.getAttribute(WebConstant.USER_LOGIN)).getFullname()
            %>
             &nbsp;
            <a href="#" class="btn btn-success "><i class="fa fa-envelope fa-1x"></i>123</a>

            &nbsp;
            &nbsp; <a href="<%=request.getContextPath() %>/logout" class="btn btn-danger "><i class="fa fa-power-off fa-1x"></i>&nbsp;Logout</a> </div>
</nav>
