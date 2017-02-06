<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>

    <!-- start: Meta -->
    <meta charset="utf-8">
    <title>Bed Type</title>
    <meta name="description" content="IGC Travel Portal System">
    <meta name="author" content="IGC Travel Portal System">
    <meta name="keyword" content="IGC Travel Portal System">
    <!-- end: Meta -->

    <!-- start: Mobile Specific -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- end: Mobile Specific -->

    <!-- 	base url -->

    <base href="${pageContext.request.contextPath}/bedType/"/>

    <!--  End	base url -->


    <!-- start: CSS -->


    <!-- ******script included********* -->
    <%@include file="/WEB-INF/includes/styling.jsp" %>

    <!-- ******  end of script included********* -->

    <!-- end: CSS -->


    <!-- start: Favicon -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
    <!-- end: Favicon -->


</head>

<body>

<!-- delete confirm model -->

<div class="modal fade" id="myModal_del" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="delete" method="post">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Delete Bed Type</h4>
                </div>
                <div class="modal-body">

                    Are you sure you want to delete this Region? This action cannot be undone!
                    <input id="deleteId" type="text" style="display: none" value="" name="id">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary btn-sm">Delete</button>
                </div>

            </form>

        </div>
    </div>
</div>

<!-- End   delete confirm model -->

<!-- start: Header -->

<!--     ***** header******  -->

<%@include file="/WEB-INF/includes/header.jsp" %>

<!--     ***** end  header******  -->

<!-- end: Header -->

<div class="container-fluid-full">
    <div class="row-fluid">

        <!-- start: Main Menu -->

        <!--     ***** navigator******  -->

        <%@include file="/WEB-INF/includes/navigator.jsp" %>

        <!--     ***** end  navigator******  -->

        <!-- end: Main Menu -->

        <noscript>
            <div class="alert alert-block span10 ">
                <h4 class="alert-heading">Warning!</h4>
                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <!-- start: Content -->
        <div id="content" class="span10">


            <ul class="breadcrumb">
                <li>
                    <i class="icon-home"></i>
                    <a href="index.html">Home</a>
                    <i class="icon-angle-right"></i>
                </li>
                <li><a href="#">Messages</a></li>
            </ul>


            <%-- 			${dbResponse} --%>
            <!-- 			 success alert -->
            <c:if test="${dbResponse!=null}">
                <div class="alert alert-success">
                    <button type="button" class="close" data-dismiss="alert">×</button>
                    <strong>Well Done!</strong> ${dbResponse.msg }
                </div>
            </c:if>


            <div class="test">
                <a href="add" title="Add BedType" data-rel="tooltip" class="btn btn-warning">Add BedType</a>
            </div>

            <c:if test="${mode!='view'}">
                <div class="test">
                    <a href="view" title="View Bed Types" data-rel="tooltip" class="btn btn-success">View Bed Types </a>
                </div>

            </c:if>


            <c:if test="${mode=='edit' || mode=='add'  }">


                <div class="row-fluid sortable">
                    <div class="box span12" id="box">

                        <div class="box-content">
                            <form id="form1" class="form-horizontal" method="post" action="${mode}">
                                <fieldset>

                                    <input type="hidden" name="bedTypeId" value="${bedMap.bedTypeId}">

                                    <div class="control-group">
                                        <label class="control-label" for="bedTypeDesc">Bed Type</label>
                                        <div class="controls">
                                            <input class="input-xlarge focused" id="bedTypeDesc" name="bedTypeDesc"
                                                   type="text" value="${bedMap.bedTypeDesc}" required>
                                        </div>
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="size">Size</label>
                                        <div class="controls">
                                            <input class="input-xlarge focused" id="size" name="size"
                                                   type="text" value="${bedMap.size}" required>
                                        </div>
                                    </div>

                                    <div class="form-actions">
                                        <button type="submit" class="btn btn-primary">Save changes</button>
                                        <button class="btn" id="cancel">Cancel</button>
                                    </div>

                                </fieldset>
                            </form>

                        </div>
                    </div>
                    <!--/span-->

                </div>
                <!--/row-->

            </c:if>
            <c:if test="${mode=='view'}">


                <div class="row-fluid sortable">
                    <div class="box span12">
                        <div class="box-header" data-original-title>
                            <h2><i class="halflings-icon white list"></i><span class="break"></span>Bed Type List
                            </h2>

                            <div class="box-icon">
                                <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
                                <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
                                <a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
                            </div>
                        </div>
                        <div class="box-content">
                            <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                <thead>
                                <tr>
                                    <th>S.N</th>
                                    <th>Bed</th>
                                    <th>Size</th>
                                    <th>Action</th>

                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${bedTypeList}" var="data" varStatus="count">
                                    <tr>
                                        <td>${count.count}.</td>

                                        <td>${data.bedTypeDesc}</td>
                                        <td>${data.size}</td>

                                        <td class="center">

                                            <a class="btn btn-info" href="edit/${data.bedTypeId}" title="Edit"
                                               data-rel="tooltip">
                                                <i class="halflings-icon white edit"></i>
                                            </a>

                                            <a class="open btn btn-danger" title="Delete" data-toggle="modal"
                                               data-target="#myModal_del"
                                               data-id="${data.bedTypeId}" data-rel="tooltip">
                                                <i class="halflings-icon white trash"></i>
                                            </a>
                                        </td>
                                    </tr>


                                </c:forEach>


                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!--/span-->

                </div>
            </c:if>


            <!-- 			end table -->


        </div><!--/.fluid-container-->

        <!-- end: Content -->
    </div><!--/#content.span10-->
</div><!--/fluid-row-->

<div class="modal hide fade" id="myModal">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h3>Settings</h3>
    </div>
    <div class="modal-body">
        <p>Here settings can be configured...</p>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn" data-dismiss="modal">Close</a>
        <a href="#" class="btn btn-primary">Save changes</a>
    </div>
</div>

<div class="clearfix"></div>

<footer>

    <p>
        <span style="text-align:left;float:left">&copy; 2013 <a
                href="http://themifycloud.com/downloads/janux-free-responsive-admin-dashboard-template/"
                alt="Bootstrap_Metro_Dashboard">JANUX Responsive Dashboard</a></span>

    </p>

</footer>

<!-- start: JavaScript-->

<!-- ******script included********* -->
<%@include file="/WEB-INF/includes/script.jsp" %>

<!-- ******  end of script included********* -->

<!-- end: JavaScript-->

<script type="text/javascript">

    //
    <!-- 	pass deleteing  id to delete confirm model  -->

    $(document).on("click", ".open", function () {
        var id = $(this).data('id');
        var hotelDetailId = $(this).data('hid');

        console.log(id);
        console.log(hotelDetailId);

        $(".modal-body #deleteId").val(id);
        $(".modal-body #hid").val(hotelDetailId);

    });

    //
    <!-- End	pass deleteing  id to delete confirm model 	 -->

    // clicking cancel button to close add/edit/detail form
    $(document).on("click", "#cancel", function () {
        $('#form1').submit(function () {
            return false;
        });

        $("#box").hide();

    });
    // end  clicking cancel button to close add/edit/detail form

</script>

<!-- enable  script for detail view to disable textEditor -->

<c:if test="${mode=='detail'}">
    <script type="text/javascript">
        $("#form1 :input").attr("disabled", true);

        $(document).ready(function () {
            $("#textEditor").setReadOnly(isReadOnly);
        });
    </script>
</c:if>

<!-- enable  script for detail view to disable textEditor -->

</body>
</html>
