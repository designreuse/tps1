<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 5/13/2016
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/includes/header.jsp" %>

<div id="wrapper">
    <%@include file="/WEB-INF/includes/leftNavigation.jsp" %>
    <div id="page-wrapper" class="gray-bg">
        <%@include file="/WEB-INF/includes/topNav.jsp" %>
        <div class="wrapper wrapper-content animated fadeIn">
            <c:if test="${mode=='update'}">
                <div class="p-w-md m-t-sm">
                    <div class="row">

                        <form id="form1" class="form-horizontal" method="post" action="${mode}">

                            <input type="hidden" name="rulesId" value="${rulesMap.rulesId}">


                            <div class="form-group"><label class="col-sm-2 control-label">Rules</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Rule" id="rulesDesc" name="rulesDesc"
                                                             type="text" value="${rulesMap.rulesDesc}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Type</label>

                                <div class="col-sm-3"><select id="type" name="type" class="form-control m-b" required>
                                    <option value="HOTEL_RULES"
                                            <c:if test="${rulesMap.type=='HOTEL_RULES'}">selected="selected"</c:if>  >
                                        Hotel Rules
                                    </option>
                                    <option value="ROOM_IMPORTANCE"
                                            <c:if test="${rulesMap.type=='ROOM_IMPORTANCE'}">selected="selected"</c:if>  >
                                        Room Importance
                                    </option>
                                </select></div>
                            </div>


                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button type="submit" class="btn btn-primary">Save changes</button>
                                </div>
                            </div>


                        </form>

                    </div>
                </div>
            </c:if>
            <c:if test="${mode=='view'}">
                <div class="row add-btn">
                    <a href="add" class="btn btn-primary">Add</a>
                </div>
            </c:if>
            <div class="row">
                <table class="table table-striped table-bordered bootstrap-datatable datatable">
                    <thead>
                    <tr>
                        <th>S.N</th>
                        <th>Rules</th>
                        <th>Type</th>
                        <th>Action</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${rulesList}" var="data" varStatus="count">

                        <tr>
                            <td>${count.count}.</td>

                            <td>${data.rulesDesc}</td>
                            <td><c:choose><c:when test="${data.type=='HOTEL_RULES'}">Hotel Rules</c:when>
                                <c:when test="${data.type=='ROOM_IMPORTANCE'}">Room Importance</c:when></c:choose></td>
                            <td class="center">

                                <a class="btn btn-info" href="edit/${data.rulesId}" title="Edit"
                                   data-rel="tooltip">
                                    <i class="fa fa-edit"></i>
                                </a>

                                <a class="open btn btn-danger" title="Delete" data-toggle="modal"
                                   data-target="#myModal_del"
                                   data-id="${data.rulesId}" data-rel="tooltip">
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
</div>
<%@include file="/WEB-INF/includes/script.jsp" %>
<script src="${pageContext.request.contextPath}/js/preview.js"></script>
<%--<c:forEach items="${siteContent.js}" var="js">
    <script src="${pageContext.request.contextPath}/js/plugins/${js}"></script>
</c:forEach>--%>
<%--<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.js"></script>--%>
<script>
    $(function () {



        $('#form1').validate({
            rules: {
                rulesDesc: {
                    required: true
                },
                type:{
                    required: true
                }
            }
        });
    });

    $("#roomId").change(function () {
        this.form.submit();
    });


</script>

</body>
</html>