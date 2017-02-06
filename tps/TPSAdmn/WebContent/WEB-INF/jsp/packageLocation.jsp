<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>

    <!-- start: Meta -->
    <meta charset="utf-8">
    <title>Package Location</title>
    <meta name="description" content="IGC Travel Portal System">
    <meta name="author" content="IGC Travel Portal System">
    <meta name="keyword" content="IGC Travel Portal System">
    <!-- end: Meta -->

    <!-- start: Mobile Specific -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- end: Mobile Specific -->

    <!-- 	base url -->

    <base href="${pageContext.request.contextPath}/packageLocation/"/>

    <!--  End	base url -->


    <!-- start: CSS -->


    <!-- ******script included********* -->
    <%@include file="/WEB-INF/includes/styling.jsp" %>

    <!-- ******  end of script included********* -->

    <!-- end: CSS -->


    <!-- start: Favicon -->
    <link rel="shortcut icon"
          href="${pageContext.request.contextPath}/img/favicon.ico">
    <!-- end: Favicon -->


</head>

<body>

<!-- delete confirm model -->

<div class="modal fade" id="myModal_del" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="delete" method="post">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">Delete Available
                        Date and Rate</h4>
                </div>
                <div class="modal-body">

                    Are you sure you want to delete this Available Date and Rate? This
                    action cannot be undone! <input id="deleteId" type="text"
                                                    style="display: none" value="" name="id">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-sm"
                            data-dismiss="modal">Close
                    </button>
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
            <div class="alert alert-block span10">
                <h4 class="alert-heading">Warning!</h4>
                <p>
                    You need to have <a href="http://en.wikipedia.org/wiki/JavaScript"
                                        target="_blank">JavaScript</a> enabled to use this site.
                </p>
            </div>
        </noscript>

        <!-- start: Content -->
        <div id="content" class="span20">


            <ul class="breadcrumb">
                <li><i class="icon-home"></i> <a href="index.html">Home</a> <i
                        class="icon-angle-right"></i></li>
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


            <c:if test="${mode!='view'}">
                <div class="test">
                    <a href="view" title="View room Facility" data-rel="tooltip" class="btn btn-success">View Package
                        Location                         </a>
                </div>

            </c:if>


            <c:if test="${mode=='view'}">
                <div class="row-fluid sortable">
                    <div class="box span12" id="box">
                        <div class="box-header" data-original-title>
                            <h2>
                                <i class="halflings-icon white edit"></i><span class="break"></span>
                                Package list
                            </h2>
                            <div class="box-icon">
                                <a href="#" class="btn-setting"><i
                                        class="halflings-icon white wrench"></i></a> <a href="#"
                                                                                        class="btn-minimize"><i
                                    class="halflings-icon white chevron-up"></i></a> <a href="#"
                                                                                        class="btn-close"><i
                                    class="halflings-icon white remove"></i></a>
                            </div>
                        </div>
                        <div class="box-content">
                            <form id="form1" class="form-horizontal" method="post"
                                  action="packageInfo">
                                <fieldset>
                                    <div class="control-group">
                                        <label class="control-label" for="packageInfoId">Package</label>
                                        <div class="controls">

                                            <select id="packageInfoId" name="packageInfoId"
                                                    data-rel="chosen">
                                                <option value="">SELECT</option>
                                                <c:forEach items="${packageInfoList}" var="data">
                                                    <option value="${data.packageInfoId}"
                                                            <c:if test="${data.packageInfoId==packageInfoId}">selected="selected"</c:if>>${data.description}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-actions">
                                        <button type="submit" class="btn btn-primary">Go</button>
                                        <!-- 								<button class="btn" id="cancel">Cancel</button> -->
                                    </div>

                                </fieldset>
                            </form>

                        </div>
                    </div>
                    <!--/span-->

                </div>
            </c:if>


            <c:if test="${locationView==true}">

                <div class="row-fluid sortable">

                    <form class="form-horizontal" method="post" action="add">
                        <div class="box span12">
                            <div class="box-header" data-original-title>
                                <h2>
                                    <i class="halflings-icon white edit"></i><span
                                        class="break"></span>Add Location
                                </h2>
                                <div class="box-icon">
                                    <a href="#" class="btn-setting"><i
                                            class="halflings-icon white wrench"></i></a> <a href="#"
                                                                                            class="btn-minimize"><i
                                        class="halflings-icon white chevron-up"></i></a> <a href="#"
                                                                                            class="btn-close"><i
                                        class="halflings-icon white remove"></i></a>
                                </div>
                            </div>
                            <div class="box-content">

                                <fieldset>
                                    <div class="control-group">
                                        <label class="control-label" for="packageName">Package</label>
                                        <div class="controls">

                                            <input class="input-xlarge focused" id="packageName"
                                                   disabled="disabled" name="packageName" type="text"
                                                   value="${packageItineraryMap.packageName} ">
                                        </div>
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="focusedInput">Day</label>
                                        <div class="controls">
                                            <input type="hidden" name="packageItineraryId"
                                                   value="${packageItineraryMap.packageItineraryId}">
                                            <input class="input-xlarge focused" id="day"
                                                   disabled="disabled" name="day" type="text"
                                                   value="${packageItineraryMap.day} ">
                                        </div>
                                    </div>


                                    <div class="control-group">
                                        <label class="control-label" for="regionId">Location</label>
                                        <div class="controls">
                                            <select id="regionId" name="areaId" data-rel="chosen">
                                                <c:forEach items="${regionList}" var="data">
                                                    <option value="${data.areaId}"> ${data.areaName},${data.regionName},${data.countryName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="modal-footer">
                                        <button type="button" class="btn"
                                                data-dismiss="modal">Close
                                        </button>
                                        <button type="submit" class="btn btn-primary">Save</button>
                                    </div>

                                </fieldset>


                            </div>
                        </div>
                        <!--/span-->


                    </form>
                </div>

            </c:if>



            <c:if test="${itineraryView==true}">
                <!-- table -->

                <div class="row-fluid sortable">
                    <div class="box span12">
                        <div class="box-header" data-original-title>
                            <h2>
                                <i class="halflings-icon white user"></i><span class="break"></span>Available
                                Package Itinerary List
                            </h2>
                            <div class="box-icon">
                                <a href="#" class="btn-setting"><i
                                        class="halflings-icon white wrench"></i></a> <a href="#"
                                                                                        class="btn-minimize"><i
                                    class="halflings-icon white chevron-up"></i></a> <a href="#"
                                                                                        class="btn-close"><i
                                    class="halflings-icon white remove"></i></a>
                            </div>
                        </div>
                        <div class="box-content">
                            <table
                                    class="table table-striped table-bordered bootstrap-datatable datatable">
                                <thead>
                                <tr>
                                    <th>S.N</th>
                                    <th>Package</th>
                                    <th>Day</th>
                                    <th>Actions</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    int count = 0;
                                %>
                                <c:forEach items="${packageItineraryList}" var="data">
                                    <%
                                        count++;
                                    %>
                                    <tr>
                                        <td><%=count%>.</td>
                                        <td>${data.packageName}</td>
                                        <td>${data.day}</td>
                                        <td class="center"><a class="btn btn-info"
                                                              href="add/${data.packageItineraryId}" title="Add Location"
                                                              data-rel="tooltip"> <i
                                                class="halflings-icon plus-sign white"></i>
                                        </a>
                                            <a class="detail btn btn-success"
                                               href="detail/${data.packageItineraryId}" title="View Location"
                                               data-rel="tooltip"> <i class="white icon-eye-open"></i>
                                            </a>

                                                <%-- <a class="open btn btn-danger" title="Remove Location"
                                                    data-toggle="modal" data-target="#myModal_del"
                                                    data-id="${data.packageItineraryId}" data-rel="tooltip">
                                                        <i class="halflings-icon white trash"></i>
                                                </a>

                                                <a class="open1 btn btn-danger" title="Remove Location"
                                                    data-toggle="modal" data-target="#myModal"
                                                    data-id="${data.packageItineraryId}" data-rel="tooltip">
                                                        <i class="halflings-icon white trash"></i>
                                                </a> --%>

                                        </td>
                                    </tr>


                                </c:forEach>


                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!--/span-->

                </div>
                <!--/row-->

                <!-- end table -->

            </c:if>


            <c:if test="${detailView==true}">

                <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
                     aria-labelledby="myModalLabel" aria-hidden="true">

                    <div class="modal-dialog">

                        <div class="modal-content">

                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                                <h4 class="modal-title" id="myModalLabel">Package Location Detail</h4>
                            </div>

                            <div class="modal-body " style="min-height: 400px;">

                                <!-- 									/////////////// -->


                                <div class="row-fluid sortable">

                                    <form class="form-horizontal location-detail-form" method="post" action="add">
                                        <div class="box span12">
                                            <div class="box-header" data-original-title>
                                                <h2>
                                                    <i class="halflings-icon white edit"></i><span
                                                        class="break"></span>Itinerary Detail
                                                </h2>
                                                <div class="box-icon">
                                                    <a href="#" class="btn-setting"><i
                                                            class="halflings-icon white wrench"></i></a> <a href="#"
                                                                                                            class="btn-minimize"><i
                                                        class="halflings-icon white chevron-up"></i></a> <a href="#"
                                                                                                            class="btn-close"><i
                                                        class="halflings-icon white remove"></i></a>
                                                </div>
                                            </div>
                                            <div class="box-content">

                                                <fieldset>
                                                    <div class="control-group">
                                                        <label class="control-label" for="packageName">Package</label>
                                                        <div class="controls">

                                                            <input class="input-xlarge focused" id="packageName"
                                                                   disabled="disabled" name="packageName" type="text"
                                                                   value="${packageItineraryMap.packageName} ">
                                                        </div>
                                                    </div>

                                                    <div class="control-group">
                                                        <label class="control-label" for="focusedInput">Day</label>
                                                        <div class="controls">
                                                            <input type="hidden" name="packageItineraryId"
                                                                   value="${packageItineraryMap.packageItineraryId}">
                                                            <input class="input-xlarge focused" id="day"
                                                                   disabled="disabled" name="day" type="text"
                                                                   value="${packageItineraryMap.day} ">
                                                        </div>
                                                    </div>

                                                </fieldset>
                                            </div>
                                        </div>
                                        <!--/span-->


                                        <!-- 											///// table  -->
                                        <div class="box span12">
                                            <div class="box-header">
                                                <h2>
                                                    <i class="halflings-icon white align-justify"></i><span
                                                        class="break"></span>Location List
                                                </h2>
                                                <!-- <div class="box-icon">
                                                    <a href="#" class="btn-setting"><i
                                                        class="halflings-icon white wrench"></i></a> <a href="#"
                                                        class="btn-minimize"><i
                                                        class="halflings-icon white chevron-up"></i></a> <a href="#"
                                                        class="btn-close"><i
                                                        class="halflings-icon white remove"></i></a>
                                                </div> -->
                                            </div>
                                            <div class="box-content">
                                                <table class="table delete-package">
                                                    <thead>
                                                    <tr>
                                                        <th>S.N</th>
                                                        <th>Location</th>
                                                        <th>Action</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <%int count = 0; %>
                                                    <c:forEach items="${packageLocationList}" var="data">
                                                        <%count++; %>
                                                        <tr>
                                                            <td><%=count%>.</td>
                                                            <td class="center">${data.areaName},${data.regionName},${data.countryName}</td>

                                                            <td class="center"><a class="open btn btn-danger"
                                                                                  title="Delete Location"
                                                                                  data-toggle="modal"
                                                                                  data-target="#myModal_del"
                                                                                  data-id="${data.packageLocationId}"
                                                                                  data-rel="tooltip">
                                                                <i class="halflings-icon white trash"></i>
                                                            </a></td>
                                                        </tr>
                                                    </c:forEach>

                                                    </tbody>
                                                </table>

                                            </div>
                                        </div>
                                        <!--/span-->


                                        <!-- 											////// table -->


                                    </form>
                                </div>
                                <!--/row-->

                            </div>

                            <div class="modal-footer padding-modal-footer">
                                <a href="#" class="btn" data-dismiss="modal">Close</a>
                            </div>

                        </div>


                    </div>

                </div>

            </c:if>


        </div>
        <!--/.fluid-container-->

        <!-- end: Content -->
    </div>
    <!--/#content.span10-->
</div>
<!--/fluid-row-->


<div class="clearfix"></div>

<footer>

    <p>
			<span style="text-align: left; float: left">&copy; 2013 <a
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
    $(document).on("click", ".open", function () {
        var id = $(this).data('id');
        $(".modal-body #deleteId").val(id);

    });

    /* $(document).on("click", ".open1", function() {
     alert("this is testing");

     }); */

    $(window).load(function () {
        $('#myModal').modal('show');
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

<c:if test="${mode=='edit'}">
    <script type="text/javascript">
        $("#packageInfoId").attr("disabled", true);
    </script>
</c:if>


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
