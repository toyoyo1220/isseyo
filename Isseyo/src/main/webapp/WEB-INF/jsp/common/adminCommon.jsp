<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<jsp:useBean id="date" class="java.util.Date" />
<fmt:formatDate var="nowDay" value="${date}" pattern="yyyy-MM-dd"/>
<fmt:formatDate var="nowTime" value="${date}" pattern="HH:mm:ss"/>

<% pageContext.setAttribute("crlf", "\r\n"); %>

<c:set var="rootPath" value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}"/>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="contextPath" value="${rootPath}${path}"/>
<c:set var="uri" value="${requestScope['javax.servlet.forward.request_uri']}"/>

<c:set var="jspPath" value="/WEB-INF/jsp"/>

<%-- <c:set var="cssPath" value="${contextPath}/template/cms/admin/css"/>
<c:set var="jsPath" value="${contextPath}/template/cms/admin/js"/>
<c:set var="imagePath" value="${contextPath}/template/cms/admin/image"/> --%>