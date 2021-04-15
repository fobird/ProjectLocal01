package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author superLin
 * @date 2021-04-14 21:49
 */
@WebServlet("/servletDemo3")
public class ServletDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 			2. 获取请求头数据
         * 方法：
         * (*)String getHeader(String name):通过请求头的名称获取请求头的值
         * Enumeration<String> getHeaderNames():获取所有的请求头名称*/
        Enumeration<String> headerNames = request.getHeaderNames();
         while (headerNames.hasMoreElements()){
             String requestHeader = headerNames.nextElement();
             String header = request.getHeader(requestHeader);
             System.out.println("header = " + header);

         }
        System.out.println("---------------------------");
        String browser = request.getHeader("user-agent");
        System.out.println("browser = " + browser);

    }
}
