<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 5/13/2016
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/includes/header.jsp"%>

    <div id="wrapper">
    <%@include file="/WEB-INF/includes/leftNavigation.jsp"%>
    <div id="page-wrapper" class="gray-bg">
    <%@include file="/WEB-INF/includes/topNav.jsp"%>
    <div class="wrapper wrapper-content animated fadeIn">

    <div class="p-w-md m-t-sm">

<div class="row">
    <form method="post" action="view">
        <div class="col-sm-12">
            <div class="col-sm-3">
                <select name="roomDetailId" class="form-control m-b" id="roomId">
                     <c:forEach items="${roomDetailList}" var="roomDetail">
                         <option <c:if test="${roomDetail.roomDetailId== roomDetailId}"> selected </c:if> value="${roomDetail.roomDetailId}">${roomDetail.customName}</option>
                     </c:forEach>
                </select>
            </div>
        </div>
    </form>
</div>
    <div class="row">
        <%--<div >
            &lt;%&ndash;<a href="customRules" class="btn btn-primary">Add Custom Rules</a>&ndash;%&gt;
                <button data-target="#myModal" data-toggle="modal" class="btn btn-primary" type="button">
                   Custom Room Importance
                </button>

        </div>
        <div class="modal inmodal" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content animated bounceInRight">
                    <form id="form" class="form-horizontal" method="post" action="${mode}">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        &lt;%&ndash;<i class="fa fa-laptop modal-icon"></i>&ndash;%&gt;
                        <h4 class="modal-title">Add/Update Custom Rules</h4>
                        &lt;%&ndash;<small class="font-bold">Lorem Ipsum is simply dummy text of the printing and typesetting industry.</small>&ndash;%&gt;
                    </div>
                    <div class="modal-body">
                                <input type="hidden" name="rulesId" value="${rulesMap.rulesId}">

                        <div class="form-group"><label class="col-sm-2 control-label">Rules</label>

                            <div class="col-sm-8" id="rulesDescWrapper"><input type="text" class="form-control rulesDesc"
                                                         placeholder="Rules" name="rulesDesc"
                                                         value="${hotelDetailMap.hotelName}" required>

                            </div>
                            <div class="col-sm-1">
                                <button type="button" class="btn btn-primary add"><i class="fa fa-plus"></i> </button>
                            </div>
                            <div class="col-sm-1">
                                <button type="button" class="btn btn-danger remove"><i class="fa fa-minus"></i> </button>
                            </div>



                        </div>

                                &lt;%&ndash;<div class="control-group">
                                    <label class="control-label" for="rulesDesc">Rules</label>
                                    <div class="controls">
                                        <input class="input-xlarge focused" id="rulesDesc" name="rulesDesc"
                                               type="text" value="${rulesMap.rulesDesc}" required>
                                    </div>
                                </div>&ndash;%&gt;

                                &lt;%&ndash;<div class="control-group">
                                    <label class="control-label" for="type">Type</label>
                                    <div class="controls">
                                        <select id="type" name="type" data-rel="chosen">
                                            <option value="HOTEL_RULES"
                                                    <c:if test="${rulesMap.type=='HOTEL_RULES'}">selected="selected"</c:if>  >Hotel Rules</option>
                                            <option value="ROOM_IMPORTANCE"
                                                    <c:if test="${rulesMap.type=='ROOM_IMPORTANCE'}">selected="selected"</c:if>  >Room Importance</option>

                                        </select>
                                    </div>
                                </div>&ndash;%&gt;




                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-white" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                    </form>
                </div>
            </div>
        </div>--%>

<form id="form1" class="form-horizontal" method="post" action="update">

        <input name="roomDetailId" value="${roomDetailId}" type="hidden">

        <table class="table table-striped table-bordered bootstrap-datatable " id="popularPlace">
            <thead>
            <tr>
                <th>S.N</th>
                <th>Rules</th>
                <th>Assign</th>
            </tr>
            </thead>
            <tbody >

            <c:forEach items="${roomImportanceList}" var="roomImportance" varStatus="count">


                <tr>
                    <td>${count.count}.</td>
                    <td>${roomImportance.rulesDesc}</td>
                    <input type="hidden" value="${roomImportance.roomImportanceId}" name="roomImportanceId">
                    <input type="hidden" value="${roomImportance.rulesId}" name="rulesId"></td>
                    <td><input type="checkbox" name="active" value="${roomImportance.rulesId}" <c:if test="${roomImportance.active=='Y'}">checked</c:if>></td>

                </tr>



            </c:forEach>


            </tbody>
        </table>

        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Save changes</button>
            <button class="btn" id="cancel">Cancel</button>
        </div>



</form>
    </div>
    </div>
    </div>
    </div>
    </div>
    <%@include file="/WEB-INF/includes/script.jsp"%>
<script src="${pageContext.request.contextPath}/js/preview.js"></script>
    <c:forEach items="${siteContent.js}" var="js">
        <script src="${pageContext.request.contextPath}/js/plugins/${js}"></script>
    </c:forEach>
    <%--<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.js"></script>--%>
    <script>
        $("#roomId").change(function(){
            this.form.submit();
        });
/*script for add and update roomImportance*/
        $(document).ready(function () {


            var max_fields = 10; //maximum input boxes allowed
            var wrapper = $("#rulesDescWrapper"); //Fields wrapper
            var add_button = $(".add"); //Add button ID

//			    var x = 1; //initlal text box count
            var x = $('.rulesDesc').length;

            if (x > 1) {
                $('.remove').show();
            } else {
                $('.remove').hide();
            }

            $(add_button).click(function (e) { //on add input button click

                e.preventDefault();
                if (x < max_fields) { //max input box allowed

                    x++; //text box increment

                    $(wrapper).append('<input type="text" class="form-control rulesDesc" placeholder="Rules" name="rulesDesc" value="${hotelDetailMap.hotelName}" required>');

                    if (x > 1) {
                        $('.remove').show();
                    } else {
                        $('.remove').hide();
                    }
                }
            });

            $(".remove").click(function (e) { //user click on remove text
                e.preventDefault();
                if (x > 1) {
                    $(".rulesDesc").last().remove();
                }

//                $(this).parent('div').parent('div').remove();
                x--;
                if (x > 1) {
                    $('.remove').show();
                } else {
                    $('.remove').hide();
                }

            });


        });

    </script>

</body>
</html>
