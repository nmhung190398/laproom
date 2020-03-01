<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Map"%>
<%@ page import="com.nmhung.utils.DateUtils" %>
<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Ahihi Đồ Ngốc</title>
<%@ include file="/views/include/cssinclude.jsp"%>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/fontawesome.css"
	integrity="sha384-1rquJLNOM3ijoueaaeS5m+McXPJCGdr5HcA03/VHXxcp2kX2sUrQDmFc3jR5i/C7"
	crossorigin="anonymous">
<style type="text/css">
#table-tabs td {
	width: 13%;
}

.td-data {
	position: relative;
}

.fa-times {
	position: absolute;
	color: red;
	top: 0px;
	right: 0px;
}
</style>
</head>
<body>
	<div id="wrapper">
		<!--HEADER-->
		<jsp:include page="/views/header.jsp"></jsp:include>
		<!--END HEADER-->
		<!-- /. NAV TOP  -->
		<!--MENU-->

		<%@ include file="/views/menu.jsp"%>
		<!--END MENU-->
		<!-- /. NAV SIDE  -->


		<div id="page-wrapper">

			<!--CONTENT-->
			<div id="page-inner">

				<div class="row">
					<div class="col-md-12">
						<nav class="navbar navbar-default">
							<div class="container-fluid">
								<ul class="nav navbar-nav">

									<!-- <li class="active"><a href="#">Home</a></li>
								<li><a href="#">Page 1</a></li>
								<li><a href="#">Page 2</a></li>
								<li><a href="#">Page 3</a></li> -->

									<c:forEach items="${roomModels}" var="room">
										<li><a id="idroom-${room.id }"
											href="tabs?idroom=${room.id }&now=${dateTable}">${room.name }</a></li>
									</c:forEach>
								</ul>


								<div class="form-group">
									<button id="btn-date-now"
										style="float: right; margin-top: 10px" type="submit"
										class="btn btn-default">Submit</button>
									<input id="date-now"
										style="width: 200px; float: right; margin-top: 10px"
										type="date" class="form-control">

								</div>


							</div>

						</nav>


					</div>
				</div>
				<hr>
				<!-- END ROW -->


				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<div class="panel-body" style="padding: 0 8px 0 8px">

									<div class="col-md-4" style="text-align: left;">
										<a href="${urlPreWeek}" class="btn btn-success">Tuần Trước</a>
									</div>
									<div class="col-md-4"
										style="text-align: center; font-size: 20px">
										<%=DateUtils.format(DateUtils.timestampAdd((Timestamp) request.getAttribute("monday"), 0))%>
										đến
										<%=DateUtils.format(DateUtils.timestampAdd((Timestamp) request.getAttribute("monday"), 6))%>
										<br>
										<span id="title-week"></span>
									</div>

									<div class="col-md-4" style="text-align: right;">
										<a class="btn btn-success" href="${urlNextWeek}">Tuần Tiếp
											Theo</a>
									</div>


								</div>


							</div>

							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="table-tabs">
										<thead>
											<tr>
												<th style="width: 50px !important;">#</th>
												<th>Thứ 2 <br><%=DateUtils.format(DateUtils.timestampAdd((Timestamp) request.getAttribute("monday"), 0))%>

												</th>
												<th>Thứ 3 <br><%=DateUtils.format(DateUtils.timestampAdd((Timestamp) request.getAttribute("monday"), 1))%>
												</th>
												<th>Thứ 4 <br><%=DateUtils.format(DateUtils.timestampAdd((Timestamp) request.getAttribute("monday"), 2))%>
												</th>
												<th>Thứ 5 <br><%=DateUtils.format(DateUtils.timestampAdd((Timestamp) request.getAttribute("monday"), 3))%>

												</th>
												<th>Thứ 6 <br><%=DateUtils.format(DateUtils.timestampAdd((Timestamp) request.getAttribute("monday"), 4))%>
												</th>
												<th>Thứ 7 <br><%=DateUtils.format(DateUtils.timestampAdd((Timestamp) request.getAttribute("monday"), 5))%>
												</th>
												<th>Chủ nhật <br><%=DateUtils.format(DateUtils.timestampAdd((Timestamp) request.getAttribute("monday"), 6))%>
												</th>

											</tr>
										</thead>
										<tbody>
											<tr>
												<td style="width: 50px !important;">Sáng</td>

												<td id="t2-0" class="td-data"><a class="dang-ky-phong" shift='0' date='2'>Đăng ký</a></td>
												<td id="t3-0" class="td-data"><a class="dang-ky-phong" shift='0' date='3'>Đăng ký</a></td>
												<td id="t4-0" class="td-data"><a class="dang-ky-phong" shift='0' date='4'>Đăng ký</a></td>
												<td id="t5-0" class="td-data"><a class="dang-ky-phong" shift='0' date='5'>Đăng ký</a></td>
												<td id="t6-0" class="td-data"><a class="dang-ky-phong" shift='0' date='6'>Đăng ký</a></td>
												<td id="t7-0" class="td-data"><a class="dang-ky-phong" shift='0' date='7'>Đăng ký</a></td>
												<td id="t1-0" class="td-data"><a class="dang-ky-phong" shift='0' date='1'>Đăng ký</a></td>
											</tr>
											<tr>
												<td style="width: 50px !important;">Chiều</td>

												<td id="t2-1" class="td-data"><a class="dang-ky-phong" shift='1' date='2'">Đăng ký</a></td>
												<td id="t3-1" class="td-data"><a class="dang-ky-phong" shift='1' date='3'">Đăng ký</a></td>
												<td id="t4-1" class="td-data"><a class="dang-ky-phong" shift='1' date='4'">Đăng ký</a></td>
												<td id="t5-1" class="td-data"><a class="dang-ky-phong" shift='1' date='5'">Đăng ký</a></td>
												<td id="t6-1" class="td-data"><a class="dang-ky-phong" shift='1' date='6'">Đăng ký</a></td>
												<td id="t7-1" class="td-data"><a class="dang-ky-phong" shift='1' date='7'">Đăng ký</a></td>
												<td id="t1-1" class="td-data"><a class="dang-ky-phong" shift='1' date='1'">Đăng ký</a></td>

											</tr>
											<tr>
												<td style="width: 50px !important;">Tối</td>

												<td id="t2-2" class="td-data"><a class="dang-ky-phong" shift='2' date='2'">Đăng ký</a></td>
												<td id="t3-2" class="td-data"><a class="dang-ky-phong" shift='2' date='3'">Đăng ký</a></td>
												<td id="t4-2" class="td-data"><a class="dang-ky-phong" shift='2' date='4'">Đăng ký</a></td>
												<td id="t5-2" class="td-data"><a class="dang-ky-phong" shift='2' date='5'">Đăng ký</a></td>
												<td id="t6-2" class="td-data"><a class="dang-ky-phong" shift='2' date='6'">Đăng ký</a></td>
												<td id="t7-2" class="td-data"><a class="dang-ky-phong" shift='2' date='7'">Đăng ký</a></td>
												<td id="t1-2" class="td-data"><a class="dang-ky-phong" shift='2' date='1'">Đăng ký</a></td>
											</tr>
										</tbody>

									</table>


								</div>



							</div>
						</div>





					</div>

				</div>


				<!-- END ROW -->

				<!-- END ROW -->

			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->
	<!-- Modal -->
	<div class="modal fade" id="modal-dang-ky" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Đăng ký phòng thực hành : <strong id="title-modal"></strong></h5>
				</div>
				<div class="modal-body">
					<form method="POST" id="form-dang-ky"
							action="<%=request.getContextPath() + "/teacher/tabs"%>">
						<input type="hidden" name="dateStart" id="date-modal">
						<input type="hidden" name="shift" id="shift-modal">
						 <input
								type="hidden" value="${idRoom }" name="idRoom">
								<input
								type="hidden" value="${userLogin.id }" name="idUser">
						<div class="row" style="padding-bottom: 5px">
								<div class="col-md-2">Môn Học</div>
								<div class="col-md-10">
									<select class="form-control" name="subject">
										<option value="">---chọn---</option>
										<option value="Tin văn phòng">Tin văn phòng</option>
										<option value="Nhập môn tin họ">Nhập môn tin học</option>
										<option value="Tin học đại cương">Tin học đại cương</option>
									</select>
								</div>
							</div>
							<div class="row" style="padding-bottom: 5px">
								<div class="col-md-2">Tên Lớp</div>
								<div class="col-md-10">
									<input class="form-control" type="text" name="classes" size=60 />
								</div>
							</div>
					</form>
				</div>
				<div class="modal-footer">
					<button  type="button" class="btn btn-secondary"
						data-dismiss="modal">Đóng</button>
					<button id="dang-ky" type="button" class="btn btn-primary">Đăng ký</button>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/views/include/jsinclude.jsp"%>
	<script src="<%=request.getContextPath()%>/assets/js/tabs/main.js"></script>
	<script type="text/javascript">


		$('#idroom-<%=request.getAttribute("idRoom")%>').attr('style','background: blue;color: white;');


		$('#btn-date-now').click(function() {
			var date = new Date($('#date-now').val());
			day = date.getDate();
			  month = date.getMonth() + 1;
			  year = date.getFullYear();

			  if(!isNaN(date) && !isNaN(month) && !isNaN(year)){
				  var href = location.protocol + '//' + location.host + location.pathname + '?now='+ day + '-' + month + '-' + year + '&idroom' + '<%=request.getAttribute("idRoom")%>';
						window.location.href = href;
					}

				});
		var data = JSON.parse('${data}');
		var idUserLogin = ${userLogin.id};
		console.log('ahihi');
		console.log(data);

		var arrayDate = JSON.parse('${arrayDate}');
		console.log(arrayDate);

		dangKy(arrayDate);
		var weekOfYearNow = ${weekOfYearNow};
		var weekOfYear = ${weekOfYear};
		var isRemove = (weekOfYear - weekOfYearNow) == 1;

		var titleWeek = '';
		if(weekOfYearNow == weekOfYear){
			titleWeek = 'Tuần hiện tại';
		}else if(isRemove){
			titleWeek = 'Tuần tiếp theo (Tuần đăng ký)';
		}
		$("#title-week").html(titleWeek);

		console.log(isRemove);
		loadDataTabs(data, idUserLogin, isRemove);
	</script>





</body>
</html>
