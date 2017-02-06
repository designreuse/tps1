<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 9/1/2016
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/includes/header.jsp" %>

<div id="wrapper">
    <!-- Modal customer Arrival -->
    <%--<div class="modal fade" id="myModal_del" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" style="padding-top: 15% !important">
            <div class="modal-content">
                <form action="arrived" method="post">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="myModalLabel">Customer Arrival</h4>
                    </div>
                    <div class="modal-body">
                        Does the customer Arrived at Hotel? <input id="deleteId" type="text" style="display: none"
                                       value="" name="invoiceNo">

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default btn-sm"
                                data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary btn-sm">Delete</button>
                    </div>

                </form>

            </div>
        </div>
    </div>--%>

    <%@include file="/WEB-INF/includes/leftNavigation.jsp" %>
    <div id="page-wrapper" class="gray-bg">
        <%@include file="/WEB-INF/includes/topNavigation.jsp" %>
        <c:if test="${mode=='view'}">
            <div class="modal inmodal" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content animated bounceInRight">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <%--<i class="fa fa-laptop modal-icon"></i>--%>
                            <h4 class="modal-title">Hotel Booking</h4>
                                <%--<small class="font-bold">Lorem Ipsum is simply dummy text of the printing and typesetting industry.</small>--%>
                        </div>
                        <div class="modal-body">
                            <h3>${hotelBookingMap.hotelName}</h3>
                            <div class="ibox ">
                                <div class="ibox-title">
                                    <h5>Booking Detail</h5>
                                </div>
                                <div class="ibox-content">


                                    <div>Booking Id: <span> ${hotelBookingMap.invoice}</span></div>
                                    <div>Room: <span> ${hotelBookingMap.roomDesc}</span></div>
                                    <%--<div>Booked For: <span> ${hotelBookingMap.roomDesc}</span></div>--%>
                                    <div>Check-In Date: <span> ${hotelBookingMap.checkInDate}</span></div>
                                    <div>Check-Out Date: <span> ${hotelBookingMap.checkOutDate}</span></div>
                                </div>
                            </div>
                            <div class="ibox ">
                                <div class="ibox-title">
                                    <h5>Guest Detail</h5>
                                </div>
                                <div class="ibox-content">
                                    <div class="col-sm-4">Guest: <span>${hotelBookingMap.guestName}</span> </div>
                                    <div class="col-sm-4">Contact Number: <span>${hotelBookingMap.guestPhNo}</span> </div>
                                    <div class="col-sm-4">Email Id: <span>${hotelBookingMap.guestEmailId}</span> </div>

                                    <c:if test="${hotelBookingMap.airportShuttle=='Y'}">
                                        <div>Airport Shuttle: <span>required</span></div>
                                        <div>Identification No.: <span>${hotelBookingMap.identificationNo}</span></div>
                                        <div>Arrival Date Time: <span>${hotelBookingMap.arrivalDateTime}</span></div>
                                    </c:if>

                                    <c:if test="${hotelBookingMap.specialRequest!=null}">
                                        <div>Special Request: <span>${hotelBookingMap.specialRequest}</span></div>
                                    </c:if>

                                </div>
                            </div>
                            <div class="ibox ">
                                <div class="ibox-title">
                                    <h5>Payment Detail</h5>
                                </div>
                                <div class="ibox-content">
                                    <div>Rate: <span> ${hotelBookingMap.finalRate}</span></div>
                                    <div>Paid: <span><c:choose><c:when test="${hotelBookingMpa.paid=='Y'}">${hotelBookingMap.finalRate}</c:when><c:otherwise>0</c:otherwise></c:choose>
                                    </div>
                                </div>
                            </div>

                        </div>

                            <form id="form1" class="form-horizontal" method="post" action="arrived">


                                    <%--<div class="form-group"><label class="col-sm-2 control-label">Arrived</label>

                                        <div class="col-sm-3"><input type="checkbox" name="invoiceNo"  value="${hotelBookingMap.invoice}"></div>
                                    </div>--%>

                                <div class="form-group col-sm-12">
                                    <input type="hidden" name="invoiceNo" value="${hotelBookingMap.invoice}">

                                    <c:if test="${hotelBookingMap.hotelArrival!='Y'}">
                                        <label class="control-label">
                                            <div class="col-sm-3"><input value="A" name="transactionType" type="radio"> </div>Arrive </label>
                                    </c:if>
                                    <c:if test="${hotelBookingMap.hotelArrival!='Y' && hotelBookingMap.payAtHotel=='Y'}">
                                        <label class="control-label">
                                            <div class="col-sm-3"><input value="C" name="transactionType" type="radio"> </div>Cancel </label>
                                    </c:if>
                                    <c:if test="${hotelBookingMap.hotelArrival=='Y' && hotelBookingMap.paid== null}">
                                        <label class="control-label">
                                            <div class="col-sm-3"><input value="P" name="transactionType" type="radio"> </div>Paid </label>
                                    </c:if>


                                </div>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-white" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary">Save changes</button>
                                </div>
                            </form>



                    </div>
                </div>
            </div>
        </c:if>

        <div class="wrapper wrapper-content animated fadeIn">

            <div class="row">
                <table class="table table-striped table-bordered bootstrap-datatable datatable">
                    <thead>
                    <tr>
                        <th>S.N</th>
                        <th>Invoice No.</th>
                        <th>Hotel</th>
                        <th>Guest Name</th>
                        <th>Room</th>
                        <th>Checked In Date</th>
                        <th>Checked Out Date</th>
                        <th>Airport Shuttle</th>
                        <th>Rate</th>
                        <th>Arrive</th>


                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${hotelBookingList}" var="data" varStatus="count">
                        <tr>
                            <td>${count.count}.</td>

                            <td>${data.invoice}</td>
                            <td>${data.hotelName}</td>
                            <td>${data.guestName}</td>
                            <td>${data.roomDesc}</td>
                            <td>${data.checkInDate}</td>
                            <td>${data.checkOutDate}</td>
                            <td><c:choose><c:when test="${data.airportShuttle=='Y'}">Yes</c:when>
                                <c:when test="${data.airportShuttle=='N'}">No</c:when></c:choose></td>
                            <td>${data.finalRate}
                                <input type="hidden" value="${data.invoice}" class="invoice"></td>
                            <td>
                                <c:if test="${data.hotelArrival=='N'}"><input type="checkbox" name="arrived"  value="${data.invoice}" class="checkbox"></c:if>

                               </td>
                        </tr>



                    </c:forEach>


                    </tbody>
                </table>
                <form id="arrived" method="post">

                    <input type="hidden" name="invoiceNo" id="invoice">
                    <input type="hidden" name="transactionType" value="A">

                </form>
            </div>


        </div>
    </div>
