<%--
  Created by IntelliJ IDEA.
  User: 周
  Date: 2020/6/16
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎登录后台管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="js/jquery.js"></script>
    <script src="js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        $(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            $(window).resize(function () {
                $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            })
        });
    </script>

</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">


<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <span>欢迎登录后台管理界面平台</span>
</div>

<div class="loginbody">

    <span class="systemlogo"></span>

    <%--使用JSTL和EL表达式完成提示语显示--%>
    <c:choose>
        <c:when test="${sessionScope.flag==0}">
            <br>
            <div style="text-align: center;font-size: 12px;color: darkred;font-weight: bold;"><span>用户名或密码错误</span>
            </div>
        </c:when>
        <c:when test="${sessionScope.flag==1}">
            <br>
            <div style="text-align: center;font-size: 12px;color: darkred;font-weight: bold;"><span>密码修改成功</span></div>
        </c:when>
        <c:when test="${sessionScope.flag==2}">
            <br>
            <div style="text-align: center;font-size: 12px;color: darkred;font-weight: bold;"><span>注册成功</span></div>
        </c:when>
    </c:choose>
    <%--移除session中的flag标记--%>
    <c:remove var="flag" scope="session"/>

    <div class="loginbox loginbox1">
        <form action="user" method="post">
            <input type="hidden" name="oper" value="login">
            <ul>
                <li><input name="uname" type="text" placeholder="用户名" class="loginuser" value=""/></li>
                <li><input name="pwd" type="password" placeholder="密码" class="loginpwd" value=""/></li>
                <li class="yzm">
                    <span><input name="" placeholder="验证码" type="text" value=""/></span><cite>X3D5S</cite>
                </li>
                <li><input name="" type="submit" class="loginbtn" value="登录"
                           onclick="javascript:window.location='main.html'"/><label><a
                        href="user/reg.jsp">注册</a></label><label><a
                        href="#">忘记密码？</a></label></li>
            </ul>
        </form>

    </div>

</div>


<div class="loginbm">版权所有 2020 <a href="http://www.uimaker.com">uimaker.com</a> 仅供学习交流，勿用于任何商业用途，交流QQ:1178605721</div>


</body>

</html>

