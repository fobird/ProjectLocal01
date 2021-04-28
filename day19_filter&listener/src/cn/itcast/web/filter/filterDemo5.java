package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author superLin
 * @date 2021-04-26 13:41
 * filter快速入门
 * 访问所有资源之前，都会执行该过滤器
 */

//浏览器直接请求index.jsp资源时，该过滤器会被执行
//@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.REQUEST)
//只有转发访问index.jsp时，该过滤器才会被执行
//@WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.FORWARD)
//浏览器直接请求index.jsp或者转发访问index.jsp。该过滤器才会被执行
@WebFilter(value = "/index.jsp", dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class filterDemo5 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init......");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("filterDemo5.....");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy.....");
    }
}
