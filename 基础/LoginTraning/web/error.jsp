<%--
  author: 周
  date: 2020/7/24 17:14
  description: 登录错误页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>错误页面</title>
</head>
<body>
<h3>登录错误，<span id="tip">5</span>秒后即将跳转至首页</h3>
</body>
</html>
<script type="text/javascript">
    var num = 5;

    // 倒数
    function countdown() {
        let tip = document.getElementById("tip");
        tip.innerHTML = '' + --this.num;
    }

    // 登录失败，5秒后跳转到首页
    setTimeout('location.assign("index.jsp")', 5000);
    // 设置定时器
    setInterval('countdown()', 1000);

</script>
