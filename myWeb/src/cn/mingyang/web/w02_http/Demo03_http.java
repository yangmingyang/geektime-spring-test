package cn.mingyang.web.w02_http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 *  String getHeader(String name)：通过请求头的名称获取请求头的值。(该方法比较常用)
 *  Enumeration<String> getHeaderNames()：获取所有的请求头名称。
 */
@WebServlet("/Demo03_http")
public class Demo03_http extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String header = request.getHeader(name);
            System.out.println(name+"===="+header);
        }
        /**
         *  防盗链中使用到的头部：referer必须是从链接中点击进来的，才有值。直接从浏览器中输入访问时没有值的。
         *
         */
    }
}
