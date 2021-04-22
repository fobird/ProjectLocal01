<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" buffer="16kb"
         language="java" errorPage="500.jsp" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%@include file="top.jsp"%>
<% ArrayList list = new ArrayList();%>
<%out.print(3 / 0);%>
$END$
</body>
</html>
