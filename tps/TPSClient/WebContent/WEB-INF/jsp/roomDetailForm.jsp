<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 4/17/2016
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>

<c:if test="${roomDetailMap == null}">
    <%--<c:set var="totalAllocateRooms" value="0"/>--%>

    <table class="table">
        <thead>
        <tr>
            <th>Room Description</th>
            <th>Allocate Number</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${roomDetailList}" var="roomDetail">
            <%--<c:set var="totalAllocateRooms" value="${roomDetail.roomsProvided + totalAllocateRooms}"/>--%>
            <tr>
                <td>${roomDetail.customName}</td>
                <td>${roomDetail.roomsProvided}</td>
                <td>
                    <a href="<c:choose><c:when test="${base!=null}">edit/${roomDetail.roomDetailId}</c:when><c:otherwise>roomDetail/edit/${roomDetail.roomDetailId}</c:otherwise></c:choose>">Edit</a>
                    <a href="<c:choose><c:when test="${base!=null}">delete/${roomDetail.roomDetailId}</c:when><c:otherwise>roomDetail/delete/${roomDetail.roomDetailId}</c:otherwise></c:choose>">
                        Detele</a></td>
            </tr>
        </c:forEach>

        </tbody>
        <c:if test="${totalAllocateRooms < hotelDetailMap.totalRoom || availRoom>0}">

            <tfoot>
            <tr>
                <td colspan="3"><a
                        href="<c:choose><c:when test="${base!=null}">addRoom</c:when><c:otherwise>roomDetail/addRoom</c:otherwise></c:choose> ">Add
                    Another Room</a></td>
            </tr>
            </tfoot>
        </c:if>

    </table>

</c:if>

