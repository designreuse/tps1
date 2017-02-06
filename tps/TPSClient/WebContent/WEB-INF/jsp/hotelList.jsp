<%@include file="/WEB-INF/includes/header.jsp" %>

<link href="${pageContext.request.contextPath}/css/plugins/blueimp/css/blueimp-gallery.min.css" rel="stylesheet">
    <div id="wrapper">

    <%@include file="/WEB-INF/includes/leftNavigation.jsp" %>
    <div id="page-wrapper" class="gray-bg">
    <%@include file="/WEB-INF/includes/topNavigation.jsp" %>
    <div class="wrapper wrapper-content animated fadeIn" id="hotel-wrapper">

    <div class="p-w-md m-t-sm">
    <div class="row">

<c:if test="${mode eq 'view'}">

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
                        <th>Active</th>
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
                            <td class="active">
                                <c:choose><c:when test="${data.active=='Y'}">Active</c:when><c:when
                                        test="${data.active=='N'}">Inactive</c:when></c:choose></td>
                        <td class="center">

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
</c:if>


    </div>
    </div>
    </div>
    </div>
    </div>

    <%@include file="/WEB-INF/includes/script.jsp" %>
    <script src="${pageContext.request.contextPath}/js/plugins/blueimp/jquery.blueimp-gallery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/preview.js"></script>


</body>
</html>
