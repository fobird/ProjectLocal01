package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author superLin
 * @date 2021-04-15 12:03
 */
@WebServlet("/servletDemo8")
public class ServletDemo8 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo8被访问了88888888888888888888");
/*      RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servletDemo9");
        requestDispatcher.forward(request,response);*/
        request.setAttribute("name", "msg");
        request.getRequestDispatcher("/servletDemo9").forward(request, response);
        // 只能访问项目内资源
        // request.getRequestDispatcher("http://www.shuquge.com/txt/74138/13780575.html").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
