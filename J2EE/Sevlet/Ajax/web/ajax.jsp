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
        function getData(method, url, data, deal200, deal404, deal500, async) {
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
                        if (deal200)
                            deal200(ajax);
                    } else if (404 === ajax.status) {
                        if (deal404)
                            deal404();
                    } else if (500 === ajax.status) {
                        if (deal500)
                            deal500();
                    }
                }
            }
            if ("get" === method) {
                // 发送请求
                ajax.open("get", url + (data === null ? "" : "?" + data), async); // false同步，true异步
                ajax.send(null);
            } else if ("post" === method) {
                ajax.open("post", url, async);
                ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                ajax.send(data);
            }
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
