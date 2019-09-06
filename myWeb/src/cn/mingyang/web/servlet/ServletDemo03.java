package cn.mingyang.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 *  Servlet3.0以上版本有一个好处：支持注解配置，可以不需要web.xml了。
 *
 *  步骤：
 *      1.创建JavaEE项目，选择Servlet的版本3.0以上，可以不创建web.xml
 *      2.定义一个类，实现Servlet接口
 *      3.复写方法
 *      4.在类上使用@WebServlet注解，进行配置
 *      如下所示
 */


/*@WebServlet("demo03")*/
public class ServletDemo03 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet3.0以上版本我来了");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
