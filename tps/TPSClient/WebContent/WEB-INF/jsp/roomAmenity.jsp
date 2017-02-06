<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 4/17/2016
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<c:if test="${base!=null}">
    <div id="wrapper">
    <%@include file="/WEB-INF/includes/leftNavigation.jsp"%>
    <div id="page-wrapper" class="gray-bg">
    <%@include file="/WEB-INF/includes/topNavigation.jsp"%>
    <div class="wrapper wrapper-content animated fadeIn">

    <div class="p-w-md m-t-sm">
    <div class="row">


    <%--<div class="col-sm-12">
        <div class="col-sm-3">
            <select name="amenityOf" class="form-control m-b" id="amenityType">
                <option value="room">room</option>
                <option value="hotel">hotel</option>

               &lt;%&ndash; <c:forEach items="${roomDetailList}" var="roomDetail">
                    <option <c:if test="${hotelDetailMap.starRating=='2'}"> selected </c:if> value="${roomDetail.roomDetailId}">${roomDetail.customName}</option>
                </c:forEach>&ndash;%&gt;
            </select>
        </div>
    </div>--%>
</c:if>


<div id="room" >
    <form class="form-horizontal" method="post" action="<c:choose><c:when test="${base!=null}">room/update</c:when><c:otherwise>amenity/room/update</c:otherwise></c:choose> ">

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
                    <input type="hidden" name="roomAmenityModels[${count.index}].roomAmenityId" value="${roomAmenity.roomAmenityId}">
                    <input type="hidden" name="roomAmenityModels[${count.index}].amenityId" value="${roomAmenity.amenityId}">
                    <div class="col-sm-6"><label>
                        <input type="checkbox" value="${roomAmenity.amenityId}" class="amenity" name="roomAmenityModels[${count.index}].active" id="roomAmenity${count.count}" <c:if test="${roomAmenity.active=='Y'}"> checked </c:if>> ${roomAmenity.amenityDesc} </label></div>
                    <div class="col-sm-6">
                        <select class="select-multiple room" multiple="multiple" name="roomAmenityModels[${count.index}].roomDetailIds" >
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
                        <select class="select-multiple room" multiple="multiple" name="roomAmenityModels[${count.index}].roomDetailIds" >
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
                            <select class="select-multiple room" multiple="multiple" name="roomAmenityModels[${count.index}].roomDetailIds" >
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
                <button type="submit" class="btn btn-primary">Continue</button>
            </div>
        </div>
    </form>
