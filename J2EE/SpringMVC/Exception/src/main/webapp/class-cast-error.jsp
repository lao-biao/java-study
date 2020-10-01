<%--
  Created by IntelliJ IDEA.
  User: 周
  Date: 2020/6/28
  Time: 20:39
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
    <title>简单映射异常处理</title>
</head>
<body>
<h3>类型转换异常</h3>
<hr>
${info}
</body>
</html>
