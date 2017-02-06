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

                            <input type="hidden" name="niblConfigId" value="${niblConfigMap.niblConfigId}">


                            <div class="form-group"><label class="col-sm-2 control-label">Bank Id</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Bank Id" id="bankId" name="bandId"
                                                             value="${niblConfigMap.bankId}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Mode</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Mode" id="mode" name="mode"
                                                             value="${niblConfigMap.mode}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Payee Id</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Payee Id" id="payeeId" name="payeeId"
                                                             value="${niblConfigMap.payeeId}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Currency</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Currency" id="currency" name="currency"
                                                             value="${niblConfigMap.currency}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Return Url</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Return Url" id="returnUrl" name="returnUrl"
                                                             value="${niblConfigMap.returnUrl}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">CG</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="CG" id="cg" name="cg"
                                                             value="${niblConfigMap.cg}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">User Lang Id</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="User Lang Id" id="userLangId" name="userLangId"
                                                             value="${niblConfigMap.userLangId}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">User Type</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="User Type" id="userType" name="userType"
                                                             value="${niblConfigMap.userType}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">App Type</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="App Type" id="appType" name="appType"
                                                             value="${niblConfigMap.appType}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Type</label>

                                <div class="col-sm-3"><select id="type" name="type" class="form-control m-b" required>
                                    <option value="LIVE"
                                            <c:if test="${niblConfigMap.type=='LIVE'}">selected="selected"</c:if>  >
                                        Live
                                    </option>
                                    <option value="TEST"
                                            <c:if test="${niblConfigMap.type=='TEST'}">selected="selected"</c:if>  >
                                        Test
                                    </option>
                                </select></div>
                            </div>

                            <div class="form-group" style="display: none"><label class="col-sm-2 control-label">Active <input type="checkbox" class="i-checks" hidden name="active" <c:if test="${esewaConfigMap.active eq 'Y'}"> checked </c:if> value="Y"></label>

                                    <%--<div class="col-sm-3"> <input type="checkbox" class="i-checks"> </div>--%>
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
            <div class="row table-responsive">
                <table class="table table-striped table-bordered bootstrap-datatable datatable">
                    <thead>
                    <tr>
                        <th>S.N</th>
                        <th>Bank Id</th>
                        <th>Mode</th>
                        <th>Payee Id</th>
                        <th>Currency</th>
                        <th>Return Url</th>
                        <th>CG</th>
                        <th>User Lang Id</th>
                        <th>User Type</th>
                        <th>App Type</th>
                        <th>Type</th>
                        <th>Active</th>
                        <th>Action</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${niblConfigList}" var="data" varStatus="count">

                        <tr>
                            <td>${count.count}.</td>

                            <td>${data.bankId}</td>
                            <td>${data.mode}</td>
                            <td>${data.payeeId}</td>
                            <td>${data.currency}</td>
                            <td>${data.returnUrl}</td>
                            <td>${data.cg}</td>
                            <td>${data.userLangId}</td>
                            <td>${data.userType}</td>
                            <td>${data.appType}</td>
                            <td>${data.type}</td>
                            <td><input type="radio" name="active" class="i-checks active1" <c:if test="${data.active=='Y'}">checked</c:if> value="${data.niblConfigId}" id="checkbox${count.count}"></td>
                            <td class="center">

                                <a class="btn btn-info" href="edit/${data.niblConfigId}" title="Edit"
                                   data-rel="tooltip">
                                    <i class="fa fa-edit"></i>
                                </a>

                                <a class="open btn btn-danger" title="Delete" data-toggle="modal"
                                   data-target="#myModal_del"
                                   data-id="${data.niblConfigId}" data-rel="tooltip">
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

        $('#form1').validate({
            rules: {
                bankId: {
                    required: true
                },
                mode:{
                    required: true
                },
                payeeId:{
                    required: true
                },
                currency:{
                    required: true
                },
                returnUrl: {
                    required: true,
                    url: true
                },
                cg:{
                    required: true
                },
                userLangId:{
                    required: true
                },
                userType: {
                    required: true
                },
                appType:{
                    required: true
                },
                type:{
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
            data: { configId: $(this).val()},
            dataType: "json",
            beforeSend: function () {
                $('.loading-img').css('display', 'block');
            },
            complete: function () {
                $('.loading-img').css('display', 'none');
            },
            success: function(data){
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

</body>
</html>