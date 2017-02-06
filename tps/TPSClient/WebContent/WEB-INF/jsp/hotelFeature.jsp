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
</c:if>
<form class="form-horizontal" method="post" action="<c:choose><c:when test="${base!=null}">update</c:when><c:otherwise>hotelFeature/update</c:otherwise></c:choose>" id="hotelFeatureForm">
    <input type="hidden" name="hotelDetailId"
           value="<c:choose><c:when test="${base!=null}">${hotelFeatureMap.hotelDetailId}</c:when><c:otherwise>${hotelDetailMap.hotelDetailId}</c:otherwise></c:choose>">
    <input type="hidden" name="hotelFeatureId"
           value="${hotelFeatureMap.hotelFeatureId}">

    <input type="hidden" name="step"
           value="2">

    <div class="form-group"><label class="col-sm-2 control-label">Check-in</label>
        <div class="col-sm-3"> <div data-autoclose="true" class="input-group clockpicker " >
            <input type="text" class="form-control" placeholder="From" name="checkInFrom"
                   value="${hotelFeatureMap.checkInFrom}" required>
                                <span class="input-group-addon">
                                    <span class="fa fa-clock-o"></span>
                                </span>
        </div></div>


        <div class="col-sm-3"><div data-autoclose="true" class="input-group clockpicker " >
            <input type="text" class="form-control" placeholder="To" name="checkInTo"
                   value="${hotelFeatureMap.checkInTo}" required>
                                <span class="input-group-addon">
                                    <span class="fa fa-clock-o"></span>
                                </span>
        </div></div>
    </div>
    <div class="hr-line-dashed"></div>

    <div class="form-group"><label class="col-sm-2 control-label">Check-out</label>

        <div class="col-sm-3"><div data-autoclose="true" class="input-group clockpicker" >
            <input type="text" class="form-control" placeholder="From" name="checkOutFrom"
                   value="${hotelFeatureMap.checkOutFrom}" required>
                                <span class="input-group-addon">
                                    <span class="fa fa-clock-o"></span>
                                </span>

        </div>

        </div>

        <div class="col-sm-3">
            <div data-autoclose="true" class="input-group clockpicker" >
                <input type="text" class="form-control" placeholder="To" name="checkOutTo"
                       value="${hotelFeatureMap.checkOutTo}" required>
                                <span class="input-group-addon">
                                    <span class="fa fa-clock-o"></span>
                                </span>
            </div>
        </div>
    </div>
    <div class="hr-line-dashed"></div>


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
                    <%--<span class="chargeOption">${hotelActivity.chargeOption}</span>--%>
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
                    <%--<span class="chargeOption">${hotelActivity.chargeOption}</span>--%>
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
                        <%--<span class="chargeOption">${hotelActivity.chargeOption}</span>--%>
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



    <div class="hr-line-dashed"></div>


    <div class="form-group">
        <div class="col-sm-4 col-sm-offset-2">
            <%--<button type="reset" class="btn btn-white">Reset</button>--%>
            <button type="submit" class="btn btn-primary">Continue</button>
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

    <%-- hotel Feature--%>
    <script type="text/javascript">


        $('.clockpicker').clockpicker();



        //    $( "[id^='select-']:hidden" ).find('input, select').prop('disabled',true);
        $("[id^='checkbox-']").each(function (element) {

            /*if($(element).is(":checked"))
             alert("test");
             //            alert($(this).next().attr("id"));
             else
             $(".answer").hide();*/
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
        });


    </script>

</c:if>

</body>
</html>