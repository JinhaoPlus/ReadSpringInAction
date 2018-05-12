<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head><title>Spring Pizza</title></head>

<body>
<h2>Customer Registration</h2>

<%--commandName和path用于页面元素和model中的对象的双向绑定，可以在表单中填充字段使用mode中对象的属性，同时又可以把填入表单的值反馈到model中的对象中--%>
<form:form commandName="order">
    <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>

    <b>Phone number: </b><form:input path="customer.phoneNumber"/><br/>
    <b>Name: </b><form:input path="customer.name"/><br/>
    <b>Address: </b><form:input path="customer.address"/><br/>
    <b>City: </b><form:input path="customer.city"/><br/>
    <b>State: </b><form:input path="customer.state"/><br/>
    <b>Zip Code: </b><form:input path="customer.zipCode"/><br/>
    <%--value="Submit"的按钮会触发名为submit的事件--%>
    <input type="submit" name="_eventId_submit" value="Submit"/>
    <%--value="Cancel"的按钮会触发名为cancel的事件--%>
    <input type="submit" name="_eventId_cancel" value="Cancel"/>
</form:form>
</body>
</html>