package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author superLin
 * @date 2021-04-28 21:46
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // chain.doFilter(req, resp);
        //首先获得请求路径，看看是不是访问跟登陆相关的资源
        HttpServletRequest request = (HttpServletRequest) req;
        String uri = request.getRequestURI();
        if (uri.contains("/login.jsp") ||
                uri.contains("/checkCodeServlet") ||
                uri.contains("/servletLogin") ||
                uri.contains("/js/") ||
                uri.contains("/css/") ||
                uri.contains("/fonts/")) {
            //放行
            chain.doFilter(req, resp);
        } else {
            HttpSession session = request.getSession();
            if (session.getAttribute("name") == null || session.getAttribute("name") == "") {
                //证明还没登陆
                request.setAttribute("error_msg", "用戶還未登錄");
                HttpServletResponse response = (HttpServletResponse) resp;
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                //已登錄,放行
                chain.doFilter(req, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
