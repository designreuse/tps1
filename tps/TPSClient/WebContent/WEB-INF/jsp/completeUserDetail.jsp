<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 5/13/2016
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/includes/header.jsp" %>

<div id="wrapper">
    <%--<%@include file="/WEB-INF/includes/adminLeftNavigation.jsp" %>--%>
    <div id="page-wrapper" class="gray-bg">
        <%@include file="/WEB-INF/includes/topNavigation.jsp" %>

        <div class="wrapper wrapper-content animated fadeIn">
                <div class="p-w-md m-t-sm">
                    <div class="row update-form">
                        <div> Before Proceeding Please Filled the Form</div>
                        <form id="form1" class="form-horizontal" method="post" action="">

                            <input type="hidden" name="userDetailId" value="${sessionScope.get('userDetailId')}">



                            <div class="form-group"><label class="col-sm-2 control-label">Address</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Address" id="address" name="address"
                                                             value="${userDetailMap.address}" required></div>
                            </div>

                            <div class="form-group"><label class="col-sm-2 control-label">Phone No.</label>

                                <div class="col-sm-3"><input type="text" class="form-control"
                                                             placeholder="Phone No." id="phoneNo" name="phoneNo"
                                                             value="${userDetailMap.phoneNo}" required></div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button type="submit" class="btn btn-primary">Save changes</button>
                                </div>
                            </div>


                        </form>

                    </div>
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

        jQuery.validator.addMethod("phoneNumber", function(value, element) {
            // return true - means the field passed validation
            // return false - means the field failed validation and it triggers the error
            // 		    return this.optional(element) || /^\+?([0-9]{1,4})\)?[-. ]?([0-9]{7,14})$/.test(value);
            return this.optional(element)
                    || /^\+?([0-9-\s]){7,19}$/.test(value);
        }, "Please enter valid phone number");


        $('#form1').validate({
            rules: {

                address:{
                    required: true
                },
                phoneNo:{
                    required: true,
                    phoneNumber: true
                }

            }
        });
    });
</script>

</body>
</html>