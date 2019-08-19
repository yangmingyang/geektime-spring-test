package com.grammar2.G01_extends;

/**
 *  继承关系中，父子类构造方法的访问特点：
 *      1.子类构造方法当中有一个默认隐含的“super（）”调用，所以一定是先调用父类构造，后执行的子类构造。
 *      2.子类构造可以通过super关键字来调用父类重载构造。
 *      3.super的父类构造调用，必须是子类构造方法的第一个语句。不能一个子类构造调用多次super构造。
 *
 *      总结：
 *          子类必须调用父类构造方法，不写则赠送super（）；写了则用写的指定的super调用，super只能有一个，还必须是第一个。
 *
 */
public class Demo04_extends_constructor {
    public static void main(String[] args) {
        //当我们创建一个子类对象的时候，这里打印出什么来呢？
        Son son = new Son();
        /**
         * 结果就是打印出来这个结果：这就代表了验证了第一个结论
         * 1.子类构造方法当中有一个默认隐含的“super（）”调用，所以一定是先调用父类构造，后执行的子类构造。
         * 父类无参构造器
         * 子类无参构造器
         */
        System.out.println("==============================");
        son.m2();
    }
}