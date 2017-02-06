<%@include file="/WEB-INF/includes/header.jsp"%>


    <div id="wrapper">
    <%@include file="/WEB-INF/includes/leftNavigation.jsp"%>
    <div id="page-wrapper" class="gray-bg">
    <%@include file="/WEB-INF/includes/topNavigation.jsp"%>
    <div class="wrapper wrapper-content animated fadeIn">

    <div class="p-w-md m-t-sm">

        <div class="row">
            <form class="form-horizontal" method="post" id="form1">

                <div class="form-group"><label class="col-sm-2 control-label">User </label>
                    <div class="col-sm-3">
                        <select name="userDetailId" class="form-control m-b" required id="userDetailId">
                            <option value="">Select</option>
                            <c:forEach items="${userDetaiList}" var="userDetail">
                                <option value="${userDetail.userDetailId}" <c:if test="${userDetail.userDetailId==userDetailId}"> selected </c:if>>${userDetail.emailId}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="form-group"><label class="col-sm-2 control-label">Hotel </label>
                    <div class="col-sm-3">
                        <select data-placeholder="Select Hotel" class="form-control m-b chosen-select" multiple style="width:350px;" tabindex="4" name="hotelDetailList">
                            <option value="">Select</option>
                            <c:forEach items="${unassignHotelDetailList}" var="hotelDetail">
                                <option value="${hotelDetail.hotelDetailId}">${hotelDetail.hotelName}</option>
                            </c:forEach>
                        </select>
                       <%-- <select name="hotelDetailList" class="form-control m-b" required id="hotelDetailList">
                            <option value="">Select</option>
                            <c:forEach items="${unassignHotelDetailList}" var="hotelDetail">
                                <option value="${hotelDetail.hotelDetailId}">${hotelDetail.hotelName}</option>
                            </c:forEach>
                        </select>--%>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-4 col-sm-offset-2">
                        <%--<button type="reset" class="btn btn-white">Reset</button>--%>
                        <button type="submit" class="btn btn-primary" formaction="update">Submit</button>

                    </div>
                </div>

            </form>
        </div>
    <div class="row">

            <table class="table table-striped table-bordered bootstrap-datatable datatable" id="hotelDetail">
                <thead>
                <tr>
                    <th>S.N</th>
                    <th>Hotel</th>
                        <%--<th>Type</th>--%>
                    <th>Star Rating</th>
                    <th>Phone No.</th>
                    <th>Address</th>
                    <th>Total Room</th>
                    <th>Active</th>


                </tr>
                </thead>
                <tbody>
                <c:forEach items="${assignHotelDetailList}" var="data" varStatus="count">


                    <tr>
                        <td>${count.count}.</td>

                        <td>${data.hotelName}</td>
                            <%--<td>${data.hotelType}</td>--%>
                        <td>${data.starRating}</td>
                        <td>${data.hotelPhNo1}<br>
                                ${data.hotelPhNo2}<br>
                                ${data.hotelPhNo3}</td>
                        <td>${data.streetAddress}</td>
                        <td>${data.totalRoom}</td>
                        <c:if test="${sessionScope.get('role')=='[ADMIN]'}">
                            <td class="active">
                                <c:choose><c:when test="${data.active=='Y'}">Active</c:when><c:when test="${data.active=='N'}">Inactive</c:when></c:choose> </td>
                        </c:if>

                    </tr>
                    <%--  <tr class="desc"><td colspan="7">
                          <table>
                              <tr><td>Full name:</td><td>Cedric Kelly</td></tr>
                              <tr><td>Extension number:</td><td>6224</td></tr>
                              <tr><td>Extra info:</td><td>And any further details here</td></tr>
                          </table>
                      </td></tr>--%>


                </c:forEach>


                </tbody>
            </table>
    </div>



    </div>
    </div>
    </div>
    </div>
    <%@include file="/WEB-INF/includes/script.jsp"%>

    <%--property Detail--%>
    <script type="text/javascript">
        $("#userDetailId").change(function(){
            $('#form1').attr('action', "assignPropertyList").submit();
        });

        /*var config = {
            '.chosen-select'           : {},
            '.chosen-select-deselect'  : {allow_single_deselect:true},
            '.chosen-select-no-single' : {disable_search_threshold:10},
            '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
            '.chosen-select-width'     : {width:"95%"}
        }
        for (var selector in config) {
            $(selector).chosen(config[selector]);
        }*/
        $(".chosen-select").select2();
    </script>




</body>
</html>
