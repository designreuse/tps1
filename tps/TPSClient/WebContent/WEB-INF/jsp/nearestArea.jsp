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

    <form id="form1" class="form-horizontal" method="post" action="update">
        <fieldset>



            <input id="hotel" name="hotelDetailId" value="${sessionScope.hotelDetailId}" type="hidden">
            <%-- <div class="control-group">
                 <label class="control-label" for="distance">Hotel</label>
                 <div class="controls">
                     <input class="input-xlarge focused" id="distance" name="distance"
                            type="text" value="${hotelName}" required>
                 </div>
             </div>--%>

            <p>Hotel: ${hotelName}</p>

            <table class="table table-striped table-bordered bootstrap-datatable " id="popularPlace">
                <thead>
                <tr>
                    <th>S.N</th>
                    <th>Place</th>
                    <th>Distance (km)</th>
                    <th>Assign</th>
                </tr>
                </thead>
                <tbody >

                <%--<c:forEach items="${nearestPlaceList}" var="place" varStatus="count">


                    <tr>
                        <td>${count.count}.</td>
                        <td>${place.place}</td>
                        <td><input type="text" value="${place.distance}"> </td>
                        <td><input type="checkbox" name="checkedRows"
                                   value="${place.popularPlaceId}"
                                   <c:if test="${place.distance!=null}">checked</c:if>></td>

                    </tr>



                </c:forEach>--%>


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
        <script type="text/javascript">

            $(document).ready(function(){
                var market="<tr> <td colspan='5'>Market</td> </tr>";
                var travel="<tr> <td colspan='5'>Travel</td> </tr>";
                var restaurant="<tr> <td colspan='5'>Restaurant</td> </tr>";
                var marketIndex=1;
                var travelIndex=1;
                var restaurantIndex =1;


                <c:forEach var="nearPlace" items="${nearestPlaceList}" varStatus="count">

                <c:choose>
                <c:when test="${nearPlace.type=='MARKET'}">

                market=market+'<tr>'+
                        '<td>'+marketIndex+'.</td>'+
                        '<td>${nearPlace.place}</td>'+
                        '<td><input type="text" value="${nearPlace.distance}" name="distance" class="distance"> <input type="hidden" value="${nearPlace.nearestAreaId}" name="nearestPlaceId">'+
                        '<input type="hidden" value="${nearPlace.popularPlaceId}" name="popularPlaceId"></td>'+
                        '<td><input type="checkbox" name="active" value="${nearPlace.popularPlaceId}" <c:if test="${nearPlace.active=='Y'}">checked</c:if> class="active"></td>'+
                        '</tr>';
                marketIndex++;
                </c:when>
                <c:when test="${nearPlace.type=='TRAVEL'}">
                travel=travel+'<tr>'+
                        '<td>'+travelIndex+'.</td>'+
                        '<td>${nearPlace.place}</td>'+
                        '<td><input type="text" value="${nearPlace.distance}" name="distance" class="distance"> <input type="hidden" value="${nearPlace.nearestAreaId}" name="nearestPlaceId">'+
                        '<input type="hidden" value="${nearPlace.popularPlaceId}" name="popularPlaceId"></td>'+
                        '<td><input type="checkbox" name="active" value="${nearPlace.popularPlaceId}" <c:if test="${nearPlace.active=='Y'}">checked</c:if> class="active"></td>'+
                        '</tr>';
                travelIndex++;
                </c:when>
                <c:when test="${nearPlace.type=='RESTAURANT'}">
                restaurant=restaurant+'<tr>'+
                        '<td>'+restaurantIndex+'.</td>'+
                        '<td>${nearPlace.place}</td>'+
                        '<td><input type="text" value="${nearPlace.distance}" name="distance" class="distance"> <input type="hidden" value="${nearPlace.nearestAreaId}" name="nearestPlaceId">'+
                        '<input type="hidden" value="${nearPlace.popularPlaceId}" name="popularPlaceId"></td>'+
                        '<td><input type="checkbox" name="active" value="${nearPlace.popularPlaceId}" <c:if test="${nearPlace.active=='Y'}">checked</c:if> class="active"></td>'+
                        '</tr>';
                restaurantIndex++;
                </c:when>
                </c:choose>

                </c:forEach>

                $('#popularPlace > tbody:last-child').append(market);
                $('#popularPlace > tbody:last-child').append(travel);
                $('#popularPlace > tbody:last-child').append(restaurant);



            });

            $(document).ready(function(){
// your code
                $("[class='active']").each(function (element) {
                    if ($(this).is(":checked")) {
//                        $(this).parent().prev().find(".distance").css("background-color", "yellow")
                        $(this).parent().prev().find(".distance").show();
                        $(this).parent().prev().find(".distance").prop('disabled', false);
                    } else {
                        $(this).parent().prev().find(".distance").hide();
                        $(this).parent().prev().find(".distance").prop('disabled', true);
                    }

                    $(this).click(function () {
//            var chargeOption = $(this).parent().parent().next().find('span').text();
                        if ($(this).is(":checked")) {
                            $(this).parent().prev().find(".distance").show();
                            $(this).parent().prev().find(".distance").prop('disabled', false);
//                $(".answer").show(300);
                        } else {
                            $(this).parent().prev().find(".distance").hide();
                            $(this).parent().prev().find(".distance").prop('disabled', true);
                        }
                    });
                });
            });




            //


        </script>


    </c:if>
    </body>
    </html>
