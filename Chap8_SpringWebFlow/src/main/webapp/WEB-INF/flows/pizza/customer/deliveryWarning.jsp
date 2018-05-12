<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Spring Pizza</title></head>

<body>
<h2>Delivery Unavailable</h2>

<p>The address is outside of our delivery area. The order
    may still be taken for carry-out.</p>
<%--flowExecutionUrl是当前的流程执行url，类似于http://localhost:8880/pizza?execution=e3s2，尾部的参数标识一个会话--%>
<%--同提交按钮会触发事件一样，_eventId会在用户在视图上点击链接后触发相应的事件，如&_eventId=accept事件名是accept--%>
<a href="${flowExecutionUrl}&_eventId=accept">Accept</a> |
<a href="${flowExecutionUrl}&_eventId=cancel">Cancel</a>
</body>
</html>