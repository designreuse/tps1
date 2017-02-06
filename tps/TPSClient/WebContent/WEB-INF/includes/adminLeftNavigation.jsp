<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 3/15/2016
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav metismenu" id="side-menu">
            <li class="nav-header">
                <div class="dropdown profile-element"> <span>
                             </span>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                           <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">Travle Portal System</strong>
                             </span><span class="text-muted text-xs block">${sessionScope.userName}</span>  </span> </a>
                    <%--<ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li><a href="profile.html">Profile</a></li>
                        <li><a href="contacts.html">Contacts</a></li>
                        <li><a href="mailbox.html">Mailbox</a></li>
                        <li class="divider"></li>
                        <li><a href="login.html">Logout</a></li>
                    </ul>--%>
                </div>

            </li>
            <li>
                <a href="${pageContext.request.contextPath}/"><i class="fa fa-th-large"></i>  <span class="nav-label">Dashboard</span></a>
            </li>
            <%--<li>
                <a href="index-2.html"><i class="fa fa-th-large"></i> <span class="nav-label">Dashboards</span> <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="index-2.html">Dashboard v.1</a></li>
                    <li><a href="dashboard_2.html">Dashboard v.2</a></li>
                    <li><a href="dashboard_3.html">Dashboard v.3</a></li>
                    <li><a href="dashboard_4_1.html">Dashboard v.4</a></li>
                    <li><a href="dashboard_5.html">Dashboard v.5 <span class="label label-primary pull-right">NEW</span></a></li>
                </ul>
            </li>--%>

            <c:set value="0" var="parentMenuId"/>
            <c:set value="F" var="Flag"/>
            <c:forEach var="nav" items="${nav}">

            <c:if test="${nav.parentMenuDesc ne 'Hotel List'}">
            <c:set var="parentMenu" value="${nav.parentMenuId}"/>

            <c:if test="${(parentMenu ne parentMenuId) && (Flag eq 'T')}">
            <c:set value="F" var="Flag"/>
        </ul>
        </li>
        </c:if>

        <c:if test="${parentMenu ne parentMenuId}">
        <li>
                <c:set value="${nav.parentMenuId}" var="parentMenuId"/>
                <c:set value="T" var="Flag"/>
            <a href="#"> <i class="fa fa-user"></i> <span class="nav-label">${nav.parentMenuDesc}</span><span class="fa arrow"></span></a>
            <ul class="nav nav-second-level collapse">
                </c:if>
                <li <c:if test="${fn:contains(nav.menuUrl, base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}${nav.menuUrl}">${nav.menuDesc}</a></li>

            </c:if>



                </c:forEach>

            <%--<li>
                <c:if test="${base==null}">
                    <c:set var="base" value="null"/>
                </c:if>
                <a href="#"><i class="fa fa-user"></i> <span class="nav-label">Admin View</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li <c:if test="${fn:contains('hotelDetail/', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/hotelDetail/">Hotel Detail</a></li>
                    <li <c:if test="${fn:contains('address/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/address/view">Address</a></li>
                    <li <c:if test="${fn:contains('activity/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/activity/view">Activity</a></li>
                    <li <c:if test="${fn:contains('amenity/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/amenity/view">Amenity</a></li>
                    <li <c:if test="${fn:contains('bedType/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/bedType/view">Bed Type</a></li>
                    <li <c:if test="${fn:contains('roomType/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/roomType/view">Room Type</a></li>
                    <li <c:if test="${fn:contains('rules/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/rules/view">Rules</a></li>
                    <li <c:if test="${fn:contains('priority/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/priority/view">Priority</a></li>
                    &lt;%&ndash;<li <c:if test="${fn:contains('roomAmenity/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/roomAmenity/view/1">Amenity</a></li>&ndash;%&gt;
                    &lt;%&ndash;<li <c:if test="${fn:contains('image/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/image/view/1">Photo</a></li>&ndash;%&gt;
                    &lt;%&ndash;<li <c:if test="${fn:contains('paymentType/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/paymentType/view">Payment Option</a></li>&ndash;%&gt;
                    &lt;%&ndash;<li <c:if test="${fn:contains('nearestArea/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/nearestArea/view">Near By Area</a></li>&ndash;%&gt;
                    &lt;%&ndash;<li <c:if test="${fn:contains('image/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/image/view/1">Message Content</a></li>&ndash;%&gt;

                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-user"></i> <span class="nav-label">Payment Config</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li <c:if test="${fn:contains('esewaConfig/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/esewaConfig/view">Esewa Configuration</a></li>
                    <li <c:if test="${fn:contains('niblConfig/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/niblConfig/view">NIBL Configuration</a></li>
                    <li <c:if test="${fn:contains('npayConfig/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/npayConfig/view">NPay Configuration</a></li>
                    <li <c:if test="${fn:contains('payGateAccess/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/payGateAccess/view">Payment Gateway Access</a></li>
                </ul>
            </li>

            <li>
                <a href="#"><i class="fa fa-user"></i> <span class="nav-label">User Info</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li <c:if test="${fn:contains('role/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/role/view">Role</a></li>
                    <li <c:if test="${fn:contains('userDetail/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/userDetail/view">User Detail</a></li>
                    <li <c:if test="${fn:contains('menuAccess/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/menuAccess/view">Menu Access</a></li>
                    &lt;%&ndash;<li <c:if test="${fn:contains('changePassword/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/changePassword/view">Change Password</a></li>&ndash;%&gt;
                    <li <c:if test="${fn:contains('emailTps/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/emailTps/view">Email Address</a></li>
                    <li <c:if test="${fn:contains('mailServerSetting/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/mailServerSetting/view">Mail Server Setting</a></li>
                </ul>
            </li>--%>



<%--
       </li>
--%>
        </ul>

    </div>
</nav>

