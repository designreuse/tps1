<%@include file="/WEB-INF/includes/header.jsp" %>
<c:if test="${base!=null}">
    <div id="wrapper">
    <%@include file="/WEB-INF/includes/leftNavigation.jsp" %>
    <div id="page-wrapper" class="gray-bg">
    <%@include file="/WEB-INF/includes/topNav.jsp" %>
    <div class="wrapper wrapper-content animated fadeIn">

    <div class="p-w-md m-t-sm">
    <div class="row">
</c:if>
<div>
    <form method="post" action="save">

        <c:set var="index" value="0"/>
        <input type="hidden" value="${sessionScope.hotelDetailId}" name="hotelDetailId">
        <c:forEach var="keyValue" items="${keySet}" varStatus="count">
            <%--<c:out value="${fn:length(key)}"/>--%>
            <%--<c:out value="${key}"/>--%>
            <%--<c:set value="${key}" var="keyValue"></c:set>--%>
            <c:if test="${keyValue eq 'food'}">

                <div class="col-lg-12">

                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <div class="col-md-3"><h5>Food</h5></div>
                            <div class="col-md-6 text-center">Note: Select only 5 places</div>
                            <div class="col-md-3 text-right">
                                <div class="ibox-tools">
                                    <a class="collapse-link">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>


                                </div>
                            </div>


                        </div>
                        <div class="ibox-content">

                            <c:forEach var="nearPlace" items="${nearPlaceSearch.food}">
                                <div class="col-sm-6">${nearPlace.placeName}</div>
                                <div class="col-sm-3">${nearPlace.distance} </div>
                                <div class="col-sm-3">
                                    <input type="hidden" class="form-control"
                                           name="nearPlacesModels[${index}].placeName" value="${nearPlace.placeName}">
                                    <input type="hidden" class="form-control" name="nearPlacesModels[${index}].distance"
                                           value="${nearPlace.distance}">
                                    <input type="hidden" class="form-control" name="nearPlacesModels[${index}].lat"
                                           value="${nearPlace.lat}">
                                    <input type="hidden" class="form-control" name="nearPlacesModels[${index}].lng"
                                           value="${nearPlace.lng}">
                                    <input type="hidden" class="form-control" name="nearPlacesModels[${index}].type"
                                           value="food">
                                    <input type="checkbox" name="checked"
                                    <c:if test="${nearPlace.checked eq 1}"> checked </c:if> value="${index}"
                                           class="food">

                                </div>
                                <c:set var="index" value="${index+1}"/>
                            </c:forEach>

                        </div>
                    </div>
                </div>
            </c:if>

            <c:if test="${keyValue eq 'store'}">
                <%--<c:out value="${nearPlaceSearch.store[0].name}"/>--%>
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <div class="col-md-3"><h5>Market</h5></div>
                            <div class="col-md-6 text-center">Note: Select only 5 places</div>
                            <div class="col-md-3 text-right">
                                <div class="ibox-tools">
                                    <a class="collapse-link">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>


                                </div>
                            </div>


                        </div>
                        <div class="ibox-content">

                            <c:forEach var="nearPlace" items="${nearPlaceSearch.store}">
                                <div class="col-sm-6">${nearPlace.placeName}</div>
                                <div class="col-sm-3">${nearPlace.distance} </div>
                                <div class="col-sm-3">
                                    <input type="hidden" class="form-control"
                                           name="nearPlacesModels[${index}].placeName" value="${nearPlace.placeName}">
                                    <input type="hidden" class="form-control" name="nearPlacesModels[${index}].distance"
                                           value="${nearPlace.distance}">
                                    <input type="hidden" class="form-control" name="nearPlacesModels[${index}].lat"
                                           value="${nearPlace.lat}">
                                    <input type="hidden" class="form-control" name="nearPlacesModels[${index}].lng"
                                           value="${nearPlace.lng}">
                                    <input type="hidden" class="form-control" name="nearPlacesModels[${index}].type"
                                           value="store">
                                    <input type="checkbox" name="checked"
                                    <c:if test="${nearPlace.checked eq 1}"> checked </c:if> value="${index}"
                                           class="store">

                                </div>
                                <c:set var="index" value="${index+1}"/>
                            </c:forEach>

                        </div>
                    </div>
                </div>


            </c:if>
            <%--<c:out value="${keyValue}"/>--%>
            <c:if test="${keyValue eq 'taxi_stand' }">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">

                        <div class="ibox-title">
                            <div class="col-md-3"><h5>Travel</h5></div>
                            <div class="col-md-6 text-center">Note: Select only 5 places</div>
                            <div class="col-md-3 text-right">
                                <div class="ibox-tools">
                                    <a class="collapse-link">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>


                                </div>
                            </div>


                        </div>
                        <div class="ibox-content">


                            <c:forEach var="nearPlace" items="${nearPlaceSearch.taxi_stand}">
                                <div class="col-sm-6">${nearPlace.placeName}</div>
                                <div class="col-sm-3">${nearPlace.distance} </div>
                                <div class="col-sm-3">
                                    <input type="hidden" class="form-control"
                                           name="nearPlacesModels[${index}].placeName" value="${nearPlace.placeName}">
                                    <input type="hidden" class="form-control" name="nearPlacesModels[${index}].distance"
                                           value="${nearPlace.distance}">
                                    <input type="hidden" class="form-control" name="nearPlacesModels[${index}].lat"
                                           value="${nearPlace.lat}">
                                    <input type="hidden" class="form-control" name="nearPlacesModels[${index}].lng"
                                           value="${nearPlace.lng}">
                                    <input type="hidden" class="form-control" name="nearPlacesModels[${index}].type"
                                           value="taxi_stand">
                                    <input type="checkbox" name="checked"
                                    <c:if test="${nearPlace.checked eq 1}"> checked </c:if> value="${index}"
                                           class="travel">

                                </div>
                                <c:set var="index" value="${index+1}"/>
                            </c:forEach>

                            <c:forEach var="nearPlace" items="${nearPlaceSearch.bus_station}">
                                <div class="col-sm-6">${nearPlace.placeName}</div>
                                <div class="col-sm-3">${nearPlace.distance} </div>
                                <div class="col-sm-3">
                                    <input type="hidden" class="form-control"
                                           name="nearPlacesModels[${index}].placeName" value="${nearPlace.placeName}">
                                    <input type="hidden" class="form-control" name="nearPlacesModels[${index}].distance"
                                           value="${nearPlace.distance}">
                                    <input type="hidden" class="form-control" name="nearPlacesModels[${index}].lat"
                                           value="${nearPlace.lat}">
                                    <input type="hidden" class="form-control" name="nearPlacesModels[${index}].lng"
                                           value="${nearPlace.lng}">
                                    <input type="hidden" class="form-control" name="nearPlacesModels[${index}].type"
                                           value="bus_station">
                                    <input type="checkbox" name="checked"
                                    <c:if test="${nearPlace.checked eq 1}"> checked </c:if> value="${index}"
                                           class="travel">

                                </div>
                                <c:set var="index" value="${index+1}"/>
                            </c:forEach>


                        </div>
                    </div>
                </div>
            </c:if>

        </c:forEach>
        <input type="submit" value="Save">
    </form>
