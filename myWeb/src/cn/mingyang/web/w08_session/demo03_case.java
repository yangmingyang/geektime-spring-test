package cn.mingyang.web.w08_session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 案例：验证码
    1.案例需求：
        1.访问带有验证码的登录页面login.jsp
        2.用户输入用户名，密码以及验证码。
            如果用户名和密码输入有误，跳转登录页面，提示验证码错误
            如果验证码输入有误，跳转登录页面，提示：验证码错误
            如果全部输入正确，则跳转到主页success.jsp,显示：用户名，欢迎您
    涉及到的知识点：
        1.转发
        2.重定向
        3.验证码生成并保存到session中
    還是不是很明白轉發和重定向的區別
 */
@WebServlet("/demo03_case")
public class demo03_case extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");
        System.out.println(userName + ":" + password + ":" + checkCode);
        HttpSession session = req.getSession();
        String checkCodeSession = (String) session.getAttribute("checkCodeSession");
        //忽略大小寫作比較
        if (checkCodeSession.equalsIgnoreCase(checkCode)){
            if ("ming".equals(userName) && "123".equals(password)){
                //全部正确，转发到成功页面
                resp.sendRedirect(req.getContextPath()+"/success.jsp");
            }else {
                req.setAttribute("user_message","用戶名或者密碼錯誤");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }else{
            req.setAttribute("error_message","验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
