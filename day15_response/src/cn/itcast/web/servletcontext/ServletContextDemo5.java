package cn.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author superLin
 * @date 2021-04-17 20:12
 */
@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		3. 功能：
		1. 获取MIME类型：
			* MIME类型:在互联网通信过程中定义的一种文件数据类型
				* 格式： 大类型/小类型   text/html		image/jpeg

			* 获取：String getMimeType(String file)
		2. 域对象：共享数据
			1. setAttribute(String name,Object value)
			2. getAttribute(String name)
			3. removeAttribute(String name)
				3. 获取文件的真实(服务器)路径
			1. 方法：String getRealPath(String path)
				 String b = context.getRealPath("/b.txt");//web目录下资源访问
		         System.out.println(b);

		        String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
		        System.out.println(c);

		        String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
		        System.out.println(a);
		*/
        ServletContext servletContext = request.getServletContext();
        String bpath = servletContext.getRealPath("/b.txt");//web目录下资源访问
        System.out.println("bpath = " + bpath);
        File bfile = new File(bpath);
        System.out.println("bfile = " + bfile);

        System.out.println("------------------------");
        String cpath = servletContext.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
        System.out.println("cpath = " + cpath);
        File cfile = new File(cpath);
        System.out.println("cfile = " + cfile);

        System.out.println("-------------------------");
        String apath = servletContext.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
        System.out.println("apath = " + apath);
        File afile = new File(apath);
        System.out.println("afile = " + afile);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