</div>

<c:if test="${base!=null}">
    </div>
    </div>
    </div>
    </div>
    </div>
    <%@include file="/WEB-INF/includes/script.jsp" %>
    <script src="${pageContext.request.contextPath}/js/preview.js"></script>

    <script type="text/javascript">
        var storeCount = $('.store:checked').length;
        var travelCount = $('.travel:checked').length;
        var foodCount = $('.food:checked').length;
        var maxCheck = 5;
        //        alert($('.store:checked').length);
        $(".food").each(function () {
            $(this).click(function () {
                if ($(this).is(":checked")) {
                    if (foodCount < maxCheck) {
                        foodCount++;
                    } else {
                        $(this).attr("checked", false);
//                        alert("only 5 places can click");
                    }
                } else {
                    foodCount--;
                }
            });
        });

        $(".store").each(function () {
            $(this).click(function () {
                if ($(this).is(":checked")) {
                    if (storeCount < maxCheck) {
                        storeCount++;
                    } else {
                        $(this).attr("checked", false);
//                        alert("only 5 places can click");
                    }
                } else {
                    storeCount--;
                }
            });
        });

        $(".travel").each(function () {
            $(this).click(function () {
                if ($(this).is(":checked")) {
                    if (travelCount < maxCheck) {
                        travelCount++;
                    } else {
                        $(this).attr("checked", false);
//                        alert("only 5 places can click");
                    }
                } else {
                    travelCount--;
                }
            });
        });
    </script>

</c:if>
</body>
</html>