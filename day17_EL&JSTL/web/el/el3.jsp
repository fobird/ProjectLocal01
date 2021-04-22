<%@ page import="cn.itcast.domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取数据</title>
</head>
<body>
<%
    /*
        3. 获取对象、List集合、Map集合的值
        1. 对象：${域名称.键名.属性名}
        * 本质上会去调用对象的getter方法
        2. List集合：${域名称.键名[索引]}
        3. Map集合：
        * ${域名称.键名.key名称}
        * ${域名称.键名["key名称"]}
    */

    User user = new User();
    user.setAge("18");
    user.setName("张三");
    user.setGender("男");
    request.setAttribute("user", user);

    ArrayList list = new ArrayList();
    list.add("一號玫瑰");
    list.add(199);
    list.add(user);
    request.setAttribute("list", list);

    Map map = new HashMap();
    map.put("key1", "no.1");
    map.put("key2", 1777);
    map.put("key3", user);
    request.setAttribute("map", map);
%>
<h3>el获取对象中的值对象：域名称.键名.属性名</h3>
${requestScope.user.name}
${requestScope.user.age}
${requestScope.user.gender}
<hr>
<h3>el获取List集合中的值对象：域名称.键名[索引]</h3>
${requestScope.list[0]}<br>
${requestScope.list[1]}<br>
${requestScope.list[2]}<br>
${requestScope.list[2].name}<br>
${requestScope.list[2].age}<br>
${requestScope.list[2].gender}<br>
<hr>
<h3>el获取Map集合中的值对象：域名称.键名.key名称 或者 域名称.键名["key名称"]</h3>
${requestScope.map.key1}<br>
${requestScope.map.key2}<br>
${requestScope.map.key3}<br>
${requestScope.map.key3.name}<br>
${requestScope.map.key3.age}<br>
${requestScope.map.key3.gender}<br>
${requestScope.map["key3"]}<br>


</body>
</html>
