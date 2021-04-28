package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author superLin
 * @date 2021-04-26 13:41
 */

@WebFilter("/*")
public class filterDemo17 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("filterDemo7.....");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter7回来了...........");
    }

    @Override
    public void destroy() {

    }
}
