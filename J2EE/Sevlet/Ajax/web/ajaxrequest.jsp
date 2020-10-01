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
        function ajaxReq() {
            // 获取用户请求数据
            var uname=document.getElementById("uname").value;
            var data="name="+uname;
            // 创建ajax引擎对象
            var ajax;
            if (window.XMLHttpRequest) {
                ajax = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                ajax = new ActiveXObject("Msxml2.XMLHTTP");
            }
            // 覆写onreadystatement函数
            ajax.onreadystatechange = function () {
                // 判断ajax状态码
                if (4 === ajax.readyState) {
                    // 判断响应状态码
                    if (200 === ajax.status) {
                        // 获取相应内容
                        var result = ajax.responseText;
                        // 处理相应内容
                        alert(result);
                    }
                }
            }
            // 发送请求
            // ajax.open("get","ajax?"+data);
            // ajax.send(null);
            // post方式
            ajax.open("post","ajax");
            // 请求头
            ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            ajax.send("name=张三&pwd=123");
        }
    </script>

    <!--声明css代码域-->
    <style type="text/css">
        #showDiv {
            border: solid 1px;
            width: 200px;
            height: 100px;
        }
    </style>
</head>
<body>
<h3>欢迎登录</h3>
<hr>
<input type="text" id="uname" name="uname" value="">
<input type="button" value="测试" onclick="ajaxReq()">
<div id="showDiv"></div>
</body>
</html>