</div>
<%--<div id="hotel" style="display: none;">
    <form class="form-horizontal" method="post" action="hotel/update ">
        <input type="hidden" name="hotelDetailId"
               value="${sessionScope.hotelDetailId}">

        <c:set var="parentId" value="0"/>
        <c:forEach var="hotelActivity" items="${hotelActivityList}" varStatus="count">
        <c:choose>
        <c:when test="${hotelActivity.parentActivityId ne parentId && count.count==1}">
        <c:set var="parentId" value="${hotelActivity.parentActivityId}"/>
        <div class="form-group"><label class="col-sm-2 control-label">${hotelActivity.parentActivityDesc} <br>
        </label>

            <div class="col-sm-10">
                <div class="col-sm-6">
                    <input type="hidden" name="hotelActivityId" value="${hotelActivity.hotelActivityId}">
                    <input type="hidden" name="activityId" value="${hotelActivity.activityId}">
                    <div class="col-sm-6"><label> <input type="checkbox" value="${hotelActivity.activityId}" id="checkbox-${count.count}" name="active" <c:if test="${hotelActivity.active=='Y'}"> checked </c:if>> ${hotelActivity.activityDesc} </label></div>

                    <div class="col-sm-6" id="select-${count.count}" <c:if test="${hotelActivity.type=='N'  || hotelActivity.active == 'N'}"> style="display: none" </c:if> >
                            &lt;%&ndash;<span class="chargeOption">${hotelActivity.chargeOption}</span>&ndash;%&gt;
                        <select name="type" class="form-control m-b" <c:if test="${hotelActivity.chargeOption=='N'}">style="display: none"</c:if> <c:if test="${hotelActivity.chargeOption!='N'}">required</c:if>>
                            <option value="">Select</option>
                            <option <c:if test="${hotelActivity.type=='F'}"> selected </c:if>  value="F">Free</option>
                            <option <c:if test="${hotelActivity.type=='P'}"> selected </c:if>  value="P">Paid</option>
                        </select>
                    </div>

                </div>



                </c:when>
                <c:when test="${hotelActivity.parentActivityId ne parentId && count.count>1}">
                <c:set var="parentId" value="${hotelActivity.parentActivityId}"/>
            </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div class="form-group"><label class="col-sm-2 control-label">${hotelActivity.parentActivityDesc} <br>
        </label>

            <div class="col-sm-10">
                <div class="col-sm-6">
                    <input type="hidden" name="hotelActivityId" value="${hotelActivity.hotelActivityId}">
                    <input type="hidden" name="activityId" value="${hotelActivity.activityId}">
                    <div class="col-sm-6"><label> <input type="checkbox" value="${hotelActivity.activityId}" id="checkbox-${count.count}" name="active" <c:if test="${hotelActivity.active=='Y'}"> checked </c:if>> ${hotelActivity.activityDesc} </label></div>
                    <div class="col-sm-6" id="select-${count.count}" <c:if test="${hotelActivity.type=='N' || hotelActivity.active == 'N'}"> style="display: none" </c:if> >
                            &lt;%&ndash;<span class="chargeOption">${hotelActivity.chargeOption}</span>&ndash;%&gt;
                        <select name="type" class="form-control m-b" <c:if test="${hotelActivity.chargeOption=='N'}">style="display: none" </c:if> <c:if test="${hotelActivity.chargeOption!='N'}">required</c:if>>
                            <option value="">Select</option>
                            <option <c:if test="${hotelActivity.type=='F'}"> selected </c:if>  value="F">Free</option>
                            <option <c:if test="${hotelActivity.type=='P'}"> selected </c:if>  value="P">Paid</option>
                        </select>
                    </div>
                </div>


                </c:when>
                <c:otherwise>

                    <div class="col-sm-6">
                        <input type="hidden" name="hotelActivityId" value="${hotelActivity.hotelActivityId}">
                        <input type="hidden" name="activityId" value="${hotelActivity.activityId}">
                        <div class="col-sm-6"><label> <input type="checkbox" value="${hotelActivity.activityId}" id="checkbox-${count.count}" name="active" <c:if test="${hotelActivity.active=='Y'}">checked</c:if> > ${hotelActivity.activityDesc} </label></div>
                        <div class="col-sm-6" id="select-${count.count}" <c:if test="${hotelActivity.type=='N' || hotelActivity.active == 'N'}"> style="display: none" </c:if> >
                                &lt;%&ndash;<span class="chargeOption">${hotelActivity.chargeOption}</span>&ndash;%&gt;
                            <select name="type" class="form-control m-b" <c:if test="${hotelActivity.chargeOption=='N'}">style="display: none" </c:if> <c:if test="${hotelActivity.chargeOption!='N'}">required</c:if>>
                                <option value="">Select</option>
                                <option <c:if test="${hotelActivity.type=='F'}"> selected </c:if>  value="F">Free</option>
                                <option <c:if test="${hotelActivity.type=='P'}"> selected </c:if>  value="P">Paid</option>
                            </select>
                        </div>
                    </div>

                </c:otherwise>
                </c:choose>


                </c:forEach>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-4 col-sm-offset-2">
                &lt;%&ndash;<button type="reset" class="btn btn-white">Reset</button>&ndash;%&gt;
                <button type="submit" class="btn btn-primary">Update</button>
            </div>
        </div>
    </form>
</div>--%>


<c:if test="${base!=null}">
    </div>
    </div>
    </div>
    </div>
    </div>
    <%@include file="/WEB-INF/includes/script.jsp"%>

    <%--Room Amenity--%>
    <script type="text/javascript">
        /*if('${room}'== 'true'){
            $("#amenityType").val("room");
            $("#hotel").hide();
            $("#room").show();
        }

        $("#amenityType").change(function(){
            if($(this).val()=='room'){
                $("#hotel").hide();
                $("#room").show();
            }else if($(this).val()=='hotel'){
                $("#hotel").show();
                $("#room").hide();
            }

        });*/


        var listsize = "${fn:length(roomDetailList)}";
        $(document).ready(function () {
            if (listsize > 1) {
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

      /*  $("[id^='checkbox-']").each(function (element) {

            /!*if($(element).is(":checked"))
             alert("test");
             //            alert($(this).next().attr("id"));
             else
             $(".answer").hide();*!/
//        var chargeOption = $(this).parent().parent().next().find('span').text();
            if ($(this).is(":checked")) {
                $(this).parent().parent().next().show();
                $(this).parent().parent().next().find('input, select').prop('disabled', false);
            } else {
                $(this).parent().parent().next().hide();
                $(this).parent().parent().next().find('input, select').prop('disabled', true);
            }

            $(this).click(function () {
//            var chargeOption = $(this).parent().parent().next().find('span').text();
                if ($(this).is(":checked")) {
                    $(this).parent().parent().next().show();
                    $(this).parent().parent().next().find('input, select').prop('disabled', false);
//                $(".answer").show(300);
                } else {
                    $(this).parent().parent().next().hide();
                    $(this).parent().parent().next().find('input, select').prop('disabled', true);
                }
            });
        });*/
    </script>

</c:if>
</body>
</html>