package cn.itcast.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author superLin
 * @date 2021-04-17 18:11
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        //1.创建一对象，在内存中图片(验证码图片对象)
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //2.美化图片
        //2.1 填充背景色
        Graphics g = img.getGraphics();//画笔对象
        g.setColor(Color.PINK);
        g.fillRect(0, 0, width, height);

        //2.2画边框
        g.setColor(Color.red);
        g.drawRect(0, 0, width - 1, height - 1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        //生成随机角标
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            //2.3写验证码
            g.drawString(str.charAt(index) + "", width / 5 * i, 25);
            sb.append(str.charAt(index));
        }
        String checkCode_session = sb.toString();
        HttpSession session = request.getSession();
        session.setAttribute("rightCheck", checkCode_session);
        //2.4画干扰线
        g.setColor(Color.green);

        //随机生成坐标点
        for (int i = 0; i < 10; i++) {
            Random random2 = new Random();
            int x1 = random2.nextInt(width);
            int x2 = random2.nextInt(width);
            int y1 = random2.nextInt(height);
            int y2 = random2.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }


        //3.将图片输出到页面展示
        ImageIO.write(img, "jpg", response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
