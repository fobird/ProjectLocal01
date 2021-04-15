package cn.itcast.web.servlet;

import cn.itcast.web.Bean.User;
import cn.itcast.web.dao.UserDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author superLin
 * @date 2021-04-15 16:23
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
/*
        String password = request.getParameter("password");
        User lUser = new User();
        lUser.setUsername(username);
        lUser.setPassword(password);*/
        User lUser = new User();
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(lUser, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        UserDao userDao = new UserDao();
        User rUser = userDao.login(lUser);
        request.setAttribute("username", username);
        if (rUser != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/successServlet");
            requestDispatcher.forward(request, response);
        }
        if (rUser == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servletFailServlet");
            requestDispatcher.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
