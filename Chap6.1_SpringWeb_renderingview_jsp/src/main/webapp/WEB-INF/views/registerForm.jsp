<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--使用spring定义的表单标签库--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style.css" />">
</head>
<body>
<h1>Register</h1>
<%--commandName和path的作用是如下的双向绑定--%>
<%--表单标签库在渲染页面元素的同时会将commandName指定的model中对象的同名属性填充到表单中去--%>
<%--path中的属性字段会在渲染时填充到表单元素的model对象的同名属性中去--%>
<sf:form method="POST" commandName="spitter">
    <%--将所有path的属性的校验错误提示都集中展示到一个div中去，设置错误提示的样式为.errors--%>
    <sf:errors path="*" element="div" cssClass="errors"/>
    <%--label的path虽然不能设置value，但是绑定了属性之后就可以在校验错误的时候通过cssErrorClass展示错误样式了--%>
    <sf:label path="firstName"
              cssErrorClass="error">First Name</sf:label>:
    <%--path="firstName"会将spitter中的firstName渲染到input的value中去--%>
    <sf:input path="firstName" cssErrorClass="error"/><br/>
    <sf:label path="lastName"
              cssErrorClass="error">Last Name</sf:label>:
    <sf:input path="lastName" cssErrorClass="error"/><br/>
    <sf:label path="email"
              cssErrorClass="error">Email</sf:label>:
    <sf:input path="email" cssErrorClass="error"/><br/>
    <sf:label path="username"
              cssErrorClass="error">Username</sf:label>:
    <sf:input path="username" cssErrorClass="error"/><br/>
    <sf:label path="password"
              cssErrorClass="error">Password</sf:label>:
    <sf:password path="password" cssErrorClass="error"/><br/>
    <input type="submit" value="Register"/>
</sf:form>
</body>
</html>
