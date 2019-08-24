package com.grammar2.G04_multi;

/**
 *  在代码中体现多态性，其实就是一句话：父类引用指向子类对象。
 *  格式：
 *      父类名称 对象名 = new 子类名称（）；
 *      或者：
 *      接口名称 对象名 = new 实现类名称（）；
 *
 *  访问成员变量的两种方式：
 *      1.直接通过对象名称访问成员变量：看等号左边是谁，优先使用谁，没有则向上找。
 *      2.间接通过成员方法访问成员变量：看该方法属于谁，优先使用谁，没有则向上找。
 *
 */
public class Demo01_multi_concept {
    public static void main(String[] args) {
        Father father = new Son();//这样的写法就是多态，父类引用指向子类对象。
        System.out.println(father.str);//father

        //子类没有覆盖重写，就是父。
        //子类如果覆盖重写，就是子
        father.showString();//son
    }
}
