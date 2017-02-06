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

                <table class="table table-striped table-bordered bootstrap-datatable">
                    <thead>

                    <tr>
                        <th>S.N</th>
                        <th>Activity</th>
                        <th>Amenity</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="rows" begin="1" end="${size}" varStatus="count">
                        <tr><td>${count.count}<%--<input type="hidden" value="${count.count}" class="priority">--%></td>
                            <td><select name="activityWebPriority" class="form-control m-b activityHighlight" id="activityWebPriority${count.count}" data-count="${count.count}"><option value="">Select</option>
                                <c:forEach items="${activityHighlightList}" var="activity">
                                    <c:if test="${activity.priority eq count.count}">
                                        <option value="${activity.activityId}" selected>${activity.activityDesc}</option>
                                    </c:if>
                                </c:forEach>
                                <c:forEach items="${activityUnhighlightList}" var="activity">
                                    <option value="${activity.activityId}">${activity.activityDesc}</option>
                                </c:forEach>
                             </select></td>
                            <td>
                                <select name="amenityWebPriority" class="form-control m-b amenityHighlight" id="amenityWebPriority${count.count}" data-count="${count.count}"><option value="">Select</option>
                                    <c:forEach items="${amenityHighlightList}" var="amenity">
                                        <c:if test="${amenity.priority eq count.count}">
                                            <option value="${amenity.amenityId}" selected>${amenity.amenityDesc}</option>
                                        </c:if>
                                    </c:forEach>
                                    <c:forEach items="${amenityUnhighlightList}" var="amenity">
                                        <option value="${amenity.amenityId}">${amenity.amenityDesc}</option>
                                    </c:forEach>
                                </select></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <form id="highlightForm" method="post">
                    <input type="hidden" name="id" id="id">
                    <input type="hidden" name="priority" id="priority">
                </form>
            </div>

        </div>
    </div>
</div>
<%@include file="/WEB-INF/includes/script.jsp" %>
<script type="text/javascript">
$('.activityHighlight').change(function () {
    $('#id').val($(this).val());
    $('#priority').val($(this).data('count'));
    $('#highlightForm').attr('action', "updateActivityHighLight").submit();
});

$('.amenityHighlight').change(function () {
    $('#id').val($(this).val());
    $('#priority').val($(this).data('count'));
    $('#highlightForm').attr('action', "updateAmenityHighLight").submit();
});
</script>

</body>
</html>


