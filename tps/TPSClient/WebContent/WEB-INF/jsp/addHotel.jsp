<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>


<!-- Mirrored from webapplayers.com/inspinia_admin-v2.4/dashboard_4.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 01 Feb 2016 10:46:03 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>${title}</title>
    <base href="${pageContext.request.contextPath}/"/>

    <%@include file="/WEB-INF/includes/styling.jsp" %>
    <link href="${pageContext.request.contextPath}/css/plugins/clockpicker/clockpicker.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/bootstrap-multiselect.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/blueimp/css/blueimp-gallery.min.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/css/plugins/dropzone/basic.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/dropzone/dropzone.css" rel="stylesheet">


</head>

<body class="top-navigation">

<div id="wrapper">
    <div class="modal inmodal fade" id="previewModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">${hotelDetailMap.hotelName}<br>
                        <small>${hotelDetailMap.streetAddress}</small>
                    </h4>
                </div>
                <div class="modal-body">
                    <div>
                        <%--<div class="col-lg-12">
                            <h1></h1>
                            <h2>${hotelDetailMap.streetAddress}</h2>
                            <h3>${hotelDetailMap.hotelPhNo1},${hotelDetailMap.hotelPhNo2}<c:if test="${hotelDetailMap.hotelPhNo3!=null}">,</c:if> ${hotelDetailMap.hotelPhNo3}</h3>
                        </div>--%>

                        <div class="ibox">
                            <div class="ibox-title">
                                <h5>Hotel Features</h5>
                                <div class="ibox-tools">
                                    <a class="collapse-link">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <ul class="unstyled">

                                    <c:set var="parentId" value="0"/>
                                    <strong>Hotel Facility: </strong>
                                    <ul>
                                        <c:forEach var="hotelActivity" items="${hotelActivityList}" varStatus="count">
                                            <c:choose>
                                                <c:when test="${hotelActivity.active=='Y'}">
                                                    <li>${hotelActivity.activityDesc}</li>
                                                </c:when>
                                            </c:choose>

                                        </c:forEach>
                                    </ul>

                                </ul>

                            </div>
                        </div>


                        <div class="ibox">
                            <div class="ibox-title">
                                <h5>Room Detail</h5>
                                <div class="ibox-tools">
                                    <a class="collapse-link">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>Room Description</th>
                                        <th>Allocate Number</th>
                                        <th>Occupancy</th>
                                        <th>Rate</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${roomDetailList}" var="roomDetail">
                                        <%--<c:set var="totalAllocateRooms" value="${roomDetail.roomsProvided + totalAllocateRooms}"/>--%>
                                        <tr>
                                            <td>
                                                <h3>${roomDetail.customName}</h3>
                                                Facilities: <br>
                                                <ul>
                                                    <c:forEach var="roomAmenity" items="${roomAmenityList}">
                                                        <c:if test="${roomAmenity.active=='Y' && fn:contains(roomAmenity.roomDetailId,roomDetail.roomDetailId )}">
                                                            <li>${roomAmenity.amenityDesc}</li>
                                                        </c:if>
                                                    </c:forEach>
                                                </ul>
                                                Size:${roomDetail.roomDimension}m<sup>2</sup>

                                            </td>
                                            <td>${roomDetail.roomsProvided}</td>
                                            <td>${roomDetail.noOfGuest}</td>
                                            <td>${roomDetail.rate}</td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>

                                </table>

                            </div>
                        </div>
                    </div>


                </div>
                <%--<div class="modal-footer">
                    &lt;%&ndash;<form method="post" action="registration">
                        <input type="hidden" name="hotelName" value="${hotelDetailMap.hotelName}">
                        <input type="hidden" name="tokenId" value="${hotelDetailMap.tokenId}">
                        <input type="hidden" name="userDetailId" value="${userDetailMap.userDetailId}">
                        <button type="submit" class="btn btn-primary" >Create New Hotel</button>
                    </form>&ndash;%&gt;

                </div>--%>
            </div>
        </div>
    </div>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom white-bg">
            <nav class="navbar navbar-static-top" role="navigation">
                <div class="navbar-header">
                    <button aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse"
                            class="navbar-toggle collapsed" type="button">
                        <i class="fa fa-reorder"></i>
                    </button>
                    <a href="#" class="navbar-brand">Dashboard</a>
                </div>
                <div class="navbar-collapse collapse" id="navbar">
                    <%--<ul class="nav navbar-nav">
                        <li class="active">
                            <a aria-expanded="false" role="button" href="layouts.html"> Back to main Layout page</a>
                        </li>
                        <li class="dropdown">
                            <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> Menu item <span class="caret"></span></a>
                            <ul role="menu" class="dropdown-menu">
                                <li><a href="#">Menu item</a></li>
                                <li><a href="#">Menu item</a></li>
                                <li><a href="#">Menu item</a></li>
                                <li><a href="#">Menu item</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> Menu item <span class="caret"></span></a>
                            <ul role="menu" class="dropdown-menu">
                                <li><a href="#">Menu item</a></li>
                                <li><a href="#">Menu item</a></li>
                                <li><a href="#">Menu item</a></li>
                                <li><a href="#">Menu item</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> Menu item <span class="caret"></span></a>
                            <ul role="menu" class="dropdown-menu">
                                <li><a href="#">Menu item</a></li>
                                <li><a href="#">Menu item</a></li>
                                <li><a href="#">Menu item</a></li>
                                <li><a href="#">Menu item</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> Menu item <span class="caret"></span></a>
                            <ul role="menu" class="dropdown-menu">
                                <li><a href="#">Menu item</a></li>
                                <li><a href="#">Menu item</a></li>
                                <li><a href="#">Menu item</a></li>
                                <li><a href="#">Menu item</a></li>
                            </ul>
                        </li>

                    </ul>--%>

                </div>
            </nav>
        </div>
        <div class="wrapper wrapper-content">
            <div class="container">
                <button data-target="#previewModal" data-toggle="modal" class="btn btn-primary" type="button">
                    Preview
                </button>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="tabs-container">
                            <ul class="nav nav-tabs tabs-custom">
                                <li class="<c:if test="${step==1 || step==null}"> active</c:if> "><a data-toggle="tab"
                                                                                                     href="#propertyDetail">
                                    Hotel Detail</a></li>
                                <li class="<c:if test="${step==2}"> active</c:if>"><a data-toggle="tab"
                                                                                      href="#hotelFeatures">Hotel
                                    Features</a></li>
                                <li class="<c:if test="${step==3}"> active</c:if>"><a data-toggle="tab"
                                                                                      href="#roomDetail">Room Detail</a>
                                </li>
                                <li class="<c:if test="${step==4}"> active</c:if>"><a data-toggle="tab"
                                                                                      href="#roomAmenity">Amenity</a>
                                </li>
                                <li class="<c:if test="${step==5}"> active</c:if>"><a data-toggle="tab" href="#images">Image</a>
                                </li>
                                <li class=""><a data-toggle="tab" href="#agreement">Agreement</a>
                                </li>
                                <%--  <li class=""><a data-toggle="tab" href="#tab-3">Room Details</a></li>
                                  <li class=""><a data-toggle="tab" href="#tab-3">Amenities</a></li>
                                  <li class=""><a data-toggle="tab" href="#tab-3">Photo</a></li>--%>
                            </ul>
                            <div class="tab-content col-lg-12">
                                <div id="propertyDetail"
                                     class="tab-pane <c:if test="${step==1 || step==null}"> active</c:if>">
                                    <div class="panel-body">
                                        <%@include file="/WEB-INF/jsp/propertyDetail.jsp" %>
                                    </div>
                                </div>
                                <c:if test="${hotelFeatureMap != null}">
                                    <div id="hotelFeatures" class="tab-pane <c:if test="${step==2}"> active</c:if>">
                                        <div class="panel-body">
                                            <%@include file="/WEB-INF/jsp/hotelFeature.jsp" %>
                                        </div>
                                    </div>
                                </c:if>

                                <c:if test="${roomDetailList != null || roomDetailMap != null}">
                                    <div id="roomDetail" class="tab-pane <c:if test="${step==3}"> active</c:if>">
                                        <div class="panel-body">
                                            <%@include file="/WEB-INF/jsp/roomDetail.jsp" %>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${roomAmenityList != null}">
                                    <div id="roomAmenity" class="tab-pane <c:if test="${step==4}"> active</c:if>">
                                        <div class="panel-body">
                                            <%@include file="/WEB-INF/jsp/roomAmenity.jsp" %>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${hotelImageList != null}">
                                    <div id="images" class="tab-pane <c:if test="${step==5}"> active</c:if>">
                                        <div class="panel-body">
                                            <%@include file="/WEB-INF/jsp/images.jsp" %>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${hotelImageList != null}">
                                    <div id="agreement" class="tab-pane">
                                        <div class="panel-body">
                                            <%@include file="/WEB-INF/jsp/agreement.jsp" %>
                                        </div>
                                    </div>
                                </c:if>


                            </div>


                        </div>
                    </div>

                </div>

            </div>

        </div>
        <div class="footer">
            <div class="pull-right">
                10GB of <strong>250GB</strong> Free.
            </div>
            <div>
                <strong>Copyright</strong> Example Company &copy; 2014-2015
            </div>
        </div>

    </div>
