<%

    if (session.getAttribute("userAccessId") == null) {

// 		http://localhost:8080/AtosView/response/receive

// 		System.out.println(http://localhost:8080/AtosView/response/receive);

        String redirect = request.getContextPath() + "/login/view";
        response.sendRedirect(redirect);
        return;
    }
%>




