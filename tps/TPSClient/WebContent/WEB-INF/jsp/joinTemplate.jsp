<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>


<!-- Mirrored from webapplayers.com/inspinia_admin-v2.4/dashboard_4.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 01 Feb 2016 10:46:03 GMT -->
<head>
    <%--<link href="${pageContext.request.contextPath}/css/plugins/dropzone/dropzone.css" rel="stylesheet">--%>
    <%--<link href="${pageContext.request.contextPath}/css/plugins/blueimp/css/blueimp-gallery.min.css" rel="stylesheet">--%>
    <base href="${pageContext.request.contextPath}/${base}/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | Dashboard v.4</title>

   <%-- <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">--%>
        <%@include file="/WEB-INF/includes/styling.jsp" %>


</head>

<body class="top-navigation">

<div id="wrapper">
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom white-bg">
            <nav class="navbar navbar-static-top" role="navigation">
                <div class="navbar-header">
                    <button aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
                        <i class="fa fa-reorder"></i>
                    </button>
                    <a href="#" class="navbar-brand">Travel Portal System</a>
                </div>
                <div class="navbar-collapse collapse" id="navbar">
                    <ul class="nav navbar-nav">
                        <li <c:if test="${step==1 || step == null}">class="active"</c:if>>
                            <a aria-expanded="false" role="button" href="${pageContext.request.contextPath}/register/hotelDetail/${sessionScope.get('token')}"> Hotel Detail</a>
                        </li>
                        <li <c:if test="${step==2}">class="active"</c:if>>
                            <a aria-expanded="false" role="button" href="${pageContext.request.contextPath}/register/hotelFeature/${sessionScope.get('token')}" class="href-child"> Hotel Features</a>
                        </li>
                        <li <c:if test="${step==3}">class="active"</c:if>>
                            <a aria-expanded="false" role="button" href="${pageContext.request.contextPath}/register/roomDetail/${sessionScope.get('token')}" class="href-child"> Room Detail</a>
                        </li>
                        <li <c:if test="${step==4}">class="active"</c:if>>
                            <a aria-expanded="false" role="button" href="${pageContext.request.contextPath}/register/roomAmenity/${sessionScope.get('token')}" class="href-child"> Room Amenity</a>
                        </li>
                        <li <c:if test="${step==5}">class="active"</c:if>>
                            <a aria-expanded="false" role="button" href="${pageContext.request.contextPath}/register/image/${sessionScope.get('token')}" class="href-child"> Images</a>
                        </li>
                        <li <c:if test="${step==6}">class="active"</c:if>>
                            <a aria-expanded="false" role="button" href="${pageContext.request.contextPath}/register/agreement/${sessionScope.get('token')}" class="href-child"> Agreement</a>
                        </li>

                    </ul>
                    <ul class="nav navbar-top-links navbar-right">
                        <li>
                            <%--<button class="btn btn-primary" id="preview">Preview</button>--%>
                            <%--<a href="login.html">
                                <i class="fa fa-sign-out"></i> Log out
                            </a>--%>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="wrapper wrapper-content">
            <div class="container">
                <div class="row">
                    <c:if test="${step==1 || step==null}">  <%@include file="/WEB-INF/jsp/propertyDetailForm.jsp" %></c:if>
                    <c:if test="${step==2}">  <%@include file="/WEB-INF/jsp/hotelFeatureForm.jsp" %></c:if>
                    <c:if test="${step==3}">  <%@include file="/WEB-INF/jsp/roomDetailForm.jsp" %></c:if>
                    <c:if test="${step==4}">  <%@include file="/WEB-INF/jsp/roomAmenityForm.jsp" %></c:if>
                    <c:if test="${step==5}"> <%@include file="/WEB-INF/jsp/image.jsp" %></c:if>
                    <c:if test="${step==6}"> <%@include file="/WEB-INF/jsp/agreement.jsp" %></c:if>
                </div>


            </div>

        </div>
       <%-- <div class="footer">
            <div class="pull-right">
                10GB of <strong>250GB</strong> Free.
            </div>
            <div>
                <strong>Copyright</strong> Example Company &copy; 2014-2015
            </div>
        </div>--%>

    </div>
</div>
<script src="${pageContext.request.contextPath}/js/preview.js"></script>

<script type="text/javascript">

    $("#preview").click(function(){
        $.ajax({
            method: "POST",
            url: "${pageContext.request.contextPath}/register/preview",
//            data: { parentAddressId: elementValue },
            dataType: "json",
            success: function(data){
console.log(data);
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
    });
    if("${step}" == 1 && "${hotelDetailMap.totalRoom}" == "" ){
        $('.href-child').click(function(e) {
            e.preventDefault();
            //do other stuff when a click happens
        });

        $('.href-child').hover(function(e) {
            $(this).attr("title","complete hotel detail");
            //do other stuff when a click happens
        });
    }

</script>


</body>


<!-- Mirrored from webapplayers.com/inspinia_admin-v2.4/dashboard_4.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 01 Feb 2016 10:46:03 GMT -->
</html>
