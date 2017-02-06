<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 5/13/2016
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/includes/header.jsp" %>

<div id="wrapper">
    <%@include file="/WEB-INF/includes/leftNavigation.jsp" %>
    <div id="page-wrapper" class="gray-bg">
        <%@include file="/WEB-INF/includes/topNav.jsp" %>
        <div class="wrapper wrapper-content animated fadeIn">
            <c:if test="${mode=='update'}">
                <form id="form1" class="form-horizontal" method="post" action="update">

                    <input type="hidden" name="offerId" value="${offerMap.offerId}">

                    <div class="form-group"><label class="col-sm-2 control-label">Type</label>

                        <div class="col-sm-3"> <input type="radio" name="type" value="offer" <c:if test="${offerMap.offerName != 'Last Minute Deal'}"> checked="" </c:if>>
                            <label>
                                Offer
                            </label>
                            <input type="radio" name="type" value="deal" <c:if test="${offerMap.offerName == 'Last Minute Deal'}"> checked="" </c:if> >
                            <label>
                                Last Minute Deal
                            </label></div>
                    </div>

                    <div class="form-group"><label class="col-sm-2 control-label">Room</label>

                        <div class="col-sm-3"><select class="form-control m-b" name="roomDetailId" required>
                            <option value="">Select</option>
                            <c:forEach items="${roomDetailList}" var="room">
                                <option value="${room.roomDetailId}"
                                        <c:if test="${offerMap.roomDetailId==room.roomDetailId}">selected</c:if> >
                                        ${room.customName}
                                </option>
                            </c:forEach>


                        </select></div>
                    </div>

                    <div class="form-group"><label class="col-sm-2 control-label">Offer Name</label>
                        <div class="col-sm-3"><input type="text" class="form-control"
                                                     placeholder="Offer Name" name="offerName" id="offerName"
                                                     value="${offerMap.offerName}" required></div>
                    </div>

                    <%--<div class="form-group" id="booking">
                        <label class="col-sm-2 control-label">Booking</label>
                        <div class="col-sm-3">
                            <div class="input-daterange input-group" id="datepickerBooking">
                                <input type="text" class="input-sm form-control" name="bookingFrom" value="${offerMap.bookingFrom}"/>
                                <span class="input-group-addon">to</span>
                                <input type="text" class="input-sm form-control" name="bookingTo" value="${offerMap.bookingTo}" />
                            </div>
                        </div>
                    </div>

                    <div class="form-group" id="effective">
                        <label class="col-sm-2 control-label">Effective</label>
                        <div class="col-sm-3">
                            <div class="input-daterange input-group" id="datepickerEffective">
                                <input type="text" class="input-sm form-control" name="effectiveFrom" value="${offerMap.effectiveFrom}"/>
                                <span class="input-group-addon">to</span>
                                <input type="text" class="input-sm form-control" name="effectiveTo" value="${offerMap.effectiveTo}" />
                            </div>
                        </div>

                    </div>--%>

                    <div class="form-group"><label class="col-sm-2 control-label">Effective</label>

                        <div class="col-sm-3">
                            <small class="text-navy">From</small>
                            <div class="input-group date" id="effectiveFrom">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input type="text" class="form-control"
                                                                                                            name="effectiveFrom"
                                                                                                            value="${offerMap.effectiveFrom}" required >
                            </div>
                        </div>

                        <div class="col-sm-3">
                            <small class="text-navy">To</small>
                            <div class="input-group date" id="effectiveTo">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input type="text" class="form-control"
                                                                                                            name="effectiveTo" id="inp-effectiveTo"
                                                                                                            value="${offerMap.effectiveTo}" required>
                            </div>
                        </div>
                    </div>
                    <div class="form-group"><label class="col-sm-2 control-label">Booking Period</label>
                        <div class="col-sm-3">
                            <small class="text-navy">From</small>
                            <div class="input-group date" id="bookingFrom">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input type="text" class="form-control"
                                                                                                            name="bookingFrom"
                                                                                                            value="${offerMap.bookingFrom}" required>
                            </div>
                        </div>

                        <div class="col-sm-3">
                            <small class="text-navy">To</small>
                            <div class="input-group date" id="bookingTo">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input type="text" class="form-control"
                                                                                                            name="bookingTo" id="inp-bookingTo"
                                                                                                            value="${offerMap.bookingTo}" required>
                            </div>
                        </div>
                    </div>
                    <div class="form-group"><label class="col-sm-2 control-label">Offer</label>

                        <div class="col-sm-3">

                            <div class="input-group">

                                <input type="text" class="form-control"
                                       name="offerAmount"
                                       value="${offerMap.offerAmount}" required>
                                <span class="input-group-btn">
                                    <%--<input type="radio" aria-label="Radio button for following text input">--%>
                                      <select type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" name="offerType">
                                          <option value="PERCENTAGE" <c:if test="${offerMap.offerType=='PERCENTAGE'}"> selected </c:if> >%</option>
                                          <option value="FLAT" <c:if test="${offerMap.offerType=='FLAT'}"> selected </c:if> >Flat</option>
                                      </select>
                                  </span>
                            </div>
                        </div>

                    </div>


                    <div class="form-group">
                        <div class="col-sm-4 col-sm-offset-2">
                            <button type="submit" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>


                </form>
            </c:if>
            <c:if test="${mode!='update'}">
                <div class="row add-btn">
                    <a href="add" class="btn btn-primary">Add</a>
                </div>
            </c:if>
            <table class="table table-striped table-bordered bootstrap-datatable datatable">
                <thead>
                <tr>
                    <th>S.N</th>
                    <th>Offer Name</th>
                    <th>Room</th>
                    <th>Booking From</th>
                    <th>Booking To</th>
                    <th>Effective From</th>
                    <th>Effective To</th>
                    <%--<th>Offer Type</th>--%>
                    <th>Offer Amount</th>
                    <th>Action</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${offerList}" var="offer" varStatus="count">
                    <tr>
                        <td>${count.count}</td>
                        <td>${offer.offerName}</td>
                        <td>${offer.roomName}</td>
                        <td>${offer.bookingFrom}</td>
                        <td>${offer.bookingTo}</td>
                        <td>${offer.effectiveFrom}</td>
                        <td>${offer.effectiveTo}</td>
                            <%--<td>${offer.effectiveOfferType}</td>--%>
                        <td><c:if test="${offer.offerType=='FLAT'}">Rs.</c:if> ${offer.offerAmount}<c:if
                                test="${offer.offerType=='PERCENTAGE'}">%</c:if></td>
                        <td class="center">

                            <a class="btn btn-info" href="edit/${offer.offerId}" title="Edit"
                               data-rel="tooltip">
                                <i class="fa fa-edit"></i>
                            </a>

                            <a class="open btn btn-danger" title="Delete" data-toggle="modal"
                               data-target="#myModal_del"
                               data-id="${offer.offerId}" data-rel="tooltip">
                                <i class="fa fa-trash"></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>
