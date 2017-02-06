<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 5/27/2016
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/includes/script.jsp"%>
</head>
<body>
<div>
<c:forEach var="keyValue" items="${keySet}" varStatus="count">
    <%--<c:out value="${fn:length(key)}"/>--%>
    <%--<c:out value="${key}"/>--%>
    <%--<c:set value="${key}" var="keyValue"></c:set>--%>
 <c:if test="${keyValue eq 'food'}">

     <div class="col-sm-4"><h4>Food</h4>
         <c:forEach var="nearPlace" items="${nearPlaceSearch.food}">
             <div class="col-sm-6">${nearPlace.name}</div>
             <div class="col-sm-6">${nearPlace.distance}</div>
         </c:forEach>

     </div></c:if>

    <c:if test="${keyValue eq 'store'}">
        <div class="col-sm-4"><h4>Market</h4>
            <%--<c:out value="${nearPlaceSearch.store[0].name}"/>--%>
            <c:forEach var="nearPlace" items="${nearPlaceSearch.store}">
                <div class="col-sm-6">${nearPlace.name}</div>
                <div class="col-sm-6">${nearPlace.distance}</div>
            </c:forEach>

        </div></c:if>

    <c:if test="${keyValue eq 'taxi_stand' }">
        <div class="col-sm-4"><h4>Travel</h4>
            <c:forEach var="nearPlace" items="${nearPlaceSearch.taxi_stand}">
                <div class="col-sm-6">${nearPlace.name}</div>
                <div class="col-sm-6">${nearPlace.distance}</div>
            </c:forEach>

        </div></c:if>

</c:forEach>
</div>
<%--<table>

    <c:forEach var="nearPlace" items="${nearPlaceSearch}">
        <c:set var="contains" value="false" />
        <c:forEach var="item" items="${nearPlace.types}">
            <c:if test="${item eq 'food'}">
                <c:set var="contains" value="true" />
            </c:if>
        </c:forEach>

        <tr> <td>${nearPlace.name}</td><td>${nearPlace.distance}</td><td><c:if test="${contains==true}">food</c:if> </td></tr>
    </c:forEach>
</table>--%>

<%--<table>
    <c:forEach var="rows" items="${distance}">
        <tr><td>${rows.destinationAddresses}</td><td>${rows.originAddresses}</td></tr>
    </c:forEach>
</table>--%>
<%@include file="/WEB-INF/includes/styling.jsp"%>
</body>
</html>
