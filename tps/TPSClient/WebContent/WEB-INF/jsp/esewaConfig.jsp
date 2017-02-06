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
        <%@include file="/WEB-INF/includes/topNavigation.jsp" %>
        <div class="wrapper wrapper-content animated fadeIn">
            <c:if test="${mode=='update'}">
                <div class="p-w-md m-t-sm">
                    <div class="row">

                        <form id="form1" class="form-horizontal" method="post" action="${mode}">

                            <input type="hidden" name="esewaConfigId" value="${esewaConfigMap.esewaConfigId}">


                            <div class="form-group"><label class="col-sm-2 control-label">Service Code</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="service code" id="serviceCode" name="serviceCode"
                                                             type="text" value="${esewaConfigMap.serviceCode}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Success Url</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Success Url" id="successUrl" name="successUrl"
                                                             type="text" value="${esewaConfigMap.successUrl}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Fail Url</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Fail Url" id="failUrl" name="failUrl"
                                                             type="text" value="${esewaConfigMap.failUrl}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Interface Url</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="interfaceUrl" id="interfaceUrl" name="interfaceUrl"
                                                             type="text" value="${esewaConfigMap.interfaceUrl}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Verify Api Url</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Verify Api Url" id="verifyApiUrl" name="verifyApiUrl"
                                                             type="text" value="${esewaConfigMap.verifyApiUrl}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Type</label>

                                <div class="col-sm-3"><select id="type" name="type" class="form-control m-b" required>
                                    <option value="LIVE"
                                            <c:if test="${esewaConfigMap.type=='LIVE'}">selected="selected"</c:if>  >
                                        Live
                                    </option>
                                    <option value="TEST"
                                            <c:if test="${esewaConfigMap.type=='TEST'}">selected="selected"</c:if>  >
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
                <table class="table table-striped table-bordered bootstrap-datatable" id="datatable">
                    <thead>
                    <tr>
                        <th>S.N</th>
                        <th>Service Code</th>
                        <th>Success Url</th>
                        <th>Fail Url</th>
                        <th>Interface Url</th>
                        <th>Verify Api Url</th>
                        <th>Type</th>
                        <th>Active</th>
                        <th>Action</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${esewaConfigList}" var="data" varStatus="count">

                        <tr>
                            <td>${count.count}.</td>

                            <td>${data.serviceCode}</td>
                            <td>${data.successUrl}</td>
                            <td>${data.failUrl}</td>
                            <td>${data.interfaceUrl}</td>
                            <td>${data.verifyApiUrl}</td>
                            <td>${data.type}</td>
                            <td><input type="radio" name="active" class="i-checks active1" <c:if test="${data.active=='Y'}">checked</c:if> value="${data.esewaConfigId}" id="checkbox${count.count}"></td>
                            <td class="center">

                                <a class="btn btn-info" href="edit/${data.esewaConfigId}" title="Edit"
                                   data-rel="tooltip">
                                    <i class="fa fa-edit"></i>
                                </a>

                                <a class="open btn btn-danger" title="Delete" data-toggle="modal"
                                   data-target="#myModal_del"
                                   data-id="${data.esewaConfigId}" data-rel="tooltip">
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
                serviceCode: {
                    required: true
                },
                successUrl:{
                    required: true,
                    url: true
                },
                failUrl:{
                    required: true,
                    url: true
                },
                interfaceUrl:{
                    required: true,
                    url: true
                },
                verifyApiUrl: {
                    required: true,
                    url: true
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