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
@WebServlet("/ServletCookieDemo6")
public class ServletCookieDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*  		4. cookie共享问题？
			1. 假设在一个tomcat服务器中，部署了多个web项目，那么在这些web项目中cookie能不能共享？
				* 默认情况下cookie不能共享

				* setPath(String path):设置cookie的获取范围。默认情况下，设置当前的虚拟目录
					* 如果要共享，则可以将path设置为"/"


			2. 不同的tomcat服务器间cookie共享问题？
				* setDomain(String path):如果设置一级域名相同，那么多个服务器之间cookie可以共享
					* setDomain(".baidu.com"),那么tieba.baidu.com和news.baidu.com中cookie可以共享 */
        Cookie c1 = new Cookie("msg1", "你好");
        c1.setDomain("/");
        response.addCookie(c1);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
