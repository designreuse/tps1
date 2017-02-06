<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>

    <!-- start: Meta -->
    <meta charset="utf-8">
    <title>Nearest Area</title>
    <meta name="description" content="IGC Travel Portal System">
    <meta name="author" content="IGC Travel Portal System">
    <meta name="keyword" content="IGC Travel Portal System">
    <!-- end: Meta -->

    <!-- start: Mobile Specific -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- end: Mobile Specific -->

    <!-- 	base url -->

    <base href="${pageContext.request.contextPath}/nearestArea/"/>

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
                    <input id="deleteId" type="text" style="display: none" value="" name="nearestAreaId">


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

            <c:if test="${mode=='view'}">

                <div class="row-fluid sortable">
                    <div class="box span12" id="box">
                        <div class="box-header" data-original-title>
                            <h2><i class="halflings-icon white edit"></i><span class="break"></span>Please select
                                hotel to
                                view Nearest Area
                            </h2>
                            <div class="box-icon">
                                <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
                                <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
                                <a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
                            </div>
                        </div>
                        <div class="box-content">
                            <form id="formArea" class="form-horizontal" method="post" action="viewNearestArea">
                                <fieldset>

                                    <div class="control-group">
                                        <label class="control-label" for="hotelDetailId">Hotel</label>
                                        <div class="controls">
                                            <select id="hotelDetailId" name="hotelDetailId" data-rel="chosen">
                                                <option value="">Select</option>
                                                <c:forEach var="hotel" items="${hotelList}">

                                                    <option value="${hotel.hotelDetailId}"
                                                            <c:if test="${hotel.hotelDetailId == hotelId}"> selected </c:if>>${hotel.hotelName}</option>
                                                </c:forEach>
                                                    <%-- <option value="TRAVEL"
                                                             <c:if test="${popularPlaceMap.type=='TRAVEL'}">selected="selected"</c:if>  >Travel</option>
                                                 <option value="RESTAURANT"
                                                         <c:if test="${popularPlaceMap.type=='RESTAURANT'}">selected="selected"</c:if>  >Restaurant</option>
                                                 <option value="MARKET"
                                                         <c:if test="${popularPlaceMap.type=='MARKET'}">selected="selected"</c:if>  >Market</option>--%>
                                            </select>
                                        </div>
                                    </div>


                                    <div class="form-actions">
                                        <button type="submit" class="btn btn-primary">Save changes</button>

                                    </div>

                                </fieldset>
                            </form>

                        </div>
                    </div><!--/span-->

                </div>
            </c:if>
            <c:if test="${mode=='update' }">
                <div class="test">
                    <a href="view" title="Select Hotel" data-rel="tooltip" class="btn btn-success">Select Hotel</a>
                </div>
                <div class="test">
                    <a href="view" title="View Nearest Area" data-rel="tooltip" class="btn btn-success">View Nearest Area </a>
                </div>
                <div class="row-fluid sortable">
                    <div class="box span12" id="box">
                        <div class="box-header" data-original-title>
                            <h2><i class="halflings-icon white edit"></i><span class="break"></span><c:if
                                    test="${mode=='add'}">Add</c:if><c:if test="${mode=='edit'}">Edit</c:if> Nearest Area
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


                                    <div class="control-group">
                                        <label class="control-label" for="hotel">Hotel</label>
                                        <div class="controls">
                                            <input id="hotel" name="hotelDetailId" value="${hotelId}" readonly>
                                            <%--<select id="hotel" name="hotelDetailId" data-rel="chosen">
                                                <option value="">Select</option>
                                                <c:forEach var="hotel" items="${hotelList}">

                                                    <option value="${hotel.hotelDetailId}"
                                                            <c:if test="${hotel.hotelDetailId == hotelId}"> selected </c:if>>${hotel.hotelName}</option>
                                                </c:forEach>
                                                   &lt;%&ndash; <option value="TRAVEL"
                                                            <c:if test="${popularPlaceMap.type=='TRAVEL'}">selected="selected"</c:if>  >Travel</option>
                                                <option value="RESTAURANT"
                                                        <c:if test="${popularPlaceMap.type=='RESTAURANT'}">selected="selected"</c:if>  >Restaurant</option>
                                                <option value="MARKET"
                                                        <c:if test="${popularPlaceMap.type=='MARKET'}">selected="selected"</c:if>  >Market</option>&ndash;%&gt;
                                            </select>--%>
                                        </div>
                                    </div>
                                        <%--<div class="control-group">
                                            <label class="control-label" for="popularPlace">Popular Place</label>
                                            <div class="controls">
                                                <select id="popularPlace" name="popularPlaceId" data-rel="chosen">
                                                    <option>Select</option>
                                                    <c:forEach var="place" items="${popularPlaceList}">
                                                        <option value="${place.popularPlaceId}"
                                                                <c:if test="${place.popularPlaceId == nearestAreaMap.popularPlaceId}"> selected </c:if> >${place.place}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="control-group">
                                            <label class="control-label" for="distance">Distance</label>
                                            <div class="controls">
                                                <input class="input-xlarge focused" id="distance" name="distance"
                                                       type="text" value="${nearestAreaMap.distance}" required>
                                            </div>
                                        </div>--%>

                                        <table class="table table-striped table-bordered bootstrap-datatable " id="popularPlace">
                                            <thead>
                                            <tr>
                                                <th>S.N</th>
                                                <th>Place</th>
                                                <th>Distance</th>
                                                <th>Assign</th>
                                            </tr>
                                            </thead>
                                            <tbody >

                                            <%--<c:forEach items="${nearestPlaceList}" var="place" varStatus="count">


                                                <tr>
                                                    <td>${count.count}.</td>
                                                    <td>${place.place}</td>
                                                    <td><input type="text" value="${place.distance}"> </td>
                                                    <td><input type="checkbox" name="checkedRows"
                                                               value="${place.popularPlaceId}"
                                                               <c:if test="${place.distance!=null}">checked</c:if>></td>

                                                </tr>



                                            </c:forEach>--%>


                                            </tbody>
                                        </table>

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

            <c:if test="${mode=='viewNearestArea'}">
            <div class="test">
                <a href="add/${hotelId}" title="Add Nearest Area" data-rel="tooltip" class="btn btn-warning">Add Neares Area </a>
            </div>

                <div class="row-fluid sortable">
                    <div class="box span12">
                        <div class="box-header" data-original-title>
                            <h2><i class="halflings-icon white list"></i><span class="break"></span>Nearest Area List
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
                                    <th>Hotel</th>
                                    <th>Popular Place</th>
                                    <th>Distance</th>
                                    <th>Action</th>

                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${nearestAreaList}" var="data" varStatus="count">
                                    <tr>
                                        <td>${count.count}.</td>

                                        <td>${data.hotelName}</td>
                                        <td>${data.place}</td>
                                        <td>${data.distance}</td>
                                        <td class="center">

                                            <a class="btn btn-info" href="edit/${data.nearestAreaId}" title="Edit"
                                               data-rel="tooltip">
                                                <i class="halflings-icon white edit"></i>
                                            </a>

                                            <a class="open btn btn-danger" title="Delete" data-toggle="modal"
                                               data-target="#myModal_del"
                                               data-id="${data.nearestAreaId}" data-rel="tooltip">
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

    <%--change in hotel field redirect to add/hotelId--%>
   /* $('#hotel').change(function() {
        alert($(this).val());
        // set the window's location property to the value of the option the user has selected
        window.location = "add/"+$(this).val();
    });*/
    <%--alert('${nearestPlaceList}');--%>

    $(document).ready(function(){
        var market="<tr> <td colspan='5'>Market</td> </tr>";
        var travel="<tr> <td colspan='5'>Travel</td> </tr>";
        var restaurant="<tr> <td colspan='5'>Restaurant</td> </tr>";
        var marketIndex=1;
        var travelIndex=1;
        var restaurantIndex =1;


        <c:forEach var="nearPlace" items="${nearestPlaceList}">

        <c:choose>
        <c:when test="${nearPlace.type=='MARKET'}">

        market=market+'<tr>'+
                '<td>'+marketIndex+'.</td>'+
                '<td>${nearPlace.place}</td>'+
                '<td><input type="text" value="${nearPlace.distance}" name="distance"> <input type="hidden" value="${nearPlace.nearestAreaId}" name="nearestPlaceId">'+
                '<input type="hidden" value="${nearPlace.popularPlaceId}" name="popularPlaceId"></td>'+
                '<td><input type="checkbox" name="active" value="${nearPlace.popularPlaceId}" <c:if test="${nearPlace.active=='Y'}">checked</c:if>></td>'+
                '</tr>';
        marketIndex++;
        </c:when>
        <c:when test="${nearPlace.type=='TRAVEL'}">
        travel=travel+'<tr>'+
                '<td>'+travelIndex+'.</td>'+
                '<td>${nearPlace.place}</td>'+
                '<td><input type="text" value="${nearPlace.distance}" name="distance"> <input type="hidden" value="${nearPlace.nearestAreaId}" name="nearestPlaceId">'+
                '<input type="hidden" value="${nearPlace.popularPlaceId}" name="popularPlaceId"></td>'+
                '<td><input type="checkbox" name="active" value="${nearPlace.popularPlaceId}" <c:if test="${nearPlace.active=='Y'}">checked</c:if>></td>'+
        '</tr>';
        travelIndex++;
        </c:when>
        <c:when test="${nearPlace.type=='RESTAURANT'}">
        restaurant=restaurant+'<tr>'+
                '<td>'+restaurantIndex+'.</td>'+
                '<td>${nearPlace.place}</td>'+
                '<td><input type="text" value="${nearPlace.distance}" name="distance"> <input type="hidden" value="${nearPlace.nearestAreaId}" name="nearestPlaceId">'+
                '<input type="hidden" value="${nearPlace.popularPlaceId}" name="popularPlaceId"></td>'+
                '<td><input type="checkbox" name="active" value="${nearPlace.popularPlaceId}" <c:if test="${nearPlace.active=='Y'}">checked</c:if>></td>'+
        '</tr>';
        restaurantIndex++;
        </c:when>
        </c:choose>

        </c:forEach>

        $('#popularPlace > tbody:last-child').append(market);
        $('#popularPlace > tbody:last-child').append(travel);
        $('#popularPlace > tbody:last-child').append(restaurant);

    });

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
