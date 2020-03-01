<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tabs</title>
<link href="<c:url value='/views/assets/css/tabs.css' />" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value='/views/assets/js/tabs.js'/>"></script>
</head>
<body>

	<div id="pettabs" class="indentmenu">
		<ul>
			<c:forEach items="${roomModels}" var="room">
				<li><a href="tabs?idroom=${room.id }"  rel="hdz${room.id }" 
				<c:set var="tmp" value="${idRoom}"/>
				<c:if test="${item.id eq tmp}">
					<c:out value="class='selected'"/>
				</c:if>
				
				>${room.name}</a></li>
			</c:forEach>
		</ul>
	</div>
	

	<div style="clear: both;"></div>

	<div class="tabcontentstyle">

		<div id="hdz${idRoom }" class="tabcontent">
			<form name="frm1" action="" method="">
				<table cellspacing=0>
					<tr>
						<th>Ngày<br>Ca thực hành
						</th>
						<th>Thứ 2 <%=request.getAttribute("monday") %></th>
						<th>Thứ 3</th>
						<th>Thứ 4</th>
						<th>Thứ 5</th>
						<th>Thứ 6</th>
						<th>Thứ 7</th>
						<th>Chủ nhật</th>
					</tr>

					<tr class="s">
						<td>Sáng</td>
						<td class="datecell" id="t2-1"><b>GV:</b> Hoàng Quang Huy<br /> <b>Môn:</b>
							Tin văn phòng<br /> <b>Lớp:</b> KT5-K16<br /> <b>Thay:</b> Sáng
							thứ 4.</td>
							
							
							
							
							
							
						<td class="datecell" id="t3-1">Thứ 3</td>
						<td class="datecell" id="t4-1">Thứ 4</td>
						<td class="datecell"id="t5-1" >Thứ 5</td>
						<td class="datecell"id="t6-1">Thứ 6</td>
						<td class="datecell"id="t7-1">Thứ 7</td>
						<td class="datecell"id="t8-1">Chủ nhật</td>
					</tr>

					<tr class="c">
						<td>Chiều</td>
						
						
						<td class="datecell" id="t2-2">Thứ 2</td>
							
		
						<td class="datecell" id="t3-2">Thứ 3</td>
						
						
						<td class="datecell" id="t4-2">Thứ 4</td>
						<td class="datecell"id="t5-2" >Thứ 5</td>
						
						<td class="datecell"id="t6-2">Thứ 6</td>
						
						<td class="datecell"id="t7-2">Thứ 7</td>
						
						<td class="datecell"id="t8-2">Chủ nhật</td>
					</tr>

					<tr class="t">
						<td>Tối</td>
						
						<td class="datecell" id="t2-3">Thứ 2</td>
						<td class="datecell" id="t3-3">Thứ 3</td>
						<td class="datecell" id="t4-3"></td>
						<td class="datecell"id="t5-3" >Thứ 5</td>
						<td class="datecell"id="t6-3">Thứ 6</td>
						<td class="datecell"id="t7-3">Thứ 7</td>
						<td class="datecell"id="t8-3">Chủ nhật</td>
					</tr>

				</table>
				<br />
				<table cellspacing=0>
					<tr>
						<td class="lc">Buổi học</td>
						<td><select name="slcWeekdate" disabled>
								<option value="0">Thứ 4</option>
						</select> <select name="slcSection" disabled>
								<option value="0">Sáng</option>
						</select></td>
					</tr>

					<tr>
						<td class="lc">Môn học</td>
						<td><select name="slcLap">
								<option value="0">---chọn---</option>
								<option value="1">Tin văn phòng</option>
								<option value="2">Nhập môn tin học</option>
								<option value="3">Tin học đại cương</option>
						</select></td>
					</tr>

					<tr>
						<td class="lc">Lớp</td>
						<td><input type="text" name="txtClassName" size=60 /></td>
					</tr>
					<tr>
						<td class="lc">Buổi thay thế</td>
						<td><textarea rows="5" cols="60"></textarea></td>
					</tr>
					<tr>
						<td colspan=2><input type="button" value="Cập nhật" /> <input
							type="reset" value="Hủy" /></td>
					</tr>

				</table>

			</form>
		</div>
	</div>

	<script type="text/javascript">
	/*
		var infors = new ddtabcontent("pettabs")
		infors.setpersist(true)
		infors.setselectedClassTarget("link")
		infors.init()*/ // định thời gian tự chuyển sang tab (ms), ở đây là 2s, nếu không muốn thì để trống
	</script>
</body>
</body>
</html>