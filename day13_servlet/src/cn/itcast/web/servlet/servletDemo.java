package cn.itcast.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author superLin
 * SERVLET3.0。不用在web.xml中配置了。改用注解的方式配置
 *    String name() default "";
 *
 *     String[] value() default {}; value 默認替代最重要方法，且參數中只有value時可以省略value
 *
 *     String[] urlPatterns() default {};
 *
 *     int loadOnStartup() default -1;
 *
 *     WebInitParam[] initParams() default {};
 *
 *     boolean asyncSupported() default false;
 *
 *     String smallIcon() default "";
 *
 *     String largeIcon() default "";
 *
 *     String description() default "";
 *
 *     String displayName() default "";
 * @date 2021-04-12 17:51
 */
@WebServlet(urlPatterns = "/demo")

public class servletDemo implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet3.0来了，，，，，，");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
