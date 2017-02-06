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
            <c:if test="${mode=='update'}">
                <div class="p-w-md m-t-sm">
                    <div class="row update-form">
                        <form id="form1" class="form-horizontal" method="post" action="update">

                            <input type="hidden" name="userDetailId" value="${userDetailMap.userDetailId}">


                            <div class="form-group"><label class="col-sm-2 control-label">Name</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Name" id="name" name="name"
                                                             value="${userDetailMap.name}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Address</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Address" id="address" name="address"
                                                             value="${userDetailMap.address}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Phone No.</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Phone No." id="phoneNo" name="phoneNo"
                                                             value="${userDetailMap.phoneNo}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Email Id</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Email Id" id="emailId" name="emailId"
                                                             value="${userDetailMap.emailId}" required></div>
                            </div>

                            <%--<div class="form-group"><label class="col-sm-2 control-label">Username</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Username" id="username" name="userName"
                                                             value="${userDetailMap.userName}" required></div>
                            </div>--%>
<c:if test="${userDetailMap.password==null}">
    <div class="form-group"><label class="col-sm-2 control-label">Password</label>

        <div class="col-sm-3"><input type="password" class="form-control"
                                     placeholder="Password" id="password" name="password"
                                     value="${userDetailMap.password}" required></div>
    </div>
</c:if>


                            <div class="form-group"><label class="col-sm-2 control-label">Role</label>

                                <div class="col-sm-3"><select id="roleId" name="roleId" class="form-control m-b" required>
                                    <option value="">Select</option>
                                    <c:forEach items="${roleList}" var="data">
                                        <option value="${data.roleId}" <c:if test="${data.roleId==userDetailMap.roleId}">selected="selected"</c:if>>${data.roleDesc}</option>
                                    </c:forEach>

                                </select></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Active</label>

                                <div class="col-sm-3"><input type="checkbox" name="active" class="i-checks" value="1"
                <c:if test="${userDetailMap.active==1 || userDetailMap==null}"> checked</c:if> ></div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button type="submit" class="btn btn-primary">Save changes</button>
                                </div>
                            </div>


                        </form>

                    </div>
                </div>
            </c:if>
            <c:if test="${mode=='view'}">
                <div class="row add-btn">
                    <a href="add" class="btn btn-primary">Add</a>
                </div>
            </c:if>
            <div class="row">
                <table class="table table-striped table-bordered bootstrap-datatable datatable">
                    <thead>
                    <tr>
                        <th>S.N</th>
                        <th>Name</th>
                        <th>Address</th>
                        <th>Phone No</th>
                        <th>Email Id</th>
                        <%--<th>Username</th>--%>
                        <th>Role</th>
                        <th>Status</th>
                        <th>Action</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userDetailList}" var="data" varStatus="count">

                        <tr>
                            <td>${count.count}.</td>

                            <td>${data.name}</td>
                            <td>${data.address}</td>
                            <td>${data.phoneNo}</td>
                            <td>${data.emailId}</td>
                            <%--<td>${data.userName}</td>--%>
                            <td>${data.roleDesc}</td>
                            <td><c:choose><c:when test="${data.active==0}">Inactive</c:when><c:when test="${data.active==1}">Active</c:when></c:choose></td>
                            <td class="center">

                                <a class="btn btn-info" href="edit/${data.userDetailId}" title="Edit"
                                   data-rel="tooltip">
                                    <i class="fa fa-edit"></i>
                                </a>

                                <a class="open btn btn-danger" title="Delete" data-toggle="modal"
                                   data-target="#myModal_del"
                                   data-id="${data.userDetailId}" data-rel="tooltip">
                                    <i class="fa fa-trash"></i>
                                </a>
                            </td>
                        </tr>


                    </c:forEach>


                    </tbody>
                </table>
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

        jQuery.validator.addMethod("phoneNumber", function(value, element) {
            // return true - means the field passed validation
            // return false - means the field failed validation and it triggers the error
            // 		    return this.optional(element) || /^\+?([0-9]{1,4})\)?[-. ]?([0-9]{7,14})$/.test(value);
            return this.optional(element)
                    || /^\+?([0-9-\s]){7,19}$/.test(value);
        }, "Please enter valid phone number");


        $('#form1').validate({
            rules: {
                name: {
                    required: true,
                    alphaNumeric: true
                },
                address:{
                    required: true,
                    alphaNumeric: true
                },
                phoneNo:{
                    required: true,
                    phoneNumber: true
                },
                emailId: {
                    required: true,
                    email: true
                },
                username: {
                    required: true
                },
                password: {
                    required: true
                },
                role: {
                    required: true
                }
            }
        });
    });
</script>

</body>
</html>