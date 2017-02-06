<%@include file="/WEB-INF/includes/header.jsp"%>
<link href="${pageContext.request.contextPath}/css/plugins/dropzone/dropzone.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/plugins/blueimp/css/blueimp-gallery.min.css" rel="stylesheet">
<c:if test="${base!=null}">
    <div id="wrapper">
    <%@include file="/WEB-INF/includes/leftNavigation.jsp"%>
    <div id="page-wrapper" class="gray-bg">
    <%@include file="/WEB-INF/includes/topNavigation.jsp"%>
    <div class="wrapper wrapper-content animated fadeIn">

    <div class="p-w-md m-t-sm">
    <div class="row">
</c:if>


<div class="col-lg-12">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>Hotel</h5>
            <div class="ibox-tools">
                <a class="collapse-link">
                    <i class="fa fa-chevron-up"></i>
                </a>


            </div>
        </div>
        <div class="ibox-content preview" id="hotel-previewContainer">

            <div class="hotelImage">
                <form id="hotel-dropzone" class="dropzone" enctype="multipart/form-data">

                    <input type="hidden" name="hotelDetailId" value="<c:choose><c:when test="${sessionScope.hotelDetailId != null}">${sessionScope.hotelDetailId}</c:when><c:otherwise>${hotelDetailMap.hotelDetailId}</c:otherwise></c:choose>">

                    <div
                            class="dz-default dz-message file-dropzone text-center well col-sm-12">

                        <span class="glyphicon glyphicon-paperclip"></span> <span>
								To attach files, drag and drop here</span><br> <span>OR</span><br>
                        <span>Just Click</span>
                    </div>

                    <!-- this is were the previews should be shown. -->
                    <div class="dropzone-previews"></div>

                    <%--<button type="submit" class="btn btn-primary pull-right" id="imageSubmit">Submit this form!</button>--%>
                </form>

                <!-- The Gallery as lightbox dialog, should be a child element of the document body -->
                <div id="blueimp-gallery" class="blueimp-gallery">
                    <div class="slides"></div>
                    <h3 class="title"></h3>
                    <a class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i>
                    </a>
                    <a class="next"><i class="fa fa-angle-right" aria-hidden="true"></i>
                    </a>
                    <a class="close"><i class="fa fa-times" aria-hidden="true"></i>
                    </a>
                    <a class="play-pause"></a>
                    <ol class="indicator"></ol>
                </div>

               <%-- <form id="hotel-dropzone" class="dropzone"
                      enctype="multipart/form-data">

                    <div
                            class="dz-default dz-message file-dropzone text-center well col-sm-12">

                        <span class="glyphicon glyphicon-paperclip"></span> <span>
								To attach files, drag and drop here</span><br> <span>OR</span><br>
                        <span>Just Click</span>
                    </div>

                    <!-- this is were the previews should be shown. -->
                    <div class="dropzone-previews"></div>
                </form>--%>
            </div>



        </div>
    </div>
</div>

<c:forEach items="${roomDetailList}" var="roomDetail" varStatus="count">
    <%--<c:set var="totalAllocateRooms" value="${roomDetail.roomsProvided + totalAllocateRooms}"/>--%>
    <div class="col-lg-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>${roomDetail.customName}</h5>
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>


                </div>
            </div>
            <div class="ibox-content">

                <div class="roomImage${count.count}">
                    <form id="room-dropzone${count.count}" class="dropzone" action="image/uploadRoomImage">
                        <input type="hidden" name="roomDetailId" value="${roomDetail.roomDetailId}">
                            <%-- <div class="dropzone-previews"></div>--%>



                        <%--<button type="submit" class="btn btn-primary pull-right">Submit this form!</button>--%>
                    </form>
                    <div id="blueimp-gallery1" class="blueimp-gallery">
                        <div class="slides"></div>
                        <h3 class="title"></h3>
                        <a class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i>
                        </a>
                        <a class="next"><i class="fa fa-angle-right" aria-hidden="true"></i>
                        </a>
                        <a class="close"><i class="fa fa-times" aria-hidden="true"></i>
                        </a>
                        <a class="play-pause"></a>
                        <ol class="indicator"></ol>
                    </div>
                </div>



            </div>
        </div>
    </div>
    <%--<tr>
        <td>${roomDetail.customName}</td>
        <td>${roomDetail.roomsProvided}</td>
        <td><a href="hotelFeature/roomDetail/edit/${roomDetail.roomDetailId}">Edit</a>
            <a href="hotelFeature/roomDetail/delete/${roomDetail.roomDetailId}"> Detele</a> </td>
    </tr>--%>
