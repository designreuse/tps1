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

                            <input type="hidden" name="agreementId" value="${agreementMap.agreementId}">


                            <div class="form-group"><label class="col-sm-2 control-label">Title</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Title" id="title" name="title"
                                                             value="${agreementMap.title}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Type</label>

                                <div class="col-sm-3">
                                    <select name="agreementAssignId" class="form-control m-b">
                                        <option value="">Select</option>
                                        <c:forEach items="${agreementAssignList}" var="agreementAssign">
                                            <option <c:if test="${agreementAssign.agreementId != null}"> selected </c:if> value="${agreementAssign.agreementAssignId}">${agreementAssign.type}</option>
                                        </c:forEach>


                                    </select></div>
                                    <%--<input type="text" class="form-control"
                                                             placeholder="Star Rating" name="starRating"
                                                             value="${hotelDetailMap.starRating}"></div>--%>
                            </div>

                            <%--<div class="hr-line-dashed"></div>--%>


                            <div class="form-group"><label class="col-sm-2 control-label">Content</label>
                                <div class="col-sm-10">
                                    <textarea class="summernote" name="content" id="content">${agreementMap.content}</textarea>
                                </div>

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
                        <th>Title</th>
                        <th>Type</th>
                        <th>Action</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${agreementList}" var="data" varStatus="count">

                        <tr>
                            <td>${count.count}.</td>

                            <td><%--<c:choose><c:when test="${data.agreementDesc == 'ADMIN'}">Admin</c:when>
                                <c:when test="${data.agreementDesc == 'ROLE_REGISTER'}">Register</c:when>
                                <c:otherwise>${data.agreementDesc}</c:otherwise>
                            </c:choose>--%> ${data.title}</td>
                            <td>${data.type}</td>
                            <td class="center">
                                    <a class="btn btn-info" href="edit/${data.agreementId}" title="Edit"
                                       data-rel="tooltip">
                                        <i class="fa fa-edit"></i>
                                    </a>

                                    <a class="open btn btn-danger" title="Delete" data-toggle="modal"
                                       data-target="#myModal_del"
                                       data-id="${data.agreementId}" data-rel="tooltip">
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
    $(document).ready(function(){

        $('.summernote').summernote();

        /*  var aHTML = $('.summernote').code();
         alert(aHTML.length);*/

    });

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