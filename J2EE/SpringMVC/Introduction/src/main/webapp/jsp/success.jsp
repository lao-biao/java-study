<%--
  Created by IntelliJ IDEA.
  User: 周
  Date: 2020/6/27
  Time: 13:58
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
    <title>Success</title>
</head>
<body>
<h3>跳转成功</h3>
<b>${username}</b>
</body>
</html>
