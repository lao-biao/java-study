<%--
  User: 周
  Date: 2020/6/28
  Time: 20:37
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>简单映射异常处理</title>
</head>
<body>
<h3>默认异常处理！</h3>
</body>
</html>
