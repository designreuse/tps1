<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%--<% session.setAttribute("userName", "ganga"); %>--%>
<%--<% session.setAttribute("role", "Admin"); %>--%>

<%

    Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
    System.out.println(authentication);
    if(authentication!=null){
        session.setAttribute("role",authentication.getAuthorities());
        session.setAttribute("userName", authentication.getName());
    }

    /*System.out.println("ganga "+authentication);
    System.out.println(authentication.getAuthorities());*/

//    session.setAttribute("userName", authentication.h);
%>
<c:if test="${sessionScope.userDetailId==null}"><% session.setAttribute("userDetailId", "18"); %></c:if>

<%--<c:if test="${sessionScope.hotelDetailId==null}"><% session.setAttribute("hotelDetailId", "1"); %></c:if>--%>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/tp-icon/tpicon.css" rel="stylesheet">

<!-- Sweet Alert -->
<link href="${pageContext.request.contextPath}/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">

<!-- Toastr style -->
<link href="${pageContext.request.contextPath}/css/plugins/toastr/toastr.min.css" rel="stylesheet">

<%--Data Table--%>
<link href="${pageContext.request.contextPath}/css/plugins/dataTables/datatables.min.css" rel="stylesheet">

<link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">

<c:forEach items="${siteContent.css}" var="css">
    <link href="${pageContext.request.contextPath}/css/plugins/${css}" rel="stylesheet">
    <%--<script src="${pageContext.request.contextPath}/css/plugins/${css}"></script>--%>
</c:forEach>


    