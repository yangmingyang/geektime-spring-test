package cn.mingyang.web.w01_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  Servlet的体系结构
 *      Servlet -- 接口
 *          GenericServlet -- 抽象类
 *              HttpServlet -- 抽象类
 *      GenericServlet:将Servlet接口中其他的方法做了默认空实现，只将service()方法作为抽象
 *          将来定义Servlet类时，可以继承GenericServlet,实现service()方法即可。
 *
 *      HttpServlet：对http协议的一种封装，简化操作。
 *          1.定义类继承HttpServlet
 *          2.复写doGet/doPost方法
 *
 */
@WebServlet("/demo5")
public class ServletDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet请求来了");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost请求来了");
    }
}
