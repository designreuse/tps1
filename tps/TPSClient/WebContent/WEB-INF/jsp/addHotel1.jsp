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
    $(document).ready(function () {


        var max_fields = 3; //maximum input boxes allowed
        var wrapper = $(".phoneNo"); //Fields wrapper
        var add_button = $(".add"); //Add button ID

//			    var x = 1; //initlal text box count
        var x = $('.hotelPhone').length;

        if (x > 1) {
            $('.removeRow').show();
        } else {
            $('.removeRow').hide();
        }

        $(add_button).click(function (e) { //on add input button click

            e.preventDefault();
            if (x < max_fields) { //max input box allowed

                x++; //text box increment

                $('.phone-input').append('<input type="text" class="form-control hotelPhone" placeholder="Phone Number" name="hotelPhNo' + x + '" required>')

                if (x > 1) {
                    $('.removeRow').show();
                } else {
                    $('.removeRow').hide();
                }
            }
        });

        $(wrapper).on("click", ".removeRow", function (e) { //user click on remove text

            e.preventDefault();
            if (x > 1) {
                $(".hotelPhone").last().remove();
            }

//                $(this).parent('div').parent('div').remove();
            x--;
            if (x > 1) {
                $('.removeRow').show();
            } else {
                $('.removeRow').hide();
            }

        });


    });

    $("#country").change(function(){
        $('#region').find('.appendedRegion').remove();
        $('#area').find('.appendedArea').remove();
        if($(this).val()){
            $.ajax({
                method: "POST",
                url: "hotelDetail/getChild",
                data: { countryId: $(this).val() },

                dataType: "json",

                success: function(data){
                    var i =0;
                    var optionList = "";

                    $.each(data, function () {
                        optionList=optionList+'<option value="'+data[i].regionId+'" class="appendedRegion">'+data[i].regionName +'</option>';
                        i++;

                    });
                    $('#region').append(optionList);
                }
            });
        }

    });

    $("[id^=address]").each(function () {

        changeFunction($(this));
    });

    function changeFunction(element){
        $(element).change(function(e){
            e.preventDefault();
            var elementId = $(this).attr("id");
            var subId = elementId.substr(elementId.length-1);
            subId = parseInt(subId)+1;

            if( typeof $("#address"+subId).attr("id")== 'undefined'){

                var elementValue = $(this).val();
                $.ajax({
                    method: "POST",
                    url: "hotelDetail/getChild",
                    data: { parentAddressId: elementValue },
                    dataType: "json",
                    success: function(data){

                        var i =0;
                        var optionList = "";
                        /*$('#parentAddress').append(' <div class="col-sm-2 addres"><small>'+data[i].type+'</small><select name="areaId" class="form-control m-b" required id="address'+subId+'">'+
                         '<option value="">Select</option>'+
                         '  </select></div>');*/
                        if(data.length>0){
                            $(' <div class="col-sm-2 addres"><small>'+data[i].type+'</small><select class="form-control m-b" required id="address'+subId+'">'+
                                    '<option value="">Select</option>'+
                                    '  </select></div>').insertBefore('#streetAddress');
                            $.each(data, function () {
                                optionList=optionList+'<option value="'+data[i].addressId+'" class="appendedField">'+data[i].addressName +'</option>';
                                i++;

                            });
                            /* subId=subId+1;*/

                            $('#address'+subId).append(optionList);
                            changeFunction("#address"+subId);
                        }else{
                            $("[id^=address]").each(function () {
                                $(this).removeAttr('name');
                            })
                            $('#'+elementId).attr('name','addressId');
                        }

                    }
                });


            }else{
                var elementValue = $(this).val();
//                        alert($(this).parent().next('.add').children('select').attr('id'));
                $(this).parent().nextAll('.addres').children('select').find('.appendedField').remove();
//                        $(this).find('#address'+subId).find('.appendedRegion').remove();
                $.ajax({
                    method: "POST",
                    url: "hotelDetail/getChild",
                    data: { parentAddressId: elementValue },
                    dataType: "json",
                    success: function(data){

                        var i =0;
                        var optionList = "";
                        $.each(data, function () {
                            optionList=optionList+'<option value="'+data[i].addressId+'" class="appendedField">'+data[i].addressName +'</option>';
                            i++;

                        });
                        /* subId=subId+1;*/

                        $('#address'+subId).append(optionList);
                    }
                });
            }


        });

    }




