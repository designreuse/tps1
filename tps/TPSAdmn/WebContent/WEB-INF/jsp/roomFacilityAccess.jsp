<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
<head>

    <!-- start: Meta -->
    <meta charset="utf-8">
    <title>roomFacility</title>
    <meta name="description" content="IGC Travel Portal System">
    <meta name="author" content="IGC Travel Portal System">
    <meta name="keyword" content="IGC Travel Portal System">
    <!-- end: Meta -->

    <!-- start: Mobile Specific -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- end: Mobile Specific -->

    <!-- 	base url -->

    <base href="${pageContext.request.contextPath}/roomFacilityAccess/"/>

    <!--  End	base url -->


    <!-- start: CSS -->


    <!-- ******script included********* -->


    <!-- start: CSS -->
    <link id="bootstrap-style" href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/bootstrap-responsive.min.css" rel="stylesheet">
    <link id="base-style" href="../../css/style.css" rel="stylesheet">
    <link id="base-style-responsive" href="../../css/style-responsive.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext'
          rel='stylesheet' type='text/css'>
    <!-- end: CSS -->

    <%@include file="../includes/styling.jsp" %>

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

                    Are you sure you want to delete this Room Facility? This action cannot be undone!
                    <input id="deleteId" type="text" style="display: none" value="" name="id">
                    <input id="hid" type="text" style="display: none;" value="" name="hotelDetailId">

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
                    <button type="button" class="close" data-dismiss="alert">�</button>
                    <strong>Well Done!</strong> ${dbResponse.msg }
                </div>
            </c:if>


            <c:if test="${mode!='view'}">
                <div class="test">
                    <a href="view" title="Manage room Facility Access" data-rel="tooltip" class="btn btn-success">Manage
                        room Facility Access </a>
                </div>

            </c:if>


            <c:if test="${mode=='edit' || mode=='add'  }">

                <div class="row-fluid sortable">
                    <div class="box span12" id="box">
                        <div class="box-header" data-original-title>
                            <h2><i class="halflings-icon white edit"></i><span class="break"></span><c:if
                                    test="${mode=='add'}">Add</c:if><c:if test="${mode=='edit'}">Edit</c:if> Room
                                Facility
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
                                    <input type="hidden" name="roomFacilityId" value="${roomMap.roomFacilityId}">
                                    <div class="control-group">
                                        <label class="control-label" for="focusedInput">Room Facility</label>

                                        <div class="controls">
                                            <input class="input-xlarge focused" id="focusedInput" required="required"
                                                   name="description"
                                                   type="text" value="${roomMap.description} ">
                                        </div>
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="countryName">Hotel Name</label>

                                        <div class="controls">
                                            <select id="countryName" name="hotelDetailId" data-rel="chosen">
                                                <c:forEach items="${hotelDetailList}" var="data">
                                                    <option value="${data.hotelDetailId}"
                                                            <c:if test="${data.hotelDetailId==roomMap.hotelDetailId}">selected="selected"</c:if> >${data.hotelName}, ${data.regionName}, ${data.countryName} </option>

                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <c:if test="${mode!='detail'}">
                                        <div class="form-actions">
                                            <button type="submit" class="btn btn-primary">Save changes</button>
                                            <button class="btn btn-danger" id="cancel">Cancel</button>
                                        </div>

                                    </c:if>


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
                    <div class="box span12" id="box2">
                        <div class="box-header" data-original-title>
                            <h2>
                                <i class="halflings-icon white edit"></i><span class="break"></span>
                                Please Select Hotel to manage Room Facility Access
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
                            <form id="form2" class="form-horizontal" method="post"
                                  action="facilityList">
                                <fieldset>
                                    <div class="control-group">
                                        <label class="control-label" for="packageInfoId">Hotel Name</label>
                                        <div class="controls">

                                            <select id="packageInfoId" name="hotelDetailId"
                                                    data-rel="chosen">
                                                <option value="">SELECT</option>
                                                <c:forEach items="${hotelDetailList}" var="data">
                                                    <option value="${data.hotelDetailId}"
                                                            <c:if test="${data.hotelDetailId==hotelDetailId}">
                                                                selected="selected"</c:if>>${data.hotelName},
                                                            ${data.regionName}, ${data.countryName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-actions">
                                        <button type="submit" class="btn btn-primary">Go</button>

                                    </div>

                                </fieldset>
                            </form>

                        </div>
                    </div>
                    <!--/span-->

                </div>

            </c:if>

            <c:if test="${listView=='listView'}">

                <div class="row-fluid sortable">
                    <div class="box span12">
                        <div class="box-header" data-original-title>
                            <h2><i class="halflings-icon white user"></i><span class="break"></span>Room facility List
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
                                    <th>Room Type</th>
                                    <th>Rate</th>
                                    <th>Hotel Name</th>
                                    <th>Manage Room Facility</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%int count = 0; %>
                                <c:forEach items="${IndividualList}" var="data">
                                    <%count++; %>
                                    <tr>
                                        <td><%=count%>.</td>
                                        <td>${data.description}</td>
                                        <td>${data.rate}</td>
                                        <td>${data.hotelName}</td>
                                        <td class="center">

                                            <a class="btn btn-info"
                                               href="accessList/${data.roomTypeId}/${data.hotelDetailId}" title="manage"
                                               data-rel="tooltip">
                                                <i class="icon-cogs white"></i> Manage Facility Access
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


            <c:if test="${accessListView=='accessListView'}">

                <div class="row-fluid sortable">
                    <div class="box span12">
                        <div class="box-header" data-original-title>
                            <h2><i class="halflings-icon white user"></i><span class="break"></span>Room facility Access
                            </h2>

                            <div class="box-icon">
                                <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
                                <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
                                <a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
                            </div>
                        </div>
                        <div class="box-content">
                            <form method="post" action="save">
                                <input type="hidden" name="checkedRows" value="off">
                                <table class="table table-striped table-bordered bootstrap-datatable ">
                                    <thead>
                                    <tr>
                                        <th>S.N</th>
                                        <th>Room Facility</th>
                                        <th>Assign</th>
                                    </tr>
                                    </thead>
                                    <tbody>


                                    <c:if test="${selectedList==\"[]\"}">

                                        <tr>
                                            <td></td>
                                            <td>No facility associated with Hotel, Please add Room Facility from
                                                <a href="${pageContext.request.contextPath}/roomFacility/add"
                                                   class="btn btn-primary btn-small" target="_blank"><i class="icon-hand-up"></i>
                                                    here</a>
                                            </td>
                                            <td></td>

                                        </tr>

                                    </c:if>




                                    <%int count = 0; %>
                                    <c:forEach items="${selectedList}" var="data1">


                                        <%count++; %>
                                        <tr>
                                            <td><%=count%>.</td>
                                            <td>${data1.description}</td>
                                            <td><input type="checkbox" name="checkedRows"
                                                       value="${data1.room_facility_id}"
                                                       <c:if test="${data1.checked==true}">checked</c:if>></td>

                                        </tr>



                                    </c:forEach>

                                    <button type="submit"
                                            class="btn btn-success save-button"><i class="icon-save"></i> save
                                    </button>
                                    </tbody>
                                </table>
                                <input type="hidden" name="roomTypeId" value="${roomTypeId}">
                            </form>

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
        var hotelDetailId = $(this).data('hid');

        console.log(id);
        console.log(hotelDetailId);

        $(".modal-body #deleteId").val(id);
        $(".modal-body #hid").val(hotelDetailId);


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
