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

                        <form id="form1" class="form-horizontal" method="post" action="${mode}">

                            <input type="hidden" name="roleId" value="${roleMap.roleId}">


                            <div class="form-group"><label class="col-sm-2 control-label">Description</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Description" id="roleDesc" name="roleDesc"
                                                             type="text" value="${roleMap.roleDesc}" required></div>
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
                        <th>Description</th>
                        <th>Action</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${roleList}" var="data" varStatus="count">

                        <tr>
                            <td>${count.count}.</td>

                            <td><%--<c:choose><c:when test="${data.roleDesc == 'ADMIN'}">Admin</c:when>
                                <c:when test="${data.roleDesc == 'ROLE_REGISTER'}">Register</c:when>
                                <c:otherwise>${data.roleDesc}</c:otherwise>
                            </c:choose>--%> ${data.roleDesc}</td>
                            <td class="center">
                                <c:if test="${(data.roleDesc != 'ROLE_ADMIN') && (data.roleDesc != 'ROLE_REGISTER')}">
                                    <a class="btn btn-info" href="edit/${data.roleId}" title="Edit"
                                       data-rel="tooltip">
                                        <i class="fa fa-edit"></i>
                                    </a>

                                    <a class="open btn btn-danger" title="Delete" data-toggle="modal"
                                       data-target="#myModal_del"
                                       data-id="${data.roleId}" data-rel="tooltip">
                                        <i class="fa fa-trash"></i>
                                    </a>
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
                description: {
                    required: true,
                    alphaNumeric: true
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