<c:if test="${roomDetailMap != null}">
    <c:if test="${totalAllocateRooms < hotelDetailMap.totalRoom || availRoom>0}">
        <a href="${pageContext.request.contextPath}/roomDetail/addRoom">Add Another Room</a>
    </c:if>

    <%--<c:out value="${roomDetailMap}"/>--%>
    <form class="form-horizontal" method="post"
          action="<c:choose><c:when test="${base!=null}">update</c:when><c:otherwise>roomDetail/update</c:otherwise></c:choose>"
          id="form1">
        <input type="hidden" name="step"
               value="3">
        <input type="hidden" name="hotelDetailId"
               value="${sessionScope.hotelDetailId}">
        <input type="hidden" name="roomDetailId"
               value="${roomDetailMap.roomDetailId}">
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>Rooms Info</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-wrench"></i>
                        </a>

                    </div>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <div class="form-group col-sm-6"><label class="col-sm-4 control-label">Room Type</label>

                            <div class="col-sm-6"><select name="parentRoomType" class="form-control m-b"
                                                          id="parentRoomType" required>
                                <option value="">Select</option>
                                <c:forEach var="parentRoomType" items="${parentRoomTypeList}">
                                    <option value="${parentRoomType.roomTypeId}"
                                            <c:if test="${parentRoomType.roomTypeId== roomDetailMap.parentRoomTypeId}"> selected </c:if>
                                    >${parentRoomType.roomTypeDesc}</option>
                                </c:forEach>

                            </select></div>
                        </div>
                        <div class="form-group col-sm-6"><label class="col-sm-4 control-label">Room Name</label>
                            <div class="col-sm-6"><select name="roomTypeId" class="form-control m-b" required
                                                          id="roomTypeId">
                                <option value="">Select</option>
                                    <%-- <c:forEach var="roomType" items="${roomTypeList}">
                                         <option value="${roomType.roomTypeId}"
                                                 <c:if test="${roomType.roomTypeId==roomDetailMap.roomTypeId}"> selected </c:if>
                                         >${roomType.roomTypeDesc}</option>
                                     </c:forEach>--%>

                            </select></div>
                        </div>
                        <div class="form-group col-sm-6"><label class="col-sm-4 control-label">Custom Name</label>
                            <div class="col-sm-6"><input type="text" class="form-control"
                                                         placeholder="Custom Name" name="customName"
                                                         value="${roomDetailMap.customName}"></div>
                        </div>
                        <div class="form-group col-sm-6"><label class="col-sm-4 control-label">Number of Room</label>
                            <div class="col-sm-6">

                                <c:set var="roomAvail" value="${roomDetailMap.roomsProvided+availRoom}"/>

                                <select name="roomsProvided" class="form-control m-b" required>
                                    <c:forEach begin="1" end="${roomAvail}" var="i">
                                        <option value="${i}">${i}</option>
                                    </c:forEach>
                                </select>

                            </div>
                        </div>
                        <div class="form-group col-sm-6"><label class="col-sm-4 control-label">Room Dimension</label>
                            <div class="col-sm-6">
                                <div class="input-group">
                                    <input type="text" class="form-control"
                                           placeholder="Room Dimension" name="roomDimension"
                                           value="${roomDetailMap.roomDimension}" required>
                                    <span class="input-group-addon" id="basic-addon2">m<sup>2</sup></span>
                                </div>

                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>Bed Option</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>


                    </div>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <div class="form-group col-sm-12"><label class="col-sm-2 control-label">Bed Type</label>

                            <div class="col-sm-3">
                                <select name="bedTypeId" class="form-control m-b" id="bedType" required>
                                    <option value="">Select</option>
                                    <c:forEach var="bedType" items="${bedTypeList}">
                                        <option value="${bedType.bedTypeId}" <c:if
                                                test="${bedType.bedTypeId== roomDetailMap.bedTypeId}"> selected </c:if> >${bedType.bedTypeDesc}</option>
                                    </c:forEach>
                                </select></div>

                            <div class="col-sm-3"><input type="text" class="form-control"
                                                         placeholder="Number of Bed" name="noOfBed" id="noOfBed"
                                                         value="${roomDetailMap.noOfBed}" required></div>
                        </div>

                        <div class="form-group col-sm-6"><label class="col-sm-4 control-label">No of Person</label>
                            <div class="col-sm-6"><input type="text" class="form-control" id="noOfGuest"
                                                         placeholder="Number of Guest" name="noOfGuest"
                                                         value="${roomDetailMap.noOfGuest}" required></div>
                        </div>
                    </div>


                </div>
            </div>
        </div>
        <c:forEach items="${currencyList}" var="currency">
                <input type="hidden" class="form-control"
                      name="currencyId" value="${currency.currencyId}" required>
        </c:forEach>
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>Extra Bed</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>


                    </div>
                </div>
                <div class="ibox-content">
                    <div class="row">

                        <div class="col-sm-12">
                            <div class="form-group col-sm-4"><label class="col-sm-4 control-label">Extra Bed</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control"
                                           placeholder="Extra Bed" name="extraAdult"
                                           value="${roomDetailMap.extraAdult}" required>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12">

                            <div class="form-group col-sm-12"><label class="col-sm-1 control-label">Rate<br>
                                <small class="text-navy">per bed</small>
                            </label>
                                <c:forEach items="${currencyList}" var="currency">
                                    <div class="col-sm-2">
                                        <small class="text-navy">${currency.currencyDesc}</small>
                                        <input type="text" class="form-control"
                                               placeholder="Adult Rate" name="adultRate"
                                        <c:forEach items="${roomRateList}" var="roomRate">
                                        <c:if test="${currency.currencyId == roomRate.currencyId}"> value="${roomRate.adultRate}"</c:if>
                                        </c:forEach>
                                               required></div>
                                </c:forEach>

                            </div>


                        </div>
                        <div class="col-sm-12">
                            <div class="form-group col-sm-4"><label class="col-sm-4 control-label">Extra Child</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control"
                                           placeholder="Extra Child" name="extraChild"
                                           value="${roomDetailMap.extraChild}" required>
                                </div>
                            </div>


                        </div>
                        <div class="col-sm-12">

                            <div class="form-group col-sm-12"><label class="col-sm-1 control-label">Rate<br>
                                <small class="text-navy">per child</small>
                            </label>
                                <c:forEach items="${currencyList}" var="currency">
                                    <div class="col-sm-2">
                                        <small class="text-navy">${currency.currencyDesc}</small>
                                        <input type="text" class="form-control"
                                               placeholder="Child Rate" name="childRate"
                                        <c:forEach items="${roomRateList}" var="roomRate">
                                        <c:if test="${currency.currencyId == roomRate.currencyId}"> value="${roomRate.childRate}"</c:if>
                                        </c:forEach>
                                              required></div>
                                </c:forEach>

                            </div>


                        </div>
                        <div class="col-sm-12">
                            <div class="form-group col-sm-4"><label class="col-sm-4 control-label">Max. Child
                                Age</label>
                                <div class="col-sm-6">
                                    <select name="childAgeMax" class="form-control m-b" required>
                                        <option value="">Select</option>
                                        <c:forEach var="age" begin="1" end="15">
                                            <option value="${age}"
                                                    <c:if test="${roomDetailMap.childAgeMax==age}">selected</c:if>>${age}</option>
                                        </c:forEach>
                                    </select></div>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>Rate</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-wrench"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <div class="col-sm-12">

                            <div class="form-group col-sm-12"><label class="col-sm-1 control-label">Rate<br>
                                <small class="text-navy">Rate for <span class="guestNo"></span> person per night</small>
                            </label>
                                <c:forEach items="${currencyList}" var="currency">
                                    <div class="col-sm-2">
                                        <small class="text-navy">${currency.currencyDesc}</small>
                                        <input type="text" class="form-control"
                                               placeholder="Rate" name="rate"
                                               <c:forEach items="${roomRateList}" var="roomRate">
                                            <c:if test="${currency.currencyId == roomRate.currencyId}"> value="${roomRate.rate}"</c:if>
                                               </c:forEach>
                                                required></div>
                                </c:forEach>

                            </div>


                        </div>
                        <%--<div class="form-group col-sm-6"><label class="col-sm-4 control-label">Rate<br>
                            <small class="text-navy">Rate for <span class="guestNo"></span> person per night</small>
                        </label>

                            <div class="col-sm-6"><input type="text" class="form-control"
                                                         placeholder="Rate" name="rate"
                                                         value="${roomDetailMap.rate}" required></div>

                        </div>--%>
                    </div>


                        <%-- <div class="form-group col-sm-12"><label class="col-sm-2 control-label">Discount</label>
                             <div class="col-sm-8">
                                 <span><label> <input type="radio" name="discountFlag"
                                 <c:if test="${roomDetailMap.discount!= null}"> checked </c:if> value="Y" required>
                                     Yes</label></span>
                                 <span><label> <input type="radio" name="discountFlag"
                                 <c:if test="${roomDetailMap.discount== null}"> checked </c:if> value="N" required> No
                                 </label></span>
                             </div>
                         </div>

                         <div style="display: none" id="discount-option" class="form-group col-sm-12">
                             <div class="form-group col-sm-12"><label
                                     class="col-sm-2 control-label">Rate
                             </label>
                                 <div class="col-sm-4"><input type="text" class="form-control"
                                                              placeholder="Discount" name="discount"
                                                              value="${roomDetailMap.discount}" required></div>
                                 <div class="col-sm-4">
                                     <select name="discountType" class="form-control m-b">
                                         <option value="P">Percent (%)</option>
                                         <option value="F">Flat</option>
                                     </select>
                                 </div>


                             </div>
                             <div class="form-group"><label class="col-sm-2 control-label">Minimum Number of Person</label>
                                 <div class="col-sm-4"><input type="text" class="form-control"
                                                              placeholder="Min Number of Guest" name="MinNoOfGuest"
                                                              value="${roomDetailMap.minNoOfGuest}" required></div>
                             </div>
                         </div>
     --%>

                </div>

            </div>


        </div>

        <div class="hr-line-dashed"></div>

        <div class="form-group col-sm-6">
            <div class="col-sm-4 col-sm-offset-2">
                    <%--<button type="reset" class="btn btn-white">Reset</button>--%>
                <button type="submit" class="btn btn-primary">Update</button>
            </div>
        </div>
    </form>
