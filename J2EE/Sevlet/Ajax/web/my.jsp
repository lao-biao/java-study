<%--
  Created by IntelliJ IDEA.
  User: 周
  Date: 2020/6/18
  Time: 8:48
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
    <title>Ajax</title>

    <!--声明js代码域-->
    <script type="text/javascript">
        function getData() {
            // 获取元素对象
            let showdiv = document.getElementById("showDiv");
            // 修改元素内容
            showdiv.innerHTML="今天天气很好";
        }
    </script>

    <!--声明css代码域-->
    <style type="text/css">
        #showDiv{
            border: solid 1px;
            width: 200px;
            height: 100px;
        }
    </style>
</head>
<body>
<h3>欢迎登录</h3>
<hr>
<input type="button" value="测试" onclick="getData()">
<div id="showDiv"></div>
</body>
</html>
