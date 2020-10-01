<%--
  Created by IntelliJ IDEA.
  User: 周
  Date: 2020/6/28
  Time: 13:07
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
    <meta charset="UTF-8">
    <title>Ajax</title>
    <script src="js/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        var userList = [];
        userList.push({uname: "张三", gender: "Male", age: 19});
        userList.push({uname: "李四", gender: "Female", age: 20});

        $.ajax({
            type: "POST",
            url: "paramajax",
            data: JSON.stringify(userList),
            contentType: "application/json;charset=utf-8"
        })
    </script>
</head>

<body>

</body>
</html>
