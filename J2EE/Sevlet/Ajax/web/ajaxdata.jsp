<%--
  Created by IntelliJ IDEA.
  User: 周
  Date: 2020/6/18
  Time: 16:06
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
    <title>AjaxData</title>

    <!--
    需求分类
        1、在当前页面显示查询结果
        2、创建ajax函数
        3、调用ajax函数发送请求到UserServlet
        4、调用业务层获取对应的数据
    -->
    <!--声明js代码域-->
    <script type="text/javascript" src="js/ajaxutil.js"></script>
    <script type="text/javascript">
        // var obj = {};
        // obj.name
        var obj = {};

        function getData() {
            // 获取用户请求信息
            var name = document.getElementById("uname").value;
            // 创建ajax引擎对象
            var ajax;
            if (window.XMLHttpRequest) {
                ajax = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                ajax = new window.ActiveXObject("Msxml2.XMLHTTP");
            }
            // 覆写onreadystatementchange函数
            ajax.onreadystatechange = function () {
                // 判断ajax状态码
                if (ajax.readyState === 4) {
                    // 判断响应状态码
                    if (ajax.status === 200) {
                        // 获取响应数据
                        var result = ajax.responseText;
                        eval("u=" + result);
                        // 处理响应数据
                        // 获取table元素对象
                        var ta = document.getElementById("table");
                        ta.innerHTML = "";
                        // 插入新的行
                        var tr = ta.insertRow(0);
                        var uid = tr.insertCell(0);
                        uid.innerHTML = "编号";
                        var uname = tr.insertCell(1);
                        uname.innerHTML = "英雄";
                        var price = tr.insertCell(2);
                        price.innerHTML = "价格";
                        var location = tr.insertCell(3);
                        location.innerHTML = "位置";
                        var description = tr.insertCell(4);
                        description.innerHTML = "描述";

                        var tr = ta.insertRow(1);
                        var uid = tr.insertCell(0);
                        uid.innerHTML = u.uid;
                        var uname = tr.insertCell(1);
                        uname.innerHTML = u.uname;
                        var price = tr.insertCell(2);
                        price.innerHTML = u.price;
                        var location = tr.insertCell(3);
                        location.innerHTML = u.location;
                        var description = tr.insertCell(4);
                        description.innerHTML = u.description;
                    }
                }
            }
            // 发送请求
            ajax.open("get", "user?name=" + name);
            ajax.send(null);
        }

        function getData2() {
            var name = document.getElementById("uname").value;
            var data = "name=" + name;
            myAjax("get", "user", data, function (ajax) {
                // 获取响应数据
                var res = ajax.responseText;
                alert(res);
            })
        }
    </script>

</head>
<body>
<h3>AjaxData</h3>
<hr>
名称: <input type="text" name="uname" value="" id="uname">
<input type="button" value="搜索" onclick="getData2()">
<hr>
<table border="1px" id="table"></table>
</body>
</html>
