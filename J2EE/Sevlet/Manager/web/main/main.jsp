<%--
  Created by IntelliJ IDEA.
  User: 周
  Date: 2020/6/17
  Time: 9:16
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
    <title>信息管理系统界面</title>
</head>
<frameset rows="88,*,31" cols="*" frameborder="no" border="0" framespacing="0">
    <frame src="main/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame"/>
    <frameset cols="187,*" frameborder="no" border="0" framespacing="0">
        <frame src="main/left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame"/>
        <frame src="main/right.jsp" name="rightFrame" id="rightFrame" title="rightFrame"/>
    </frameset>
    <frame src="main/footer.jsp" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame"
           title="bottomFrame"/>
</frameset>
<noframes>
    <body>
    </body>
</noframes>
</html>

