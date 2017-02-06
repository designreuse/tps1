<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 5/10/2016
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tax</title>
</head>
<body>
<form>
    <div class="form-group"><label class="col-sm-2 control-label">Tax</label>

        <div class="col-sm-3">
            <input type="text" class="form-control hotelPhone" placeholder="Phone Number" name="hotelPhNo1"
                   value="${hotelDetailMap.hotelPhNo1}" required></div>
        <%--<input type="text" class="form-control"
                                 placeholder="Star Rating" name="starRating"
                                 value="${hotelDetailMap.starRating}"></div>--%>
    </div>
    <div class="hr-line-dashed"></div>
</form>
</body>
</html>
