<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 5/13/2016
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/includes/header.jsp" %>

<div id="wrapper">
    <%@include file="/WEB-INF/includes/leftNavigation.jsp" %>
    <div id="page-wrapper" class="gray-bg">
        <%@include file="/WEB-INF/includes/topNav.jsp" %>
        <div class="wrapper wrapper-content animated fadeIn">
            <c:if test="${mode eq 'update'}">
                <div class="row">
                    <form id="form1" class="form-horizontal" method="post" action="update">

                        <input type="hidden" name="cancellationId" value="${cancellationMap.cancellationId}">


                        <div class="form-group"><label class="col-sm-2 control-label">Cancellation Before</label>


                            <div class="col-sm-3"><select name="freeCancellationBefore" class="form-control m-b" id="freeCancellation" required>
                                <%--<option value="1" <c:if test="${cancellationMap.freeCancellationBefore==1}">selected</c:if> >
                                    1 day
                                </option>
                                <option value="2" <c:if test="${cancellationMap.freeCancellationBefore==2}">selected</c:if>>
                                    2 days
                                </option>
                                <option value="3" <c:if test="${cancellationMap.freeCancellationBefore==3}">selected</c:if>>
                                    3 days
                                </option>
                                <option value="7" <c:if test="${cancellationMap.freeCancellationBefore==7}">selected</c:if>>
                                    7 days
                                </option>
                                <option value="14" <c:if test="${cancellationMap.freeCancellationBefore==14}">selected</c:if>>
                                    14 days
                                </option>--%>


                                <c:forEach begin="1" end="14"  var="count" >
                                    <%--<c:if test="${fn:contains (cancellationList, count)}"><option value="count" >
                                            test${count}
                                    </option> </c:if>--%>
                                    <c:if test="${!fn:contains(cancellationBefore, count) || cancellationMap.freeCancellationBefore eq count}">
                                        <option value="${count}" <c:if test="${cancellationMap.freeCancellationBefore==count}">selected</c:if> >
                                                ${count} <c:choose><c:when test="${count==1}">day</c:when><c:otherwise>days</c:otherwise></c:choose>
                                        </option>
                                    </c:if>
                                    <%--<option value="count" <c:if test="${cancellationMap.freeCancellationBefore==count}">selected</c:if> >
                                            ${count} <c:choose><c:when test="${count==1}">day</c:when><c:otherwise>days</c:otherwise></c:choose>
                                    </option>--%>


                                </c:forEach>
                            </select>
                            </div>
                        </div>

                        <div class="form-group"><label class="col-sm-2 control-label">Charge Type</label>
                            <div class="col-sm-3"><select name="chargeType" id="chargeType" class="form-control m-b" required>
                               <%-- <option value="NIGHTS" <c:if test="${cancellationMap.chargeType=='NIGHTS'}">selected</c:if> >
                                    Night Basis
                                </option>--%>
                                <option value="PERCENTAGE" <c:if test="${cancellationMap.chargeType=='PERCENTAGE'}">selected</c:if>>
                                    Percentage Basis
                                </option>
                               <%-- <option value="FIXED" <c:if test="${cancellationMap.chargeType=='FIXED'}">selected</c:if>>
                                    Fixed Charges
                                </option>--%>

                            </select></div>
                                <%--<div class="col-sm-10">
                                    <label class="radio-inline"> <input type="radio" value="NIGHTS" name="chargeType" <c:if test="${cancellationMap.chargeType=='NIGHTS'}">checked</c:if> > Nights </label>
                                    <label class="radio-inline"> <input type="radio" value="PERCENTAGE" name="chargeType" <c:if test="${cancellationMap.chargeType=='PERCENTAGE'}">checked</c:if> > Percentage Basis </label>
                                    <label class="radio-inline"> <input type="radio" value="FIXED" name="chargeType" <c:if test="${cancellationMap.chargeType=='FIXED'}">checked</c:if> > Fixed Charges </label>
                                </div>--%>

                        </div>

                        <div class="form-group"><label class="col-sm-2 control-label">Charge</label>
                            <div class="col-sm-3">
                                <input type="text" step="any" class="form-control"
                                       placeholder="Charges" name="chargeAmount" id="charges"
                                       value="${cancellationMap.chargeAmount}" required>
                            </div>

                        </div>


                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button type="submit" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>


                    </form>
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
                        <th>Cancellation Before (days)</th>
                        <th>Type</th>
                        <th>Charge Amount</th>
                        <th>Action</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cancellationList}" var="data" varStatus="count">

                        <tr>
                            <td>${count.count}.</td>

                            <td>${data.freeCancellationBefore}</td>
                            <td>${data.chargeType}</td>
                            <td>${data.chargeAmount}</td>
                            <td class="center">

                                <a class="btn btn-info" href="edit/${data.cancellationId}" title="Edit"
                                   data-rel="tooltip">
                                    <i class="fa fa-edit"></i>
                                </a>

                                <a class="open btn btn-danger" title="Delete" data-toggle="modal"
                                   data-target="#myModal_del"
                                   data-id="${data.cancellationId}" data-rel="tooltip">
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

<script type="text/javascript">

    $(function () {

        $('#form1').validate({
            rules: {
                freeCancellationBefore: {
                    required: true
                },
                chargeType:{
                    required: true
                },
                chargeAmount:{
                    required: true,
                    number: true,
                    min: 0
                }
            }
        });
    });

    $('#chargeType').change(function(){
        if($(this).val()=='NIGHTS'){
            $('#charges').attr('max',$('#freeCancellation').val());
        }else if($(this).val()=='PERCENTAGE'){
            $('#charges').attr('max',100);
        }
    });
</script>

</body>
</html>