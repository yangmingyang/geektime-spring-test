package com.mego.w06_proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 动态代理：
    特点：字节码随用随创建，随用随加载。
    作用：不修改源码的基础上对方法进行增强。
    分类：
        1.基于接口的动态代理。
        2.基于子类的动态代理。
    基于接口的动态代理：
        涉及的类：Enhancer
        提供者：第三方库cglib库
    如何创建代理对象：
        使用Enhancer类中的create方法
    创建代理对象的要求：
        被代理类不能是最终类
    create方法的参数：
        Class：字节码
            它是用于指定被代理对象的字节码。
        Callback：用于提供增强的代码
            它是让我们写如何代理。我们一般都是写一个该接口的实现类，通常情况下都是匿名内部类，但不是必须的。
            此接口的实现类都是谁用谁写。
            我们一般写的都是该接口的子接口实现类：MethodInterceptor
    需要引入依赖的jar:
         <dependency>
             <groupId>cglib</groupId>
             <artifactId>cglib</artifactId>
             <version>3.3.0</version>
         </dependency>
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();
        Producer producerCglib = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都会经过该方法
             * @param o
             * @param method
             * @param objects
             *  以上三个参数和基于接口的动态代理中invoke方法的参数时一样的
             * @param methodProxy   : 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //提供增强的代码
                Float money = (Float) objects[0];
                if (method.getName().equals("saleProduct")){
                    System.out.println("进来了" + money);
                }
                return method.invoke(producer,money * 0.8f);
            }
        });
        producerCglib.saleProduct(12000f);
    }
}
