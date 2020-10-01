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
            // 创建ajax引擎对象
            var ajax = getAjax();
            // 覆写onreadystatement函数
            ajax.onreadystatechange = function () {
                // 获取元素对象
                let showdiv = document.getElementById("showDiv");
                // 会执行4次,判断ajax状态码，只在数据成功接收时执行以下代码
                if (4 === ajax.readyState) {
                    // 判断响应状态码
                    if (200 === ajax.status) {
                        // 处理相应内容
                        // 获取响应内容，修改元素内容
                        showdiv.innerHTML = ajax.responseText;
                    } else if (404 === ajax.status) {
                        showdiv.innerHTML = "请求资源不存在";
                    } else if (500 === ajax.status) {
                        showdiv.innerHTML = "服务器繁忙";
                    }
                } else {
                    showdiv.style.position = "relative";
                    showdiv.innerHTML = "<img src='img/loading.gif' width='32' height='32' " +
                        "style='position: absolute;left: 50%;top: 50%;margin-top: -16px;margin-left: -16px;'>"
                }
            }
            // 发送请求
            ajax.open("get", "ajax"); // false同步，true异步
            ajax.send(null);
        }

        /*ajax的封装*/
        function getAjax() {
            var ajax;
            if (window.XMLHttpRequest) {  // firefox
                ajax = new XMLHttpRequest();
            } else if (window.ActiveXObject) { // ie
                ajax = new ActiveXObject("Msxml2.XMLHTTP");
            }
            return ajax;
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
<input type="button" value="测试" onclick="getData()">
<div id="showDiv"></div>
</body>
</html>
