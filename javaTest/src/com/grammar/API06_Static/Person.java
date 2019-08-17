package com.grammar.API06_Static;

public class Person {
    static {
        System.out.println("运行代码块的内容");
    }
    public Person(){
        System.out.println("运行构造方法");
    }
}
