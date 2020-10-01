<%--
  author: 周超
  date: 2020/7/24 15:31
  description: 登录页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>登录</title>
    <style type="text/css">
        #box {
            /*border: 1px solid #000000;*/
            text-align: center;
            padding: 10px;
            height: 300px;
        }

        #box input {
            border-radius: 4px;
            border-collapse: collapse;
            border: 1px solid;
        }
    </style>
</head>
<body>
<div id="box">
    <h3>欢迎登录</h3>
    <!--baseUrl+login-->
    <form action="login" method="post">
        用户名:<input type="text" name="username"><br>
        密&nbsp;&nbsp;&nbsp;码:<input type="password" name="password"><br>
        <input type="submit" value="登录">
        <input type="reset" value="重置">
    </form>
</div>
</body>
</html>
