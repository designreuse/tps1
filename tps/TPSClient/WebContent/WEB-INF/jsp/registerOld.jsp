<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 4/11/2016
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="igc.tech.com.security.CaptchaServlet" %>
<%


    CaptchaServlet.generateToken(session);
%>
<!DOCTYPE html>
<html>
<head>
    <title>login</title>
    <%@include file="/WEB-INF/includes/styling.jsp" %>
    <!-- Toastr style -->
    <link href="css/plugins/toastr/toastr.min.css" rel="stylesheet">

</head>
<body class="gray-bg">
<%--<%  if (showGoodResult) {%>
<h1 style="color: green;">Your kung fu is good!</h1>
<%  } else if (showBadResultt) {%>
<h1 style="color: red;">This is not right. Try again!</h1>
<%  } %>--%>

<c:if test="${hotelDetailList!=null}">
    <div class="modal inmodal fade" id="myModal" tabindex="-1" role="dialog"  aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <%--<h4 class="modal-title">Modal title</h4>--%>
                </div>
                <div class="modal-body">

                    <p>Continue with existing Information</p>
                    <c:forEach var="hotelDetail" items="${hotelDetailList}">
                        <a href="getToken/${hotelDetail.tokenId}"><button type="button" class="btn btn-primary">${hotelDetail.hotelName}</button></a>

                    </c:forEach>



                </div>
                <div class="modal-footer">
                    <form method="post" action="registration">
                        <input type="hidden" name="hotelName" value="${hotelDetailMap.hotelName}">
                        <input type="hidden" name="tokenId" value="${hotelDetailMap.tokenId}">
                        <input type="hidden" name="userDetailId" value="${userDetailMap.userDetailId}">
                        <button type="submit" class="btn btn-primary" >Create New Hotel</button>
                    </form>

                </div>
            </div>
        </div>
    </div>
</c:if>


<div class="loginColumns animated fadeInDown">
    <div class="row">

        <%--<div class="row">
            <form action="" method="post">
                <input name="captcha" type="text" autocomplete="off" />
                <input type="submit" />
            </form>
            <img alt="captcha image" src="captcha" />
        </div>--%>

        <%--<div class="col-md-6">
            <h2 class="font-bold">Welcome to IN+</h2>

            <p>
                Perfectly designed and precisely prepared admin theme with over 50 pages with extra new web app views.
            </p>

            <p>
                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.
            </p>

            <p>
                When an unknown printer took a galley of type and scrambled it to make a type specimen book.
            </p>

            <p>
                <small>It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</small>
            </p>

        </div>--%>
        <div class="col-md-6">
            <div class="ibox-content">
                <c:out value="${message}"/>
                <form class="m-t" role="form" action="registration" method="post" id="signUp">
                    <div class="form-group">
                        <label class="control-label">Property Name</label>
                        <input type="text" class="form-control" placeholder="Property Name" required="" name="hotelName">
                    </div>
                    <div class="form-group">
                        <label class="control-label">Property Type</label>
                        <input type="text" class="form-control" placeholder="Property Type" required="" name="hotelName">
                    </div>
                    <div class="form-group">
                        <label class="control-label">Name</label>
                        <input type="text" class="form-control" placeholder="Name" required="" name="name">
                    </div>
                    <div class="form-group">
                        <label class="control-label">Email</label>
                        <input type="email" class="form-control" placeholder="Email" required="" name="emailId">
                    </div>
                    <div class="form-group">
                        <label class="control-label">Captcha</label>
                        <input type="text" class="form-control" placeholder="Enter the text on image" required="" id="captcha" name="captcha">
                        <div>
                            <img alt="captcha image" src="captcha" />
                            <button id="refresh" onclick="Captcha();"><i class="fa fa-refresh"></i> </button>
                        </div>

                    </div>

                    <%--<div> <img id="captcha_id" name="imgCaptcha" src="captcha">
                        <a href="javascript:;"
                           title="change captcha text"
                           onclick="document.getElementById('captcha_id').src = 'captcha?' + Math.random();  return false">
                            <i class="fa fa-refresh"></i></a>
                    </div>
                    <div>
                        <input type="text" class="form-control" required="" name="formCaptcha" id="txtInput" placeholder="Enter the Text">
                    </div>--%>
                    <%--<div><input type="text" id="mainCaptcha"/>
                        <button id="refresh" onclick="Captcha();"><i class="fa fa-refresh"></i> </button></div>
                        &lt;%&ndash;<input type="button" id="refresh" value="Refresh"  /></div>&ndash;%&gt;
                    <div class="form-group"><label class="control-label">Captcha</label>

                        <input type="text" class="form-control" required=""  id="txtInput" placeholder="Enter the Text">
                    </div>
--%>
                    <button type="submit" class="btn btn-primary block full-width m-b">Get Started</button>




                </form>

            </div>
        </div>
    </div>
    <hr/>
    <div class="row">
        <div class="col-md-6">
            Copyright IGC
        </div>
        <div class="col-md-6 text-right">
            <small>© 2014-2015</small>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/includes/script.jsp" %>
<!-- Toastr script -->
<script src="js/plugins/toastr/toastr.min.js"></script>
<script type="text/javascript">
    <c:if test="${responseMsg!=null}">
    toastr.info('${responseMsg}');
    </c:if>

    $(window).load(function () {
        <c:if test="${hotelDetailList!=null}">
        $('#myModal').modal('show');
        </c:if>
    });

    $("#refresh").click(function () {
        <%
    CaptchaServlet.generateToken(session);
%>
    });

    $("#signUp").submit(function(e){
        var captcha = $('#captcha').val();
        $.ajax({
            method: "POST",
            url: "captchaValidation",
            data: { captcha: captcha},
            dataType: "json",
            success: function(data){

                console.log(data);
                if(data!=true){
                    e.preventDefault();
                }

            }
        });

    });
</script>

<%--<script type="text/javascript">
    Captcha();
    function Captcha(){
        var alpha = new Array('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
        var i;
        for (i=0;i<6;i++){
            var a = alpha[Math.floor(Math.random() * alpha.length)];
            var b = alpha[Math.floor(Math.random() * alpha.length)];
            var c = alpha[Math.floor(Math.random() * alpha.length)];
            var d = alpha[Math.floor(Math.random() * alpha.length)];
            var e = alpha[Math.floor(Math.random() * alpha.length)];
            var f = alpha[Math.floor(Math.random() * alpha.length)];
            var g = alpha[Math.floor(Math.random() * alpha.length)];
        }
        var code = a + ' ' + b + ' ' + ' ' + c + ' ' + d + ' ' + e + ' '+ f + ' ' + g;
        document.getElementById("mainCaptcha").value = code
    }
    function ValidCaptcha(){
        var string1 = removeSpaces(document.getElementById('mainCaptcha').value);
        var string2 = removeSpaces(document.getElementById('txtInput').value);
        if (string1 == string2){
            return true;
        }
        else{
            return false;
        }
    }
    function removeSpaces(string){
        return string.split(' ').join('');
    }

    $("#signUp").submit(function(){
        ValidCaptcha();
    });
</script>--%>
</body>
</html>
