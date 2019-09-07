package cn.mingyang.web.w01_servlet;

import javax.servlet.*;
import java.io.IOException;


/**
 *  Servlet：server applet
 *      概念：运行在服务器端的小程序。
 *          Servlet就是一个接口，定义了Java类被浏览器访问到（tomcat识别）的规则。
 *          将来我们自定义一个类，实现Servlet接口，复写方法。
 *
 *  快速入门：
 *      1.创建JavaEE项目
 *      2.定义一个类，实现Servlet接口
 *      3.实现接口中的抽象方法
 *      4.配置Servlet
 *
 *  执行原理：
 *      1.当服务器接受到客户端浏览器的请求后，会解析请求URL路径，获取访问的Servlet的资源路径。
 *      2.查找web.xml文件，是否有对应的<url-pattern>标签体内容。
 *      3.如果有，则在找到对应的<w01_servlet-class>全类名。
 *      4.Tomcat会将字节码文件加载进内存，并且创建其对象。
 *      5.调用其方法。
 *
 */
public class ServletDemo01 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException,
            IOException {
        //该方法每次请求都会被执行
        System.out.println("I am coming");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