</c:if>


<%@include file="/WEB-INF/includes/script.jsp" %>
<%--<script src="${pageContext.request.contextPath}/js/plugins/clockpicker/clockpicker.js"></script>--%>
<script type="text/javascript">

    $(function () {
        $('#form1').validate({
            rules: {
                parentRoomType: {
                    required: true
                },
                roomTypeId: {
                    required: true
                },
                roomsProvided: {
                    required: true
                },
                roomDimension: {
                    required: true
                },
                extraAdult: {
                    required: true
                },
                extraChild: {
                    required: true
                },
                bedTypeId: {
                    required: true
                },
                noOfBed: {
                    required: true,
                    number: true,
                    min: 1
                },
                noOfGuest: {
                    required: true,
                    min: 1
                },
                rate: {
                    required: true
                },
                discount: {
                    required: true
                }, discountType: {
                    required: true
                },
                MinNoOfGuest: {
                    required: true
                }

            }
        });
    });

    function subRoomType() {
        var parentRoomType = $("#parentRoomType").val();
//            alert(parentRoomType);

        var roomType = "";
        <c:forEach var="roomType" items="${roomTypeList}">
        if ("${roomType.parentRoomTypeId}" == parentRoomType) {
            <%--alert("room"+"${roomType.parentRoomTypeId}");--%>
            roomType = roomType + '<option class="appendOption" value="${roomType.roomTypeId}"<c:if test="${roomType.roomTypeId==roomDetailMap.roomTypeId}"> selected </c:if>>${roomType.roomTypeDesc}</option>';
        }
        </c:forEach>
        $("#roomTypeId").find('.appendOption').remove();
        $("#roomTypeId").append(roomType);
    }

    subRoomType();

    $("#parentRoomType").change(function () {
        subRoomType();
    });

    $('#bedType').change(function () {
        var bedTypeId = $(this).val();
        var bedCapacity = 1;

        if ($('#bedTypeId').val() != "") {
            <c:forEach var="bedType" items="${bedTypeList}">
            if (bedTypeId == '${bedType.bedTypeId}') {
                bedCapacity = "${bedType.capacity}";
            }
            </c:forEach>
        }

        if ($('#noOfBed').val() == "") {
            $("#noOfGuest").val(bedCapacity * 1);
            $(".guestNo").text($("#noOfGuest").val());
        } else {
            var noOfBed = $('#noOfBed').val();
            $("#noOfGuest").val(bedCapacity * noOfBed);
            $(".guestNo").text($("#noOfGuest").val());
        }
    });

    $('#noOfBed').change(function () {
        var noOfBed = $(this).val();
        var bedTypeId = $('#bedType').val();
        var bedCapacity = 1;

        if ($('#bedTypeId').val() != "") {
            <c:forEach var="bedType" items="${bedTypeList}">
            if (bedTypeId == '${bedType.bedTypeId}') {
                bedCapacity = "${bedType.capacity}";
            }
            </c:forEach>
        }


        if ($('#noOfBed').val() == "") {
            $("#noOfGuest").val(bedCapacity * 1);
            $(".guestNo").text($("#noOfGuest").val());
        } else {
            var noOfBed = $('#noOfBed').val();
            $("#noOfGuest").val(bedCapacity * noOfBed);
            $(".guestNo").text($("#noOfGuest").val());
        }
    });

    if ($("#noOfGuest").val() == '') {
        $("#noOfGuest").val(1);
    }

    $(".guestNo").text($("#noOfGuest").val());

    $("#noOfGuest").change(function () {
        $(".guestNo").text($("#noOfGuest").val());
    });

    //    alert($('input[name=discountFlag]:checked').val());

    if ($('input[name=discountFlag]:checked').val() != 'Y') {
        $('#discount-option').find('input, select').prop('disabled', true);
        $('#discount-option').hide();
    } else {
        $('#discount-option').find('input, select').prop('disabled', false);
        $('#discount-option').show();
    }

    $("input[name='discountFlag']").click(function () {
        if ($(this).val() == 'Y') {
            $('#discount-option').show();
            $('#discount-option').find('input, select').prop('disabled', false);
        } else {
            $('#discount-option').hide();
            $('#discount-option').find('input, select').prop('disabled', true);
        }

    });


</script>



