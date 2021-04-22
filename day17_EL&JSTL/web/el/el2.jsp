<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取域中的数据</title>
</head>
<body>
<%
    //在域中存储数据
    session.setAttribute("name", "李斯");
    request.setAttribute("name", "zhangsan");
    request.setAttribute("age", 18);
%>
<h3>el获取值</h3>
${requestScope.name}<br>
${requestScope.age}<br>
${sessionScope.name}<br>
${name}
</body>
</html>
