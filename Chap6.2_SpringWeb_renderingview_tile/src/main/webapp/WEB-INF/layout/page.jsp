<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ page session="false" %>
<%--这个模版设定了页面布局--%>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet"
          type="text/css"
          href="<s:url value="/resources/style.css" />">
</head>
<body>
<div id="header">
    <%--header位置等待插入的tile块名为header--%>
    <t:insertAttribute name="header"/>
</div>
<div id="content">
    <%--content位置等待插入的tile块名为body--%>
    <t:insertAttribute name="body"/>
</div>
<div id="footer">
    <%--footer位置等待插入的tile块名为footer--%>
    <t:insertAttribute name="footer"/>
</div>
</body>
</html>
