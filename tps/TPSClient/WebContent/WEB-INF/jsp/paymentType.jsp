    <%@include file="/WEB-INF/includes/header.jsp"%>
    <c:if test="${base!=null}">
        <div id="wrapper">
        <%@include file="/WEB-INF/includes/leftNavigation.jsp"%>
        <div id="page-wrapper" class="gray-bg">
        <%@include file="/WEB-INF/includes/topNavigation.jsp"%>
        <div class="wrapper wrapper-content animated fadeIn">

        <div class="p-w-md m-t-sm">
        <div class="row">
    </c:if>

<form class="form-horizontal" method="post" action="<c:choose><c:when test="${base!=null}">edit</c:when><c:otherwise>hotelDetail/edit</c:otherwise></c:choose> " id="propertyDetailForm">


    <input type="hidden" name="hotelDetailId"
           value="${hotelDetailMap.hotelDetailId}">



    <c:forEach var="paymentType" items="${paymentTypeList}">
        <div class="col-sm-6">
            <div><label> <input type="checkbox" value="${paymentType.paymentTypeId}" name="paymentType" <c:if test="${roomAmenity.active=='Y'}"> checked </c:if>> ${paymentType.paymentTypeDesc} </label></div>

        </div>
    </c:forEach>

    <%--<div class="form-group"><label class="col-sm-2 control-label">Number of
        Rooms</label>

        <div class="col-sm-3"><input type="number" class="form-control"
                                     placeholder="Number of Rooms"
                                     name="totalRoom"
                                     value="${hotelDetailMap.totalRoom}" required></div>
    </div>
    <div class="hr-line-dashed"></div>--%>

    <div class="form-group">
        <div class="col-sm-4 col-sm-offset-2">
            <%--<button type="reset" class="btn btn-white">Reset</button>--%>
            <button type="submit" class="btn btn-primary">Update</button>
        </div>
    </div>
</form>

    <c:if test="${base!=null}">
        </div>
        </div>
        </div>
        </div>
        </div>
        <%@include file="/WEB-INF/includes/script.jsp"%>



    </c:if>
    </body>
    </html>
