package cn.mingyang.web.w08_session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
Session:
    1.概念：服务器端会话技术，在一次会话的多次请求间共享数据，将数据保存在服务器端的对象中。HttpSession
        注意：在这里强调的一次会话的多次请求间

    2.快速入门：
        1.获取HttpSession对象：
            HttpSession session = request.getSession();
        2.使用HttpSession对象：
            Object getAttribute(String name)
            void setAttribute(String name,Object value)
            void removeAttribute(String name)
    3.原理；
        Session的实现是依赖于Cookie的。
            第一次请求的时候，后台会响应：set-cookie:JSESSIONID=2297437362CC4BE157E7F43D66783A8D
            之后如果在一次会话之内请求，请求头中会带一个cookie:JSESSIONID=2297437362CC4BE157E7F43D66783A8D

        疑问：
            1.服务器如何确保在一次会话范围内，多次获取的Session对象是同一个？？？
            2.这里说Session的实现是依赖cookie，那如果用户把浏览器cookie禁用了，那是不是就意味着session就失效了？？？

    4.细节：
        1.当客户端关闭后，服务器不关闭，两次获取session是否为同一个？
            默认情况下，不是。
            如果需要相同，则可以创建Cookie，键为JSESSIONID,设置最大存活时间，让cookie持久化保存。
                 Cookie cookie = new Cookie("JSESSIONID", session.getId());
                 // 设置cookie有效时间为1个小时
                 cookie.setMaxAge(60 * 60);
                 resp.addCookie(cookie);

        2.客户端不关闭，服务器关闭后，两次获取的session是同一个吗？
            不是同一个，但是要确保数据不丢失。Tomcat自动完成以下工作
                session的钝化：
                    在服务器（正常关闭）之前，将session对象系列化到硬盘上。
                    在Tomcat的work目录上会创建一个SESSIONS.ser文件
                session的活化:
                    在服务器启动后，将session文件转化为内存中的session对象即可。
                    Tomcat会自动去work目录上读取SESSIONS.ser文件
            该技术的使用场景：
                比如以后使用java实现的购物车功能，如果不确保session数据不丢失，就会出现消费者把加入购物车商品都丢失，
                消费者不相信我们的网站，从而丢失客户流量。

        3.session什么时候被销毁？
            1.服务器关闭
            2.session对象调用invalidate()方法也会自动销毁。
            3.session默认失效时间 30分钟。
                我们可以在Tomcat的web.xml文件中进行修改
                <session-config>
                    <session-timeout>30</session-timeout>
                </session-config>

        4.session的特点：
            1.session用于存储一次会话的多次请求的数据，存储在服务器端。
            2.session可以存储任意类型，任意大小的数据。

        session与Cookie的区别：
            1.session存储数据在服务器端，Cookie存储在客户端。
            2.session没有数据大小限制，Cookie有。
            3.session数据安全，Cookie相对于不安全。
 */
@WebServlet("/demo01_session")
public class demo01_session extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("msg","hello");

        System.out.println(session);

        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        // 设置cookie有效时间为1个小时
        cookie.setMaxAge(60 * 60);
        resp.addCookie(cookie);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
