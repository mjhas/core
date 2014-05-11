<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<!doctype html>
<html xmlns:ng="http://angularjs.org">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:choose>
        <c:when test="${empty pageTitle}">
            <spring:message code="core.pageTitle" />
        </c:when>
        <c:otherwise>
            <spring:message code="${pageTitle}" />
        </c:otherwise>
    </c:choose></title>
<c:forEach var="css" items="${cssStack}">
    <link rel="stylesheet" href="<spring:url value="${css.url}" />" />
</c:forEach>
<script data-main="core/main.js" src="<spring:url value="/core-resources/require/require.js" />"></script>
<%-- <c:forEach var="js" items="${jsStack}">
    <!-- ${js.angularModuleName} -->
    <script src="<spring:url value="${js.url}" />"></script>
</c:forEach> --%>
<c:forEach var="css" items="${pageCssStack}">
    <link rel="stylesheet" href="<spring:url value="${css.url}" />" />
</c:forEach>
<%-- <c:forEach var="js" items="${pageJsStack}"> --%>
<%--     ${js.angularModuleName} --%>
<%--     <script src="<spring:url value="${js.url}" />"></script> --%>
<%-- </c:forEach> --%>
</head>
<body>
    <nav id="navigation" class="navbar navbar-default" role="navigation" ng-controller="coreMenuController">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<spring:url value="/" />">Home</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <c:forEach var="menu" items="${menuList}">
                    <c:choose>
                        <c:when test="${fn:length(menu.subMenu) == 0}">
                            <li><a href="<spring:url value="/" />${menu.url}"><spring:message code="${menu.key}" /></a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="dropdown"><a href="#" class="dropdown-toggle"><spring:message code="${menu.key}" /> <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <c:forEach var="subMenu" items="${menu.subMenu}">
                                        <li><a href="<spring:url value="/" />${subMenu.url}"><spring:message code="${subMenu.key}" /></a></li>
                                    </c:forEach>
                                </ul></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </ul>
            <c:if test="${navbarRight}">
                <ul class="nav navbar-nav navbar-right">
                    <c:if test="${languageSwitch}">
                        <li class="dropdown"><a href="#" class="dropdown-toggle">Language <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="<spring:url value="" />?lang=de">Deutsch</a></li>
                                <li class="divider"></li>
                                <li><a href="<spring:url value="" />?lang=en">English</a></li>
                            </ul></li>
                    </c:if>
                    <c:if test="${loginLogoutSwitch}">
                        <li><a href="#">Login Logout</a></li>
                    </c:if>
                </ul>
            </c:if>
        </div>
        <!-- /.navbar-collapse -->
    </nav>


    <div class="container">
        <c:choose>
            <c:when test="${ page != null }">
                <jsp:include page="${page}" />
            </c:when>
            <c:otherwise>
                <c:if test="${ redirect != null }">
                    <c:redirect url="${redirect}" />
                </c:if>
            </c:otherwise>
        </c:choose>
    </div>
    <script type="text/javascript">
					
				</script>
</body>
</html>