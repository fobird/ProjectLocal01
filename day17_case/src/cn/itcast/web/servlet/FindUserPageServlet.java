package cn.itcast.web.servlet;

import cn.itcast.damain.PageBean;
import cn.itcast.damain.User;
import cn.itcast.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author superLin
 * @date 2021-04-25 18:08
 */
@WebServlet("/findUserPageServlet")
public class FindUserPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置参数编码
        request.setCharacterEncoding("utf-8");
        //获得每页显示多少行rows，当前页面currentPage
        String rows = request.getParameter("rows");
        String currentPage = request.getParameter("currentPage");
        //获取表单传过来的参数
        Map<String, String[]> map = request.getParameterMap();
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }
        //调用service层方法返回pageBean对象
        UserService userService = new cn.itcast.service.impl.UserService();
        PageBean<User> pb = userService.findUserByPage(currentPage, rows, map);
        //将Page对象存到request域中
        request.setAttribute("pb", pb);
        request.setAttribute("conditions", map);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