</script>
<script>
    var markers =[];
    var latitude = Number("${hotelDetailMap.lat}");
    var longitude = Number("${hotelDetailMap.lng}");
    var zoomValue = 11;
    if(latitude==0|| longitude==0){
        latitude =28.3949;
        longitude = 84.1240;
        zoomValue = 8;
    }
    function initMap() {
        var mapDiv = document.getElementById('map');
        var map = new google.maps.Map(mapDiv, {
            center: {lat: latitude, lng: longitude},
            zoom: zoomValue
        });
//            var latlng = {lat: latitude, lng: longitude};
        var marker = new google.maps.Marker({
            position: {lat: latitude, lng: longitude},
            map: map
        });
        markers.push(marker);

        var geocoder = new google.maps.Geocoder;
//            var infowindow = new google.maps.InfoWindow;
        map.addListener('click', function(e) {
            placeMarkerAndPanTo(e.latLng, map);
//                geocodeLatLng(geocoder, map, e.latLng, infowindow);
            map.setCenter(e.latLng);
            map.setZoom(11);
        });

        document.getElementById('address4').addEventListener('change', function() {
            var address =$("#address4 option:selected").text();
            address = address+","+$("#address3 option:selected").text();

            codeAddress(address,geocoder, map);
        });


    }

    function geocodeLatLng(geocoder, map, latlng, infowindow) {
        /*var input = document.getElementById('latlng').value;
         var latlngStr = input.split(',', 2);
         var latlng = {lat: parseFloat(latlngStr[0]), lng: parseFloat(latlngStr[1])};*/
        geocoder.geocode({'location': latlng}, function (results, status) {
            if (status === google.maps.GeocoderStatus.OK) {
                if (results[1]) {
//                        map.setZoom(11);
                    for (var i = 0; i < markers.length; i++) {
                        markers[i].setMap(null);
                    }

                    var marker = new google.maps.Marker({
                        position: latlng,
                        map: map
                    });
                    markers.push(marker);

                    console.log(results[1]);
                    infowindow.setContent(results[1].formatted_address);
                    infowindow.open(map, marker);
                } else {
                    window.alert('No results found');
                }
            } else {
                window.alert('Geocoder failed due to: ' + status);
            }
        });
    }

    function placeMarkerAndPanTo(latLng, map) {
        /* var marker = new google.maps.Marker();
         marker.setMap(null);*/


        for (var i = 0; i < markers.length; i++) {
            markers[i].setMap(null);
        }

        var marker = new google.maps.Marker({
            position: latLng,
            map: map
        });

        markers.push(marker);
        console.log(marker);
        $("#latitude").val(latLng.lat());
        $("#longitude").val(latLng.lng());
//            alert(latLng.lng());
//            map.panTo(latLng);
    }

    function codeAddress(address, geocoder, map) {
//    var geocoder = new google.maps.Geocoder;
//    var address = document.getElementById('address').value;
        geocoder.geocode( { 'address': address}, function(results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                console.log(results[0]);
                map.setCenter(results[0].geometry.location);
                map.setZoom(11);
                for (var i = 0; i < markers.length; i++) {
                    markers[i].setMap(null);
                }
                var marker = new google.maps.Marker({
                    map: map,
                    position: results[0].geometry.location
                });
                $("#latitude").val(results[0].geometry.location.lat());
                $("#longitude").val(results[0].geometry.location.lng());
                markers.push(marker);
            } else {
                alert('Geocode was not successful for the following reason: ' + status);
            }
        });
    }

</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD8U7vAY3_TcAyfwZ0hzWkK-ZGvV7An-24&callback=initMap">
</script>

<%-- hotel Feature--%>
<script type="text/javascript">


    $('.clockpicker').clockpicker();



    //    $( "[id^='select-']:hidden" ).find('input, select').prop('disabled',true);
    $("[id^='checkbox-']").each(function (element) {

        /*if($(element).is(":checked"))
         alert("test");
         //            alert($(this).next().attr("id"));
         else
         $(".answer").hide();*/
//        var chargeOption = $(this).parent().parent().next().find('span').text();
        if ($(this).is(":checked")) {
            $(this).parent().parent().next().show();
            $(this).parent().parent().next().find('input, select').prop('disabled', false);
        } else {
            $(this).parent().parent().next().hide();
            $(this).parent().parent().next().find('input, select').prop('disabled', true);
        }

        $(this).click(function () {
//            var chargeOption = $(this).parent().parent().next().find('span').text();
            if ($(this).is(":checked")) {
                $(this).parent().parent().next().show();
                $(this).parent().parent().next().find('input, select').prop('disabled', false);
//                $(".answer").show(300);
            } else {
                $(this).parent().parent().next().hide();
                $(this).parent().parent().next().find('input, select').prop('disabled', true);
            }
        });
    });


</script>

