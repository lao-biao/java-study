<%--
  author: 周
  date: 2020/6/30 10:31
  description:  
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>账户添加页面</title>
</head>
<body>
<h3>添加账户信息表单</h3>
<form name="accountForm" action="/account/save" method="post">
    账户名称:<input type="text" name="uname"><br>
    账户金额:<input type="text" name="money"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
