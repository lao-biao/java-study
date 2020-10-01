<%--
  Created by IntelliJ IDEA.
  User: 周
  Date: 2020/6/28
  Time: 15:48
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
    <title>文件上传</title>
</head>
<body>
<h3>单文件上传</h3>
<form action="upload" method="post" enctype="multipart/form-data">
    用户名:<input type="text" name="uname"><br>
    文件:<input type="file" name="file"><br>
    <input type="submit" value="submit">
</form>
<hr>
<h3>多文件上传</h3>
<form action="upload-multiply" method="post" enctype="multipart/form-data">
    用户名:<input type="text" name="uname"><br>
    文件1:<input type="file" name="file"><br>
    文件2:<input type="file" name="file"><br>
    <input type="submit" value="submit">
</form>
</body>
</html>
