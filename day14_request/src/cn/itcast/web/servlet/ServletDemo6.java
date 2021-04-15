package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @author superLin
 * @date 2021-04-15 12:03
 */
@WebServlet("/servletDemo6")
public class ServletDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        1. 获取请求参数通用方式：不论get还是post请求方式都可以使用下列方法来获取请求参数
				1. String getParameter(String name):根据参数名称获取参数值    username=zs&password=123
				2. String[] getParameterValues(String name):根据参数名称获取参数值的数组  hobby=xx&hobby=game
				3. Enumeration<String> getParameterNames():获取所有请求的参数名称
				4. Map<String,String[]> getParameterMap():获取所有参数的map集合
        * */
        String username = request.getParameter("username");
        System.out.println("username = " + username);
        System.out.println("-----------------------");
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println("hobby = " + hobby);
        }
        System.out.println("------------------------");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println("name = " + name);
        }
        System.out.println("------------------------");
        Map<String, String[]> map = request.getParameterMap();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            String[] values = request.getParameterValues(key);
            for (String value : values) {
                System.out.println(key + "--------" + value);

            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
