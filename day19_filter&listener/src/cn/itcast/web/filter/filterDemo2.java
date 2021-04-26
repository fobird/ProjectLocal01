package cn.itcast.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author superLin
 * @date 2021-04-26 13:41
 * filter快速入门
 * 访问所有资源之前，都会执行该过滤器
 */
//@WebFilter("/user/user.jsp")//单独访问某个资源
public class filterDemo2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("dofilterDemo2.....");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
