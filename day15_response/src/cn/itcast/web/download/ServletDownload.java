package cn.itcast.web.download;

import cn.itcast.web.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author superLin
 * @date 2021-04-18 16:49
 */
@WebServlet("/servletDownload")
public class ServletDownload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数，文件名称
        String filename = request.getParameter("filename");
        //2.使用字节输入流加载文件进内存
        //2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //2.2用字节流关联
        FileInputStream fis = new FileInputStream(new File(realPath));
        //3.设置response的响应头
        //3.1设置响应头类型：content-type
        String mimeType = servletContext.getMimeType(filename);
        response.setContentType(mimeType);
        //解决中文文件名问题
        //1.获取user-agent请求头、
        String header = request.getHeader("user-agent");
        //2.使用工具类方法编码文件名即可
        String fileName = DownLoadUtils.getFileName(header, filename);
        //3.2设置响应头打开方式:content-disposition
        response.setHeader("content-disposition", "attachment;filename=" + fileName);
        //4.将输入流的数据写出到输出流中
        byte[] buff = new byte[1024 * 8];
        int length = 0;
        ServletOutputStream sos = response.getOutputStream();
        while ((length = fis.read(buff)) != -1) {
            sos.write(buff, 0, length);
        }
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        this.doPost(request, response);
    }
}
