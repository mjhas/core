<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
require.config({
    //By default load any module IDs from js/lib
    baseUrl: '<spring:url value="/" />',
    paths: {
        domReady: 'core-resources/require/domReady',
    <c:forEach var="js" items="${jsStack}">
        <c:forEach var="provide" items="${js.provides}">
        '${provide.name}' : '${js.requireUrl}',
        </c:forEach>
    </c:forEach>
    <c:forEach var="pageJs" items="${pageJsStack}">
        <c:forEach var="provide" items="${pageJs.provides}">
        '${provide.name}' : '${pageJs.requireUrl}',
        </c:forEach>
    </c:forEach>
    },
    shim: {
        <c:forEach var="js" items="${jsStack}">
            <c:forEach varStatus="provideStatus" var="provide" items="${js.provides}">
            '${provide.name}': {
                deps: [
                <c:forEach var="dependency" items="${js.dependencies}">
                    '${dependency.name}',
                </c:forEach>
                ],
                exports: '${js.provide}'
            },
            </c:forEach>
        </c:forEach>
        <c:forEach var="pageJs" items="${pageJsStack}">
            <c:forEach varStatus="provideStatus" var="provide" items="${pageJs.provides}">
            '${provide.name}': {
                deps: [
                <c:forEach var="dependency" items="${pageJs.dependencies}">
                    '${dependency.name}',
                </c:forEach>
                ],
                exports: '${pageJs.provide}'
            },
            </c:forEach>
        </c:forEach>
    }
});
    <c:set var="emptyAngularModuleList" scope="request" value="" />
    <c:set var="requireString" value="" />
    <c:forEach var="js" items="${jsStack}">
       <c:if test="${not empty js.angularModuleName}">
       <c:set var="requireString" value="${requireString},'${js.provide}'" />
       </c:if>
    </c:forEach>   
    <c:forEach var="js" items="${pageJsStack}">
       <c:if test="${not empty js.angularModuleName}">
       <c:set var="requireString" value="${requireString},'${js.provide}'" />
       </c:if>
    </c:forEach>   
    
    require(['angular','domReady'${requireString}],function(angular,domReady){
        domReady(function(){
          angular.bootstrap(document, [ 
<c:forEach var="js" items="${jsStack}"><c:if test="${not empty js.angularModuleName}"><c:if test="${not empty emptyAngularModuleList}">,</c:if>'${js.angularModuleName}'<c:set var="emptyAngularModuleList" scope="request" value="1" /></c:if> </c:forEach>
<c:forEach var="js" items="${pageJsStack}"><c:if test="${not empty js.angularModuleName}"><c:if test="${not empty emptyAngularModuleList}">,</c:if>'${js.angularModuleName}'<c:set var="emptyAngularModuleList" scope="request" value="1" /></c:if> </c:forEach>
          ]);
        });
    });
