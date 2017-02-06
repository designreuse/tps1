<%@include file="/WEB-INF/includes/header.jsp" %>
<div id="wrapper">
	<%@include file="/WEB-INF/includes/adminLeftNavigation.jsp" %>
	<div id="page-wrapper" class="gray-bg">
		<%@include file="/WEB-INF/includes/topNavigation.jsp" %>

		<div class="wrapper wrapper-content animated fadeIn">



	<!-- Modal add user -->
	<c:if test="${add }">
		<div class="modal fade" id="myModal_add" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" >
				<div class="modal-content">
					<form action="add" method="post" class="emailInfo">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel1">Add <c:out value="${title }"></c:out></h4>
						</div>
						<div class="modal-body no-scroll">
	
							<div class="row">
								<div class="form-group col-md-6">
									<label class="control-label">Name</label> <input
										class="form-control" id="username" name="username" required="required" maxlength="50"
										type="text" placeholder="Username" value="${dataMapAdd.USER_NAME }">
									<label style="color: red"><c:out value="${errorAdd.USERNAME}"></c:out></label>
	
									<p class="help-block"></p>
								</div>
								
								<div class="form-group col-md-6">
									<label class="control-label">Email Id</label> <input
										class="form-control" id="emailId" name="emailId" required="required" maxlength="50"
										type="text" placeholder="Email Id" value="${dataMapAdd.EMAIL_ID }" >
									<label style="color: red"><c:out value="${errorAdd.EMAIL_ID}"></c:out></label>
	
									<p class="help-block"></p>
								</div>
	
								<div class="form-group col-md-6">
									<label class="control-label">Password</label> <input
										class="form-control" id="password" name="password" maxlength="50"
										required="required" type="password" placeholder="Password" value="${dataMapAdd.PASSWORD }">
									<label style="color: red"><c:out value="${errorAdd.PASSWORD}"></c:out></label>
	
									<p class="help-block"></p>
								</div>
	

								<div class="form-group col-md-6">
									<label class="control-label">Host</label> <input
										class="form-control" id="host" name="host" 
										required="required" type="text" placeholder="Host" value="${dataMapAdd.HOST }">
									<label style="color: red"><c:out value="${errorAdd.HOST}"></c:out></label>
	
									<p class="help-block"></p>
								</div>
	
								<div class="form-group col-md-6">
									<label class="control-label">Port</label> <input 
										class="form-control" id="port" name="port" value="${dataMapAdd.PORT }" 
										required="required" type="text" placeholder="Port">
									<label style="color: red"><c:out value="${errorAdd.port}"></c:out></label>
	
									<p class="help-block"></p>
								</div>
	
							</div>
	
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default btn-sm"
								data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary btn-sm">Add</button>
						</div>
	
					</form>
	
				</div>
			</div>
		</div>
	</c:if>
	<!-- model add user complete-->

	<c:if test="${edit==true}">

		<!-- Modal edit user -->
		<div class="modal fade" id="myModal_edit" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="edit" method="post" class="emailInfo">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel2">Edit <c:out value="${title }"></c:out></h4>
						</div>

						<div class="modal-body no-scroll">

							<div class="row">
								<input type="hidden"    name="id"    value="${dataMap.ID}"  >
								<div class="form-group col-md-6">
									<label class="control-label">Name</label> <input
										class="form-control" id="username" name="username" required="required" 
										type="text" placeholder="Username" value="${dataMap.USER_NAME }">
									<label style="color: red"><c:out value="${error.USERNAME}"></c:out></label>
	
									<p class="help-block"></p>
								</div>
								<div class="form-group col-md-6">
									<label class="control-label">EmailId</label> <input
										class="form-control" id="emailId" name="emailId" required="required" " 
										type="text" placeholder="Email Id" value="${dataMap.EMAIL_ID }">
									<label style="color: red"><c:out value="${error.EMAIL_ID}"></c:out></label>
	
									<p class="help-block"></p>
								</div>
	
								<div class="form-group col-md-6">
									<label class="control-label">Password</label> <input
										class="form-control" id="password" name="password" 
										required="required" type="password" placeholder="Password" value="${dataMap.PASSWORD }">
									<label style="color: red"><c:out value="${error.PASSWORD}"></c:out></label>
	
									<p class="help-block"></p>
								</div>
	

								<div class="form-group col-md-6">
									<label class="control-label">Host</label> <input
										class="form-control" id="host" name="host" pattern="^([\w\s])$" 
										required="required" type="text" placeholder="Host" value="${dataMap.HOST }">
									<label style="color: red"><c:out value="${error.HOST}"></c:out></label>
	
									<p class="help-block"></p>
								</div>
	
								<div class="form-group col-md-6">
									<label class="control-label">Port</label> <input 
										class="form-control" id="port" name="port" value="${dataMap.PORT }" 
										required="required" pattern="^([\w\s]{1,})$"  type="text" placeholder="Port">
									<label style="color: red"><c:out value="${error.port}"></c:out></label>
	
									<p class="help-block"></p>
								</div>
	
							</div>
								

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default btn-sm"
								data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-warning btn-sm">Update</button>
						</div>

					</form>

				</div>
			</div>
		</div>
		<!-- model edit user complete-->

	</c:if>

	<div id="wrapper">


		<!--     ***** navigator******  -->

		<%@include file="/WEB-INF/includes/navigator.jsp"%>

		<!--     ***** end  navigator******  -->

		<div id="page-wrapper">

			<div class="container-fluid">

				<c:if test="${dataStatus.MSG!=null && dataStatus.STATUS=='Success' }">
					<div class="row">

						<div class="col-lg-6">
							<!-- User added success message -->
							<div class="alert alert-success alert-dismissible user-added"
								role="alert">
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<strong>Congrats!</strong> ${dataStatus.MSG }
							</div>
						</div>
					</div>

				</c:if>
				
				<c:if test="${dataStatus.MSG!=null && dataStatus.STATUS=='Unsucess' }">
					<div class="row">

						<div class="col-lg-6">
							<!-- User added success message -->
							<div class="alert alert-danger alert-dismissible user-added"
								role="alert">
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<strong>Sorry!</strong> ${dataStatus.MSG }
							</div>
						</div>
					</div>

				</c:if>
				
				<c:if test="${dataStatus.MSG!=null && dataStatus.STATUS=='Unsucess' }">
					<div class="row">

						<div class="col-lg-6">
							<!-- User added success message -->
							<div class="alert alert-danger alert-dismissible user-added"
								role="alert">
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<strong>Sorry!</strong> ${dataStatus.MSG }
							</div>
						</div>
					</div>

				</c:if>



