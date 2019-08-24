package com.mingYang.G11_Annotation.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 需求：写一个测试方法，把所有Calculate类中带有Check注解的方法都能自动化测试
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        //目的要先获取Calculate中所有需要测试的方法
        Class<Calculate> calculateClass = Calculate.class;
        Calculate calculate = calculateClass.newInstance();

        Method[] methods = calculateClass.getMethods();
        for (Method method : methods){
            //System.out.println(method.getName());
            if(method.isAnnotationPresent(Check.class)){
                //System.out.println(method.getName());
                //获取到方法后，就是调用该方法了
                try {
                    method.invoke(calculate);
                }catch (Exception e){
                    System.out.println(e.getCause().getMessage());
                }

            }
        }
    }
}
