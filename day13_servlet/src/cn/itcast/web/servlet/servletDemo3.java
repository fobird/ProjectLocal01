package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author superLin
 * @date 2021-04-13 22:26
 */
//@WebServlet({"/d4","/dd4","/ddd4"})
//@WebServlet("/ddd4/dd4")
//@WebServlet("/ddd4/*")
@WebServlet("*.do")
public class servletDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo3...");
    }
}
