<%--
  author: 周超
  date: 2020/7/24 15:36
  description: 首页
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>首页</title>
    <style>
        #top-box {
            width: 90%;
            height: 30px;
            margin: 0 auto;
            border: 1px solid blue;
            text-align: right;
        }

        #content-box {
            width: 90%;
            height: 90%;
            margin: 0 auto;
            border: 1px solid blue;
            text-align: center;
        }
    </style>
</head>
<body>
<div id="top-box">
    <c:if test="${sessionScope.currentUser == null }">
        <a href="login.jsp">登录</a>
    </c:if>
    <c:if test="${sessionScope.currentUser != null }">
        ${currentUser.username }，您好
    </c:if>
</div>
<div id="content-box">
    <h1>首页内容</h1>
</div>
</body>
</html>
