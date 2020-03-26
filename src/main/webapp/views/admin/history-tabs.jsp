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
            <div class="row" style="margin-bottom: 5px">
                <form method="get">
                    <div class="col-md-5">
                        <select class="form-control" id="slTeacher" name="">
                            <option value="">--Chọn Giáo Viên---</option>
                            <c:forEach items="${teachers }" var="teacher">
                                <option value="${teacher.id }">${teacher.username }</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-5">
                        <select class="form-control" id="slClass" name="class">
                            <option value="">--Chọn Lớp---</option>
                        </select>
                    </div>
                    <div class="col-md-2"><button class="btn btn-success">Lọc</button></div>
                </form>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-primary">

                        <div class="panel-heading">
                            <div class="panel-body">
                                Thông tin thực hành :
                                <c:if test="${classModel != null}">
                                    GV : <c:out value="${classModel.teacher.fullname}" /> -
                                    Môn : <c:out value="${classModel.subject.name}" /> -
                                    Mã môn : <c:out value="${classModel.code}" /> -
                                    Tổng số buổi thực hành : <c:out value="${classModel.subject.totalLesson}" />
                                </c:if>
                            </div>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Phòng Máy</th>
                                        <th>Ngày</th>
                                        <th>Ca</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${roomTimes}" var="item" varStatus="loop">
                                        <tr>
                                            <td>Buổi ${loop.index + 1}</td>
                                            <td>${item.room.name} | ${item.room.location}</td>
                                            <td><fmt:formatDate pattern="dd-MM-yyyy" value="${item.date}" /></td>
                                            <td>
                                                <c:if test="${item.shift == 0}">
                                                    Sáng
                                                </c:if>
                                                <c:if test="${item.shift == 1}">
                                                    Chiều
                                                </c:if>
                                                <c:if test="${item.shift == 2}">
                                                    Tối
                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>

                    </div>
                </div>

            </div>
            <div class="row" style="margin-top: 5px">
                <div class="col-md-12">
                    <a class="btn btn-info" href="${pageContext.servletContext.contextPath}/api/download/thong-ke?class=${classModel.id}">Chích xuất báo cáo</a>
                </div>
            </div>
            <%--end row--%>
        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->

<%@ include file="/views/footer.jsp" %>

<%@ include file="/views/include/jsinclude.jsp" %>
<script src="<%=request.getContextPath() %>/resources/assets/js/ajax.js"></script>
<script src="<%=request.getContextPath() %>/resources/assets/js/main.js"></script>
<script>
    const slClass = $('#slClass');
    const slTeacher = $('#slTeacher');
    const contextPath = '<c:out value="${pageContext.servletContext.contextPath}" />';
    function loadClasses(idTeacher) {
        if(idTeacher == ''){
            return;
        }
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
    const teacherVal = slTeacher.val();
    console.log(teacherVal);
    if(teacherVal != ''){
        loadClasses();
    }
    slTeacher.on('change', function () {
        const idClass = this.value;
        loadClasses(idClass);
    });
</script>

</body>
</html>
