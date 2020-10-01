<%--
  Created by IntelliJ IDEA.
  User: 周
  Date: 2020/6/17
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>

</head>

<body>
<div class="footer">
    <span>仅供学习交流，请勿用于任何商业用途</span>
    <i>版权所有 2014 uimaker.com</i>
</div>
</body>
</html>
