package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author superLin
 * @date 2021-04-14 21:54
 */
@WebServlet("/servletDemo4")
public class ServletDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String referer = request.getHeader("Referer");
        if (referer != null) {
            if (referer.contains("chrome")) {
                System.out.println("谷歌浏览器");
            } else if (referer.contains("ie")) {
                System.out.println("ie浏览器");
            }

        }
        if (referer != null) {
            if (referer.contains("/day14")) {
                System.out.println("正常播放");
            } else {
                System.out.println("请到官网");
            }
        }
    }
}