</c:forEach>

<a></a>
<div id="preview-template" style="display: none;">
    <div class="dz-preview dz-file-preview">
        <div class="dz-details">
            <div class="dz-filename"><span data-dz-name></span></div>
            <%--<div class="dz-size" data-dz-size></div>--%>
            <img data-dz-thumbnail />
        </div>
        <div class="dz-progress"><span class="dz-upload" data-dz-uploadprogress></span></div>
        <div class="dz-success-mark"><span>✔</span></div>
        <div class="dz-error-mark"><span>✘</span></div>
        <div class="dz-error-message"><span data-dz-errormessage></span></div>
    </div>
</div>

<c:if test="${base!=null}">
    </div>
    </div>
    </div>
    </div>
    </div>
    <%@include file="/WEB-INF/includes/script.jsp"%>
    <!-- blueimp gallery -->
    <script src="${pageContext.request.contextPath}/js/plugins/blueimp/jquery.blueimp-gallery.min.js"></script>
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
                        url: "upload",
                        previewTemplate: document.querySelector('#preview-template').innerHTML,
                        //            previewsContainer: '#hotel-previewContainer',
                        autoProcessQueue: true,
                        uploadMultiple: true,
                        maxFilesize: 256, // MB
                        parallelUploads: 100,
                        maxFiles: 100,
                        addRemoveLinks: true,
//                    previewsContainer : ".dropzone-previews",
//                                        acceptedFiles: ".png, .jpg",
                                        acceptedFiles: "image/*",

                        // Dropzone settings
                        init: function () {
                            var myDropzone = this;
                            $('#imageSubmit').on("click", function (e) {
                                e.preventDefault();
                                alert("dsfsadf");
                                myDropzone.processQueue();
                            });

                            $.getJSON("getImage/" +${hotelDetailId}).done(function (data) {
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
                                        $(mockFile.previewTemplate).children('.dz-details').wrap('<a data-gallery="#hotelImage" href="${url}'+value.imageUrl+'" class="image"></a>');
//
                                    });
                                }
                                //                    $(file.previewTemplate).append('<span class="server_file" >'+value.imageUrl+'</span>');

                            });

                            $("#hotel-dropzone").on('focusout', 'input.caption', function() {

                                var caption = $(this).val();
                                var imageId = $(this).parent().parent().find('.server_file').text();

                                $.post("hotelCaption",{imageId: imageId, caption: caption});
                            });

                            $("#hotel-dropzone").on('click', 'input.thumbnail', function() {

                                var imageId = $(this).parent().parent().find('.server_file').text();

                                $.post("hotelThumbnail",{imageId: imageId, hotelDetailId: ${hotelDetailId}});
                            });

                            /*this.on("addedfile", function(file){
                                $(this).click(function(){
                                    alert("ganga");
                                })
                            });*/

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
                                        caption = response[i].ID.caption;
                                    }


                                    $(files[i].previewTemplate).append('<div class="custom-field"><input type="text" placeholder="caption" class="caption" value="' + caption + '"><br>'+
                                            '<input type="radio" name="thumbnail" class="thumbnail"'+thumbnail1+' ></div>');
                                    $(files[i].previewTemplate).append('<span class="server_file" style="display: none">' + response[i].ID + '</span>');
                                    $(files[i].previewTemplate).children('.dz-details').wrap('<a data-gallery="#hotelImage" href="${url}${hotelDetailId}/'+response[i].file_name+'" ></a>');

