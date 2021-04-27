package cn.itcast.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author superLin
 * @date 2021-04-26 13:41
 * filter快速入门
 * 访问所有资源之前，都会执行该过滤器
 */
//@WebFilter("/index.jsp") //1. 具体资源路径： /index.jsp   只有访问index.jsp资源时，过滤器才会被执行
//@WebFilter("/user/*") //2. 拦截目录： /user/*	访问/user下的所有资源时，过滤器都会被执行
//@WebFilter("*.jsp") //3. 后缀名拦截： *.jsp		访问所有后缀名为jsp资源时，过滤器都会被执行
public class filterDemo4 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init......");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("filterDemo4.....");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy.....");
    }
}
