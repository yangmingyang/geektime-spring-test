package com.grammar2.G05_final;

/**
 *  一旦使用final用来修饰局部变量，那么这个变量就不能进行更改。
 *  “一次赋值，终生不变”
 */
public class Demo03_final_variable {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(num);
        num = 20;
        System.out.println(num);

        System.out.println("=========================");

        //只能被赋值一次
        final int num2 =100;
        //num2 = 250; //错误写法
        System.out.println(num2);

        //也可以这样写
        final int num3;
        num3 = 300;
        System.out.println(num3);

        System.out.println("========================");

        /**
         *  1.对于基本类型来说，不可变说的是变量当中的数据不可改变。
         *  2.对于引用类型来说，不可变说的是变量当中的地址值不可改变。
         */
        Student student = new Student("赵丽颖");
        System.out.println(student);//com.grammar2.G05_final.Student@19e1023e
        student = new Student("霍建华");
        //这样程序运行每次都会生成不同的地址值
        System.out.println(student);//com.grammar2.G05_final.Student@7cef4e59

        System.out.println("========================");

        final Student student1 = new Student("小沈阳");
        //student1 = new Student("xxy"); //错误写法
        //地址值虽然不能改变，但对象里面的内容可以改变
        System.out.println(student1.getName());

        student1.setName("赵本山");
        System.out.println(student1.getName());

    }
}
