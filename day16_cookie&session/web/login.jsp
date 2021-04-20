<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
    <script>
        window.onload = function (ev) {
            document.getElementById("checkCode").onclick = function (ev1) {
                this.src = "/day16/checkCodeServlet?" + new Date().getTime();
            }
        }
    </script>
</head>
<body>
<form action="/day16/loginServlet" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="checkCode" src="/day16/checkCodeServlet"></img></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>
    </table>
    <div><%=request.getAttribute("up_error")%>
    </div>
    <div><%=request.getAttribute("cc_error")%>
    </div>
</form>

</body>
</html>
