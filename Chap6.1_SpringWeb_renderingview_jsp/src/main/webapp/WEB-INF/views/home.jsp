<%--使用javax.servlet标准定义的jstl(java server tag lib)标签库--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--使用spring定义的通用标签库--%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />">
</head>
<body>
<h1><s:message code="spitter.welcome" text="Welcome"/></h1>

<s:url value="/spitter/register" var="registerUrl"/>
<%--s:url会在渲染时在url前面加上context路径--%>
<a href="<s:url value="/spittles" />">Spittles</a> |
<a href="${registerUrl}">Register</a>

</body>
</html>
