package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author superLin
 * @date 2021-04-18 19:30
 */
@WebServlet("/ServletCookieDemo3")
public class ServletCookieDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*  1. 一次可不可以发送多个cookie?
			* 可以
                * 可以创建多个Cookie对象，使用response调用多次addCookie方法发送cookie即可。
        */
        Cookie c1 = new Cookie("msg1", "kunga");
        Cookie c2 = new Cookie("msg2", "tiga");
        response.addCookie(c1);
        response.addCookie(c2);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
