<%--
  Created by IntelliJ IDEA.
  User: 周
  Date: 2020/6/18
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.pojo.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<!--使用传统方式获取作用域对象的数据-->
<h3>EL表达式学习:使用传统方式获取作用域对象的数据</h3>
<%--
<b><%=request.getParameter("uname")%>
</b><br>
<b><%=request.getAttribute("str")%>
</b><br>
<b><%=((User) request.getAttribute("user")).getAddr().getTown()%>
</b><br>
<b><%=((ArrayList) request.getAttribute("list")).get(1)%>
</b><br>
<b><%=((User) ((ArrayList) request.getAttribute("lu")).get(0)).getAddr().getPre()%>
</b><br>
<b><%=((ArrayList<User>) request.getAttribute("lu")).get(1).getAddr().getPre()%>
</b><br>
<b><%=((HashMap) request.getAttribute("map")).get("b")%>
</b><br>
<b><%=((HashMap<String, User>) request.getAttribute("mu")).get("a").getAddr().getTown()%>
</b>
--%>

<%--
    传统方式获取作用域数据
        缺点一:导入包
        缺点二:需要强制导包
        缺点三:获取数据的代码过于麻烦
    EL表达式获取作用域数据
        作用:获取作用域对象中的数据
        注意:获取的是pageContext、reqeust、session、application四个对象中的数据，其他数据一概不理会
            找到了则返回，找不到则什么都不做，也不报错
        语法规范
            ${表达式}
            表达式:
                获取请求数据
                    request对象存储了请求数据    param.键名         返回的是值
                    request对象存储了请求数据    paramValues.键名   返回的是数组
                通过setAttribute方法存储到作用域对象中的数据
                    ${键名}   返回键名所对应的值
                    注意:
                        如果存储的是普通字符串则直接返回
                        如果存储的是对象，则返回的是对象
                            获取对象中的数据
                                普通对象:${键名.属性名.属性名...}
                                集合对象:
                                    list集合${键名[角标]}
                                    map集合${键名.map集合存储的键名}
        作用域查找顺序
            默认查找顺序
                pageContext-->reqeust-->session-->application
                注意:每次查找都是从小到大进行查找，找到了则获取，不再继续找了
            指定查找顺序
                ${requestScope.键名}
                ${pageScope.键名}
                ${sessionScope.键名}
                ${applicationScope.键名}
    EL表达式的逻辑运算
        ${关系表达式}
        ${逻辑表达式}
        ${算术表达式}
        ${三目表达式}
        注意:+表示加法运算，不表示字符连接，使用EL表达式进行字符连接会报错
    EL表达式的空值判断
        ${empty 键名}
        作用:判断键名对象的值是否存有数据
    EL获取请求头数据和Cookie
        请求头数据:
            ${header}   返回所有的请求头数据
            ${header["键名"]}   返回指定键名的请求头数据
            ${headerValues["键名"]} 返回指定得键名(同键不同值)
        获取cookie数据
            ${cookie}   返回存储了所有的cookie对象的map集合
            ${cookie.键名}    返回指定的cookie对象
            ${cookie.键名.name}   返回指定的cookie对象存储的数据的键名
            ${cookie.键名.value}   返回指定的cookie对象存储的数据的值

--%>

<!--使用EL表达式方式获取作用域对象的数据-->
<h3>EL表达式学习:使用EL表达式方式获取作用域对象的数据</h3>
<b>${param.uname}</b><br>
<b>${paramValues.fav}</b><br>
<b>${str}</b><br>
<b>${user.addr.town}</b><br>
<b>${list[1]}</b><br>
<b>${lu[1].addr.pre}</b><br>
<b>${map.a}</b><br>
<b>${mu.a.addr.town}</b>

<!--EL作用域查找顺序-->
<%
    pageContext.setAttribute("hello", "hello pageContext");
    request.setAttribute("hello", "hello request");
    session.setAttribute("hello", "hello session");
    application.setAttribute("hello", "hello application");
%>
<hr>
<h3>EL作用域查找顺序</h3>
<%--${hello}--%>
${requestScope.hello}
${pageScope.hello}
${sessionScope.hello}
${applicationScope.hello}
<hr>
<h3>EL表达式的逻辑运算</h3>
1+3=>${1+3}<br>
1*2=>${1*2}<br>
1/2=>${1/2}<br>
4-2=>${4-2}<br>
4%2=>${4%2}<br>
4==3=>${4==3}<br>
4>2=>${4>2}<br>
1==1?'男':'女'=>${1==1?'男':'女'}<br>
1+"2"=>${1+"2"}

<hr>
<h3>EL表达式的空值判断</h3>
${empty s0}
${empty s1}
${empty s2}
${empty s3}

<!--使用EL表达式方式获取请求头数据-->
<hr>
<h3>使用EL表达式方式获取请求头数据</h3>
${header}
${header["User-Agent"]}<br>
${headerValues["Accept-Language"][0]}<br>
${cookie}<br>
${cookie.JSESSIONID.value}