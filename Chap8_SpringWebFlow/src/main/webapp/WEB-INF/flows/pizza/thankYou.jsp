<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head><title>Spring Pizza</title></head>

<body>
<h2>Thank you for your order!</h2>

<%--以下三种表达了视图中返回暂停的流程的几种方法--%>
<%--1. 使用name="_flowExecutionKey"的input元素将value=flowExecutionKey参数传回暂停的流程来恢复它
        使用name="_eventId_EVENT"的submit提交动作来在流程中触发EVENT事件--%>
<form:form>
    <input type="hidden" name="_flowExecutionKey"
           value="${flowExecutionKey}"/>
    <input type="submit" name="_eventId_finished" value="Finished"/>
</form:form>

<%--2. 使用name="_flowExecutionKey"的input元素将flowExecutionKey参数传回暂停的流程来恢复它
        使用name="_eventId_EVENT"的input元素将value=EVENT参数传回在流程中触发EVENT事件--%>
<form:form>
    <input type="hidden" name="_flowExecutionKey"
           value="${flowExecutionKey}"/>
    <input type="hidden" name="_eventId"
           value="finished"/>
    <input type="submit" value="Finished"/>
</form:form>

<%--3. 使用href='${flowExecutionUrl}&_eventId=EVENT'的超链接同时恢复暂停的流程和触发EVENT事件--%>
<a href='${flowExecutionUrl}&_eventId=finished'>Finish</a>

--%>

</body>
</html>