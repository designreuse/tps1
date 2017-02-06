<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 6/17/2016
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/includes/header.jsp" %>

<div id="wrapper">
    <%@include file="/WEB-INF/includes/adminLeftNavigation.jsp" %>
    <div id="page-wrapper" class="gray-bg">
        <%@include file="/WEB-INF/includes/topNavigation.jsp" %>


        <div class="wrapper wrapper-content animated fadeIn">
            <div class="row">
                <table class="table table-striped table-bordered bootstrap-datatable datatable">
                    <thead>
                    <tr>
                        <th>S.N</th>
                        <th>Description</th>
                        <th>Type</th>
                        <th>Active</th>
                        <th>Logo</th>
                        <%--<th>Action</th>--%>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${payGateAccessList}" var="data" varStatus="count">

                        <tr>
                            <td>${count.count}.</td>

                            <td>${data.payGateDesc}</td>

                            <td>${data.type}</td>
                            <td><input type="checkbox" name="active" class="i-checks active1" <c:if test="${data.active=='Y'}">checked</c:if> value="${data.payGateAccessId}" id="checkbox${count.count}"></td>
                            <td><img src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/TPSResources/icons/${data.image}" alt="${data.payGateDesc} logo" width="50" height="50">
                                <a class="upload-link" data-id="${data.payGateAccessId}" data-type="${data.type}">Change Logo</a> </td>
                           <%-- <td class="center">

                                <a class="btn btn-info" href="edit/${data.payGateAccessId}" title="Edit"
                                   data-rel="tooltip">
                                    <i class="fa fa-edit"></i>
                                </a>

                                <a class="open btn btn-danger" title="Delete" data-toggle="modal"
                                   data-target="#myModal_del"
                                   data-id="${data.payGateAccessId}" data-rel="tooltip">
                                    <i class="fa fa-trash"></i>
                                </a>
                            </td>--%>
                        </tr>


                    </c:forEach>


                    </tbody>
                </table>

                <form action="iconUpload" id="iconUploadForm" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="payGateAccessId" id="payGateAccesId">
                    <input type="hidden" name="type" id="type">
                    <input id="paymentIcon-upload" type="file" name="iconImage"/>
                </form>

            </div>

        </div>
    </div>
</div>
<%@include file="/WEB-INF/includes/script.jsp" %>

<script type="text/javascript">
    $(function(){
        $(".upload-link").on('click', function(e){
            e.preventDefault();

            $("#payGateAccesId").val($(this).data('id'));
            $("#type").val($(this).data('type'));
            $("#paymentIcon-upload:hidden").trigger('click');
        });

        $("#paymentIcon-upload").change(function(){
           $("#iconUploadForm").submit();
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
            url: "update",
            data: {payGateAccessId: $(this).val(), active: activeStatus},
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


</body>
</html>


