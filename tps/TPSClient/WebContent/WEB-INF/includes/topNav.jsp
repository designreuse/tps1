<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 3/15/2016
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>


<div class="row border-bottom">
    <nav class="navbar navbar-static-top white-bg" role="navigation" style="margin-bottom: 0">


        <ul class="nav navbar-nav">
           <%-- <li>
                <span class="m-r-sm text-muted welcome-message">${sessionScope.hotelName}</span>
            </li>--%>

               <c:set value="0" var="parentMenuId"/>
               <c:set value="F" var="Flag"/>
               <c:forEach var="topNav" items="${topNav}">

               <c:set var="parentMenu" value="${topNav.parentMenuId}"/>

               <c:if test="${(parentMenu ne parentMenuId) && (Flag eq 'T')}">
               <c:set value="F" var="Flag"/>
        </ul>
        </li>
        </c:if>

        <c:if test="${(parentMenu ne parentMenuId) && (topNav.level eq 4)}">
        <c:set value="${topNav.parentMenuId}" var="parentMenuId"/>
        <c:set value="T" var="Flag"/>
        <li class="dropdown">
            <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> ${topNav.parentMenuDesc} <span class="caret"></span></a>
            <ul role="menu" class="dropdown-menu">
                </c:if>
                <c:if test="${(topNav.menuUrl ne null)}">
                    <li <c:if test="${fn:contains(topNav.menuUrl, base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}${topNav.menuUrl}">${topNav.menuDesc}</a></li>
                </c:if>


                </c:forEach>
                    </ul></li>

               <%--<li>
                   <a aria-expanded="false" role="button" href="${pageContext.request.contextPath}/hotelDetail/edit/${sessionScope.get('hotelDetailId')}"> Hotel Detail</a>
               </li>
               <li>
                   <a aria-expanded="false" role="button" href="${pageContext.request.contextPath}/hotelFeature/view"> Hotel Feature</a>
               </li>
               <li>
                   <a aria-expanded="false" role="button" href="${pageContext.request.contextPath}/roomDetail/view"> Room Detail</a>
               </li>
               <li>
                   <a aria-expanded="false" role="button" href="${pageContext.request.contextPath}/roomAmenity/view"> Room Amenity</a>
               </li>
               <li>
                   <a aria-expanded="false" role="button" href="${pageContext.request.contextPath}/image/view"> Photo</a>
               </li>
            <li class="dropdown">
                <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> Charges <span class="caret"></span></a>
                <ul role="menu" class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/offer/view">Offer</a></li>
                </ul>
            </li>
               <li class="dropdown">
                   <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> Policy and Rules <span class="caret"></span></a>
                   <ul role="menu" class="dropdown-menu">
                       <li><a href="${pageContext.request.contextPath}/cancellation/view">Cancellation Rules</a></li>
                       <li><a href="${pageContext.request.contextPath}/customeRules/view">Custom Rules</a></li>
                       <li><a href="${pageContext.request.contextPath}/hotelRules/view">Hotel Rules</a></li>
                       <li><a href="${pageContext.request.contextPath}/roomImportance/view">Room Importance</a></li>
                   </ul>
               </li>--%>
           <%-- <li class="dropdown">
                <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                    <i class="fa fa-envelope"></i>  <span class="label label-warning">16</span>
                </a>
                <ul class="dropdown-menu dropdown-messages">
                    <li>
                        <div class="dropdown-messages-box">
                            <a href="profile.html" class="pull-left">
                                <img alt="image" class="img-circle" src="img/a7.jpg">
                            </a>
                            <div>
                                <small class="pull-right">46h ago</small>
                                <strong>Mike Loreipsum</strong> started following <strong>Monica Smith</strong>. <br>
                                <small class="text-muted">3 days ago at 7:58 pm - 10.06.2014</small>
                            </div>
                        </div>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <div class="dropdown-messages-box">
                            <a href="profile.html" class="pull-left">
                                <img alt="image" class="img-circle" src="img/a4.jpg">
                            </a>
                            <div>
                                <small class="pull-right text-navy">5h ago</small>
                                <strong>Chris Johnatan Overtunk</strong> started following <strong>Monica Smith</strong>. <br>
                                <small class="text-muted">Yesterday 1:21 pm - 11.06.2014</small>
                            </div>
                        </div>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <div class="dropdown-messages-box">
                            <a href="profile.html" class="pull-left">
                                <img alt="image" class="img-circle" src="img/profile.jpg">
                            </a>
                            <div>
                                <small class="pull-right">23h ago</small>
                                <strong>Monica Smith</strong> love <strong>Kim Smith</strong>. <br>
                                <small class="text-muted">2 days ago at 2:30 am - 11.06.2014</small>
                            </div>
                        </div>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <div class="text-center link-block">
                            <a href="mailbox.html">
                                <i class="fa fa-envelope"></i> <strong>Read All Messages</strong>
                            </a>
                        </div>
                    </li>
                </ul>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                    <i class="fa fa-bell"></i>  <span class="label label-primary">8</span>
                </a>
                <ul class="dropdown-menu dropdown-alerts">
                    <li>
                        <a href="mailbox.html">
                            <div>
                                <i class="fa fa-envelope fa-fw"></i> You have 16 messages
                                <span class="pull-right text-muted small">4 minutes ago</span>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="profile.html">
                            <div>
                                <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                <span class="pull-right text-muted small">12 minutes ago</span>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="grid_options.html">
                            <div>
                                <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                <span class="pull-right text-muted small">4 minutes ago</span>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <div class="text-center link-block">
                            <a href="notifications.html">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </div>
                    </li>
                </ul>
            </li>--%>


        <li><a class="preview-hotel" data-id="${sessionScope.get('hotelDetailId')}" data-page="">Preview</a></li>
        </ul>
        <ul class="nav navbar-top-links navbar-right">
            <li>
                <a href="${pageContext.request.contextPath}/logout">
                    <i class="fa fa-sign-out"></i> Log out
                </a>
            </li>
        </ul>

    </nav>
</div>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-8">
        <h1 class="hotelName"><span class="text-muted text-xs block">${sessionScope.hotelName}</span></h1>
        <h2 class="page-title"></h2>

        <%--<ol class="breadcrumb">
            <li>
                ${sessionScope.hotelName}
            </li>
            <li class="active page-title">
            </li>
        </ol>
--%>
    </div>
</div>
