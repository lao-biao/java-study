<%--
  Created by IntelliJ IDEA.
  User: 周
  Date: 2020/6/13
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="request" method="post">
        用户名:<input type="text" name="uname" value=""/><br/>
        密码:<input type="text" name="pwd" value=""/> <br/>
        爱好:<br/>
        1<input type="checkbox" name="fav" value="1"><br/>
        2<input type="checkbox" name="fav" value="2"><br/>
        3<input type="checkbox" name="fav" value="3"><br/>

        <input type="submit" value="登录"/>

    </form>
</body>
</html>
