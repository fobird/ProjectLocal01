package cn.itcast.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author superLin
 * @date 2021-04-11 23:42
 */
public class servletDemo2 implements Servlet {
    /**
     * 初始方法，在Servlet被加载进内存，对象被创建时调用·
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init......");
    }

    /**
     * =获得ServletConfig对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 服务方法，在用户每一次访问servlet时被调用
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service.......");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /***
     * 销毁方法，在服务器关闭时被调用
     */
    @Override
    public void destroy() {
        System.out.println("destroy....");
    }
}
