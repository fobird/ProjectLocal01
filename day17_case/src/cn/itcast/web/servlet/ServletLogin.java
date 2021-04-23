package cn.itcast.web.servlet;

import cn.itcast.damain.User;
import cn.itcast.service.LoginService;
import cn.itcast.service.impl.LoginServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

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
 * @date 2021-04-24 1:16
 */
@WebServlet("/servletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //設置請求的编码格式
        request.setCharacterEncoding("utf-8");
        //获取表单传递过来的验证码
        String verifycode = request.getParameter("verifycode");
        //获取后台生成的验证码
        String rightCheck = (String) request.getSession().getAttribute("rightCheck");
        request.getSession().removeAttribute("rightCheck");
        //获取表单传递过来的用户名密码
        Map<String, String[]> parameterMap = request.getParameterMap();

        if (!rightCheck.equalsIgnoreCase(verifycode)) {
            //验证码有误
            request.setAttribute("error_msg", "验证码有误！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            //验证码正确
            try {
                User user = new User();
                BeanUtils.populate(user, parameterMap);
                LoginService loginService = new LoginServiceImpl();
                User reUser = loginService.loginUser(user);
                if (reUser == null) {
                    //证明数据库里没有这个用户，用户名或者密码错误
                    request.setAttribute("error_msg", "用户名或者密码有误！");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                } else {
                    //证明数据库里有这个用户，重定向到index.jsp頁面
                    request.getSession().setAttribute("name",reUser.getName());
                    response.sendRedirect(request.getContextPath()+"/index.jsp");
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
