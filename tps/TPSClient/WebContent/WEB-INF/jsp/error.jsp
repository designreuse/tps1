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

            <!-- header html -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Error!!!</h1>
                </div>
            </div>

            <!-- form html-->
            <div class="row">
                <div class="col-lg-12">
                    <div role="alert"
                         class="alert alert-danger alert-dismissible fade in">
                        <button aria-label="Close" data-dismiss="alert" class="close"
                                type="button">
                            <span aria-hidden="true">×</span>
                        </button>
                        <h4>Sorry! You got an error!</h4>

                        <c:if test="${errorMessage!=null }">

                            <p>${errorMessage}</p>

                        </c:if>

                        <p></p>
                    </div>

                </div>
                <div class="redirect">

                    <a href="${pageContext.request.contextPath}" class="btn btn-success"><i class="fa fa-home"></i>
                        Back to home</a>

                </div>


            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/includes/script.jsp" %>


</body>
</html>