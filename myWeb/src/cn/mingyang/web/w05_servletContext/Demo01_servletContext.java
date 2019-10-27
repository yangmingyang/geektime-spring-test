package cn.mingyang.web.w05_servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  ServletContent对象
 *      1.概念：代表整个web应用，可以和程序的容器（服务器）来通信
 *      2.获取：
 *          1.通过request对象获取
 *              request.getServletContent();
 *          2.通过HttpServlet获取
 *              this.getServletContent();
 *      3.功能：
 *          1.获取MIME类型：
 *              MIME类型：在互联网通信过程中定义的一种文件数据类型
 *                  格式：大类型/小类型  text/html   image/jpeg
 *              获取：String getMimeType(String file)
 *
 *          2.域对象：共享数据
 *              1.setAttribute(String name,Object value)
 *              2.getAttribute(String name)
 *              3.removeAttribute(String name)
 *
 *              ServletContext对象范围：所有用户所有请求的数据。
 *              注意：因为该对象的作用范围非常广，并且有效时期非常长，所以我们一定要非常谨慎使用该对象
 *
 *          3.获取文件的真实（服务器）路径
 *
 */
@WebServlet("/demo01_servletContext")
public class Demo01_servletContext extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过request对象获取
        ServletContext servletContext1 = req.getServletContext();
        //通过HttpServlet获取
        ServletContext servletContext2 = this.getServletContext();
        System.out.println(servletContext1);
        System.out.println(servletContext2);
        System.out.println(servletContext1 == servletContext2);

        System.out.println("===============================");
        String fileName = "a.jpg";
        //1.获取MIME类型：
        String mimeType = servletContext1.getMimeType(fileName);
        System.out.println(mimeType);//结果为：image/jpeg

        System.out.println("===============================");
        //域对象：共享数据
        servletContext1.setAttribute("msg","mingYang");

        System.out.println("===============================");
        String realPath = servletContext1.getRealPath("/index.jsp");
        System.out.println(realPath);
        //输出的结果为：D:\code\myselfCode\geektime-spring-test\myWeb\out\artifacts\myWeb_war_exploded\index.jsp
        /*
            思考：这个getRealPath()方法可以使用在什么样的场景？
            1.当一些配置信息的存放在项目中的时候，就可以使用该方法获取到项目的真实路径
         */
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
