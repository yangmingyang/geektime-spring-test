package com.grammar2.G01_extends;

/**
 *  在父子类的继承关系当中，如果成员变量重名，则创建子类对象是，访问有两种方式：
 *      1.直接通过子类对象访问成员变量：
 *          等号左边是谁，就优先用谁，没有则向上找。
 *      2.间接通过成员方法访问成员变量：
 *          该方法属于谁，就优先用谁，没有则向上找。
 *
 *  继承父类的好处：
 *  1.继承父类，就子类就可以直接使用父类的成员变量和方法
 */
public class Demo01_extends_field {
    public static void main(String[] args) {
        Father father = new Father();
        System.out.println(father.fatherNu);//10

        System.out.println("=======================");

        Son son = new Son();
        //1.继承父类，就子类就可以直接使用父类的成员变量和方法
        System.out.println(son.fatherNu);//10
        System.out.println(son.sonNu);//20

        //直接通过子类对象访问成员变量,等号左边是谁，就优先用谁，没有则向上找。
        System.out.println(son.str);//son

        System.out.println("=======================");
        //间接通过成员方法访问成员变量,该方法属于谁，就优先用谁，没有则向上找。
        son.sonMethod();//son

        System.out.println("========================");
        /**
         *  当子类和父类和局部变量都重名的情况先，如何区分局部变量，本类的成员变量，父类的成员变量。分别怎么调用？
         *      局部变量：直接写成员变量名
         *      本类的成员变量：this.成员变量名
         *      父类的成员变量：super.成员变量名
         *
         *         //局部变量
         *         String str ="Local";
         *         System.out.println("局部变量："+str);
         *         System.out.println("本类的成员变量："+this.str);
         *         System.out.println("父类的成员变量："+super.str);
         */
        son.method();

    }
}
