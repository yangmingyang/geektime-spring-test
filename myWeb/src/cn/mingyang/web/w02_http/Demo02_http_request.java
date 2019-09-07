package cn.mingyang.web.w02_http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  1.获取请求方式:GET
 *      * String getMethod()
 *  2.获取虚拟目录：/day14
 *      * String getContextPath()
 *  3.获取Servlet路径：/demo1
 *      * String getServletPath()
 *  4.获取get方式请参数：name=zhangsan
 *      * String getQueryString()
 *  5.获取请求URI:/day14/demo1
 *      * String getRequestURI(): /day14/demo1
 *      * StringBuffer getRequestURL(): http://localhost/day14/demo1
 *      * URL:统一资源定位符：http://localhost/day14/demo1
 *      * URI:统一资源标识符：/day14/demo1
 *        注意：URI的范围比URL的访问大
 *  6.获取协议及版本：HTTP/1.1
 *      * String getProtocol()
 *  7.获取客户端的ip地址
 *      * String getRemoteAddr()
 */
@WebServlet("/request02")
public class Demo02_http_request extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求方式:GET  String getMethod()
        String method = req.getMethod();
        System.out.println(method);

        //2.获取虚拟目录：/day14  String getContextPath()
        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        //3.获取Servlet路径：/demo1   * String getServletPath()
        String servletPath = req.getServletPath();
        System.out.println(servletPath);

        //4.获取get方式请参数：name=zhangsan  * String getQueryString()
        String queryString = req.getQueryString();
        System.out.println(queryString);

        //5.获取请求URI:/day14/demo1
        // String getRequestURI(): /day14/demo1
        // StringBuffer getRequestURL(): http://localhost/day14/demo1
        String requestURI = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURI);
        System.out.println(requestURL);

        //6.获取协议及版本：HTTP/1.1
        // * String getProtocol()
        String protocol = req.getProtocol();
        System.out.println(protocol);

        //7.获取客户端的ip地址
        //* String getRemoteAddr()
        String remoteAddr = req.getRemoteAddr();
        System.out.println(remoteAddr);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
