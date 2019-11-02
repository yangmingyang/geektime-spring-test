package cn.mingyang.web.w04_response;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/demo06_response_checkCode")
public class Demo06_response_checkCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //生成验证码案例
        int width = 100;
        int height = 50;
        //创建一个内存图片
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //画背景颜色

        //获取画笔
        Graphics graphics = image.getGraphics();
        //设置画笔的颜色，来进行填充
        graphics.setColor(Color.pink);
        graphics.fillRect(0,0,width,height);

        //画边框
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0,0,width-1,height-1);

        //写上随机字符串，这里也可以使用随机字符串
        graphics.drawString("A",20,25);
        graphics.drawString("b",40,25);
        graphics.drawString("c",60,25);
        //创建Random类对象
        Random random = new Random();
        //产生随机数,100内的随机数
        int number = random.nextInt(100);
        graphics.drawString(number+"",80,25);
        HttpSession session = req.getSession();
        session.setAttribute("checkCodeSession","Abc"+number);
        System.out.println("checkCodeSession：" + "Abc"+number);

        //画随机线,这里可以用随机数
        graphics.drawLine(0,0,30,30);
        graphics.drawLine(20,0,40,30);
        graphics.drawLine(0,34,30,50);
        graphics.drawLine(10,25,30,30);

        //把图片输出到浏览器上
        ImageIO.write(image,"JPG",resp.getOutputStream());
    }
}
