package cn.mingyang.web.w09_filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 Servlet、Filter、Listener这三个号称为javaWeb的三大组件

 Filter：过滤器
    1.概念：
        web中的过滤器：当访问服务器的资源时，过滤器可以将请求拦截下来，完全一些特殊的功能。
        过滤器的作用：
            一般用于完全通用的操作。如：登录验证、统一编码处理，敏感字符过滤...
    2.快速入门：
        1.步骤：
            1.定义一个类，实现接口Filter
            2.复写方法
            3.配置拦截路径
                1.web.xml
                2.注解
 */
//表示拦截所有链接
@WebFilter("/*")
public class demo01_filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //注意，一定要放行，拦截的资源才可以被访问到
        System.out.println("被拦截了。。。。。。");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
