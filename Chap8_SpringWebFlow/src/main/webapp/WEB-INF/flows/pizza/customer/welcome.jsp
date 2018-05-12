<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head><title>Spring Pizza</title></head>

<body>
<h2>Welcome to Spring Pizza!!!</h2>

<form:form>
    <%--name="_flowExecutionKey"意味着这个input是一个流程执行key，其值是后台传出的flowExecutionKey
        在视图展示的时候流程会暂停，通过流程执行key来返回到流程中恢复流程执行--%>
    <%--这个flowExecutionKey其实就是URL：http://localhost:8880/pizza?execution=e3s2中的e3s2，用来标识一次会话--%>
    <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
    <input type="text" name="phoneNumber"/><br/>
    <%--name=_eventId_phoneEntered意味着这个submit提交是一个事件，提交后会触发事件，事件名是phoneEntered
        在流程里触发这个事件会流向相应的流程中--%>
    <input type="submit" name="_eventId_phoneEntered" value="Lookup Customer"/>
</form:form>
</body>
</html>