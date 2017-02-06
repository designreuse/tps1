<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
<head>

    <!-- start: Meta -->
    <meta charset="utf-8">
    <title>Hotel Detail</title>
    <meta name="description" content="IGC Travel Portal System">
    <meta name="author" content="IGC Travel Portal System">
    <meta name="keyword" content="IGC Travel Portal System">
    <!-- end: Meta -->

    <!-- start: Mobile Specific -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- end: Mobile Specific -->

    <!-- 	base url -->

    <base href="${pageContext.request.contextPath}/hotelImage/"/>

    <!--  End	base url -->


    <!-- start: CSS -->


    <!-- ******script included********* -->
    <%@include file="/WEB-INF/includes/styling.jsp" %>

    <!-- ******  end of script included********* -->
    <!-- end: CSS -->

    <link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/themes/dark-hive/jquery-ui.css"
          id="theme">
    <!-- Demo styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/demo.css">
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/demo-ie8.css">
    <![endif]-->
    <style>
        /* Adjust the jQuery UI widget font-size: */
        .ui-widget {
            font-size: 0.95em;
        }
    </style>
    <!-- blueimp Gallery styles -->
    <link rel="stylesheet" href="//blueimp.github.io/Gallery/css/blueimp-gallery.min.css">
    <!-- CSS to style the file input field as button and adjust the Bootstrap progress bars -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.fileupload.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.fileupload-ui.css">
    <!-- CSS adjustments for browsers with JavaScript disabled -->
    <noscript>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.fileupload-noscript.css">
    </noscript>
    <noscript>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.fileupload-ui-noscript.css">
    </noscript>


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
                    <h4 class="modal-title" id="myModalLabel">Delete Hotel Detail</h4>
                </div>
                <div class="modal-body">

                    Are you sure you want to delete this Hotel Detail? This action cannot be undone!
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
                    <a href="#">Home</a>
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


            <c:if test="${mode=='view'}">

                <div class="row-fluid sortable">
                    <div class="box span12" id="box">
                        <div class="box-header" data-original-title>
                            <h2><i class="halflings-icon white edit"></i><span class="break"></span>Please select
                                hotel to
                                view Images
                            </h2>
                            <div class="box-icon">
                                <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
                                <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
                                <a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
                            </div>
                        </div>
                        <div class="box-content">
                            <form id="formArea" class="form-horizontal" method="post" action="viewImages">
                                <fieldset>

                                    <div class="control-group">
                                        <label class="control-label" for="hotelDetailId">Hotel</label>
                                        <div class="controls">
                                            <select id="hotelDetailId" name="hotelDetailId" data-rel="chosen">
                                                <option value="">Please Select Hotel</option>
                                                <c:forEach items="${hotelDetailList}" var="data">
                                                    <option value="${data.hotelDetailId}"
                                                    >${data.hotelName},${data.regionName},${data.countryName}</option>
                                                </c:forEach>
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


            <c:if test="${UploadView=='UploadView'}">


                <div class="test">
                    <a href="view" title="Add Hotel Image" data-rel="tooltip" class="btn btn-success">Select Hotel</a>
                </div>


                <div class="test">
                    <form method="post" action="viewImages">
                        <input type="hidden" value="${HotelDetailIDForImage}"
                               name="hotelDetailId">

                        <button href="view" title="Add Hotel Image" data-rel="tooltip" class="btn btn-success">View
                            Hotel
                            Image
                        </button>

                    </form>


                </div>


                <div class="row-fluid sortable ui-sortable">
                    <div class="box span12">
                        <div data-original-title="" class="box-header">
                            <h2><i class="halflings-icon white picture"></i><span class="break"></span> Upload
                                File</h2>
                            <div class="box-icon">


                            </div>
                        </div>


                        <div class="box-content">

                            <form id="fileupload" action="upload" method="POST"
                                  enctype="multipart/form-data">
                                <!-- Redirect browsers with JavaScript disabled to the origin page -->
                                <noscript><input type="hidden" name="redirect"
                                                 value="https://blueimp.github.io/jQuery-File-Upload/"></noscript>
                                <!-- The fileupload-buttonbar contains buttons to add/delete files and start/cancel the upload -->
                                <div class="fileupload-buttonbar">
                                    <div class="fileupload-buttons">
                                        <!-- The fileinput-button span is used to style the file input field as button -->
            <span class="fileinput-button">
                <span>Add files...</span>
                <input type="file" name="files[]" multiple>
            </span>
                                        <button type="submit" class="start">Start upload</button>
                                        <button type="reset" class="cancel">Cancel upload</button>
                                            <%--  <button type="button" class="delete">Delete</button>--%>
                                            <%-- <input type="checkbox" class="toggle">--%>
                                        <!-- The global file processing state -->
                                        <span class="fileupload-process"></span>
                                    </div>
                                    <!-- The global progress state -->
                                    <div class="fileupload-progress fade fade-jquery" style="display:none">
                                        <!-- The global progress bar -->
                                        <div class="progress" role="progressbar" aria-valuemin="0"
                                             aria-valuemax="100"></div>
                                        <!-- The extended global progress state -->
                                        <div class="progress-extended">&nbsp;</div>
                                    </div>
                                </div>
                                <!-- The table listing the files available for upload/download -->
                                <table role="presentation">
                                    <tbody class="files"></tbody>
                                </table>
                            </form>


                            <div id="blueimp-gallery" class="blueimp-gallery blueimp-gallery-controls"
                                 data-filter=":even">
                                <div class="slides"></div>
                                <h3 class="title"></h3>
                                <a class="prev">?</a>
                                <a class="next">?</a>
                                <a class="close">×</a>
                                <a class="play-pause"></a>
                                <ol class="indicator"></ol>
                            </div>
                            <table id="uploaded-files" class="table">
                                <tr>
                                    <th>File Name</th>
                                    <th>File Size</th>
                                    <th>File Type</th>
                                    <th>Download</th>
                                </tr>
                            </table>


                            <script id="template-upload" type="text/x-tmpl">

{% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-upload fade fade-jquery">
        <td>
            <span class="preview"></span>
        </td>
        <td>
            <p class="name">{%=file.name%}</p>
            <strong class="error"></strong>
        </td>
        <td>
            <p class="size">Processing...</p>
            <div class="progress"></div>
        </td>
        <td>
            {% if (!i && !o.options.autoUpload) { %}
                <button class="start" disabled>Start</button>
            {% } %}
            {% if (!i) { %}
                <button class="cancel">Cancel</button>
            {% } %}
        </td>

        <td class="title"><label>Image Caption: <input name="title[]" required></label></td>


    </tr>
{% } %}























                            </script>
                            <!-- The template to display files available for download -->
                            <script id="template-download" type="text/x-tmpl">
{% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-download fade fade-jquery">
        <td>
            <span class="preview">
                {% if (file.thumbnailUrl) { %}
                    <a href="{%=file.url%}" title="{%=file.name%}" download="{%=file.name%}" data-gallery><img src="{%=file.thumbnailUrl%}"></a>
                {% } %}
            </span>
        </td>
        <td>
           <!-- <p class="name">
                <a href="{%=file.url%}" title="{%=file.name%}" download="{%=file.name%}" {%=file.thumbnailUrl?'data-gallery':''%}>{%=file.name%}</a>
            </p>-->
            {% if (file.error) { %}
              <!--  <div><span class="error">Error</span> {%=file.error%}</div>-->
            {% } %}
        </td>
        <td>
            <span class="size">{%=o.formatFileSize(file.size)%}</span>
        </td>
        <td>
           <%-- <button class="delete" data-type="{%=file.deleteType%}" data-url="{%=file.deleteUrl%}"{% if (file.deleteWithCredentials) { %} data-xhr-fields='{"withCredentials":true}'{% } %}>Delete</button>
            <input type="checkbox" name="delete" value="1" class="toggle">--%>
        </td>
    </tr>
{% } %}






















                            </script>


                        </div>

                    </div><!--/span-->

                </div>


            </c:if>

            <c:if test="${ImageView=='ImageView'}">

            <div class="test">
                <a href="uploadFile" title="Add Hotel Image" data-rel="tooltip" class="btn btn-success">Add Hotel
                    Image</a>
            </div>


            <div class="row-fluid sortable ui-sortable">
                <div class="box span12">
                    <div data-original-title="" class="box-header">
                        <h2><i class="halflings-icon white picture"></i><span class="break"></span> Gallery</h2>
                        <div class="box-icon">


                        </div>
                    </div>


                    <div class="box-content">
                        <c:set
                                value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/TPSResources/HotelImages/"
                                var="url"></c:set>


                        <div class="row-fluid">
                            <form method="post" action="edit" id="image-form">

                                <c:if test="${hotelImageModelList.size()!=0}">
                                    <button type="submit" class="btn btn-success block">submit</button>
                                </c:if>

                                <c:if test="${hotelImageModelList.size()==0}">
                                    <div class="alert alert-block ">
                                        <button data-dismiss="alert" class="close" type="button">×</button>
                                        <h4 class="alert-heading">No Image!</h4>
                                        <p>Please add Image to view them in gallery</p>
                                    </div>
                                </c:if>

                                <input
                                        type="radio" value="0" name="thumbnail" id="defaultCheck">
                                <input
                                        type="checkbox" name="active[]" checked="checked" value="0" id="defaultActive">

                                <c:forEach items="${hotelImageModelList}" var="data">
                                    <div class="span3 galleryHolder">

                                        <a class="example-image-link"
                                           href="${url}${data.imageUrl}"
                                           data-lightbox="example-set"
                                           data-title="Click the right half of the image to move forward."><img
                                                class="example-image"
                                                src="${url}/${data.imageUrl}" alt=""/></a>
                                        <div class="galleryFooter">


                                            <div class="image-post">

                                                <input type="hidden" value="${data.hotelImageId}" name="hotelImageId[]">

                                                <div class="controls">
                                                    <input type="text" name="caption[]" value="${data.caption}"
                                                           placeholder=" Image caption"
                                                           class="image-caption">

                                                    <div class="image-label"><span><input
                                                            type="radio" value="${data.hotelImageId}" name="thumbnail"
                                                    <c:if test="${data.thumbnail=='Y'}">
                                                            checked="checked"
                                                    </c:if>></span></div>
                                                    Thumbnail
                                                    <div class="image-label"><span><input
                                                            type="checkbox" name="active[]" value="${data.hotelImageId}"
                                                    <c:if test="${data.active=='Y'}">
                                                            checked="checked"
                                                    </c:if>  ></span></div>
                                                    Active on site

                                                </div>

                                                    <%--  <button type="submit" class="open btn btn-success btn-small img-btn">
                                                          Submit
                                                      </button>--%>

                                                <a class="open btn btn-danger btn-small img-btn" title="Delete"
                                                   data-toggle="modal"
                                                   data-target="#myModal_del"
                                                   data-id="${data.hotelImageId}" data-rel="tooltip">
                                                    <i class="halflings-icon white trash"></i>
                                                </a>


                                            </div>


                                        </div>

                                    </div>

                                </c:forEach>
                            </form>


                        </div>


                    </div>

                </div><!--/span-->

            </div>


        </div>

        </c:if>


        <!-- 			Add  or Edit form -->

        <c:if test="${mode=='edit' || mode=='add' || mode=='detail'}">

            <div class="row-fluid sortable">
                <div class="box span12" id="box">
                    <div class="box-header" data-original-title>
                        <h2><i class="halflings-icon white edit"></i><span class="break"></span><c:if
                                test="${mode=='add'}">Add</c:if><c:if test="${mode=='edit'}">Edit</c:if> <c:if
                                test="${mode=='detail'}">View</c:if> Hotel Detail </h2>
                        <div class="box-icon">
                            <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
                            <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
                            <a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
                        </div>
                    </div>
                    <div class="box-content">
                        <form id="form1" class="form-horizontal" method="post" action="${mode}">
                            <fieldset>
                                <input type="hidden" name="hotelDetailId" value="${hotelDetailMap.countryId}">
                                <div class="control-group">
                                    <label class="control-label" for="hotelName">Hotel Name</label>
                                    <div class="controls">
                                        <input class="input-xlarge focused" id="hotelName" name="hotelName"
                                               type="text" value="${hotelDetailMap.hotelName}">
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="hotelPhNo1">Phone No</label>
                                    <div class="controls">
                                        <input class="input-xlarge focused" id="hotelPhNo1" name="hotelPhNo1"
                                               type="text" value="${hotelDetailMap.hotelPhNo1}">
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="hotelPhNo2">Phone No(1.Optional)</label>
                                    <div class="controls">
                                        <input class="input-xlarge focused" id="hotelPhNo2" name="hotelPhNo2"
                                               type="text" value="${hotelDetailMap.hotelPhNo2}">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="hotelPhNo3">Phone No(2.Optional)</label>
                                    <div class="controls">
                                        <input class="input-xlarge focused" id="hotelPhNo3" name="hotelPhNo3"
                                               type="text" value="${hotelDetailMap.hotelPhNo3}">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="hotelAddress">Address</label>
                                    <div class="controls">
                                        <input class="input-xlarge focused" id="hotelAddress" name="hotelAddress"
                                               type="text" value="${hotelDetailMap.hotelAddress}">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="hotelEmailId">Email Id</label>
                                    <div class="controls">
                                        <input class="input-xlarge focused" id="hotelEmailId" name="hotelEmailId"
                                               type="text" value="${hotelDetailMap.hotelEmailId}">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="personalDetail">Personal Name</label>
                                    <div class="controls">
                                        <input class="input-xlarge focused" id="personalDetail"
                                               name="personalDetail" type="text"
                                               value="${hotelDetailMap.personalDetail}">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="personalPhNo">Personal Ph No</label>
                                    <div class="controls">
                                        <input class="input-xlarge focused" id="personalPhNo" name="personalPhNo"
                                               type="text" value="${hotelDetailMap.personalPhNo}">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="personalEmailId">Personal Email Id</label>
                                    <div class="controls">
                                        <input class="input-xlarge focused" id="personalEmailId"
                                               name="personalEmailId" type="text"
                                               value="${hotelDetailMap.personalEmailId}">
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="regionId">Location</label>
                                    <div class="controls">
                                        <select id="regionId" name="regionId" data-rel="chosen">
                                            <option value=""><strong>SELECT</strong></option>

                                            <c:forEach items="${regionList}" var="data">
                                                <option value="${data.regionId}"
                                                        <c:if test="${data.regionId==hotelDetailMap.regionId}">selected="selected"</c:if> >
                                                    <strong>${data.regionName}, ${data.countryName}</strong>
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="url">Hotel Link</label>
                                    <div class="controls">
                                        <input class="input-xlarge focused" id="url" name="url" type="text"
                                               value="${hotelDetailMap.url}">
                                    </div>
                                </div>

                                <c:if test="${mode!='detail'}">
                                    <div class="form-actions">
                                        <button type="submit" class="btn btn-primary">Save changes</button>
                                        <button class="btn" id="cancel">Cancel</button>
                                    </div>

                                </c:if>


                            </fieldset>
                        </form>

                    </div>
                </div><!--/span-->

            </div>
            <!--/row-->

        </c:if>
        <!-- 			End Add  or Edit form -->


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


<!-- ******script included********* -->


<%@include file="/WEB-INF/includes/script.jsp" %>

<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>

<!-- ******  end of script included********* -->

<!-- end: JavaScript-->


<script type="text/javascript">


    $("#image-form").submit(function (event) {


        if ($('input[name=thumbnail]:checked').length <= 0) {

            $('#defaultCheck').attr('checked', true);
        }
        /*
         return false;
         */

    });


    //
    <!-- 	pass deleteing  id to delete confirm model  -->

    $(document).on("click", ".open", function () {
        var id = $(this).data('id');
        $(".modal-body #deleteId").val(id);

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


</body>
</html>
	