</div>


<%@include file="/WEB-INF/includes/script.jsp"%>
<!-- Clock picker -->
<script src="${pageContext.request.contextPath}/js/plugins/clockpicker/clockpicker.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/iCheck/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/bootstrap-multiselect.js"></script>
<%--<script src="${pageContext.request.contextPath}/js/inspinia.js"></script>--%>

<!-- Jquery Validate -->
<script src="js/plugins/validate/jquery.validate.min.js"></script>

<script>
    $(document).ready(function () {
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });
</script>

<%--property Detail--%>
<script type="text/javascript">


<%--Validation--%>
<%--<script type="text/javascript">
    $(document).ready(function(){
        jQuery.validator.addMethod("alphaNumeric",
                function(value, element) {
                    // return true - means the field passed validation
                    // return false - means the field failed validation and it triggers the error
                    return this.optional(element)
                            || /^([\w\s]+)$/.test(value);
                }, "Only alphanumeric value and underscore is allowed!");

        jQuery.validator.addMethod("phoneNumber", function(value, element) {
            // return true - means the field passed validation
            // return false - means the field failed validation and it triggers the error
            // 		    return this.optional(element) || /^\+?([0-9]{1,4})\)?[-. ]?([0-9]{7,14})$/.test(value);
            return this.optional(element)
                    || /^\+?([0-9-\s]){7,19}$/.test(value);
        }, "Please enter valid phone number");

        $("#propertyDetailForm").validate({
            rules: {
                hotelName: {
                    required: true,
                    alphaNumeric: true
                },
                starRating: {
                    required: true,
                    number: true
                },
                hotelPhNo1: {
                    required: true,
                    phoneNumber: true
                },
                hotelPhNo2: {
                    required: true,
                    phoneNumber: true
                },
                hotelPhNo3: {
                    required: true,
                    phoneNumber: true
                },
                streetAddress: {
                    required: true
                },
                zipCode: {
                    required: true
                },
                url: {
                    required: true,
                    url: true
                },
                totalRoom:{
                    required: true,
                    number: true
                }
            }
        });

        $("#hotelFeatureForm").validate({
            rules: {

                parkingArea: {
                    required: true,
                    phoneNumber: true
                },
                hotelPhNo3: {
                    required: true,
                    phoneNumber: true
                },
                streetAddress: {
                    required: true
                },
                zipCode: {
                    required: true
                },
                url: {
                    required: true,
                    url: true
                },
                totalRoom:{
                    required: true,
                    number: true
                }
            }
        });

    });
</script>--%>
</body>
</html>
