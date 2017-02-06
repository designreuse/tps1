<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 5/13/2016
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/includes/header.jsp" %>

<div id="wrapper">
    <%@include file="/WEB-INF/includes/adminLeftNavigation.jsp" %>
    <div id="page-wrapper" class="gray-bg">
        <%@include file="/WEB-INF/includes/topNavigation.jsp" %>
        <div class="wrapper wrapper-content animated fadeIn">
            <c:if test="${mode=='update'}">
                <div class="p-w-md m-t-sm">
                    <div class="row">

                        <form id="form1" class="form-horizontal" method="post" action="${mode}">

                            <input type="hidden" name="bedTypeId" value="${bedTypeMap.bedTypeId}">


                            <div class="form-group"><label class="col-sm-2 control-label">Bed Description</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Description" id="bedTypeDesc" name="bedTypeDesc"
                                                             type="text" value="${bedTypeMap.bedTypeDesc}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Dimension</label>
                                <input type="hidden" name="bedDimension" id = "bedDimension">
                                <c:set var="splitString" value="${fn:split(bedTypeMap.bedDimension, '-')}" />
                                <c:set var="splitString2" value="${fn:split(splitString[1], ' ')}" />
                                <%--<c:out value="${fn:join(splitString2, '-')}"/>--%>
                                <div class="col-sm-3">
                                        <small>Length</small>
                                    <div class="input-group"> <input type="text" class="form-control"
                                                                               placeholder="Demension" id="length" name="length"
                                                                               type="text" value="${splitString[0]}" required>
                                        <span class="input-group-addon">cm</span>
                                    </div>
                                </div>

                                    <div class="col-sm-3">
                                        <small>Breadth</small>
                                        <div class="input-group"> <input type="text" class="form-control"
                                               placeholder="Demension" id="breadth" name="breadth"
                                               type="text" value="${splitString2[0]}" required>
                                        <span class="input-group-addon">cm</span>
                                        </div>
                                </div>

                                <div class="col-sm-3"></div>
                            </div>
                            <div class="form-group"><label class="col-sm-2 control-label">Capacity</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Capacity" id="capacity" name="capacity"
                                                             type="text" value="${bedTypeMap.capacity}" required></div>
                            </div>
                            <div class="form-group"><label class="col-sm-2 control-label">Active</label>

                                <div class="col-sm-3"><input type="checkbox" value="Y" id="checkbox"
                                                             name="active" <c:if test="${bedTypeMap.active=='Y'}">checked</c:if> ></div>
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
                <a href="add" class="btn btn-default">Add</a>
            </c:if>
            <div class="row">
                <table class="table table-striped table-bordered bootstrap-datatable datatable">
                    <thead>
                    <tr>
                        <th>S.N</th>
                        <th>Bed</th>
                        <th>Dimension</th>
                        <th>Capacity</th>
                        <th>Active</th>
                        <th>Action</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${bedTypeList}" var="data" varStatus="count">

                        <tr>
                            <td>${count.count}.</td>

                            <td>${data.bedTypeDesc}</td>
                            <td>${data.bedDimension}</td>
                            <td>${data.capacity}</td>
                            <td>${data.active}</td>
                            <td class="center">

                                <a class="btn btn-info" href="edit/${data.bedTypeId}" title="Edit"
                                   data-rel="tooltip">
                                    <i class="fa fa-edit"></i>
                                </a>

                                <a class="open btn btn-danger" title="Delete" data-toggle="modal"
                                   data-target="#myModal_del"
                                   data-id="${data.bedTypeId}" data-rel="tooltip">
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
<%--<c:forEach items="${siteContent.js}" var="js">
    <script src="${pageContext.request.contextPath}/js/plugins/${js}"></script>
</c:forEach>--%>
<%--<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.js"></script>--%>
<script>
    $(function () {
        jQuery.validator.addMethod("alphaNumeric", function (value, element) {
            // return true - means the field passed validation
            // return false - means the field failed validation and it triggers the error
            return this.optional(element) || /^([\w\s]+)$/.test(value);
        }, "Only alphanumeric value and underscore is allowed!");


        $('#form1').validate({
            rules: {
                bedTypeDesc: {
                    required: true,
                    alphaNumeric: true
                },
                length:{
                    required: true,
                    digits: true,
                    min: 1
                },
                breadth:{
                    required: true,
                    digits: true,
                    min: 1
                },
                capacity:{
                    required: true,
                    digits: true,
                    min: 1
                }
            }
        });
    });

    $( "form" ).submit(function( event ) {
        $('#bedDimension').val($('#length').val().concat('-',$('#breadth').val(),' cm'));
    });


</script>

</body>
</html>