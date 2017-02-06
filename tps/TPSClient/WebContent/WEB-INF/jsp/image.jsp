

<div class="col-lg-12">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <div class="col-md-3"><h5>Hotel</h5></div>
            <div class="col-md-6 text-center">Note: Upload atleast 4 photo</div>
            <div class="col-md-3 text-right">
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>


                </div>
            </div>
            <%--<h5>Hotel</h5>
            <div class="ibox-tools">
                <a class="collapse-link">
                    <i class="fa fa-chevron-up"></i>
                </a>


            </div>--%>
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
                <div class="col-md-3"><h5>${roomDetail.customName}</h5></div>
                <div class="col-md-6 text-center">Note: Upload atleast 4 photo</div>
                <div class="col-md-3 text-right">
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>


                    </div>
                </div>
                <%--<h5>${roomDetail.customName}</h5>
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>


                </div>--%>
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


    <%@include file="/WEB-INF/includes/script.jsp"%>
    <!-- blueimp gallery -->
    <%--<script src="${pageContext.request.contextPath}/js/plugins/blueimp/jquery.blueimp-gallery.min.js"></script>--%>
    <%--<!-- DROPZONE -->--%>
    <%--<script src="${pageContext.request.contextPath}/js/plugins/dropzone/dropzone.js"></script>--%>
    <script src="${pageContext.request.contextPath}/js/image.js"></script>
    <script src="${pageContext.request.contextPath}/js/JIC.js"></script>


    <script>
        <c:set
                                    value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/TPSResources/HotelImages/"
                                    var="url"></c:set>

        <c:set
                                    value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/TPSResources/RoomImages/"
                                    var="roomImageUrl"></c:set>
        $(document).ready(function () {

            var jsonUrl = {"saveUrl": "upload", "getUrl": "getImage/${hotelDetailId}", "deleteUrl": "deleteImage", "captionUpdate": "hotelCaption", "thumbnailUpdate": "hotelThumbnail"}

            Dropzone.autoDiscover = false;
            var myDropzoneTheFirst = dropzoneImage(jsonUrl, "${hotelDetailId}", "${url}","#hotel-dropzone", "#hotelImage");

        });

        <c:forEach items="${roomDetailList}" var="roomDetail" varStatus="count">
        $(document).ready(function () {
            var jsonUrl = {"saveUrl": "uploadRoomImage", "getUrl": "getRoomImage/${roomDetail.roomDetailId}", "deleteUrl": "deleteRoomImage", "captionUpdate": "roomCaption", "thumbnailUpdate": "roomThumbnail"}


            var myDropzone${count.count} = dropzoneImage(jsonUrl, "${roomDetail.roomDetailId}", "${roomImageUrl}","#room-dropzone${count.count}", "roomImage${count.count}");




        });
        </c:forEach>




    </script>






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







