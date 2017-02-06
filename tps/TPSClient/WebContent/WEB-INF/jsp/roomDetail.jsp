<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 4/17/2016
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--<c:choose>
    <c:when test="${fn:length(roomDetailList) gt 0}"
</c:choose>
<c:set var="totalAllocateRooms" value="0"/>
<c:forEach items="${roomDetailList}" var="roomDetail">
    <c:set var="totalAllocateRooms" value="${roomDetail.roomsProvided+totalAllocateRooms}"/>
</c:forEach>--%>
<%@include file="/WEB-INF/includes/header.jsp" %>
<c:if test="${base!=null}">
    <div id="wrapper">
    <%@include file="/WEB-INF/includes/leftNavigation.jsp" %>
    <div id="page-wrapper" class="gray-bg">
    <%@include file="/WEB-INF/includes/topNavigation.jsp" %>
    <div class="wrapper wrapper-content animated fadeIn">

    <div class="p-w-md m-t-sm">
    <div class="row">
</c:if>
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
        <a href="roomDetail/addRoom">Add Another Room</a>
    </c:if>
    <form class="form-horizontal" method="post" action="<c:choose><c:when test="${base!=null}">update</c:when><c:otherwise>roomDetail/update</c:otherwise></c:choose>">
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

                           <%-- <c:choose>
                                <c:when test="${roomDetailMap.roomsProvided ne null && totalAllocateRooms < hotelDetailMap.totalRoom}">
                                    <c:set var="roomAvail"
                                           value="${roomDetailMap.roomsProvided+(hotelDetailMap.totalRoom-totalAllocateRooms)}"/>
                                </c:when>
                                <c:when test="${roomDetailMap.roomsProvided ne null && totalAllocateRooms >= hotelDetailMap.totalRoom}">
                                    <c:set var="roomAvail"
                                           value="${roomDetailMap.roomsProvided+(hotelDetailMap.totalRoom-totalAllocateRooms)}"/>
                                </c:when><c:otherwise>
                                <c:set var="roomAvail" value="${hotelDetailMap.totalRoom-totalAllocateRooms}"/>
                            </c:otherwise></c:choose>--%>

                            <c:set var="roomAvail" value="${roomDetailMap.roomsProvided+availRoom}"/>

                            <select name="roomsProvided" class="form-control m-b" required>
                                <c:forEach begin="1" end="${roomAvail}" var="i">
                                    <option value="${i}">${i}</option>
                                </c:forEach>
                            </select>

                            <%--<input type="text" class="form-control"
                                   placeholder="No of Room" name="roomsProvided"
                                   value="${roomDetailMap.roomsProvided}" required>--%>
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

                    <div class="form-group col-sm-6"><label class="col-sm-4 control-label">Extra Adult</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control"
                                   placeholder="Extra Adult" name="extraAdult"
                                   value="${roomDetailMap.extraAdult}" required>


                        </div>
                    </div>

                    <div class="form-group col-sm-6"><label class="col-sm-4 control-label">Extra Child</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control"
                                   placeholder="Extra Child" name="extraChild"
                                   value="${roomDetailMap.extraChild}" required>


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
                            <%--<ul class="dropdown-menu dropdown-user">
                                <li><a href="#">Config option 1</a>
                                </li>
                                <li><a href="#">Config option 2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>--%>
                    </div>
                </div>
                <div class="ibox-content">

                    <div class="form-group col-sm-6"><label class="col-sm-4 control-label">Rate<br>
                        <small class="text-navy">Rate for <span class="guestNo"></span> person per night</small>
                    </label>

                        <div class="col-sm-6"><input type="text" class="form-control"
                                                     placeholder="Rate" name="rate"
                                                     value="${roomDetailMap.rate}" required></div>

                    </div>


                    <div class="form-group col-sm-12"><label class="col-sm-2 control-label">Discount</label>
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


                </div>

            </div>


        </div>


            <%--<div class="hr-line-dashed"></div>--%>


        <div class="hr-line-dashed"></div>

        <div class="form-group col-sm-6">
            <div class="col-sm-4 col-sm-offset-2">
                    <%--<button type="reset" class="btn btn-white">Reset</button>--%>
                <button type="submit" class="btn btn-primary">Continue</button>
            </div>
        </div>
    </form>
</c:if>

<c:if test="${base!=null}">
    </div>
    </div>
    </div>
    </div>
    </div>
    <%@include file="/WEB-INF/includes/script.jsp" %>
    <script src="${pageContext.request.contextPath}/js/plugins/clockpicker/clockpicker.js"></script>
    <script type="text/javascript">
        var x = "${roomDetailMap.parentRoomTypeId}";
        var y = "${roomDetailMap}";
        alert(x);
  console.log("fh"+x);
  console.log("fh"+y);
        function subRoomType() {
            var parentRoomType = $("#parentRoomType").val();
            var roomType = "";
            <c:forEach var="roomType" items="${roomTypeList}">
            if ("${roomType.parentRoomTypeId}" == parentRoomType) {
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

</c:if>
</body>
</html>


