package cn.itcast.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author superLin
 * @date 2021-04-20 17:44
 */
@WebServlet("/SessionDemo5")
public class SessionDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            2. 客户端不关闭，服务器关闭后，两次获取的session是同一个吗？
			* 不是同一个，但是要确保数据不丢失。tomcat自动完成以下工作
				* session的钝化：
					* 在服务器正常关闭之前，将session对象系列化到硬盘上
				* session的活化：
					* 在服务器启动后，将session文件转化为内存中的session对象即可。
        * */
        HttpSession session = request.getSession();//当第一次有request.getSession()时，才会在响应头有Set-Cooki存有session的id
        System.out.println("session = " + session);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
