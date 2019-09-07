package cn.mingyang.web.w01_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  Servlet相关配置
 *      1.urlpartten:Servlet访问路径
 *          (1).一个Servlet可以定义多个访问路径：@WebServlet({"/d4","/dd4","/ddd4"})
 *          (2).路径定义规则：
 *              a. /xxx
 *              b. /xxx/xx :多层路径，目录结构
 *              c. *.do
 */
//@WebServlet({"/d4","/dd4","/ddd4"})
//@WebServlet("/user/demo6")
//@WebServlet("demo6.do")
//@WebServlet("*.do")
public class ServletDemo06 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo06我来了");
    }
}
