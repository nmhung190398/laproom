<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <%@ include file="/views/include/cssinclude.jsp" %>

    <link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.3.1/css/fontawesome.css"
          integrity="sha384-1rquJLNOM3ijoueaaeS5m+McXPJCGdr5HcA03/VHXxcp2kX2sUrQDmFc3jR5i/C7"
          crossorigin="anonymous">
     <style type="text/css">
     	.td-data{
     		position: relative;
     	}

     	.link-del{
     		position: absolute;
     		top: 0px;
     		right: 2px;
     		color: red;
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

    <%@ include file="/views/menu.jsp" %>
    <!--END MENU-->
    <!-- /. NAV SIDE  -->


    <div id="page-wrapper">

        <!--CONTENT-->
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <nav class="navbar navbar-default">
                        <div class="container-fluid">
                            <div class="navbar-header">
                                <a class="navbar-brand" href="#">Danh Sách phòng</a>
                            </div>
                            <ul class="nav navbar-nav">
                                <c:forEach items="${rooms}" var="item">
                                    <li tag="${item.id}" class="li-room"><a
                                            href="tabs?room=${item.id}">${item.name}</a></li>

                                </c:forEach>
                            </ul>
                        </div>
                        <script>
                            const roomActive = ${roomActive};
                            $(".li-room").each(function () {
                                const li = $(this);
                                const id = li.attr('tag');
                                console.log(id);
                                if (parseInt(id) == roomActive) {
                                    li.attr('class', 'li-room active');
                                }
                            })
                        </script>
                        <ul class="nav navbar-nav navbar-right">

                        </ul>
                    </nav>


                </div>
            </div>
            <div class="row">

                <div class="col-md-12">
                <div class="panel panel-primary">
                	<div class="panel-heading">
                		<div class="panel-body">
                			<div class="col-md-4" style="text-align: left;">
										<a href="tabs?room=${roomActive}&date=${dateWeek[0]}" class="btn btn-success">Tuần Trước</a>
									</div>
									<div class="col-md-4"
										style="text-align: center; font-size: 20px">
										${dateWeek[2]}
										đến
										${dateWeek[8]}
										<br>
										<span id="title-week">
											<c:if test ="${isDangKy}">
         										Tuần Đăng Ký
      										</c:if>
      										<c:if test ="${isWeekNow}">
         										Tuần Hiện Tại
      										</c:if>
										</span>
									</div>

									<div class="col-md-4" style="text-align: right;">
										<a class="btn btn-success" href="tabs?room=${roomActive}&date=${dateWeek[1]}">Tuần Tiếp
											Theo</a>
									</div>

                		</div>
                	</div>
                	<div class="panel-body">
                		 <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>

                                <th>#</th>
                                <th>Thứ 2<br>${dateWeek[2]}</th>
                                <th>Thứ 3<br>${dateWeek[3]}</th>
                                <th>Thứ 4<br>${dateWeek[4]}</th>
                                <th>Thứ 5<br>${dateWeek[5]}</th>
                                <th>Thứ 6<br>${dateWeek[6]}</th>
                                <th>Thứ 7<br>${dateWeek[7]}</th>
                                <th>Chủ nhật<br>${dateWeek[8]}</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>Sáng</td>
                                <td class="td-data" id="2-0"></td>
                                <td class="td-data" id="3-0"></td>
                                <td class="td-data" id="4-0"></td>
                                <td class="td-data" id="5-0"></td>
                                <td class="td-data" id="6-0"></td>
                                <td class="td-data" id="7-0"></td>
                                <td  class="td-data" id="8-0"></td>
                            </tr>
                            <tr>
                                <td>Chiều</td>
                                <td class="td-data"  id="2-1"></td>
                                <td class="td-data"  id="3-1"></td>
                                <td class="td-data"  id="4-1"></td>
                                <td class="td-data"  id="5-1"></td>
                                <td class="td-data"  id="6-1"></td>
                                <td class="td-data"  id="7-1"></td>
                                <td class="td-data"  id="8-1"></td>
                            </tr>
                            <tr>
                                <td>Tối</td>
                                <td class="td-data"  id="2-2"></td>
                                <td class="td-data"  id="3-2"></td>
                                <td class="td-data"  id="4-2"></td>
                                <td class="td-data"  id="5-2"></td>
                                <td class="td-data"  id="6-2"></td>
                                <td class="td-data"  id="7-2"></td>
                                <td class="td-data"  id="8-2"></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                	</div>
                </div>
                <!-- END PANEL -->

                </div>
            </div>
            <!-- END ROW -->

            <div class="row">
                <div class="col-md-12">
                    <a target="_blank" href="<c:out value="${pageContext.servletContext.contextPath}" />/api/download/roomtime/week?date=${dateWeek[2]}&room=${roomActive}" class="btn btn-success">Chích xuất báo cáo</a>
                </div>
            </div>


            <!-- Modal -->
            <div class="modal fade" id="modal-add" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel"></h5>
                        </div>
                        <div class="modal-body">
                            <form id="form-add" method="post" action="tabs">
								<input type="hidden" name="date" />
								<input type="hidden" name="shift" />

								<input type="hidden" name="idRoom" value="${roomActive }" />
                                <!-- END ROW -->
                                <div class="row" style="padding-bottom: 5px">
                                    <div class="col-md-2">Giáo Viên</div>
                                    <div class="col-md-10">
                                        <select class="form-control" name="idTeacher">
                                            <c:forEach items="${teachers }" var="teacher">
                                                <option value="${teacher.id }">${teacher.username }</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <!-- END ROW -->
                                <div class="row" style="padding-bottom: 5px">
                                    <div class="col-md-2">Lớp học</div>
                                    <div class="col-md-10">
                                        <select class="form-control" name="idClass">
                                            <option value="">--Chọn---</option>
                                        </select>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="modal-action">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
            <%--end modal--%>

        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->

<%@ include file="/views/include/jsinclude.jsp" %>
<script src="<%=request.getContextPath() %>/resources/assets/js/ajax.js"></script>
<script src="<%=request.getContextPath() %>/resources/assets/js/main.js"></script>
<script src="<%=request.getContextPath() %>/resources/assets/js/tabs/main.js"></script>
<script>
    let modalAdd = $("#modal-add");
    const slClass = $('select[name="idClass"]');
    const slTeacher = $('select[name="idTeacher"]');
    const contextPath = '<c:out value="${pageContext.servletContext.contextPath}" />';
    const isDangKy = ${isDangKy};
    const dateOfWeek = [
    	'${dateWeek[0]}','${dateWeek[1]}',
    	'${dateWeek[2]}','${dateWeek[3]}',
    	'${dateWeek[4]}','${dateWeek[5]}',
    	'${dateWeek[6]}','${dateWeek[7]}',
    	'${dateWeek[7]}'];
    const roomTimes = JSON.parse('${roomTimes}');
    console.log(roomTimes);
    $("#showAdd").click(function () {
        modalAdd.modal('show');
    });

    function loadClasses(idTeacher) {
        ajaxGet(contextPath + '/api/user/teacher/' + idTeacher, function (data) {
            console.log(data);
            const dataMap = data.map(function (item) {
                return {
                    id: item.id,
                    label: item.code + "|" + item.subject.name,
                }
            });
            addOption(slClass, dataMap)
        });
    }

    loadClasses(slTeacher.val());
    slTeacher.on('change', function () {
        const idClass = this.value;
        loadClasses(idClass);
    });
    function addDangKy() {
		$(".td-data").each(function() {
			const tmp = $(this).attr('id').split('-');
			const shift = tmp[1];
			const date = dateOfWeek[tmp[0]];
			$(this).html('<a class="dang-ky-phong" shift="'+ shift +'" date="'+ date +'">Đăng ký</a>');
		});
	}
    if(isDangKy){
    	addDangKy();
    }
    $(".td-data").on("click", ".dang-ky-phong" , function() {
		const shift = $(this).attr('shift');
		const date = $(this).attr('date');
		console.log(date);
		let shiftTmp = "Tối";
		if(shift == 0){
			shiftTmp = "Sáng";
		}else if(shift == 1){
			shiftTmp = "Chiều"
		}
		$("#exampleModalLabel").html('Đăng ký phòng học ngày ' + date + " buổi " + shiftTmp);
		$("input[name='shift']").val(shift);
		$("input[name='date']").val(date);
		modalAdd.modal('show');
    });
    $(".td-data").on("click", ".link-del" , function() {
        console.log($(this));
        window.location = 'tabs/del/' + $(this).attr('idDel');
    });

    $("#modal-action").click(function() {
		$("#form-add").submit();
	})

	loadDataTabs(roomTimes,isDangKy);



</script>

</body>
</html>
