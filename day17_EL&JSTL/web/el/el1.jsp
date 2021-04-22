<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el1</title>
</head>
<body>
<%--1. 运算：
* 运算符：
1. 算数运算符： + - * /(div) %(mod)
2. 比较运算符： > < >= <= == !=
3. 逻辑运算符： &&(and) ||(or) !(not)
4. 空运算符： empty
* 功能：用于判断字符串、集合、数组对象是否为null或者长度是否为0
* ${empty list}:判断字符串、集合、数组对象是否为null或者长度为0
* ${not empty str}:表示判断字符串、集合、数组对象是否不为null 并且 长度>0--%>
${3>4}<br>
\${3>4}
<hr>
<h3>算数运算符</h3>
${3+4}<br>
${3-4}<br>
${3*4}<br>
${3/4}<br>
${3%4}<br>
<h3>比较运算符</h3>
${3>4}<br>
${3>=4}<br>
${3!=4}<br>
${3==4}<br>
<h3>逻辑运算符</h3>
${3>4&&3<4}<br>
${3>4||3<4}<br>
<h4>empty运算符</h4>
<% request.setAttribute("u", "zhangsan");%>
${empty requestScope.u}<br>
${empty requestScope.b}<br>
${not empty requestScope.u}<br>
${not empty requestScope.b}<br>
</body>
</html>