</div>
<%@include file="/WEB-INF/includes/script.jsp" %>
<%--<c:forEach items="${siteContent.js}" var="js">
    <script src="${pageContext.request.contextPath}/js/plugins/${js}"></script>
</c:forEach>--%>
<%--<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.js"></script>--%>
<script type="text/javascript">

   /* $("[id^='checkbox']").each(function(){
        $(this).click(function () {
            if($(this).next().attr('class')=='booking'){
                $(this).next().show();
            } else{
                $(this).after("<tr class='booking'><td colspan='8'>ganga</td></tr>")
            }
        });

    });*/
   $(function () {
       jQuery.validator.addMethod("alphaNumeric", function (value, element) {
           // return true - means the field passed validation
           // return false - means the field failed validation and it triggers the error
           return this.optional(element) || /^([\w\s]+)$/.test(value);
       }, "Only alphanumeric value and underscore is allowed!");

//	 	   $( "#addform" ).validate();
       $('#form1').validate({
           errorPlacement: function( label, element ) {
               element.parent().parent().parent().append( '<br>');
               element.parent().parent().parent().append( label);

           },
           rules: {
               transactionType: {
                   required: true
               }
           }
       });
   });

   $('#myModal').modal('show');

var flag = false;
    $(".checkbox").click(function(e){
flag=true;
        e.preventDefault();
        $("#invoice").val($(this).val());
        $("#arrived").attr("action","arrived").submit();

    });

    $("tbody tr").click(function(e){
        /*if (!$(e.target).closest('.checkbox-div').length) {
            //do your stuff
            alert('Clicked');
        }*/

        if(flag==false){
            var x = $(this).find('.invoice').val();
//        alert(x);
            $("#invoice").val(x);
            $("#arrived").attr('action','detail').submit();
            console.log(x);
            flag=true;
        }

//        $('#myModal').modal('show');
    });





</script>

</body>
</html>


