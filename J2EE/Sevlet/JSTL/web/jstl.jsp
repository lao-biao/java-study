<%--
  Created by IntelliJ IDEA.
  User: 周
  Date: 2020/6/19
  Time: 19:56
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%--
  JSTL学习
    作用:提高在jsp中的逻辑代码的编写效率，使用标签
    使用:
        JSTL的核心标签库
        JSTL的格式化标签库
        JSTL的SQL标签库
        JSTL的函数标签库
        JSTL的XML标签库
    JSTL的核心标签库:
        1、导入jar包
        2、声明jstl标签库的引入(核心标签库)
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    1.1版本,推荐使用
            <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
        3、内容
            基本标签
                <c:out value="数据" default="默认值"/>
                    数据可以作为常量值也可以是EL表达式
                    作用:将数据输出给客户端
                <c:set var="hello" value="hello pageContext" scope="page"/>
                    作用:存储数据到作用域对象中
                    var:表示存储的键名
                    value:表示存储的数据
                    scope:表示要存储的作用域对象 page request session application
                <c:remove var="hello" scope="request"/>
                    作用:删除作用域中指定键的数据
                    var:表示要删除的键的名字
                    scrope:表示要删除的作用域(可选)
                    注意:
                        如果在不指定作用域的情况使用该标签删除数据，会将四个作用域对象中的符合要求的数据全部删除

            逻辑标签
                <c:if test="${表达式}">
                    前端代码
                </c:if>
                    作用:进行逻辑判断，相当于java代码的单分支判断
                    注意:逻辑判断标签需要依赖于EL的逻辑运算，也就是表达式中涉及到的数据必须从作用域中拿
                <c:choose>
                    <c:when test="">执行内容</c:when>
                    ...
                    <c:otherwise>执行内容</c:otherwise>
                </c:choose>
                    作用:用来进行多条件逻辑判断，类似java中的多分支语句
                    注意:条件成立只会执行一次，都不成立则执行otherwise
            循环标签
                <c:forEach begin="1" end="4" step="1">
                    循环体
                </c:forEach>
                作用:循环内容进行处理
                begin:声明循环开始位置
                end:声明循环结束位置
                step:设置循环步长
                varStatus:声明变量记录每次循环的数据(角标、次数，是否是第一次循环，是否是最后一次循环)
                    注意:数据存储在作用域中，需要使用EL表达式获取
                    例如:${vs.index}--${vs.count}--${vs.first}--${vs.last}
                items:声明要遍历的对象，结合EL表达式获取对象
                var:声明变量记录每次循环的结果，存储在作用域中，通过EL表达式获取对象

    JSTL的格式化标签库


    菜鸟教程-JSTL:https://www.runoob.com/jsp/jsp-jstl.html
--%>

<%
    request.setAttribute("str", "今天天气很好！");
    // request.setAttribute("hello", "hello request");
    // request.removeAttribute("str");
%>
<%--基本标签--%>
<h3>基本标签</h3>
<c:out value="哈哈"/><br>
<c:out value="${str}"/><br>
<c:out value="${str2}" default="嘿嘿"/><br>

<c:set var="hello" value="hello pageContext" scope="page"/><br>
<c:set var="hello" value="hello requset" scope="request"/><br>
<c:set var="hello" value="hello session" scope="session"/><br>
<c:set var="hello" value="hello application" scope="application"/><br>

<%--<c:out value="${applicationScope.hello}"/> <br>--%>
<c:remove var="hello" scope="request"/><br/>
<c:out value="${hello}"/>

<hr>
<%--逻辑标签--%>
<h3>逻辑标签</h3>
<%--传统方式--%>
<%

    int a = 4;
    if (a > 3) {
%>
<b>今天天气很好</b>
<%}%><br>
<%--jstl方式--%>
<c:set var="a" value="4"/>
<c:if test="${a>3}">
    <b>今天天气很好</b>
</c:if>
<br>
<c:set var="score" value="75"/>
<c:choose>
    <c:when test="${score>=90}">
        <i>A等</i>
    </c:when>
    <c:when test="${score>=80&&score<90}">
        <i>B等</i>
    </c:when>
    <c:when test="${score>=70&&score<80}">
        <i>C等</i>
    </c:when>
    <c:when test="${score>=60&&score<70}">
        <i>D等</i>
    </c:when>
    <c:otherwise>
        <i>E等</i>
    </c:otherwise>
</c:choose>
<hr>
<%--JSTL的循环标签--%>
<h3>JSTL的循环标签</h3>
<%--传统方式表格--%>
<table border="1px">
    <tr>
        <td>课程名称</td>
        <td>教师</td>
        <td>价格</td>
        <td>重要性</td>
    </tr>
    <%
        for (int i = 0; i < 3; i++) {
            if (i == 2) {
    %>
    <tr>
        <td>java</td>
        <td>张老师</td>
        <td>0</td>
        <td>0</td>
    </tr>
    <%
            }
        }
    %>
    <tr>
        <td>python</td>
        <td>李老师</td>
        <td>0</td>
        <td>1</td>
    </tr>
</table>

<%
    ArrayList<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");
    list.add("c");
    request.setAttribute("list", list);

    HashMap<String, String> map = new HashMap<>();
    map.put("hello", "Hello");
    map.put("world", "world");
    request.setAttribute("map", map);
%>
<%--使用JSTL方式完成循环--%>
<%--常量循环--%>
<c:forEach begin="1" end="4" step="1" varStatus="vs">
    ${vs.index}--${vs.count}--${vs.first}--${vs.last}<br>
</c:forEach>
<%--动态循环--%>
<c:forEach items="${list}" var="varlist">
    bbb--${varlist}<br>
</c:forEach>
<%--JSTL方式创建表格--%>
<table border="1px">
    <tr>
        <td>课程名称</td>
        <td>教师</td>
        <td>价格</td>
        <td>重要性</td>
    </tr>
    <c:forEach items="${list}" var="s">
        <tr>
            <td>${s}</td>
            <td>${s}</td>
            <td>${s}</td>
            <td>${s}</td>
        </tr>
    </c:forEach>
</table>
<%--遍历map集合--%>
<c:forEach items="${map}" var="m">
    ${m.key}:${m.value} <br>
</c:forEach>