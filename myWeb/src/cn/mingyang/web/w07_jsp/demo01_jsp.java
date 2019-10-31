package cn.mingyang.web.w07_jsp;

/**
JSP：入门学习
    1.概念：Java Server Pages：java服务器端页面
        可以理解为：一个特殊的页面，其中既可以指定定义html标签，又可以定义java代码
        用于简化书写

    2.原理：
        JSP本质上就是一个Servlet

    3.JSP的脚本：JSP定义Java代码的方式
        1.<% 代码 %>：定义的java代码，在service方法中。service方法中可以定义什么，该脚本中就可以定义什么。
        2.<%! 代码 %>：定义的java代码，在jsp转换后的java类的成员位置。
        3.<%= 代码 %>：定义的java代码，会输出到页面上。输出语句中可以定义什么，该脚本中就可以定义什么。

    4.JSP的内置对象
        在JSP页面中不需要获取和创建，可以直接使用的对象
        jsp一共有9个内置对象。
        今天学习3个：
            request
            response
            out：字符输出流对象。可以将数据输出到页面上。和response.getWriter()类似
                respnse.getWriter()和out.write()的区别：
                    在Tomcat服务器真正给客户端做出响应之前，会先找response缓冲区数据，再找out缓冲区数据。
                    response.getWriter()数据输出永远在out.write()之前
 */
public class demo01_jsp {
}
