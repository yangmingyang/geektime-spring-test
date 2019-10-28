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
 *          基于响应头set-cookie和请求头cookie实现
 *          其实就是利用Http协议，在服务器端设置了响应头，然后发送给浏览器，浏览器就会把Cookie自动解析，然后每次发送数据
 *          给服务器端，就会自动把对应的Cookie带上。
 *
 *      cookie的细节：
 *          1.一次可以不可以发送多个cookie?
 *              可以
 *              可以创建多个Cookie对象，使用response调用多次addCookie方法发送cookie即可。
 *          2.cookie在浏览器中保存多长时间？
 *              1.默认情况下，当浏览器关闭后，Cookie数据被销毁
 *              2.持久化存储：
 *                  setMaxAge(int seconds)
 *                      1.正数：将Cookie数据写到硬盘的文件中。持久化存储。cookie存活时间。
 *                      2.负数：默认值，代表关闭浏览器后，cookie信息被删除
 *                      3.零：删除cookie信息
 *          3.cookie能不能存中文？
 *              在Tomcat8之前，cookie中不能直接存储中文数据。
 *                  需要将中文数据转码---一般采用URL编码（%E3）
 *              在Tomcat8之后，cookie支持中文数据。
 *          4.cookie共享问题？
 *              1.假设在一个Tomcat服务器中，部署了多个web项目，那么在这些web项目中cookie能不能共享？
 *                  默认情况下cookie不能共享，但我们可以通过setPath（String path）方法设置cookie可以共享。
 *
 *                  setPath（String path）：设置cookie的获取范围。默认情况下，设置当前的虚拟目录。
 *                      如果要共享，则可以将path设置为“/”
 *
 *              2.不同的Tomcat服务器间cookie共享问题？
 *                  setDomain(String path):如果设置一级域名相同，那么多个服务器之间cookie可以共享。
 *                  比如：setDomain(".baidu.com"),那么tieba.baidu.com和news.baidu.com中的cookie可以共享
 *                  注意：这种方式可能会在电商的项目中使用到。
 *
 *      Cookie的特点和作用
 *          1.cookie存储数据在客户端浏览器
 *          2.浏览器对于单个cookie的大小有限制（4kb）以及对同一个域名下的总cookie数量也有限制（20个）
 *
 *          作用：
 *              1.cookie一般用于存储少量的不太敏感的数据
 *              2.在不登录的情况下，完全服务器对客户端的身份识别
 */
@WebServlet("/demo01_cookie")
public class demo01_cookie extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("msg", "helloMingYang");
        resp.addCookie(cookie);

        Cookie cookie1 = new Cookie("dataPersistence", "setMaxAge");
        //持久化存储,30秒后，自动被浏览器删除
        cookie1.setMaxAge(30);
        resp.addCookie(cookie1);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
