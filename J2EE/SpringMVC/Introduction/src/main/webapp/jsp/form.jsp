<%--
  Created by IntelliJ IDEA.
  User: 周
  Date: 2020/6/28
  Time: 11:35
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
    <title>测试获取集合类型参数</title>
</head>
<body>
<form action="paramset" method="post">
    unmae:<input type="text" name="lu[0].uname"><br>
    gender:<input type="text" name="lu[0].gender"><br>
    age:<input type="text" name="lu[0].age"><br>
    <hr>
    unmae:<input type="text" name="lu[1].uname"><br>
    gender:<input type="text" name="lu[1].gender"><br>
    age:<input type="text" name="lu[1].age"><br>
    <input type="submit" value="submit">
</form>

</body>
</html>
