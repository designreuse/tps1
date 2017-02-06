<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>

    <!-- start: Meta -->
    <meta charset="utf-8">
    <title>Facility</title>
    <meta name="description" content="IGC Travel Portal System">
    <meta name="author" content="IGC Travel Portal System">
    <meta name="keyword" content="IGC Travel Portal System">
    <!-- end: Meta -->

    <!-- start: Mobile Specific -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- end: Mobile Specific -->

    <!-- 	base url -->

    <base href="${pageContext.request.contextPath}/facility/"/>

    <!--  End	base url -->


    <!-- start: CSS -->


    <!-- ******script included********* -->


    <%@include file="../includes/styling.jsp" %>
    <link  href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css" rel="stylesheet">

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
                    <h4 class="modal-title" id="myModalLabel">Delete Room Facility</h4>
                </div>
                <div class="modal-body">

                    Are you sure you want to delete this Facility? This action cannot be undone!
                    <input id="deleteId" type="text" style="display: none" value="" name="facilityId">


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

        <%@include file="/WEB-INF/includes/navigator.jsp" %>


        <noscript>
            <div class="alert alert-block span10">
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

            <c:if test="${dbResponse!=null}">
                <div class="alert alert-success">
                    <button type="button" class="close" data-dismiss="alert">×</button>
                    <strong>Well Done!</strong> ${dbResponse.msg }
                </div>
            </c:if>


            <c:if test="${mode=='edit' || mode=='add'  }">
                <div class="test">
                    <a href="view" title="View Popular Place" data-rel="tooltip" class="btn btn-success">View Facilities </a>
                </div>

                <div class="row-fluid sortable">
                    <div class="box span12" id="box">
                        <div class="box-header" data-original-title>
                            <h2><i class="halflings-icon white edit"></i><span class="break"></span><c:if
                                    test="${mode=='add'}">Add</c:if><c:if test="${mode=='edit'}">Edit</c:if> Facility
                            </h2>

                            <div class="box-icon">
                                <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
                                <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
                                <a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
                            </div>
                        </div>
                        <div class="box-content">
                            <form id="form1" class="form-horizontal" method="post" action="${mode}">
                                <fieldset>

                                    <input type="hidden" name="facilityId" value="${facilityMap.facilityId}">

                                    <div class="control-group">
                                        <label class="control-label" for="facilityDesc">Facility</label>
                                        <div class="controls">
                                            <input class="input-xlarge focused" id="facilityDesc" name="facilityDesc"
                                                   type="text" value="${facilityMap.facilityDesc}" required>
                                        </div>
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="type">Type</label>
                                        <div class="controls">
                                            <select id="type" name="type" data-rel="chosen">
                                                    <option value="HOTEL"
                                                            <c:if test="${facilityMap.type=='HOTEL'}">selected="selected"</c:if>  >Hotel</option>
                                                <option value="ROOM"
                                                        <c:if test="${facilityMap.type=='ROOM'}">selected="selected"</c:if>  >Room</option>

                                            </select>
                                        </div>
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="icon">Icon</label>
                                        <div class="controls">
                                            <input class="input-xlarge focused" id="icon" name="icon"
                                                   type="text" value="${facilityMap.icon}" >
                                        </div>
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="image">Image</label>
                                        <div class="controls">
                                            <input class="input-xlarge focused" id="image" name="image"
                                                   type="text" value="${facilityMap.image}" >
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
            <div class="test">
                <a href="add" title="Add Faciliyt" data-rel="tooltip" class="btn btn-warning">Add Facility </a>
            </div>

                <div class="row-fluid sortable">
                    <div class="box span12">
                        <div class="box-header" data-original-title>
                            <h2><i class="halflings-icon white list"></i><span class="break"></span>Popular Place List
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
                                    <th>Facility</th>
                                    <th>Type</th>
                                    <th>Icon</th>
                                    <th>Action</th>

                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${facilityList}" var="data" varStatus="count">
                                    <tr>
                                        <td>${count.count}.</td>

                                        <td>${data.facilityDesc}</td>
                                        <td>${data.type}</td>
                                        <td class="icn"><c:choose><c:when test="${data.icon!=null}"><i class="fa fa-${data.icon}"></i></c:when>
                                            <c:when test="${data.image!=null}">${data.image}</c:when></c:choose></td>
                                        <td class="center">

                                            <a class="btn btn-info" href="edit/${data.facilityId}" title="Edit"
                                               data-rel="tooltip">
                                                <i class="halflings-icon white edit"></i>
                                            </a>

                                            <a class="open btn btn-danger" title="Delete" data-toggle="modal"
                                               data-target="#myModal_del"
                                               data-id="${data.facilityId}" data-rel="tooltip">
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


        </div>
        <!--/.fluid-container-->

        <!-- end: Content -->
    </div>
    <!--/#content.span10-->
</div>
<!--/fluid-row-->
<!--/fluid-row-->


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

        $(".modal-body #deleteId").val(id);



    });

    //
    <!-- End	pass deleteing  id to delete confirm model 	 -->



    //clicking cancel button to close add/edit/detail form
    $(document).on("click", "#cancel", function () {
        $('#form1').submit(function () {
            return false;
        });
        $("#box").hide();


    });
    //end  clicking cancel button to close add/edit/detail form

</script>

</body>
</html>
