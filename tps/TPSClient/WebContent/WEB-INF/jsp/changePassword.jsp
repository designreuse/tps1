<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 5/13/2016
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/includes/header.jsp" %>


<div id="wrapper">
	<%@include file="/WEB-INF/includes/adminLeftNavigation.jsp" %>
	<div id="page-wrapper" class="gray-bg">
		<%@include file="/WEB-INF/includes/topNavigation.jsp" %>

		<div class="wrapper wrapper-content animated fadeIn">
				<div class="p-w-md m-t-sm">
					<div class="row update-form">

						<form id="form1" class="form-horizontal" method="post" action="${mode}">

							<%--<input type="hidden" name="roleId" value="${roleMap.roleId}">--%>


							<div class="form-group"><label class="col-sm-2 control-label">Current Password</label>

								<div class="col-sm-3"><input type="password" class="form-control"
															 placeholder="Current Password" id="currentPassword" name="currentPassword"
															 required></div>
							</div>

								<div class="form-group"><label class="col-sm-2 control-label">New Password</label>

									<div class="col-sm-3"><input type="password" class="form-control"
																 placeholder="New Password" id="newPassword" name="newPassword"
																 required></div>
								</div>

								<div class="form-group"><label class="col-sm-2 control-label">Retype Password</label>

									<div class="col-sm-3"><input type="password" class="form-control"
																 placeholder="Retype Password" id="retypePassword" name="retypePassword"
																 required></div>
								</div>

							<div class="form-group">
								<div class="col-sm-4 col-sm-offset-2">
									<button type="submit" class="btn btn-primary">Save changes</button>
								</div>
							</div>


						</form>

					</div>
				</div>

		</div>
	</div>
</div>
<%@include file="/WEB-INF/includes/script.jsp" %>
<script type="text/javascript">
	$(function () {
		jQuery.validator.addMethod("alphaNumeric", function (value, element) {
			// return true - means the field passed validation
			// return false - means the field failed validation and it triggers the error
			return this.optional(element) || /^([\w\s]+)$/.test(value);
		}, "Only alphanumeric value and underscore is allowed!");

//	 	   $( "#addform" ).validate();
		$('#form1').validate({
			rules: {
				currentPassword: {
					required: true
				},
				newPassword: {
					required: true
				},
				retypePassword: {
					required: true,
					equalTo: "#newPassword"
				}
			}
		});
	});
</script>
<%--<c:forEach items="${siteContent.js}" var="js">
    <script src="${pageContext.request.contextPath}/js/plugins/${js}"></script>
</c:forEach>--%>
<%--<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.js"></script>--%>

</body>
</html>