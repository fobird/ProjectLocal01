package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author superLin
 * @date 2021-04-29 14:40
 */

/**
 * 敏感词汇过滤器
 */
@WebFilter("/*")
public class SensitiveFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //用代理對象来增强方法req.getparameters方法
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter方法
                //判断是否是getParameter方法
                if (method.getName().equals("getParameter")) {
                    //增强返回值
                    //获取返回值
                    String value = (String) method.invoke(req, args);
                    for (String word : list) {
                        if (value.contains(word)) {
                            value = value.replaceAll(word, "xxx");
                        }
                    }
                    return value;
                }
                return method.invoke(req, args);
            }
        });
        //2.放行
        chain.doFilter(proxy_req, resp);
    }

    private List<String> list = new ArrayList<String>();

    public void init(FilterConfig config) throws ServletException {
        //获取servletContext对象，以获得敏感词汇txt在服务器上的真实路径
        ServletContext servletContext = config.getServletContext();
        //2.读取文件
        String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
        try {
            //3.将文件的每一行数据添加到list中
            BufferedReader br = new BufferedReader(new FileReader(realPath));
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
