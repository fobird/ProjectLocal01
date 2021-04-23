<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>if:相当于java代码的if语句</title>
</head>
<body>
<%--1. if:相当于java代码的if语句
1. 属性：
* test 必须属性，接受boolean表达式
* 如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
* 一般情况下，test属性值会结合el表达式一起使用
2. 注意：
* c:if标签没有else情况，想要else情况，则可以在定义一个c:if标签--%>
<c:if test="true">
    我是真
</c:if>
<c:if test="false">
    我是假
</c:if>

<%
    //判断request域中的一个list集合是否为空，如果不为null则显示遍历集合
    ArrayList list = new ArrayList();
    list.add("aaa");
    list.add("111");
    request.setAttribute("list", list);
%>
<c:if test="${not empty list}">
    list有值，遍历成功。。。
</c:if>
<c:if test="${empty list}">
    list没值，遍历失败
</c:if>
<% request.setAttribute("number",3);%>
<c:if test="${number %2==0}">我是偶数</c:if>
<c:if test="${number %2!=0}">我是奇数</c:if>

</body>
</html>
