package cn.mingyang.web.w05_servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo02_servletContext")
public class Demo02_servletContext extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ServletContext servletContext = req.getServletContext();
        ServletContext servletContext = this.getServletContext();
        Object msg = servletContext.getAttribute("msg");
        /*
            这里有一个疑问？
            为什么这里的获取不到m
         */
        System.out.println(msg);
    }
}
