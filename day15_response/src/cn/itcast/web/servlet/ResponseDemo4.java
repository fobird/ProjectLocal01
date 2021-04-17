package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author superLin
 * @date 2021-04-16 15:54
 */
@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //解決乱码问题得在获取流对象前
        //设置该流的默认编码，设置服务器端的编码方式
       // response.setCharacterEncoding("utf-8");
        //3. 告诉浏览器响应体使用的编码
       // response.setHeader("content-type","text/html;charset=utf-8");
        //有了这条，不用上面两条了
        response.setContentType("text/html;charset=utf-8");
        //        1. 获取字符输出流
        PrintWriter pw = response.getWriter();
//        2. 输出数据
        pw.write("你好 response!");
/*     * 注意：
	   * 乱码问题：
        1. PrintWriter pw = response.getWriter();获取的流的默认编码是ISO-8859-1
        2. 设置该流的默认编码
        3. 告诉浏览器响应体使用的编码*/

        //简单的形式，设置编码，是在获取流之前设置
        response.setContentType("text/html;charset=utf-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
