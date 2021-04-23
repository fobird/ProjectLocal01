<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>choose</title>
</head>
<body>
<%--
2. choose:相当于java代码的switch语句
    1. 使用choose标签声明         			相当于switch声明
    2. 使用when标签做判断         			相当于case
    3. 使用otherwise标签做其他情况的声明    	相当于default
    --%>

<%--
    完成数字编号对应星期几案例
        1.域中存储一数字
        2.使用choose标签取出数字         相当于switch声明
        3.使用when标签做数字判断         相当于case
        4.otherwise标签做其他情况的声明  相当于default
--%>
<% request.setAttribute("date",55);%>
<c:choose>
    <c:when test="${date==1}">星期一</c:when>
    <c:when test="${date==2}">星期二</c:when>
    <c:when test="${date==3}">星期三</c:when>
    <c:when test="${date==4}">星期四</c:when>
    <c:when test="${date==5}">星期五</c:when>
    <c:when test="${date==6}">星期六</c:when>
    <c:when test="${date==7}">星期七</c:when>

    <c:otherwise>数字输入有误</c:otherwise>
</c:choose>

</body>
</html>
