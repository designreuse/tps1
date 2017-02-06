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

                            <input type="hidden" name="npayConfigId" value="${npayConfigMap.npayConfigId}">


                            <div class="form-group"><label class="col-sm-2 control-label">Merchant Id</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Merchant Id" id="merchantId" name="merchantId"
                                                             value="${npayConfigMap.merchantId}" required>
                                </div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Merchant User Name</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Merchant Username" id="merchantUserName"
                                                             name="merchantUserName"
                                                             value="${npayConfigMap.merchantUserName}"
                                                             required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Merchant Password</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Merchant Password" id="merchantPassword"
                                                             name="merchantPassword"
                                                             value="${npayConfigMap.merchantPassword}"
                                                             required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Signature</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Signature" id="signature" name="signature"
                                                             value="${npayConfigMap.signature}" required>
                                </div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Interface Url</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="interfaceUrl" id="interfaceUrl"
                                                             name="interfaceUrl"
                                                             value="${npayConfigMap.interfaceUrl}" required>
                                </div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Api Url</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Api Url" id="apiUrl" name="apiUrl"
                                                             value="${npayConfigMap.apiUrl}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Type</label>

                                <div class="col-sm-3"><select id="type" name="type" class="form-control m-b" required>
                                    <option value="LIVE"
                                            <c:if test="${npayConfigMap.type=='LIVE'}">selected="selected"</c:if>  >
                                        Live
                                    </option>
                                    <option value="TEST"
                                            <c:if test="${npayConfigMap.type=='TEST'}">selected="selected"</c:if>  >
                                        Test
                                    </option>
                                </select></div>
                            </div>

                            <div class="form-group" style="display: none"><label class="col-sm-2 control-label">Active <input type="checkbox" class="i-checks" hidden name="active" <c:if test="${esewaConfigMap.active eq 'Y'}"> checked </c:if> value="Y"></label>

                                    <%--<div class="col-sm-3"> <input type="checkbox" class="i-checks"> </div>--%>
                            </div>

                                <%--<div class="form-group"><label class="col-sm-2 control-label">Active <input type="checkbox" class="i-checks"></label>

                                    <div class="col-sm-3"> <input type="checkbox" class="i-checks"> </div>
                                </div>--%>

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
                <table class="table table-striped table-bordered bootstrap-datatable" id="datatable">
                    <thead>
                    <tr>
                        <th>S.N</th>
                        <th>Merchant Id</th>
                        <th>Merchant Username</th>
                        <th>Merchant Password</th>
                        <th>Signature</th>
                        <th>Interface Url</th>
                        <th> Api Url</th>
                        <th>Type</th>
                        <th>Active</th>
                        <th>Action</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${npayConfigList}" var="data" varStatus="count">

                        <tr>
                            <td>${count.count}.</td>

                            <td>${data.merchantId}</td>
                            <td>${data.merchantUserName}</td>
                            <td>${data.merchantPassword}</td>
                            <td>${data.signature}</td>
                            <td>${data.interfaceUrl}</td>
                            <td>${data.apiUrl}</td>
                            <td>${data.type}</td>
                            <td><input type="radio" name="active" class="i-checks active1"
                                       <c:if test="${data.active=='Y'}">checked</c:if> value="${data.npayConfigId}"
                                       id="checkbox${count.count}"></td>
                            <td class="center">

                                <a class="btn btn-info" href="edit/${data.npayConfigId}" title="Edit"
                                   data-rel="tooltip">
                                    <i class="fa fa-edit"></i>
                                </a>

                                <a class="open btn btn-danger" title="Delete" data-toggle="modal"
                                   data-target="#myModal_del"
                                   data-id="${data.npayConfigId}" data-rel="tooltip">
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
                merchantId: {
                    required: true
                },
                merchantUsername: {
                    required: true
                },
                merchantPassword: {
                    required: true
                },
                signature: {
                    required: true
                },
                interfaceUrl: {
                    required: true
                },
                apiUrl: {
                    required: true
                },
                type: {
                    required: true
                }
            }
        });
    });

    $(".active1").change(function () {
        var activeStatus = 'N';
        if ($(this).is(":checked")) {
            activeStatus = 'Y';
        } else {
            activeStatus = 'N';
        }

        $.ajax({
            method: "POST",
            url: "activate",
            data: {configId: $(this).val()},
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

</body>
</html>