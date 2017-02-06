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
                url: "hotelDetail/getRegion",
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

    $("#region").change(function(){
        $('#area').find('.appendedArea').remove();
        if($(this).val()){
            $.ajax({
                method: "POST",
                url: "hotelDetail/getArea",
                data: { regionId: $(this).val() },
                dataType: "json",
                success: function(data){
                    var i =0;
                    var optionList = "";

                    $.each(data, function () {

                        optionList=optionList+'<option value="'+data[i].areaId+'" class="appendedArea">'+data[i].areaName +'</option>';
                        i++;
                    });
                    $('#area').append(optionList);
                }
            });
        }

    });




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

<!-- DROPZONE -->
<script src="${pageContext.request.contextPath}/js/plugins/dropzone/dropzone.js"></script>

<script>
    <c:set
                                value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/TPSResources/HotelImages/"
                                var="url"></c:set>

    <c:set
                                value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/TPSResources/RoomImages/"
                                var="roomImageUrl"></c:set>
    $(document).ready(function () {

        Dropzone.autoDiscover = false;
        var myDropzoneTheFirst = new Dropzone(
                '#hotel-dropzone', //id of drop zone element 1
                {
                    url: "image/upload",
                    previewTemplate: document.querySelector('#preview-template').innerHTML,
                    //            previewsContainer: '#hotel-previewContainer',
                    autoProcessQueue: true,
                    uploadMultiple: true,
                    maxFilesize: 256, // MB
                    parallelUploads: 100,
                    maxFiles: 100,
                    addRemoveLinks: true,
//                    previewsContainer : ".dropzone-previews",
                    //                acceptedFiles: ".png, .jpg",

                    // Dropzone settings
                    init: function () {
                        var myDropzone = this;
                        $('#imageSubmit').on("click", function (e) {
                            e.preventDefault();
                            alert("dsfsadf");
                            myDropzone.processQueue();
                        });

                        $.getJSON("image/getImage/" +${hotelDetailMap.hotelDetailId}).done(function (data) {
                            if (data.Data != '') {


                                $.each(data, function (key, value) {
                                    //// Create the mock file:
                                    var mockFile = {
                                        name: value.fileName,
                                        size: 12345
                                    };


                                    // Call the default addedfile event handler
                                    myDropzone.emit("addedfile", mockFile);
                                    // And optionally show the thumbnail of the file:
                                    myDropzone.emit("thumbnail", mockFile, "${url}" + value.imageUrl);

                                    //                            myDropzone.emit("previewTemplate", mockFile.append('<span class="server_file" >'+value.imageUrl+'</span>'))
//                                    $(mockFile.previewTemplate).append('<span class="server_file" style="display: none">' + value.hotelImageId + '</span>');
                                    var thumbnail1 ='';
                                    var caption = '';
                                    if(value.thumbnail=='Y'){
                                        thumbnail1= 'checked';
                                    }
                                    if(value.caption!=undefined){
                                        caption = value.caption;
                                    }


                                    $(mockFile.previewTemplate).append('<div class="custom-field"><input type="text" placeholder="caption" class="caption" value="' + caption + '"><br>'+
                                            '<input type="radio" name="thumbnail" class="thumbnail"'+thumbnail1+' ></div>');
                                    $(mockFile.previewTemplate).append('<span class="server_file" style="display: none">' + value.hotelImageId + '</span>');

                                    // If you use the maxFiles option, make sure you adjust it to the
                                    // correct amount:
                                    //var existingFileCount = 1; // The number of files already uploaded
                                    //myDropzone.options.maxFiles = myDropzone.options.maxFiles - existingFileCount;
                                });
                            }
                            //                    $(file.previewTemplate).append('<span class="server_file" >'+value.imageUrl+'</span>');

                        });

                        $("#hotel-dropzone").on('focusout', 'input.caption', function() {

                            var caption = $(this).val();
                            var imageId = $(this).parent().parent().find('.server_file').text();

                            $.post("image/hotelCaption",{imageId: imageId, caption: caption});
                        });

                        $("#hotel-dropzone").on('click', 'input.thumbnail', function() {

                            var imageId = $(this).parent().parent().find('.server_file').text();

                            $.post("image/hotelThumbnail",{imageId: imageId, hotelDetailId: ${hotelDetailId}});
                        });
                        this.on("sendingmultiple", function () {

                        });
                        this.on("successmultiple", function (files, response) {


                            var i = 0;
                            $.each(files, function () {

                                var thumbnail1 ='';
                                var caption = '';
                                if(response[i].thumbnail=='Y'){
                                    thumbnail1= 'checked';
                                }
                                if(response[i].caption!=undefined){
                                    caption = response[i].caption;
                                }


                                $(files[i].previewTemplate).append('<div class="custom-field"><input type="text" placeholder="caption" class="caption" value="' + caption + '"><br>'+
                                        '<input type="radio" name="thumbnail" class="thumbnail"'+thumbnail1+' ></div>');
                                $(files[i].previewTemplate).append('<span class="server_file" style="display: none">' + response[i].ID + '</span>');
//                                $(files[i].previewTemplate).append('<span class="server_file" style="display: none">' + files[i].ID + '</span>');
                                i++;

                            });

                        });
                        this.on("errormultiple", function (files, response) {
                        });
                        this.on("success", function (file, response) {
//                            $.each(response, function(key,value) {
//                                $(file.previewTemplate).append('<span class="server_file">'+value.ID+'</span>');
//                            });
                        });
                        /*    this.on("success", function(file, response) {

                         var text=JSON.stringify(response);
                         text= text.replace('[','');
                         text= text.replace(']','');
                         //text.replace(']','');


                         //       alert(text);
                         /!*
                         var obj = jQuery.parseJSON(response);
                         alert(obj.msg);*!/
                         // alert(response);

                         // var jsontext = '{"firstname":"Jesper","surname":"Aaberg","phone":["555-0100","555-0120"]}';
                         var contact = JSON.parse(text);
                         alert(contact.ID)

                         });
                         */
                        this.on("removedfile", function (file) {
                            var server_file = $(file.previewTemplate).children('.server_file').text();
                            //                    alert(server_file);

                            // Do a post request and pass this path and use server-side language to delete the file
                            $.post("image/deleteImage", {file_to_be_deleted: server_file});
                        });

                    }
                });
    });

    <c:forEach items="${roomDetailList}" var="roomDetail" varStatus="count">
    $(document).ready(function () {


        var myDropzone${count.count} = new Dropzone(
                '#room-dropzone${count.count}', //id of drop zone element 1
                {
                    url: "image/uploadRoomImage",
                    previewTemplate: document.querySelector('#preview-template').innerHTML,
                    //            previewsContainer: '#hotel-previewContainer',
                    uploadMultiple: true,
                    parallelUploads: 100,
                    maxFiles: 100,
                    addRemoveLinks: true,
                    //                acceptedFiles: ".png, .jpg",

                    // Dropzone settings
                    init: function () {
                        var myDropzone = this;

                        $.getJSON("image/getRoomImage/" +
                                ${roomDetail.roomDetailId}).done(function (data) {
                            if (data.Data != '') {


                                $.each(data, function (key, value) {
                                    //// Create the mock file:
                                    var mockFile = {
                                        name: value.fileName,
                                        size: 12345
                                    };


                                    // Call the default addedfile event handler
                                    myDropzone.emit("addedfile", mockFile);
                                    // And optionally show the thumbnail of the file:
                                    myDropzone.emit("thumbnail", mockFile, "${roomImageUrl}" + value.imageUrl);

                                    //                            myDropzone.emit("previewTemplate", mockFile.append('<span class="server_file" >'+value.imageUrl+'</span>'))
//                                    $(mockFile.previewTemplate).append('<span class="server_file" style="display: none">' + value.roomImageId + '</span>');
                                    var thumbnail1 ='';
                                    var caption = '';
                                    if(value.thumbnail=='Y'){
                                        thumbnail1= 'checked';
                                    }
                                    if(value.caption!=undefined){
                                        caption = value.caption;
                                    }


                                    $(mockFile.previewTemplate).append('<div class="custom-field"><input type="text" placeholder="caption" class="caption" value="' + caption + '"><br>'+
                                            '<input type="radio" name="thumbnail" class="thumbnail"'+thumbnail1+' ></div>');
                                    $(mockFile.previewTemplate).append('<span class="server_file" style="display: none">' + value.roomImageId + '</span>');


                                    // If you use the maxFiles option, make sure you adjust it to the
                                    // correct amount:
                                    //var existingFileCount = 1; // The number of files already uploaded
                                    //myDropzone.options.maxFiles = myDropzone.options.maxFiles - existingFileCount;
                                });
                            }
                            //                    $(file.previewTemplate).append('<span class="server_file" >'+value.imageUrl+'</span>');

                        });

                        $("#room-dropzone${count.count}").on('focusout', 'input.caption', function() {

                            var caption = $(this).val();
                            var imageId = $(this).parent().parent().find('.server_file').text();

                            $.post("image/roomCaption",{imageId: imageId, caption: caption});
                        });
                        $("#room-dropzone${count.count}").on('click', 'input.thumbnail', function() {

                            var imageId = $(this).parent().parent().find('.server_file').text();

                            $.post("image/roomThumbnail",{imageId: imageId, roomDetailId: ${roomDetail.roomDetailId}});
                        });
                        this.on("sendingmultiple", function () {
                        });
                        this.on("successmultiple", function (files, response) {
                            var i = 0;
                            $.each(files, function () {

                                var thumbnail1 ='';
                                var caption = '';
                                if(response[i].thumbnail=='Y'){
                                    thumbnail1= 'checked';
                                }
                                if(response[i].caption!=undefined){
                                    caption = response[i].caption;
                                }


                                $(files[i].previewTemplate).append('<div class="custom-field"><input type="text" placeholder="caption" class="caption" value="' + caption + '"><br>'+
                                        '<input type="radio" name="thumbnail" class="thumbnail"'+thumbnail1+' ></div>');
                                $(files[i].previewTemplate).append('<span class="server_file" style="display: none">' + response[i].ID  + '</span>');

//                                $(files[i].previewTemplate).append('<span class="server_file" style="display: none">' + response[i].ID + '</span>');
                                i++;

                            });
                        });
                        this.on("errormultiple", function (files, response) {
                        });


                        this.on("removedfile", function (file) {
                            var server_file = $(file.previewTemplate).children('.server_file').text();
                            //                    alert(server_file);

                            // Do a post request and pass this path and use server-side language to delete the file
                            $.post("image/deleteRoomImage", {file_to_be_deleted: server_file});
                        });

                    }
                }
        );


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
