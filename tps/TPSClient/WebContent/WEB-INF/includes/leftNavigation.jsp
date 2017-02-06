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
                             </span> <span class="text-muted text-xs block">${sessionScope.userName}</span> </span> </a>
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
            <a href="#"> <i class="fa fa-th-large"></i> <span class="nav-label">${nav.parentMenuDesc}</span><span class="fa arrow"></span></a>
            <ul class="nav nav-second-level collapse">
                </c:if>
                <li <c:if test="${fn:contains(nav.menuUrl, base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}${nav.menuUrl}">${nav.menuDesc}</a></li>

            </c:if>



            </c:forEach>

            <%--<li>
                <a href="#"><i class="fa fa-user"></i> <span class="nav-label">Hotel Detail</span><span class="fa arrow"></span></a>
                <c:if test="${base==null}">
                    <c:set var="base" value="null"/>
                </c:if>
                <ul class="nav nav-second-level collapse">
                    <li <c:if test="${fn:contains('hotelDetail/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/hotelDetail/view">Hotel Detail</a></li>
                   <c:if test="${sessionScope.get('hotelDetailId') ne null}">
                       <li <c:if test="${fn:contains('hotelFeature/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/hotelFeature/view">Hotel Feature</a></li>
                       <li <c:if test="${fn:contains('roomDetail/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/roomDetail/view">Room</a></li>
                       <li <c:if test="${fn:contains('roomAmenity/view/', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/roomAmenity/view">Amenity</a></li>
                       <li <c:if test="${fn:contains('image/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/image/view">Photo</a></li>
                       <li <c:if test="${fn:contains('nearestArea/viewNearPlaces', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/nearestArea/viewNearPlaces">Near Areas</a></li>
                   </c:if>


                &lt;%&ndash;<li <c:if test="${fn:contains('paymentType/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/paymentType/view">Payment Option</a></li>&ndash;%&gt;
                    &lt;%&ndash;<li <c:if test="${fn:contains('nearestArea/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/nearestArea/view">Near By Area</a></li>&ndash;%&gt;
                    &lt;%&ndash;<li <c:if test="${fn:contains('image/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/image/view/1">Message Content</a></li>&ndash;%&gt;

                </ul>
            </li>
            <c:if test="${sessionScope.get('hotelDetailId') ne null}">
                <li>
                    <a href="#"><i class="fa fa-user"></i> <span class="nav-label">Charges</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                            &lt;%&ndash;<li><a href="${pageContext.request.contextPath}/roomDetail/roomRates">Room Rates</a></li>&ndash;%&gt;
                            &lt;%&ndash;<li <c:if test="${fn:contains('agent/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/agent/view">Taxes and Charges</a></li>&ndash;%&gt;
                        <li <c:if test="${fn:contains('offer/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/offer/view">Offers</a></li>
                    </ul>
                </li>

                <li>
                    <a href="#"><i class="fa fa-user"></i> <span class="nav-label">Policy and Rules</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li <c:if test="${fn:contains('cancellation/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/cancellation/view">Cancellation Rules</a></li>
                        <li <c:if test="${fn:contains('customRules/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/customRules/view">Custom Rules</a></li>
                        <li <c:if test="${fn:contains('hotelRules/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/hotelRules/view">Hotel Rules</a></li>
                        <li <c:if test="${fn:contains('roomImportance/view', base)}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/roomImportance/view">Room Importance</a></li>
                    </ul>
                </li>
            </c:if>--%>


           <%-- <li>
                <a href="#"><i class="fa fa-files-o"></i> <span class="nav-label">Reports</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="search_results.html">Search results</a></li>
                    <li><a href="lockscreen.html">Lockscreen</a></li>

                </ul>
            </li>--%>


<%--
       </li>
--%>
        </ul>
    </div>
</nav>

