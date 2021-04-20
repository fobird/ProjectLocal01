package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author superLin
 * @date 2021-04-20 23:52
 * 1. 案例需求：
 * 1. 访问带有验证码的登录页面login.jsp
 * 2. 用户输入用户名，密码以及验证码。
 * * 如果用户名和密码输入有误，跳转登录页面，提示:用户名或密码错误
 * * 如果验证码输入有误，跳转登录页面，提示：验证码错误
 * * 如果全部输入正确，则跳转到主页success.jsp，显示：用户名,欢迎您
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置request编码
        request.setCharacterEncoding("utf-8");
        //2.获取参数
        String checkCode = request.getParameter("checkCode");//頁面傳過來的驗證碼
        String username = request.getParameter("username");//頁面傳過來的username
        String password = request.getParameter("password");//頁面傳過來的password
        //3.先获取生成的验证码
        HttpSession session = request.getSession();
        String sessionCode = (String) session.getAttribute("rightCheck");
        //3.先判断验证码是否正确
        if (sessionCode != null && checkCode != null && sessionCode.equalsIgnoreCase(checkCode)) {            //忽略大小写比较
            //验证码正确
            //判断用户名和密码是否一致
            if (username != null && password != null &&
                    username.equals("zhangsan") && password.equals("123")) {
                //用户名密码正确
                //確保驗證碼一次性的
                session.removeAttribute("rightCheck");
                request.setAttribute("user", username);
                request.getRequestDispatcher("/success.jsp").forward(request, response);
            } else {
                //用户名密码有错误
                //登录失败
                //存储提示信息到request
                request.setAttribute("up_error", "用戶名或者密碼错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            //驗證碼錯誤
            //登录失败
            //存储提示信息到request
            request.setAttribute("cc_error", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
