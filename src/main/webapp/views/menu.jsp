<%@ page import="com.nmhung.model.UserModel" %>
<%@ page import="com.nmhung.constant.WebConstant" %>
<%@ page import="com.nmhung.utils.SessionUtil" %>
<%@ page language="java" contentType="text/html; UTF-8"
		 pageEncoding="UTF-8"%>

<nav class="navbar-default navbar-side" role="navigation">
	<div class="sidebar-collapse">
		<ul class="nav" id="main-menu">
			<li class="text-center"><img
				src="<%=request.getContextPath() %>/resources/assets/img/find_user.png"
				class="user-image img-responsive" /></li>


			<li><a href="<%=request.getContextPath() %>/teacher/home"><i
					class="fa fa-home fa-1x"></i> Trang Chủ</a></li>

			<%--<li><a href="<%=request.getContextPath() %>/teacher/tabs"><i--%>
					<%--class="fa fa-home fa-1x"></i>Tabs</a></li>--%>



			<% if(SessionUtil.getInstance().isAdmin(request)){
			%>
			<li><a href="<%=request.getContextPath() %>/admin/subject"><i
				class="fa fa-home fa-1x"></i>Subject</a></li>
			<li><a href="<%=request.getContextPath() %>/admin/class"><i
					class="fa fa-home fa-1x"></i>Class</a></li>
			<li><a href="<%=request.getContextPath() %>/admin/tabs"><i
					class="fa fa-home fa-1x"></i>Tabs</a></li>
			<li><a href="<%=request.getContextPath() %>/admin/room"><i
					class="fa fa-home fa-1x"></i>Room</a></li>

			<li><a href="<%=request.getContextPath() %>/admin/info"><i
					class="fa fa-home fa-1x"></i>Info Date</a></li>
			<%
				}
			%>



			<!-- /teacher/calendarcl -->
			<li><a href="<%=request.getContextPath() %>/teacher/calendarcl"><i
					class="fa fa-home fa-1x"></i>Thời Khóa Biểu</a></li>





		</ul>

	</div>

</nav>
