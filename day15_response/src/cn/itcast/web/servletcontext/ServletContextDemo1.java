package cn.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author superLin
 * @date 2021-04-17 20:12
 */
@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*	2. 获取：
		1. 通过request对象获取
			request.getServletContext();
		2. 通过HttpServlet获取
			this.getServletContext();*/
        ServletContext servletContext1 = request.getServletContext();
        ServletContext servletContext2 = this.getServletContext();
        System.out.println("servletContext1 = " + servletContext1);
        System.out.println("servletContext2 = " + servletContext2);
        System.out.println(servletContext1 == servletContext2);
        /*
        *
        *servletContext1 = org.apache.catalina.core.ApplicationContextFacade@369accb4
         servletContext2 = org.apache.catalina.core.ApplicationContextFacade@369accb4
         true
*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
