package com.grammar.API06_Static;

public class MyClass {
    //成员变量
    int num;

    //静态变量
    static int numStatic;

    public void methoed(){
        System.out.println(num);
        System.out.println(numStatic);
        System.out.println("这是一个成员方法");

    }

    public static void staticMethod(){
        System.out.println("这是一个静态方法");
        System.out.println(numStatic);
        //静态不能直接访问非静态【重点】
        //System.out.println(num);

        //静态方法中不能使用this关键字。直接报错
        //System.out.println(this);
    }
}
