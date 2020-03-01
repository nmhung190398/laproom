<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Ahihi Đồ Ngốc</title>
<%@ include file="/views/include/cssinclude.jsp"%>
<style type="text/css">
.subject{
	font-size: 16px;
	font-weight: bold;
}

.room{
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
		
		<%@ include file="/views/menu.jsp"  %>
		<!--END MENU-->
		<!-- /. NAV SIDE  -->


		<div id="page-wrapper">

			<!--CONTENT-->
			<div id="page-inner">
				<div class="row">
					<div class="col-md-5">
						<input id="date-s"
										style="width: 100%;"
										type="date" class="form-control">
					</div>
					
					<div class="col-md-5">
						<input id="date-e"
										style="width: 100%;"
										type="date" class="form-control">
					</div>
					<div class="col-md-1">
						<input type="button" value="load" id="load-date" class="btn">
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-md-12">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover">
								<thead>
									<th>STT</th>
									<th>Thứ</th>
									<th>Ngày</th>
									<th>Sáng</th>
									<th>Chiều</th>
									<th>Tối</th>
								</thead>
								<tbody>
									<%=request.getAttribute("bodyTable") %>
								
							
								</tbody>
								
							</table>
						
						</div>
					</div>
				
				</div>
				<!-- END ROW -->
				
				
				
				
				
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->
	
	<%@ include file="/views/include/jsinclude.jsp"%>
	
	<script type="text/javascript">
		<%=request.getAttribute("jsBodyTable")%>
		
		$('#load-date').click(function() {
			var s = new Date($('#date-s').val());
			 var e = new Date($('#date-e').val());
			
			dayS = s.getDate();
			  monthS = s.getMonth() + 1;
			  yearS = s.getFullYear();
			  
			  dayE = e.getDate();
			  monthE = e.getMonth() + 1;
			  yearE = e.getFullYear();
			  
			  if(!isNaN(dayS) && !isNaN(monthS) && !isNaN(yearS) && !isNaN(dayE) && !isNaN(monthE) && !isNaN(yearE)){
				  var href = location.protocol + '//' + location.host + location.pathname + '?s='+ dayS + '-' + monthS + '-' + yearS;
				  href += '&e=' + dayE + '-' + monthE + '-' + yearE;
	
				  window.location.href = href;
			  }
			  
			  
			 
			  
			  
		});
		
	</script>
	


</body>
</html>