//                                    $(files[i].previewTemplate).append('<span class="server_file" style="display: none">' + response[i].ID + '</span>');
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


                            this.on("removedfile", function (file) {

                                var server_file = $(file.previewTemplate).children('.server_file').text();
                                //                    alert(server_file);

                                // Do a post request and pass this path and use server-side language to delete the file
                                $.post("deleteImage", {file_to_be_deleted: server_file});
                            });

                        }
                    });

        });

        <c:forEach items="${roomDetailList}" var="roomDetail" varStatus="count">
        $(document).ready(function () {


            var myDropzone${count.count} = new Dropzone(
                    '#room-dropzone${count.count}', //id of drop zone element 1
                    {
                        url: "uploadRoomImage",
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

                            $.getJSON("getRoomImage/" +
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

                                        var thumbnail1 ='';
                                        var caption = '';
                                        if(value.thumbnail=='Y'){
                                            thumbnail1= 'checked';
                                        }
                                        if(value.caption!=undefined){
                                            caption = value.caption;
                                        }

                                        $(mockFile.previewTemplate).append('<span class="server_file" style="display: none">' + value.roomImageId + '</span>');
                                        $(mockFile.previewTemplate).append('<div class="custom-field"><input type="text" placeholder="caption" class="caption" value="' + caption + '"><br>'+
                                                '<input type="radio" name="thumbnail" class="thumbnail"'+thumbnail1+' ></div>');
                                        $(mockFile.previewTemplate).children('.dz-details').wrap('<a data-gallery="roomImage${count.count}" href="${roomImageUrl}'+value.imageUrl+'" class="image"></a>');

//                                        $(mockFile.previewTemplate).append('<span class="server_file" style="display: none">' + value.roomImageId + '</span>');


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

                                $.post("roomCaption",{imageId: imageId, caption: caption});
                            });
                            $("#room-dropzone${count.count}").on('click', 'input.thumbnail', function() {

                                var imageId = $(this).parent().parent().find('.server_file').text();

                                $.post("roomThumbnail",{imageId: imageId, roomDetailId: ${roomDetail.roomDetailId}});
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

                                    $(files[i].previewTemplate).append('<span class="server_file" style="display: none">' + response[i].ID + '</span>');
                                    $(files[i].previewTemplate).append('<div class="custom-field"><input type="text" placeholder="caption" class="caption" value="' + caption + '"><br>'+
                                            '<input type="radio" name="thumbnail" class="thumbnail"'+thumbnail1+' ></div>');
                                    $(files[i].previewTemplate).children('.dz-details').wrap('<a data-gallery="roomImage${count.count}" href="${roomImageUrl}${roomDetail.roomDetailId}/'+response[i].file_name+'" class="image"></a>');

//                                    $(files[i].previewTemplate).append('<span class="server_file" style="display: none">' + response[i].ID + '</span>');
                                    i++;

                                });

                            });
                            this.on("errormultiple", function (files, response) {
                            });


                            this.on("removedfile", function (file) {
                                var server_file = $(file.previewTemplate).children('.server_file').text();
                                //                    alert(server_file);

                                // Do a post request and pass this path and use server-side language to delete the file
                                $.post("deleteRoomImage", {file_to_be_deleted: server_file});
                            });

                        }
                    }
            );


        });
        </c:forEach>




    </script>

</c:if>
</body>
</html>



<%--

<div class="dz-preview dz-file-preview">
  <div class="dz-details">
    <div class="dz-filename"><span data-dz-name></span></div>
    <div class="dz-size" data-dz-size></div>
    <img data-dz-thumbnail />
  </div>
  <div class="dz-progress"><span class="dz-upload" data-dz-uploadprogress></span></div>
  <div class="dz-success-mark"><span>✔</span></div>
  <div class="dz-error-mark"><span>✘</span></div>
  <div class="dz-error-message"><span data-dz-errormessage></span></div>
</div>

--%>

<%--<form action="hotelFeature/upload" class="dropzone">
    <div class="fallback">
        <input name="file" type="file" multiple />
    </div>
</form>--%>







