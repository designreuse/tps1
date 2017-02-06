<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 4/11/2016
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/includes/header.jsp" %>

<div class="middle-box text-center loginscreen animated fadeInDown">
    <div>
        <div>

            <h1 class="logo-name"></h1>

        </div>
        <h3>Welcome to Travel Protal System</h3>
       <%-- <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
            <font color="red">
                Your login attempt was not successful due to <br/><br/>
                <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
            </font>
        </c:if>--%>

        <%--<c:if test="${not empty sessionScope.SPRING_SECURITY_LAST_EXCEPTION}">
            <div class="error">
                Your login attempt was not successful, try again.<br />
                Reason: ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
            </div>
        </c:if>--%>

        <form class="m-t" role="form" name='loginForm' action="<c:url value='/j_spring_security_check' />" method="post" id="loginForm">
        <%--<form class="m-t" role="form" name='loginForm' action="j_spring_security_check" method="post">--%>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Email Address" required="" name="j_username" id="userName">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="Password" required="" name="j_password" id="password">
            </div>

            <%--<input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />--%>
            <button type="submit" class="btn btn-primary block full-width m-b">Login</button>

          <%--  <a href="#"><small>Forgot password?</small></a>
            <p class="text-muted text-center"><small>Do not have an account?</small></p>
            <a class="btn btn-sm btn-white btn-block" href="register.html">Create an account</a>--%>
        </form>

    </div>
</div>
<%@include file="/WEB-INF/includes/script.jsp" %>
<script type="text/javascript">
   <c:if test="${SPRING_SECURITY_LAST_EXCEPTION.message=='Bad credentials'}">
    toastr.error('Invalid UserName or Password');
    </c:if>

    <c:if test="${responseMsg!=null && status==null}">
    toastr.info('${responseMsg}');
    </c:if>

    var sessionTokenValue= "${sessionScope.get('token')}";
    if(sessionTokenValue!=''){
        $("#loginForm").hide();
        $("#userName").val("register");
        $("#password").val("register");
        $("#loginForm").submit();
    }

</script>
<h1>${test}</h1>


</body>
</html>
