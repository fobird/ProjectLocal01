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
@WebServlet("/ServletCookieDemo4")
public class ServletCookieDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*  	2. cookie在浏览器中保存多长时间？
			1. 默认情况下，当浏览器关闭后，Cookie数据被销毁
			2. 持久化存储：
				* setMaxAge(int seconds)
					1. 正数：将Cookie数据写到硬盘的文件中。持久化存储。并指定cookie存活时间，
					时间到后，cookie文件自动失效,哪怕服务器关闭了，cookie在规定时间内还是存活
					2. 负数：默认值
					3. 零：删除cookie信息
        */
        Cookie c1 = new Cookie("msg1", "kunga");
        c1.setMaxAge(0);
        response.addCookie(c1);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
