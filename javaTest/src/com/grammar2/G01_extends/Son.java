package com.grammar2.G01_extends;

/**
 *  继承有什么好处：
 *      1.继承父类，就子类就可以直接使用父类的成员变量和方法
 *
 *  super关键字的三种用法：
 *      1.在子类的成员方法中，访问父类的成员变量。
 *      2.在子类的成员方法中，访问父类的成员方法。
 *      3.在子类的构造方法中，访问父类的构造方法。
 */
public class Son extends Father{
    int sonNu=20;
    //定义一个和父类同名的变量
    String str ="son";

    public Son(){
        //子类构造可以通过super关键字来调用父类重载构造。
        //super();//这样是默认调用父类的无参构造方法

        //3.super的父类构造调用，必须是子类构造方法的第一个语句。不能一个子类构造调用多次super构造。
        //子类必须调用父类构造方法，不写则赠送super（）；写了则用写的指定的super调用，super只能有一个，还必须是第一个。
        //意思是如果super();  和 super(10); 同事使用，编译器就会报错
        super(10);////3.在子类的构造方法中，访问父类的构造方法。

        System.out.println("子类无参构造器");
    }

    public void sonMethod(){
        System.out.println(this.str);
    }

    /**
     *  如何区分局部变量，本类的成员变量，父类的成员变量。分别怎么调用？
     *      局部变量：直接写成员变量名
     *      本类的成员变量：this.成员变量名
     *      父类的成员变量：super.成员变量名
     */
    public void method(){
        //局部变量
        String str ="Local";
        System.out.println("局部变量："+str);
        System.out.println("本类的成员变量："+this.str);
        //1.在子类的成员方法中，访问父类的成员变量。
        System.out.println("父类的成员变量："+super.str);
    }

    public void fs(){
        System.out.println("调用的是子类对象");
    }


    @Override
    public void m(){
        System.out.println("重新父类的m方法");
    }

    public void m2(){
        super.m();
    }

}