<%-- Room Detail--%>
<script type="text/javascript">

    function subRoomType(){
        var parentRoomType = $("#parentRoomType").val();
        var roomType="";
        <c:forEach var="roomType" items="${roomTypeList}">
        if("${roomType.parentRoomTypeId}"== parentRoomType){
            roomType=roomType+'<option class="appendOption" value="${roomType.roomTypeId}"<c:if test="${roomType.roomTypeId==roomDetailMap.roomTypeId}"> selected </c:if>>${roomType.roomTypeDesc}</option>';
        }
        </c:forEach>
        $("#roomTypeId").find('.appendOption').remove();
        $("#roomTypeId").append(roomType);
    }

    subRoomType();

    $("#parentRoomType").change(function(){
        subRoomType();
    });

    $('#bedType').change(function () {
        var bedTypeId = $(this).val();
        var bedCapacity = 1;

        if ($('#bedTypeId').val() != "") {
            <c:forEach var="bedType" items="${bedTypeList}">
            if (bedTypeId == '${bedType.bedTypeId}') {
                bedCapacity = "${bedType.capacity}";
            }
            </c:forEach>
        }

        if ($('#noOfBed').val() == "") {
            $("#noOfGuest").val(bedCapacity * 1);
            $(".guestNo").text($("#noOfGuest").val());
        } else {
            var noOfBed = $('#noOfBed').val();
            $("#noOfGuest").val(bedCapacity * noOfBed);
            $(".guestNo").text($("#noOfGuest").val());
        }
    });

    $('#noOfBed').change(function () {
        var noOfBed = $(this).val();
        var bedTypeId = $('#bedType').val();
        var bedCapacity = 1;

        if ($('#bedTypeId').val() != "") {
            <c:forEach var="bedType" items="${bedTypeList}">
            if (bedTypeId == '${bedType.bedTypeId}') {
                bedCapacity = "${bedType.capacity}";
            }
            </c:forEach>
        }


        if ($('#noOfBed').val() == "") {
            $("#noOfGuest").val(bedCapacity * 1);
            $(".guestNo").text($("#noOfGuest").val());
        } else {
            var noOfBed = $('#noOfBed').val();
            $("#noOfGuest").val(bedCapacity * noOfBed);
            $(".guestNo").text($("#noOfGuest").val());
        }
    });

    if ($("#noOfGuest").val() == '') {
        $("#noOfGuest").val(1);
    }

    $(".guestNo").text($("#noOfGuest").val());

    $("#noOfGuest").change(function () {
        $(".guestNo").text($("#noOfGuest").val());
    });

    //    alert($('input[name=discountFlag]:checked').val());

    if ($('input[name=discountFlag]:checked').val() != 'Y') {
        $('#discount-option').find('input, select').prop('disabled', true);
        $('#discount-option').hide();
    } else {
        $('#discount-option').find('input, select').prop('disabled', false);
        $('#discount-option').show();
    }

    $("input[name='discountFlag']").click(function () {
        if ($(this).val() == 'Y') {
            $('#discount-option').show();
            $('#discount-option').find('input, select').prop('disabled', false);
        } else {
            $('#discount-option').hide();
            $('#discount-option').find('input, select').prop('disabled', true);
        }

    });


</script>

