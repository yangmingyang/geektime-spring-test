package com.mingYang.Annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *  3.在程序使用（解析）注解
 *      1.获取注解定义的位置对象 （class,Method_Serializable,Field）
 *      2.获取指定的注解
 *          getAnnotation(class)：其实就是在内存中生成了一个该注解的子类实现对象。
 *          注意：我们实际上定义注解只是注意了一个抽象方法而已，但在实际使用的过程中，jvm会自动帮我们创建一个该子类的实现对象。
 *
 *      3.调用注解中的抽象方法获取配置的属性值。
 */
@Pro(className = "com.mingYang.Reflect.domain.Person",methodName="eat")
public class Demo03Annotation_reflect {
    /**
     *  案例：
     *      需求：写一个“框架”，不能改变该类的任何代码的前提下，可以帮我们创建任意类的对象，并且执行其中的任意方法。
     *  这次的优化是不在pro.properties配置文件中读取数据了，而是直接定义一个注解。通过注解的方式获取值。
     */
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        //需要先读取注解中的值，怎么获取注解中的值呢？
        //利用方式的方法，先获取反射类字节码对象
        Class<Demo03Annotation_reflect> cls = Demo03Annotation_reflect.class;
        Pro pro = cls.getAnnotation(Pro.class);
        String className = pro.className();
        String methodName = pro.methodName();
        System.out.println(className+"==="+methodName);

        //拿到了类名创建对象
        Class<?> aClass = Class.forName(className);
        Object o = aClass.newInstance();

        //先获取类中的方法
        Method method = aClass.getMethod(methodName);
        //调用对象的方法
        method.invoke(o);
    }
}
