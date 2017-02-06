<%@include file="/WEB-INF/includes/header.jsp" %>

<link href="${pageContext.request.contextPath}/css/plugins/blueimp/css/blueimp-gallery.min.css" rel="stylesheet">
<c:if test="${base!=null}">
    <div id="wrapper">

    <%@include file="/WEB-INF/includes/leftNavigation.jsp" %>
    <div id="page-wrapper" class="gray-bg">
    <%@include file="/WEB-INF/includes/topNavigation.jsp" %>
    <div class="wrapper wrapper-content animated fadeIn" id="hotel-wrapper">

    <div class="p-w-md m-t-sm">
    <div class="row">
</c:if>

<c:if test="${mode eq 'view'}">
    <div class="row">

        <a href="add" class="btn btn-primary" id="add">Add Hotel</a>
        <div id="popover-head" class="hide">some title</div>
        <div id="popover-content" class="hide">
            <form>
                <!-- my form -->
            </form>
        </div>
        <div class="row">
            <table class="table table-striped table-bordered bootstrap-datatable datatable" id="hotelDetail">
                <thead>
                <tr>
                    <th>S.N</th>
                    <th>Username</th>
                    <th>Hotel</th>
                        <%--<th>Type</th>--%>
                    <th>Star Rating</th>
                    <th>Phone No.</th>
                    <th>Address</th>
                    <th>Total Room</th>
                    <c:if test="${sessionScope.get('role')=='[ADMIN]'}">
                        <th>Active</th>
                    </c:if>
                    <th>Action</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${hotelDetailList}" var="data" varStatus="count">
                    <c:if test="${sessionScope.get('role')!='[ADMIN]' && data.active=='Y'}">

                    </c:if>

                    <tr id="row${data.hotelDetailId}">
                        <td>${count.count}.</td>
                        <td>${data.emailId}</td>

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
                                <c:choose><c:when test="${data.active=='Y'}">Active</c:when><c:when
                                        test="${data.active=='N'}">Inactive</c:when></c:choose></td>
                        </c:if>
                        <td class="center">
                            <c:if test="${sessionScope.get('role')=='[ADMIN]' && (data.active eq 'Y' || data.active eq 'N')}"> <a class="btn btn-primary active-check"
                                                                                    title="<c:choose><c:when test="${data.active=='Y'}">Active</c:when><c:when test="${data.active=='N'}">Inactive</c:when></c:choose>"
                                                                                    id="checkbox${count.count}"
                                                                                    data-rel="tooltip">
                                <c:choose><c:when test="${data.active=='Y'}"><i class="fa fa-check-square-o"
                                                                                aria-hidden="true"></i>
                                </c:when><c:when test="${data.active=='N'}"><i class="fa fa-square-o"
                                                                               aria-hidden="true"></i>
                                </c:when></c:choose>
                                    <%--<i class="fa fa-edit"></i>--%>
                            </a>
                                <input type="hidden" class="hotelDetailId" value="${data.hotelDetailId}"/>
                            </c:if>


                            <a class="btn btn-info" href="edit/${data.hotelDetailId}" title="Edit"
                               data-rel="tooltip">
                                <i class="fa fa-edit"></i>
                            </a>

                            <a class="open btn btn-danger" title="Delete" data-toggle="modal"
                               data-target="#myModal_del"
                               data-id="${data.hotelDetailId}" data-rel="tooltip">
                                <i class="fa fa-trash"></i>
                            </a>

                            <button class="preview-hotel" data-id="${data.hotelDetailId}" data-page="${action}">preview</button>

                                <%--<a class="open btn btn-success" title="Delete" data-toggle="modal" href="bookingDetail"
                                   data-id="${data.hotelDetailId}" data-rel="tooltip">
                                    <i class="fa fa-eye"></i>
                                </a>--%>

                                <%--<input type="checkbox" name="active" <c:if test="${data.active=='Y'}">checked</c:if> value="Y" id="checkbox${count.count}">--%>

                        </td>
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
</c:if>


<c:if test="${base!=null}">
    </div>
    </div>
    </div>
    </div>
    </div>

    <%@include file="/WEB-INF/includes/script.jsp" %>
    <script src="${pageContext.request.contextPath}/js/plugins/blueimp/jquery.blueimp-gallery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/preview.js"></script>


    <%--property Detail--%>
    <script type="text/javascript">

        $('body').on('click', '.active-check', function () {
            var hotelDetailId = $(this).next('.hotelDetailId').val();
            var active = 'Y';
            var elementId = $(this).attr("id");
            /* if($(this).is(":checked")){
             active='Y'
             }*/
            if ($(this).attr('title') == 'Active') {
                active = 'N';
            }
            $.ajax({
                method: "POST",
                url: "activate",
                data: {hotelDetailId: hotelDetailId, active: active},
                dataType: "json",
                beforeSend: function () {
                    $('.loading-img').css('display', 'block');
                },
                complete: function () {
                    $('.loading-img').css('display', 'none');
                },
                success: function (data) {
                    if (data.status == 'SUCCESS') {
                        if (active == 'Y') {
                            $("#" + elementId).attr('title', 'Active');
                            $("#" + elementId).find('i').toggleClass('fa fa-check-square-o fa fa-square-o');
                            $("#" + elementId).parent().prev('td').html('Active');
//                                $("#"+elementId).text('<i class="fa fa-check-square-o" aria-hidden="true"></i>');
//                                $("#"+elementId).text('Active');
                        } else {
                            $("#" + elementId).attr('title', 'Inactive');
                            $("#" + elementId).find('i').toggleClass('fa fa-check-square-o fa fa-square-o');
                            $("#" + elementId).parent().prev('td').html('Inactive');
//                                $("#"+elementId).text('<i class="fa fa-square-o" aria-hidden="true"></i>');
//                                $("#"+elementId).text('Inactive');
                        }
                    } else {
                        $("#" + elementId).prop("checked", !$("#" + elementId).prop("checked"));
                    }

                    console.log(data);
                    responseMessage(data.status, data.msg);


                }
            });

        });



    </script>

</c:if>


</body>
</html>
