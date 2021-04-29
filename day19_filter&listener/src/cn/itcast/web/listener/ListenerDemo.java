package cn.itcast.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author superLin
 * @date 2021-04-29 18:53
 */
@WebListener
public class ListenerDemo implements ServletContextListener {
    /**
     * 监听ServletContext对象创建的。ServletContext对象服务器启动后自动创建。
     * <p>
     * 在服务器启动后自动调用
     *
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被创建了。。。");
        ServletContext servletContext = servletContextEvent.getServletContext();
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        //String realPath = servletContext.getRealPath("/WEB-INF/classes/applicationContext.xml");
        String realPath = servletContext.getRealPath(contextConfigLocation);
        try {
            FileInputStream fis = new FileInputStream(realPath);
            System.out.println(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在服务器关闭后，ServletContext对象被销毁。当服务器正常关闭后该方法被调用
     *
     * @param servletContextEvent
     */
    @Override

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被销毁了。。。");
    }
}
