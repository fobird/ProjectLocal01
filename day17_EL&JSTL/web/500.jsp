<%@ page contentType="text/html;charset=UTF-8" language="java"
         isErrorPage="true"
%>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
<h1>服务器繁忙</h1>
<% out.print(exception.getMessage());%>
</body>
</html>
