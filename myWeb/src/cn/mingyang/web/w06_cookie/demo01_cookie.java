package cn.mingyang.web.w06_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  会话技术：
 *      1.会话：一次会话中包含多次请求和响应。
 *          一次会话：浏览器第一次给服务器资源发送请求，会话建立，直到有一方断开为止。
 *      2.功能：在一次会话的范围内的多次请求间，共享数据
 *      3.方式：
 *          1.客户端会话技术：Cookie
 *          2.服务器端会话技术：Session
 *
 *      Cookie:
 *          1.概念：客户端会话技术，将数据保存到客户端
 *          2.快速入门：
 *              1.创建Cookie对象，绑定数据
 *                  new Cookie(String name,String value)
 *              2.发送Cookie对象
 *                  response.addCookie(Cookie cookie)
 *              3.获取Cookie,拿到数据
 *                  Cookie[] request.getCookies()
 *
 *      Cookie技术的原理：
 *          其实就是利用Http协议，在服务器端设置了响应头，然后发送给浏览器，浏览器就会把Cookie自动解析，然后每次发送数据
 *          给服务器端，就会自动把对应的Cookie带上。
 *
 *
 */
@WebServlet("/demo01_cookie")
public class demo01_cookie extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("msg", "helloMingYang");
        resp.addCookie(cookie);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
