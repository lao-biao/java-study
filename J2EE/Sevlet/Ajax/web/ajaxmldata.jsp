<%--
  Created by IntelliJ IDEA.
  User: 周
  Date: 2020/6/18
  Time: 18:36
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
    <title>XML数据格式学习</title>
    <!--声明js代码域-->
    <script type="text/javascript">
        function getXML() {
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
                        var result = ajax.responseXML;
                        alert(result.getElementsByTagName("uname")[0].innerHTML);
                    }
                }
            }
            // 发送请求
            ajax.open("get", "xml",true);
            ajax.send(null);
        }
    </script>
</head>
<body>
<h3>XML数据格式学习</h3>
<hr>
<input type="button" value="测试" onclick="getXML()">
</body>
</html>
