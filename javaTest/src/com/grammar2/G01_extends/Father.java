package com.grammar2.G01_extends;

public class Father {
    int fatherNu=10;
    //定义一个和子类同名的变量
    String str ="father";

    public Father(){
        System.out.println("父类无参构造器");
    }

    public Father(int i){
        System.out.println("父类有参构造器");
    }

    public void fs(){
        System.out.println("调用的是父类对象");
    }

    public void m(){
        System.out.println("我是父类的方法");
    }
}
