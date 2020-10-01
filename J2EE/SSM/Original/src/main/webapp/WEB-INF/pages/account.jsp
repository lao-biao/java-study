<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  author: 周
  date: 2020/6/30 10:35
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
    <title>账户信息</title>
</head>
<body>
<h3>账户信息</h3>
<table border="1px">
    <tr align="center">
        <td>账户id</td>
        <td>账户名称</td>
        <td>账户金额</td>
    </tr>
    <c:forEach items="${accountList}" var="account">
        <tr align="center">
            <td>${account.uid}</td>
            <td>${account.uname}</td>
            <td>${account.money}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
