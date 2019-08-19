package com.grammar2.G01_extends;

/**
 *  super关键字用来访问父类内容，而this关键字用来访问本类内容。用法也有三种。
 *      1.在本类的成员方法中，访问本类的成员变量。
 *      2.在本类的成员方法中，访问本类的另外一个成员方法。
 *      3.在本类的构造方法中，访问本类的另外一个构造方法。
 *
 *      在这三种用法当中要注意：
 *          a.this(...)调用也必须是构造方法的第一个语句，唯一一个。
 *          b.super和this两种构造调用，不能同时使用。
 */
public class Demo06_extends_this extends Father{
    //父类也有这个变量
    String str ="thisSon";

    public Demo06_extends_this(){
        //调用构造方法必须是在第一行，放在其他代码下面都会报错
        this(10);

        //1.在本类的成员方法中，访问本类的成员变量。
        System.out.println(this.str);
    }

    public Demo06_extends_this(int i){
        System.out.println("调用有参数的构造方法了:"+i);
    }

    public void methodA(){
        System.out.println("A方法");
        this.methodB();
    }

    public void methodB(){
        System.out.println("B方法");
    }


    public static void main(String[] args) {
        Demo06_extends_this obj = new Demo06_extends_this();
        /**
         * 答应的结果：
         * 父类无参构造器
         * 调用有参数的构造方法了:10
         * thisSon
         */
        obj.methodA();
    }
}
