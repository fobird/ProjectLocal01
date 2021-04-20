<%--
  Created by IntelliJ IDEA.
  User: QC
  Date: 2021/4/18
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    System.out.println("index.jsp被访问了");
    int i = 5;
%>

<%! int i = 3;%>
<h1>hi jsp~</h1>
<%= i%>
</body>
</html>
