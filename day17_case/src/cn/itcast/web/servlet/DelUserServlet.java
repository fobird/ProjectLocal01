package cn.itcast.web.servlet;

import cn.itcast.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author superLin
 * @date 2021-04-24 15:49
 */
@WebServlet("/delUserServlet")
public class DelUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求参数
        request.setCharacterEncoding("utf-8");
        //获得id
        String id = request.getParameter("id");
        //调用service层删除用户方法
        UserService userService=new cn.itcast.service.impl.UserService();
        userService.delUserById(id);
        //重定向回userListServlet
        response.sendRedirect(request.getContextPath()+"/userListServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
