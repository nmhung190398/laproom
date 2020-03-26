<%@ page language="java" contentType="text/html; UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <%@ include file="/views/include/cssinclude.jsp" %>

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
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>Mã lớp</th>
                                <th>Môn học</th>
                                <th>Giảng viên</th>
                                <th>Ngày bắt đầu</th>
                                <th>Ngày kết thúc</th>
                                <th>#</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${classes}" var="item">
                                <tr class="tr-data">

                                    <td>${item.code}</td>
                                    <td>${item.subject.name}</td>
                                    <td>${item.teacher.fullname}</td>
                                    <td>${item.startDate}</td>
                                    <td>${item.endDate}</td>
                                    <td>
                                        <btn tag="${item.code}" class="btn btn-link btn-edit">Sửa</btn>
                                    </td>

                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-12" style="text-align: center">
                    <button class="btn btn-success" id="btn-add">Thêm</button>
                </div>
            </div>
            <%--END ROW--%>

            <%--POP UP ADD & EDIT--%>
            <!-- Modal -->
            <div class="modal fade" id="modal-ae" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form id="form-ae" method="post">

                                <div class="row" style="padding-bottom: 5px">
                                    <div class="col-md-2">Mã lớp</div>
                                    <div class="col-md-10">
                                        <input class="form-control" type="text" name="code" size=60/>
                                    </div>
                                </div>
                                <!-- END ROW -->
                                <div class="row" style="padding-bottom: 5px">
                                    <div class="col-md-2">Môn Học</div>
                                    <div class="col-md-10">
                                        <select class="form-control" name="idSubject">
                                            <c:forEach items="${subjects}" var="subject">
                                                <option value="${subject.id}">${subject.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
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
                                    <div class="col-md-2">Ngày bắt đầu</div>
                                    <div class="col-md-10">
                                        <input class="form-control" type="date" name="startDate"/>
                                    </div>
                                </div>
                                <!-- END ROW -->
                                <div class="row" style="padding-bottom: 5px">
                                    <div class="col-md-2">Ngày kết thúc</div>
                                    <div class="col-md-10">
                                        <input class="form-control" type="date" name="endDate"/>
                                    </div>
                                </div>
                                <!-- END ROW -->
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="modal-action">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>



        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->

<%@ include file="/views/footer.jsp" %>

<%@ include file="/views/include/jsinclude.jsp" %>
<script>
    var formAE = $('#form-ae');
    var urlAdd = "class/add";
    var urlEdit = "class/edit";
    var modalAE = $("#modal-ae");

    function setAcction(acction) {
        formAE.attr("action", acction);
    }

    $("#btn-add").click(function () {
        setAcction(urlAdd);
        modalAE.modal('show');
        $("#modal-action").html("Thêm");
    });

    $("#btn-edit").click(function () {
        console.log(this.rowIndex);
        setAcction(urlEdit);
        modalAE.modal('show');
        $("#modal-action").html("Sửa");
    })

    $("#modal-action").click(function () {
        console.log(formAE);
        formAE.submit();
    })


</script>

</body>
</html>