<%-- <c:if test="${activate==false }"> --%>
				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-9">
						<h1 class="page-header"><c:out value="${title }"></c:out></h1>
					</div>

					<div class="col-lg-3 text-right user-add-button">
						
							<a href="add" <c:if test="${add==false}">style="display: none" </c:if>>
							<button class="btn btn-success" title="delete this item"
								data-toggle="modal" 
								data-id="0001423232" id="addBtn">
	
								<i class="fa fa-plus-square"></i> Add new
	
							</button></a>
						


					</div>
				</div>
				<!-- /.row -->

				<div class="row">


					<div class="col-lg-12 table-responsive">
<%-- ${mt:charAt("AB",0)} <!-- It will give you A-->
 --%>
 <form action="activate" method="post">
						<table id="tableList" class="table table-bordered table-striped"
							cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>S.N</th>
									<th>Name</th>
									<th>Email Id</th>
									<th>Host</th>
									<th>Port</th>
									<th>Active</th>
									<th <c:if test="${edit==false }"> style="display: none"</c:if>>Edit</th>
									<th <c:if test="${delete==false }"> style="display: none"</c:if>>Delete</th>
								</tr>
							</thead>


							<tbody>

							
								<%int count=0; %>
								
								<c:forEach items="${dataList}" var="dataList">
									<%count++; %>
									<tr>
										<td><%=count %></td>
										<td>${dataList.USER_NAME}</td>
										<td>${dataList.EMAIL_ID}</td>
										<td>${dataList.HOST}</td>
										<td>${dataList.PORT}</td>
<%-- 										<td>${dataList.ACTIVE}</td> --%>
										<td> <input type="radio" value="${dataList.ID }" name="emailId" class="emailId" <c:if test="${dataList.ACTIVE==true}"> checked="checked" </c:if>></td>
										<td <c:if test="${edit==false }"> style="display: none"</c:if>><a style="text-decoration: none; color: inherit"
											href="edit/${dataList.ID}" title="edit this item"> <i
												class="fa fa-pencil" style="font-size: 18px"></i>
										</a></td>
										<td class="center" <c:if test="${delete==false }"> style="display: none"</c:if>><a
											class=" open btn btn-danger btn-sm " title="delete this item"
											data-toggle="modal" data-target="#myModal_del"
											data-id="${dataList.ID}"> <span
												class="glyphicon glyphicon-trash"></span> Delete
										</a></td>
									</tr>

								</c:forEach>
								

							</tbody>
						</table></form>
					</div>
				</div>
				<!-- /.container-fluid -->
<%-- </c:if> --%>
			</div>
			<!-- /#page-wrapper -->

		</div>
		<!-- /#wrapper -->
	</div>


		</div>
	</div>
</div>
<%@include file="/WEB-INF/includes/script.jsp" %>
<script>
	$('.emailId').change(function() {

		this.form.submit();
	});

	$(function() {
		jQuery.validator.addMethod("alphaNumeric", function(value, element) {
			// return true - means the field passed validation
			// return false - means the field failed validation and it triggers the error
			return this.optional(element) || /^([\w\s]+)$/.test(value);
		}, "Only alphanumeric value and underscore is allowed!");

//		 	   $( "#addform" ).validate();
		$('.emailInfo').validate({
			rules: {
				username: {
					required: true,
					alphaNumeric: true
				},
				emailId: {
					required: true,
					email: true
				},
				password:{
					required: true
				},
				host:{
					required: true
				},
				port:{
					required: true,
					number: true
				}
			} ,
			showErrors: function(errorMap, errorList) {
				$.each(this.successList, function(index, value) {
					return $(value).popover("hide");
				});

				return $.each(errorList, function(index, value) {
					var _popover;
					_popover = $(value.element).popover({
						trigger: "manual",
						placement: "bottom",
						content: value.message,
						css: "color:red",
						template: "<div class=\"popover\"><div class=\"arrow\"></div><div class=\"popover-inner\"><div class=\"popover-content\"><p></p></div></div></div>"
					});
					// Bootstrap 3.x :
					_popover.data("bs.popover").options.content = value.message;
					// Bootstrap 2.x :
//	 			      _popover.data("popover").options.content = value.message;
					return $(value.element).popover("show");
				});
			}
		});
	});
</script>
</body>
</html>
	

