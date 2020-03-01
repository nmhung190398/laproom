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
                    <div class="panel panel-primary">

                        <div class="panel-heading">
                            <div class="panel-body">
                                Thông tin phòng thực hành ngày <fmt:formatDate pattern="dd-MM-yyyy" value="${date}"/>
                            </div>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>STT</th>
                                        <th>Tên giáo viên</th>
                                        <th>Phòng máy</th>
                                        <th>Môn</th>
                                        <th>Ca</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${roomTimes}" var="item" varStatus="loop">
                                        <tr>
                                            <td>${loop.index + 1}</td>
                                            <td>${item.clasS.teacher.fullname}</td>
                                            <td>${item.room.name}</td>
                                            <td>
                                                    ${item.clasS.code}
                                                <br>
                                                    ${item.clasS.subject.name}
                                            </td>
                                            <td>
                                                <c:if test="${item.shift} == 0">
                                                    Sáng
                                                </c:if>
                                                <c:if test="${item.shift} == 1">
                                                    Chiều
                                                </c:if>
                                                <c:if test="${item.shift} == 2">
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
            <%--END ROW--%>


        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->

<%@ include file="/views/footer.jsp" %>

<%@ include file="/views/include/jsinclude.jsp" %>


</body>
</html>
