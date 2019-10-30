package cn.mingyang.web.w06_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
    案例：记住上一次访问时间
        1.需求：
            1.访问一个Servlet,如果是第一次访问，则提示：您好，欢迎您首次访问。
            2.如果不是第一次访问，则提示：欢迎回来，您上次访问时间为：显示时间字符串。

 */
@WebServlet("/demo04_case")
public class demo04_case extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean flag = false;
        Cookie[] cookies = req.getCookies();
        //输出是中文乱码，所以要设置响应头
        resp.setContentType("text/html;charset=utf-8");

        for (Cookie c : cookies){
            String name = c.getName();
            if (name.equals("lastTime")){
                flag = true;

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String format = simpleDateFormat.format(new Date());

                //为了防止中文，因为cookie不允许有空格，所以需要使用URLDecoder进行编码
                format = URLEncoder.encode(format,"utf-8");
                Cookie cookie = new Cookie("lastTime", format);

                //设置cookie有效时间为一个月，这是保存到文件去的
                cookie.setMaxAge(60 * 60 * 24 * 30);
                resp.addCookie(cookie);

                String value = c.getValue();
                //解码
                value = URLDecoder.decode(value, "utf-8");

                resp.getWriter().write("欢迎回来，您上次访问时间为："+value);
                //跳出单次循环
                break;
            }
        }
        if (cookies.length==0 || flag == false){
            //第一次访问
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String format = simpleDateFormat.format(new Date());
            //通过URLEncoder进行解码
            format = URLEncoder.encode(format,"utf-8");
            Cookie cookie = new Cookie("lastTime", format);
            resp.addCookie(cookie);
            resp.getWriter().write("您好，欢迎您首次访问");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
