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
                    <div class="row update-form">

                        <form id="form1" class="form-horizontal" method="post" action="${mode}">

                            <input type="hidden" name="mailServerSettingId" value="${mailServerSettingMap.mailServerSettingId}">


                            <div class="form-group"><label class="col-sm-2 control-label">Display Name</label>

                                <div class="col-sm-3"><input
                                        class="form-control" id="displayName" name="displayName" required="required"
                                        type="text" placeholder="Display Name" value="${mailServerSettingMap.displayName }"></div>
                            </div>
                            <div class="form-group"><label class="col-sm-2 control-label">Email Id</label>

                                <div class="col-sm-3"><input
                                        class="form-control" id="emailId" name="emailId" required="required"
                                    type="text" placeholder="Email Id" value="${mailServerSettingMap.emailId }"></div>
                            </div>
                            <div class="form-group"><label class="col-sm-2 control-label">Password</label>

                                <div class="col-sm-3"><input
                                        class="form-control" id="password" name="password"
                                        required="required" type="password" placeholder="Password" value="${mailServerSettingMap.password }">
                                    </div>
                            </div>
                            <div class="form-group"><label class="col-sm-2 control-label">Host</label>

                                <div class="col-sm-3"><input
                                        class="form-control" id="host" name="host"
                                        required="required" type="text" placeholder="Host" value="${mailServerSettingMap.host }"></div>
                            </div>
                            <div class="form-group"><label class="col-sm-2 control-label">Port</label>

                                <div class="col-sm-3"><input
                                        class="form-control" id="port" name="port" value="${mailServerSettingMap.port }"
                                        required="required" pattern="^([\w\s]{1,})$"  type="text" placeholder="Port"></div>
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
                        <th>Name</th>
                        <th>Email Id</th>
                        <th>Host</th>
                        <th>Port</th>
                        <th>Active</th>
                        <th>Action</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${mailServerSettingList}" var="data" varStatus="count">

                        <tr>
                            <td>${count.count}</td>
                            <td>${data.displayName}</td>
                            <td>${data.emailId}</td>
                            <td>${data.host}</td>
                            <td>${data.port}</td>
                            <td> <input type="radio" value="${data.mailServerSettingId }" class="active1" <c:if test="${data.active==true}"> checked="checked" </c:if>></td>
                            <td class="center">

                                <a class="btn btn-info" href="edit/${data.mailServerSettingId}" title="Edit"
                                   data-rel="tooltip">
                                    <i class="fa fa-edit"></i>
                                </a>

                                <a class="open btn btn-danger" title="Delete" data-toggle="modal"
                                   data-target="#myModal_del"
                                   data-id="${data.mailServerSettingId}" data-rel="tooltip">
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
<script type="text/javascript">

    $(function () {
        jQuery.validator.addMethod("alphaNumeric", function (value, element) {
            // return true - means the field passed validation
            // return false - means the field failed validation and it triggers the error
            return this.optional(element) || /^([\w\s]+)$/.test(value);
        }, "Only alphanumeric value and underscore is allowed!");


        $('#form1').validate({
            rules: {
                displayName: {
                    required: true,
                    alphaNumeric: true
                },
                emailId:{
                    required: true,
                    email: true
                },
                password:{
                    required: true
                },
                host:{
                    required: true
                },
                port:{
                    required: true
                }
            }
        });
    });


    $(".active1").change(function(){
        var activeStatus='N';
        if($(this).is(":checked")) {
            activeStatus='Y';
        }else{
            activeStatus='N';
        }

        $.ajax({
            method: "POST",
            url: "activate",
            data: { mailServerSettingId: $(this).val()},
            dataType: "json",
            beforeSend: function () {
                $('.loading-img').css('display', 'block');
            },
            complete: function () {
                $('.loading-img').css('display', 'none');
            },
            success: function (data) {
                toastr.success(data.status,data.msg);
                /* $(".active1").attr("checked",false);
                 $("#checkbox1").attr("checked",true);*/
            }

        });

    });
</script>
<%--<c:forEach items="${siteContent.js}" var="js">
    <script src="${pageContext.request.contextPath}/js/plugins/${js}"></script>
</c:forEach>--%>
<%--<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.js"></script>--%>

</body>
</html>