    <%@include file="/WEB-INF/includes/header.jsp"%>
    <style>
        #map {
            width: 100%;
            height: 400px;
        }
    </style>


        <div id="wrapper">
        <%@include file="/WEB-INF/includes/leftNavigation.jsp"%>
        <div id="page-wrapper" class="gray-bg">
        <%@include file="/WEB-INF/includes/topNav.jsp"%>
        <div class="wrapper wrapper-content animated fadeIn" id="">

        <div class="p-w-md m-t-sm">
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
        </div>
        </div>
    <script src="${pageContext.request.contextPath}/js/preview.js"></script>

    </body>
    </html>
