<%@page import="com.nmhung.model.*"%>
<%@page import="java.util.List"%>
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
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										
										<th>Tên Phòng</th>
										<th>Vị Trí</th>
										<th>Số Lượng PC</th>
										<th style="width: 150px"># </th>
									</tr>
								</thead>
								
								
								<tbody>
								
									<c:forEach items="${roomModels}" var="item">
									
										<tr>
											<td  ><input class="id-${item.id} name form-control" value="${item.name }"></input> </td>
											<td  ><input class="id-${item.id} location form-control" value="${item.location }"></input> </td>
											<td  ><input class="id-${item.id} pc-count form-control" value="${item.totalDesktop }"></input> </td>
											<td>
												<button class="btndel btn btn-link" tag="${item.id}" >Xóa</button>&nbsp;&nbsp;
												<button class="btnedit btn btn-link"  tag="${item.id}">Sửa</button>
						
											</td>
											
										</tr>
										
										
									
									</c:forEach>
									
									
									  <tr>
											<td style="background: #428bca" ><input style="background: #428bca; color: #fff" class="add name form-control" value=""></input> </td>
											<td style="background: #428bca" ><input style="background: #428bca; color: #fff" class="add location form-control" value=""></input> </td>
											<td style="background: #428bca" ><input style="background: #428bca; color: #fff" class="add pc-count form-control" value=""></input> </td>
											<td style="background: #428bca">
												<button style="width: 100%" class="btn btn-success" id="btn-add">Thêm</button>
												
											</td>
											
										</tr>
	
								</tbody>
							</table>
						</div>
						
						<hr>
						
						
						
						
					</div>

				</div>
				<!-- END ROW -->


				<hr>
				


			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->

	<%@ include file="/views/include/jsinclude.jsp"%>

	<script type="text/javascript">
	var form;
	function createForm() {
		var form = document.createElement("form");
		form.setAttribute('id','frmSubmit');
		document.body.appendChild(form);
		form.method = "POST";
		form.action = window.location;
		var element1 = document.createElement('input');
		element1.setAttribute("type", "hidden");
        element1.setAttribute("id", 'submit-id');
        element1.setAttribute("name", 'id');
		form.appendChild(element1);

		var element1 = document.createElement('input');
		element1.setAttribute("type", "hidden");
        element1.setAttribute("id", 'submit-name');
        element1.setAttribute("name", 'name');
		form.appendChild(element1);
		
		var element1 = document.createElement('input');
		element1.setAttribute("type", "hidden");
        element1.setAttribute("id", 'submit-location');
        element1.setAttribute("name", 'location');
		form.appendChild(element1);
		
		var element1 = document.createElement('input');
		element1.setAttribute("type", "hidden");
        element1.setAttribute("id", 'submit-pc-count');
        element1.setAttribute("name", 'totalDesktop');
		form.appendChild(element1);
		
		var element1 = document.createElement('input');
		element1.setAttribute("type", "hidden");
        element1.setAttribute("id", 'submit-type');
        element1.setAttribute("name", 'type');
		form.appendChild(element1);
	}
	
	createForm();

	    
	    $('button.btndel').click(function() {
			var id = $(this).attr('tag');
			console.log(id);
			
			$('#submit-type').val(0);
			$('#submit-id').val(id);
			$('#frmSubmit').submit();
		});
	    
	    $('#btn-add').click(function() {
	    	var type = 3;
			var name = $('input.add.name').val();
			var location = $('input.add.location').val();
			var pcCount = $('input.add.pc-count').val();
			
	    	$('#submit-type').val(type);
			$('#submit-name').val(name);
			$('#submit-location').val(location);
			$('#submit-pc-count').val(pcCount);
			
			
			$('#frmSubmit').submit();
		})
	
		
		$('button.btnedit').click(function() {
			
			var id = $(this).attr('tag');
			console.log(id);
			var type = 0;
			var name = $('input.id-'+id+'.name').val();
			var location = $('input.id-'+id+'.location').val();
			var pcCount = $('input.id-'+id+'.pc-count').val();
			
			console.log(name + ' ' + location + ' ' + pcCount);
			
			$('#submit-type').val(1);
			$('#submit-id').val(id);
			$('#submit-name').val(name);
			$('#submit-location').val(location);
			$('#submit-pc-count').val(pcCount);
			
			
			$('#frmSubmit').submit();
			
			

		});
	
	</script>


</body>
</html>
