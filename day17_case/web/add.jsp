<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script>
        window.onload = function (ev) {
            /*            var sbtn = document.getElementById("sbtn");
                        sbtn.onclick = function (ev1) {     }*/
            //针对年级
            /*
                        debugger;
                        var age = document.getElementById("age");
                        age.onchange = function (ev1) {
                            //如果把获取值放上面，就是页面一加载就拿值，那肯定为空，得在方法里重新拿值
                            var age_value = document.getElementById("age").value;
                            var regExp = /^(?:[1-9][0-9]?|1[01][0-9]|120)$/;//年龄是1-120之间有效
                            if (!regExp.test(age_value)) {
                                alert("年龄是1-120之间有效");
                                return false;
                            }
                        }；
            */

            var sbtn = document.getElementById("sbtn");
            sbtn.onclick = function (ev1) {
                //针对年级
                var age_value = document.getElementById("age").value;
                var regExpAge = /^(?:[1-9][0-9]?|1[01][0-9]|120)$/;//年龄是1-120之间有效
                if (!regExpAge.test(age_value)) {
                    alert("年龄是1-120之间有效");
                    return false;
                }
                //针对邮箱
                var email_value = document.getElementById("email").value;
                var regExpEmail = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
                if (!regExpEmail.test(email_value)) {
                    alert("请输入正确邮箱");
                    return false;
                }
            }
        }
    </script>
</head>
<body>
<div class="container">
    <center><h3>添加联系人页面</h3></center>
    <form action="${pageContext.request.contextPath}/addUserServlet" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value="男" checked="checked"/>男
            <input type="radio" name="gender" value="女"/>女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
        </div>

        <div class="form-group">
            <label>籍贯：</label>
            <select name="address" class="form-control" id="jiguan">
                <option value="广东">广东</option>
                <option value="广西">广西</option>
                <option value="湖南">湖南</option>
            </select>
        </div>

        <div class="form-group">
            <label>QQ：</label>
            <input type="text" class="form-control" name="qq" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label>Email：</label>
            <input type="text" class="form-control" name="email" id="email" placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" id="sbtn" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>