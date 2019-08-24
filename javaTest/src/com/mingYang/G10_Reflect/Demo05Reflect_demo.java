package com.mingYang.G10_Reflect;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 *  案例：
 *      需求：写一个“框架”，不能改变该类的任何代码的前提下，可以帮我们创建任意类的对象，并且执行其中的任意方法。
 *  实现的思路:
 *      1.配置文件
 *      2.反射
 *  实现的步骤：
 *      1.将需要创建的对象的全类名和需要执行的方法定义在配置文件中。
 *      2.在程序中加载读取配置文件。
 *      3.使用反射技术来加载文件进内存中。
 *      4.创建对象。
 *      5.执行方法
 */
public class Demo05Reflect_demo {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        //2.在程序中加载读取配置文件。
        properties.load(new FileInputStream("D:\\code\\myselfCode\\geektime\\geektime-spring-test\\javaTest\\src\\com\\mingYang\\G10_Reflect\\pro.properties"));
        String className = (String) properties.get("className");
        String methodName = (String) properties.get("classMethod");
        System.out.println(className+"=="+methodName);

        //3.使用反射技术来加载文件进内存中。
        Class<?> aClass = Class.forName(className);
        /*//获取构造方法
        Constructor<?> constructor = aClass.getConstructor();
        //创建对象
        Object obj = constructor.newInstance();*/
        /**
         * 这里有一个简单的方法，如果是创建无参的对象，可以直接这样调
         */
        Object obj = aClass.newInstance();
        //获取类方法
        Method method = aClass.getMethod(methodName);
        //调用方法
        method.invoke(obj);
    }
}
