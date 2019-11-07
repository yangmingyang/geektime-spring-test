package cn.mingyang.web.w10_listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;

/**
 Listener：监听器
    概念：web的三大组件之一。
        事件监听机制
            事件：一件事情
            事件源：事件发生的地方
            监听器：一个对象
            注册监听：将事件、事件源、监听器绑定在一起。当事件源上发生某个事件后，执行监听器代码。
    ServletContextListener：监听ServletContext对象的创建和销毁
        void contextDestroyed(ServletContextEvent sce)：ServletContext对象被销毁之前会调用该方法。
        void contextInitialized(ServletContextEvent sce)：ServletContext对象创建后会调用该方法。
    步骤：
        1.定义一个类，实现ServletContextListener接口
        2.复写方法
        3.配置方式有以下两种
            1.web.xml
                 <listener>
                    <listener-class>cn.mingyang.web.w10_listener.demo01_listener</listener-class>
                 </listener>
                还可以指定初始化参数：使用<context-param></context-param>标签
            2.注解方式
                @WebListener
 */
//@WebListener
public class demo01_listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //ServletContext对象创建后会调用该方法。一般用于加载资源使用
        System.out.println("servletContext对象被创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //ServletContext对象被销毁之前会调用该方法。
        System.out.println("servletContext对象被销毁了");
    }
}
