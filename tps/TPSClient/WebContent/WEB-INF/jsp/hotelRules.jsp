<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 5/13/2016
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/includes/header.jsp"%>

    <div id="wrapper">
    <%@include file="/WEB-INF/includes/leftNavigation.jsp"%>
    <div id="page-wrapper" class="gray-bg">
    <%@include file="/WEB-INF/includes/topNav.jsp"%>
    <div class="wrapper wrapper-content animated fadeIn">

    <div class="p-w-md m-t-sm">
    <div class="row">
<form id="form1" class="form-horizontal" method="post" action="${mode}">


        <%--<div class="control-group">
            <label class="control-label" for="hotel">Hotel</label>
            <div class="controls">
                ${hotelName}
                <input id="hotel" name="hotelDetailId" value="${hotelId}" type="hidden">
                    &lt;%&ndash;<select id="hotel" name="hotelDetailId" data-rel="chosen">
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
                    </select>&ndash;%&gt;
            </div>
        </div>--%>
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


        <input id="hotel" name="hotelDetailId" value="${hotelDetailId}" type="hidden">

        <table class="table table-striped table-bordered bootstrap-datatable " id="popularPlace">
            <thead>
            <tr>
                <th>S.N</th>
                <th>Rules</th>
                <th>Assign</th>
            </tr>
            </thead>
            <tbody >

            <c:forEach items="${hotelRulesList}" var="hotelRules" varStatus="count">


                <tr>
                    <td>${count.count}.</td>
                    <td>${hotelRules.rulesDesc}</td>
                    <input type="hidden" value="${hotelRules.hotelRulesId}" name="hotelRulesId">
                    <input type="hidden" value="${hotelRules.rulesId}" name="rulesId"></td>
                    <td><input type="checkbox" name="active" value="${hotelRules.rulesId}" <c:if test="${hotelRules.active=='Y'}">checked</c:if>></td>

                </tr>



            </c:forEach>


            </tbody>
        </table>

        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Save changes</button>
            <button class="btn" id="cancel">Cancel</button>
        </div>



    </fieldset>
</form>
<c:if test="${base!=null}">
    </div>
    </div>
    </div>
    </div>
    </div>
    <%@include file="/WEB-INF/includes/script.jsp"%>
    <script src="${pageContext.request.contextPath}/js/preview.js"></script>
    <c:forEach items="${siteContent.js}" var="js">
        <script src="${pageContext.request.contextPath}/js/plugins/${js}"></script>
    </c:forEach>


</c:if>
</body>
</html>
