

<h2>Your Accommodation Agreement with Booking.com B.V.</h2>
<div class="row">
    <div class="col-lg-6">
<h3>Between</h3>
        <strong>IGC Group</strong><br>
        <p>Metro Park- 3rd Floor<br>
            North Gate Royal Palace<br>
            Lazimpat-2, Kathmandu, Nepal
        </p>
    </div>
    <div class="col-lg-6">
        <h3>And You, The Accomodation</h3>
        Property Name: ${hotelDetailMap.hotelName}<br>
        Contact Person: ganga Maharjan
        Address: Pulchowk
    </div>
</div>
<div class="row">
    Have Agreed as Follows:
    <dl>
        <dt>Commission percentage</dt>
        <dd>The commission percentage shall be 12% What do I get for the commission I pay? </dd>
        <dt>Execution and performance</dt>
        <dd>The Agreement is only effective after approval and confirmation by Booking.com B.V. </dd>
        <dt>General delivery terms</dt>
        <dd>This Agreement is subject to and governed by the General Delivery Terms (the "Terms and Conditions"). The Accommodation declares that it has read and hereby accepts the terms and conditions. </dd>
    </dl>
</div>
<div class="row">
    <form action="register/agreement" method="post" id="agreement">
        <div><label> <input type="checkbox" value="" name="agreement1"> I certify that this is a legitimate accommodation business with all necessary licenses and permits, which can be shown upon first request. Booking.com B.V. reserves the right to verify and investigate any details provided in this registration. </label></div>
        <div><label> <input type="checkbox" value="" name="agreement2"> I have read, accepted and agreed to the terms and conditions.</label></div>
        <button type="submit" class="btn btn-primary">Continue</button>
    </form>

</div>
<%@include file="/WEB-INF/includes/script.jsp" %>


<script type="text/javascript">
    <%--<c:if test="${responseMsg!=null&&status==null}">
    toastr.info('${responseMsg}');
    </c:if>

    <c:if test="${responseMsg!=null&&status!=Error}">
    toastr.error('${responseMsg}');
    </c:if>--%>
    $(function () {
        $('#agreement').validate({
            errorPlacement: function( label, element ) {
                element.parent().parent().append( '<br>');
                element.parent().parent().append( label);

            },
            rules: {
                agreement1: {
                    required: true
                },
                agreement2: {
                    required: true
                }
            }
        });
    });
</script>
