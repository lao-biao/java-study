<%--
  Created by IntelliJ IDEA.
  User: 周
  Date: 2020/6/28
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Interceptor</title>
</head>
<body>
<h3>SpringMVC拦截器</h3>
<i>Hello,${unmae}</i>
</body>
</html>
