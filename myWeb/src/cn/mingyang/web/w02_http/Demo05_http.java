package cn.mingyang.web.w02_http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/Demo05_http")
public class Demo05_http extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * String getParameter(String name):根据参数名词获取参数值
         * String[] getParameterValues(String name):根据参数名称获取参数值的数组
         * Enumeration<String> getParameterNames():获取所有请求的参数名称
         * Map<String,String[]> getParameterMap():获取所有参数的map集合
         */
        String userName = req.getParameter("userName");
        System.out.println(userName);

        System.out.println("=======getParameterNames================");

        //该方法有一个弊端，如果是参数的结果是一个集合，则只能获取到一个值
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            System.out.println("参数名：" + name);
            System.out.println(req.getParameter(name));
        }

        System.out.println("=====getParameterValues========================");

        String[] hobbies = req.getParameterValues("hobby");
        for(String hobby : hobbies){
            System.out.println(hobby);
        }

        System.out.println("===getParameterMap==========");
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        for(String key : keySet){
            System.out.println("参数名：" + key);
            String[] strings = parameterMap.get(key);
            for (String s : strings){
                System.out.println(s);
            }
        }
    }
}
