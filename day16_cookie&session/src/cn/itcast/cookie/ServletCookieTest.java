package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author superLin
 * @date 2021-04-19 15:38
 * 1. 需求：
 * 1. 访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
 * 2. 如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串
 * <p>
 * 2. 分析：
 * 1. 可以采用Cookie来完成
 * 2. 在服务器中的Servlet判断是否有一个名为lastTime的cookie
 * 1. 有：不是第一次访问
 * 1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
 * 2. 写回Cookie：lastTime=2018年6月10日11:50:01
 * 2. 没有：是第一次访问
 * 1. 响应数据：您好，欢迎您首次访问
 * 2. 写回Cookie：lastTime=2018年6月10日11:50:01
 */
@WebServlet("/ServletCookieTest")
public class ServletCookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastTime".equals(name)) {
                    //证明这不是第一次访问，先获得cookie里的值，作为展示的时间，再修改cookie的值，重新发送到浏览器
                    flag = true;
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String value = cookie.getValue();
                    System.out.println("解码前：" + value);
                    System.out.println("分割线......");
                    String decode_str_date = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后：" + decode_str_date);
                    response.getWriter().write("欢迎回来，您上次访问时间为:" + decode_str_date);
                    Date date = new Date();
                    String str_date = sdf.format(date);
                    System.out.println("编码前：" + str_date);
                    System.out.println("分割线......");
                    String encode_str_date = URLEncoder.encode(str_date, "utf-8");
                    System.out.println("编码后：" + encode_str_date);
                    cookie.setValue(encode_str_date);
                    response.addCookie(cookie);
                }
            }
        }

        if (cookies == null || cookies.length <= 0 || !flag) {
            //证明是第一次访问这个servlet
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            System.out.println("编码前：" + str_date);
            System.out.println("分割线......");
            String encode_str_date = URLEncoder.encode(str_date, "utf-8");
            System.out.println("编码后：" + encode_str_date);
            Cookie cookie = new Cookie("lastTime", encode_str_date);
            cookie.setMaxAge(60 * 60 * 24 * 30);//设置一个月的周期
            response.addCookie(cookie);
            response.getWriter().write("您好，欢迎您首次访问。");

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
