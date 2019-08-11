package com.mingYang.Annotation;

/**
 *  自定义的一个注解，反编译完就是这样的：public interface MyAnnotation extends java.lang.annotation.Annotation{ }
 */
public @interface MyAnnotation {
    //int类型,基本数据类型
    int age();
    //枚举
    Sex sex();
    //注解
    MyAnnotation2 m2();
    //数组
    String[] name();
}