<%--Room Amenity--%>
<script type="text/javascript">

    var listsize = "${fn:length(roomDetailList)}";
    $(document).ready(function () {
        if (listsize > 1) {
            $('.select-multiple').multiselect({
                includeSelectAllOption: true,
                numberDisplayed: 1,
                maxHeight: 200
            });
        } else {
            $('.select-multiple').multiselect({
                maxHeight: 200
            });
        }

        $(".amenity").each(function (element) {
            if ($(this).is(':checked')) {
                $(this).parent().parent().next().children().attr('required', true);
            }
        });


    });

    /* Extra Bed*/
    if ($('input[name=extraBed]:checked').val() != 'Y') {
        $('#extraBed-option').find('input, select').prop('disabled', true);
        $('#extraBed-option').hide();
    } else {
        $('#extraBed-option').find('input, select').prop('disabled', false);
        $('#extraBed-option').show();
    }

    $("input[name='extraBed']").click(function () {
        if ($(this).val() == 'Y') {
            $('#extraBed-option').show();
            $('#extraBed-option').find('input, select').prop('disabled', false);
        } else {
            $('#extraBed-option').hide();
            $('#extraBed-option').find('input, select').prop('disabled', true);
        }

    });

    if ($("input[name='infant']").prop("checked") == true) {
        var text = '<label class="col-sm-2 control-label">Infant Rate per Night</label>' +
                '<div class="col-sm-3"><input type="text" class="form-control" name="infantRate" value="${extraBedMap.infantRate}" required></div>';
        $(text).appendTo('#infantRate');
    }
    else {
        $('#infantRate').children().remove();
    }

    if ($("input[name='child']").prop("checked") == true) {
        var text = '<label class="col-sm-2 control-label">Child Rate per Night</label>' +
                '<div class="col-sm-3"><select name="childAgeMax" class="form-control m-b" required>' +
                '<option value="6" <c:if test="${extraBedMap.childAgeMax==6}"> selected </c:if> >Up to 6 years old.</option> ' +
                '<option value="12" <c:if test="${extraBedMap.childAgeMax==12}"> selected </c:if>>Up to 12 years old.</option> ' +
                '<option value="16" <c:if test="${extraBedMap.childAgeMax==16}"> selected </c:if>>Up to 16 years old.</option></div>' +
                '<div class="col-sm-3">' +
                '<input type="text" class="form-control"name="childRate" value="${extraBedMap.childRate}" required></div>';
        $(text).appendTo('#childRate');
    }
    else {
        $('#childRate').children().remove();
    }

    if ($("input[name='adult']").prop("checked") == true) {
        var text = '<label class="col-sm-2 control-label">Adult Rate per Night</label>' +
                '<div class="col-sm-3"><input type="text" class="form-control" name="adultRate" value="${extraBedMap.adultRate}" required></div>';
        $(text).appendTo('#adultRate');
    }
    else {
        $('#adultRate').children().remove();
    }

    $("input[name='infant']").click(function () {

        if ($(this).prop("checked") == true) {
            var text = '<label class="col-sm-2 control-label">Infant Rate per Night</label>' +
                    '<div class="col-sm-3"><input type="text" class="form-control" name="infantRate" value="${extraBedMap.infantRate}" required></div>';
            $(text).appendTo('#infantRate');
        }
        else {
            $('#infantRate').children().remove();
        }
    });

    $("input[name='child']").click(function () {

        if ($(this).prop("checked") == true) {
            var text = '<label class="col-sm-2 control-label">Child Rate per Night</label>' +
                    '<div class="col-sm-3"><select name="childAgeMax" class="form-control m-b" required>' +
                    '<option value="6">Up to 6 years old.</option> ' +
                    '<option value="12">Up to 12 years old.</option> ' +
                    '<option value="16">Up to 16 years old.</option></div>' +
                    '<div class="col-sm-3">' +
                    '<input type="text" class="form-control"name="childRate" value="${extraBedMap.childRate}" required></div>';
            alert(text);
            $(text).appendTo('#childRate');
        }
        else {
            $('#childRate').children().remove();
        }
    });

    $("input[name='adult']").click(function () {

        if ($(this).prop("checked") == true) {
            var text = '<label class="col-sm-2 control-label">Adult Rate per Night</label>' +
                    '<div class="col-sm-3"><input type="text" class="form-control" name="adultRate" value="${extraBedMap.adultRate}" required></div>';
            $(text).appendTo('#adultRate');
        }
        else {
            $('#adultRate').children().remove();
        }
    });



</script>

<!-- blueimp gallery -->
<script src="${pageContext.request.contextPath}/js/plugins/blueimp/jquery.blueimp-gallery.min.js"></script>
<!-- DROPZONE -->
<script src="${pageContext.request.contextPath}/js/plugins/dropzone/dropzone.js"></script>
<script src="${pageContext.request.contextPath}/js/image.js"></script>

<script>
    <c:set
                                value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/TPSResources/HotelImages/"
                                var="url"></c:set>

    <c:set
                                value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/TPSResources/RoomImages/"
                                var="roomImageUrl"></c:set>
    $(document).ready(function () {
        var jsonUrl = {"saveUrl": "image/upload", "getUrl": "image/getImage/${hotelDetailMap.hotelDetailId}", "deleteUrl": "image/deleteImage", "captionUpdate": "image/hotelCaption", "thumbnailUpdate": "image/hotelThumbnail"}

        Dropzone.autoDiscover = false;
        var myDropzoneTheFirst = dropzoneImage(jsonUrl, "${hotelDetailMap.hotelDetailId}", "${url}","#hotel-dropzone", "#hotelImage");

    });

    <c:forEach items="${roomDetailList}" var="roomDetail" varStatus="count">
    $(document).ready(function () {
        var jsonUrl = {"saveUrl": "image/uploadRoomImage", "getUrl": "image/getRoomImage/${roomDetail.roomDetailId}", "deleteUrl": "image/deleteRoomImage", "captionUpdate": "image/roomCaption", "thumbnailUpdate": "image/roomThumbnail"}



        var myDropzone${count.count} = dropzoneImage(jsonUrl, "${roomDetail.roomDetailId}", "${roomImageUrl}","#room-dropzone${count.count}", "roomImage${count.count}");




    });
    </c:forEach>
</script>


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