<%@include file="/WEB-INF/includes/script.jsp" %>
<script src="${pageContext.request.contextPath}/js/preview.js"></script>

<script type="text/javascript">

    $(function () {
        jQuery.validator.addMethod("alphaNumeric", function (value, element) {
            // return true - means the field passed validation
            // return false - means the field failed validation and it triggers the error
            return this.optional(element) || /^([\w\s]+)$/.test(value);
        }, "Only alphanumeric value and underscore is allowed!");


        $('#form1').validate({
            rules: {
                roomDetailId: {
                    required: true,
                    alphaNumeric: true
                },
                offerName:{
                    required: true
                },
                effectiveFrom:{
                    required: true
                },
                effectiveTo:{
                    required: true
                },
                offerAmount:{
                    required: true
                }
            }
        });


    });

    /*datetimepicker*/
    $(function(){
        var x = $('input[name=type]:checked').val();
        var bookingFrom = new Date();
        var effectiveFrom = new Date();
        var bookingTo = new Date();
        bookingTo.setDate(bookingTo.getDate()+1);
        var effectiveTo = new Date();
        effectiveTo.setDate(effectiveTo.getDate()+1);

        if("${offerMap}" == ''){
            bookingFrom = new Date(bookingFrom.getFullYear(), bookingFrom.getMonth(), bookingFrom.getDate(), 00, 01);
            bookingTo = new Date(bookingTo.getFullYear(), bookingTo.getMonth(), bookingTo.getDate(), 23, 59);
            effectiveFrom = new Date(effectiveFrom.getFullYear(), effectiveFrom.getMonth(), effectiveFrom.getDate());
            effectiveTo = new Date(effectiveTo.getFullYear(), effectiveTo.getMonth(), effectiveTo.getDate());

        }else{
            bookingFrom = new Date('${offerMap.bookingFrom}');
            effectiveFrom = new Date('${offerMap.effectiveFrom}');
            bookingTo = new Date('${offerMap.bookingTo}');
            effectiveTo = new Date('${offerMap.effectiveTo}');

            bookingFrom = new Date(bookingFrom.getFullYear(), bookingFrom.getMonth(), bookingFrom.getDate(), bookingFrom.getHours(), bookingFrom.getMinutes());
            bookingTo = new Date(bookingTo.getFullYear(), bookingTo.getMonth(), bookingTo.getDate(), bookingTo.getHours(), bookingTo.getMinutes());
            effectiveFrom = new Date(effectiveFrom.getFullYear(), effectiveFrom.getMonth(), effectiveFrom.getDate());
            effectiveTo = new Date(effectiveTo.getFullYear(), effectiveTo.getMonth(), effectiveTo.getDate());
        }


        $('#bookingFrom').datetimepicker({
            format: 'YYYY/MM/DD HH:mm',
            sideBySide: true,
            minDate: bookingFrom
        });
        $('#bookingTo').datetimepicker({
            format: 'YYYY/MM/DD HH:mm',
            sideBySide: true,
            minDate: bookingFrom
        });
        $('#effectiveFrom').datetimepicker({
            format: 'YYYY/MM/DD',
            minDate: effectiveFrom
        });
        $('#effectiveTo').datetimepicker({
            format: 'YYYY/MM/DD',
            minDate: effectiveFrom
        });

        $("#bookingFrom").data('DateTimePicker').date(new Date(bookingFrom.getFullYear(), bookingFrom.getMonth(), bookingFrom.getDate(), bookingFrom.getHours(), bookingFrom.getMinutes()));
        $("#bookingTo").data('DateTimePicker').date(new Date(bookingTo.getFullYear(), bookingTo.getMonth(), bookingTo.getDate(), bookingTo.getHours(), bookingTo.getMinutes()));
        $("#effectiveFrom").data('DateTimePicker').date(new Date(effectiveFrom.getFullYear(), effectiveFrom.getMonth(), effectiveFrom.getDate()));
        $("#effectiveTo").data('DateTimePicker').date(new Date(effectiveTo.getFullYear(), effectiveTo.getMonth(), effectiveTo.getDate()));
      /*  if("${offerMap}" == ''){


        }
*/


        $("#bookingFrom").on("dp.change", function (e) {

            $('#bookingTo').data("DateTimePicker").minDate(e.date);

        });
        $("#bookingTo").on("dp.change", function (e) {
            /*if(x != 'deal'){
                $('#bookingFrom').data("DateTimePicker").maxDate(e.date);
            }*/
        });

        $("#effectiveFrom").on("dp.change", function (e) {

            $('#effectiveTo').data("DateTimePicker").minDate(e.date);
        });
        $("#effectiveTo").on("dp.change", function (e) {
//            $('#effectiveFrom').data("DateTimePicker").maxDate(e.date);
        });

        if(x == 'deal'){
            $('#bookingTo').data("DateTimePicker").format('HH:mm');
            $("#offerName").val('Last Minute Deal');
            $("#offerName").prop('readonly', true);
        }

        $('input[name=type]').change(function(){
            x = $(this).val();
            if($(this).val()== 'deal'){
                $('#bookingTo').data("DateTimePicker").format('HH:mm');
                $("#offerName").val('Last Minute Deal');
                $("#offerName").prop('readonly', true);

            }else{
                $('#bookingTo').data("DateTimePicker").format('YYYY/MM/DD HH:mm');
//                $('#bookingFrom').data("DateTimePicker").maxDate(bookingTo);
                /*$("#inp-bookingTo").prop('readonly', false);maxDate: bookingTo
                $("#inp-effectiveTo").prop('readonly', false);*/
                $("#offerName").prop('readonly', false);
                $("#offerName").val('');
            }
        });
    });




    /*$('.input-group.date').datepicker({
        todayBtn: "linked",
        format: 'yyyy/mm/dd',
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        startDate: "2016/08/20"
    });*/
    /*$('#effective .input-daterange').datepicker({
        format: 'yyyy/mm/dd',
        keyboardNavigation: false,
        forceParse: false,
        autoclose: true
    });
    $('#booking .input-daterange').datepicker({
        format: 'yyyy/mm/dd',
        keyboardNavigation: false,
        forceParse: false,
        autoclose: true
    });*/


</script>


</body>
</html>