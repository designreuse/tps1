<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 4/17/2016
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>


<div id="room" >
    <form class="form-horizontal" method="post" action="<c:choose><c:when test="${base!=null}">room/update</c:when><c:otherwise>amenity/room/update</c:otherwise></c:choose> " id="form1">

        <input type="hidden" name="hotelDetailId"
               value="<c:choose><c:when test="${sessionScope.hotelDetailId != null}">${sessionScope.hotelDetailId}</c:when><c:otherwise>${hotelDetailMap.hotelDetailId}</c:otherwise></c:choose>">

        <input type="hidden" name="step"
               value="4">

        <c:set var="parentId" value="0"/>
        <c:forEach var="roomAmenity" items="${roomAmenityList}" varStatus="count">
        <c:choose>
        <c:when test="${roomAmenity.parentAmenityId ne parentId && count.count==1}">
        <c:set var="parentId" value="${roomAmenity.parentAmenityId}"/>
        <div class="form-group"><label class="col-sm-2 control-label">${roomAmenity.parentAmenityDesc} <br>
        </label>

            <div class="col-sm-10">
                <div class="col-sm-6">
                    <input type="hidden" name="roomAmenityModels[${count.index}].roomAmenityId" value="${roomAmenity.roomAmenityId}" >
                    <input type="hidden" name="roomAmenityModels[${count.index}].amenityId" value="${roomAmenity.amenityId}">
                    <div class="col-sm-6"><label>
                        <input type="checkbox" value="${roomAmenity.amenityId}" class="amenity" name="roomAmenityModels[${count.index}].active" id="roomAmenity${count.count}" <c:if test="${roomAmenity.active=='Y'}"> checked </c:if>> ${roomAmenity.amenityDesc} </label></div>
                    <div class="col-sm-6">
                        <select class="select-multiple room" multiple="multiple" name="roomAmenityModels[${count.index}].roomDetailIds" id="roomDetail${count.count}">
                            <c:forEach var="roomDetail" items="${roomDetailList}">
                                <option value="${roomDetail.roomDetailId}" <c:if test="${fn:contains(roomAmenity.roomDetailId,roomDetail.roomDetailId )}"> selected </c:if> >${roomDetail.customName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                </c:when>
                <c:when test="${roomAmenity.parentAmenityId ne parentId && count.count>1}">
                <c:set var="parentId" value="${roomAmenity.parentAmenityId}"/>
            </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div class="form-group"><label class="col-sm-2 control-label">${roomAmenity.parentAmenityDesc} <br>
        </label>

            <div class="col-sm-10">
                <div class="col-sm-6">
                    <input type="hidden" name="roomAmenityModels[${count.index}].roomAmenityId" value="${roomAmenity.roomAmenityId}">
                    <input type="hidden" name="roomAmenityModels[${count.index}].amenityId" value="${roomAmenity.amenityId}">
                    <div class="col-sm-6"><label> <input type="checkbox" value="${roomAmenity.amenityId}" class="amenity" name="roomAmenityModels[${count.index}].active" id="roomAmenity${count.count}" <c:if test="${roomAmenity.active=='Y'}"> checked </c:if>> ${roomAmenity.amenityDesc} </label></div>
                    <div class="col-sm-6">
                        <select class="select-multiple room" multiple="multiple" name="roomAmenityModels[${count.index}].roomDetailIds" id="roomDetail${count.count}">
                            <c:forEach var="roomDetail" items="${roomDetailList}" >
                                <option value="${roomDetail.roomDetailId}" <c:if test="${fn:contains(roomAmenity.roomDetailId,roomDetail.roomDetailId )}"> selected </c:if> >${roomDetail.customName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                </c:when>
                <c:otherwise>

                    <div class="col-sm-6">
                        <input type="hidden" name="roomAmenityModels[${count.index}].roomAmenityId" value="${roomAmenity.roomAmenityId}">
                        <input type="hidden" name="roomAmenityModels[${count.index}].amenityId" value="${roomAmenity.amenityId}">
                        <div class="col-sm-6"><label> <input type="checkbox" value="${roomAmenity.amenityId}" class="amenity" name="roomAmenityModels[${count.index}].active" id="roomAmenity${count.count}" <c:if test="${roomAmenity.active=='Y'}">checked</c:if> > ${roomAmenity.amenityDesc} </label></div>
                        <div class="col-sm-6">
                            <select class="select-multiple room" multiple="multiple" name="roomAmenityModels[${count.index}].roomDetailIds" id="roomDetail${count.count}">
                                <c:forEach var="roomDetail" items="${roomDetailList}">
                                    <option value="${roomDetail.roomDetailId}" <c:if test="${fn:contains(roomAmenity.roomDetailId,roomDetail.roomDetailId )}"> selected </c:if> >${roomDetail.customName}</option>
                                </c:forEach>

                            </select>
                        </div>
                    </div>

                </c:otherwise>
                </c:choose>


                </c:forEach>
            </div>
        </div>



        <div class="hr-line-dashed"></div>


        <div class="form-group">
            <div class="col-sm-4 col-sm-offset-2">
                <%--<button type="reset" class="btn btn-white">Reset</button>--%>
                <button type="submit" class="btn btn-primary">Update</button>
            </div>
        </div>
    </form>
</div>


    <%@include file="/WEB-INF/includes/script.jsp"%>

    <%--Room Amenity--%>
    <script type="text/javascript">
        $(function () {

            $('#form1').validate({
                ignore: ':hidden:not(".room")',
                errorPlacement: function( label, element ) {
                    element.parent().append( label );
                    /*if( element.attr( "name" ) === "roomAmenityModels[].roomDetailIds" || element.attr( "name" ) === "event_services[]" ) {
                        element.parent().append( label ); // this would append the label after all your checkboxes/labels (so the error-label will be the last element in <div class="controls"> )
                    } else {
                        label.insertAfter( element ); // standard behaviour
                    }*/
                }
            });

            $("[id^='roomAmenity']").each(function (element) {

                $(this).rules("add", {

                    required :function(element){
                        var roomDetailId = $(element).parent().parent().next('div').children().val();
                        if(roomDetailId != null){
                            return true;
                        }else{
                            return false;
                        }
                    }
                });
            });

            $("[id^='roomDetail']").each(function (element) {
                console.log($("[id^='roomDetail']"));
                $(this).rules("add", {

                    required :function(element){
                        var amenityId = $(element).parent().prev('div').children().children();
                        if($(amenityId).is(":checked")){
                            return true;
                        }else{
                            return false;
                        }
                    }
                });
            });
        });

        var listsize = "${fn:length(roomDetailList)}";
        $(document).ready(function () {
            if (listsize > 1) {
                console.log("ganga");
                $('.select-multiple').multiselect({

                    includeSelectAllOption: true,
                    numberDisplayed: 1,
                    maxHeight: 200
                });
            } else {
                $('.select-multiple').multiselect({
                    maxHeight: 200
                });
            }

            $(".amenity").each(function (element) {
                if ($(this).is(':checked')) {
                    $(this).parent().parent().next().children().attr('required', true);
                }
            });


        });

    </script>
