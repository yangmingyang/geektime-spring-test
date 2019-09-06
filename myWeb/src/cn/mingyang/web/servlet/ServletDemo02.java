package cn.mingyang.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 *  Servlet中的生命周期：
 *      1.被创建：执行init方法，只执行一次。
 *          Servlet什么时候被创建？
 *              默认情况下，第一次被访问时，Servlet被创建
 *              可以配置执行Servlet的创建时机。
 *                  在<servlet>标签下配置
 *                      1.第一次被访问时，创建
 *                          <load-on-startup>的值为负数
 *                      2.在服务器启动时，创建
 *                          <load-on-startup>的值为0或正整数
 *          Servlet的init方法，只执行一次，说明一个Servlet在内存中只存在一个对象，Servlet是单例的
 *              多个用户同时访问时，可能存在线程安全问题。
 *              解决：尽量不要在Servlet中定义成员变量。即使定义了成员变量，页不要对其进行修改值。
 *
 *      2.提供服务：执行service方法，执行多次。
 *          每次访问Servlet时，Service方法都会调用一次。
 *
 *      3.被销毁：执行destroy方法，只执行一次。
 *          Servlet被销毁时执行。服务器关闭时，Servlet被销毁
 *          只有服务器正确关闭时，才会执行destroy方法。
 *          destroy方法在Servlet被销毁之前执行，一般用于释放资源。
 *
 */
public class ServletDemo02 implements Servlet {

    /**
     * 只会被执行一次的初始化方法
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    /**
     * 获取ServletConfig对象
     * ServletConfig：Servlet的配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务方法
     * 每一次Servlet被访问时，执行。执行多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
        System.out.println("正在执行ServletDemo02");
    }

    /**
     * 获取Servlet的一些信息，版本，作者等等
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     *  销毁方法
     *  在服务器正常关闭时，执行，执行一次。
     */
    @Override
    public void destroy() {
        System.out.println("destroy方法");
    }
}
