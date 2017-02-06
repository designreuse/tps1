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

                            <input type="hidden" name="contentId" value="${contentMap.contentId}">


                            <div class="form-group"><label class="col-sm-2 control-label">Content Title</label>
                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Content Title" id="contentTitle" name="contentTitle"
                                                             value="${contentMap.contentTitle}" required></div>
                            </div>
                            <div class="form-group"><label class="col-sm-2 control-label">Content Url</label>
                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Content Url" id="contentUrl" name="contentUrl"
                                                             value="${contentMap.contentUrl}" required></div>
                            </div>
                            <div class="form-group"><label class="col-sm-2 control-label">Content Page Title</label>
                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Content Page Title" id="contentPageTitle" name="contentPageTitle"
                                                             value="${contentMap.contentPageTitle}" required></div>
                            </div>
                            <div class="form-group"><label class="col-sm-2 control-label">Content Body</label>
                                <div class="col-sm-10"><textarea class="summernote" name="contentBody" id="contentBody">${contentMap.contentBody}</textarea></div>
                            </div>
                            <div class="form-group"><label class="col-sm-2 control-label">Meta Description</label>
                                <div class="col-sm-10"><textarea class="form-control" name="metaDescription" id="metaDescription">${contentMap.metaDescription}</textarea></div>
                            </div>
                            <div class="form-group"><label class="col-sm-2 control-label">Meta Keywords</label>
                                <div class="col-sm-10"><textarea class="form-control" name="metaKeywords" id="metaKeywords">${contentMap.metaKeywords}</textarea></div>
                            </div>
                            <div class="form-group"><label class="col-sm-2 control-label">Meta Title</label>
                                <div class="col-sm-10"><input type="text" class="form-control"
                                                              placeholder="Meta Title" id="metaTitle" name="metaTitle"
                                                              value="${contentMap.metaTitle}" required>
                                    <%--<textarea class="form-control" name="metaTitle" id="metaTitle">${contentMap.metaTitle}</textarea>--%></div>
                            </div>
                            <div class="form-group"><label class="col-sm-2 control-label">Content Tag</label>
                                <div class="col-sm-3"> <select data-placeholder="Select Tags" class="form-control m-b chosen-select" multiple style="width:350px;" tabindex="4" name="tagList">
                                    <option value="">Select</option>
                                    <c:forEach items="${tagList}" var="tag">
                                        <option value="${tag.tagId}" <c:forEach items="${selectedContentTag}" var="selected">
                                            <c:if test="${tag.tagId == selected.tagId}">selected</c:if> </c:forEach> >${tag.description}</option>
                                    </c:forEach>
                                </select></div>
                            </div>
                            <div class="form-group"><label class="col-sm-2 control-label">New Tag
                                <%--<br><small class="text-navy">seperate tag with commag(,)</small>--%></label>
                                <div class="col-sm-10"><input type="text" class="form-control"
                                                              placeholder="Tag1,Tag2" id="newTag" name="newTags"
                                                              >
                                        </div>
                            </div>
                            <div></div>
                            <div class="form-group"><label class="col-sm-2 control-label">Active</label>
                                <div class="col-sm-3"><input type="checkbox" name="active" value="Y"></div>
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
                    <c:forEach items="${contentList}" var="data" varStatus="count">

                        <tr>
                            <td>${count.count}.</td>

                            <td><%--<c:choose><c:when test="${data.contentDesc == 'ADMIN'}">Admin</c:when>
                                <c:when test="${data.contentDesc == 'ROLE_REGISTER'}">Register</c:when>
                                <c:otherwise>${data.contentDesc}</c:otherwise>
                            </c:choose>--%> ${data.contentTitle}</td>
                            <td class="center">
                                    <a class="btn btn-info" href="edit/${data.contentId}" title="Edit"
                                       data-rel="tooltip">
                                        <i class="fa fa-edit"></i>
                                    </a>

                                    <a class="open btn btn-danger" title="Delete" data-toggle="modal"
                                       data-target="#myModal_del"
                                       data-id="${data.contentId}" data-rel="tooltip">
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
        $(".chosen-select").select2();

        /*  var aHTML = $('.summernote').code();
         alert(aHTML.length);*/

    });
    $(function () {
       /* jQuery.validator.addMethod("alphaNumeric", function (value, element) {
            // return true - means the field passed validation
            // return false - means the field failed validation and it triggers the error
            return this.optional(element) || /^([\w\s]+)$/.test(value);
        }, "Only alphanumeric value and underscore is allowed!");*/

//	 	   $( "#addform" ).validate();
        $('#form1').validate({
            ignore: ':hidden:not("#contentBody")',
            errorPlacement: function( label, element ) {
                element.parent().append( label );

            },
            rules: {
                contentTitle: {
                    required: true
                },
                contentUrl: {
                    required: true
                },
                contentPageTitle: {
                    required: true
                },
                contentBody: {
                    required: true,
                    minlength:100,
                    maxlength: 8000
                },
                metaDescription: {
                    required: true
                },
                metaKeywords: {
                    required: true
                },
                metaTitle: {
                    required: true
                }
            },
           messages: {
            description: {
                required: "This field is required.",
                        minlength: "This field is required."
            }
        }

        });
    });
</script>

</body>
</html>