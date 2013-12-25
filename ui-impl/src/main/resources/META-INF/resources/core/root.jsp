<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html xmlns:ng="http://angularjs.org">
<head>
<meta charset="utf-8">
<title>Core App</title>
<script src="<spring:url value="/core-javascript/javascript/" />angular.min.js"></script>
<script src="<spring:url value="/core-javascript/javascript/" />jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="<spring:url value="/" />bootstrap/css/bootstrap.min.css" />

<!-- Latest compiled and minified JavaScript -->
<script src="<spring:url value="/" />bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
    <nav class="navbar navbar-default" role="navigation">
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
                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><spring:message code="${menu.key}" /> <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <c:forEach var="subMenu" items="${menu.subMenu}">
                                        <li><a href="<spring:url value="/" />${subMenu.url}"><spring:message code="${subMenu.key}" /></a></li>
                                    </c:forEach>
                                </ul></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Language <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="<spring:url value="" />?lang=de">Deutsch</a></li>
                        <li class="divider"></li>
                        <li><a href="<spring:url value="" />?lang=en">English</a></li>
                    </ul></li>
                <li><a href="#">Login Logout</a></li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>
    <div class="container">
        <c:if test="${ page != null }">
            <jsp:include page="${page}" />
        </c:if>
    </div>
</body>
</html>