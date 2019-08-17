package com.grammar.API06_Static;

/**
 *  静态代码块的格式：
 *  public class 类名称{
 *      static{
 *          //静态代码块的内容
 *      }
 *  }
 *
 *  特点：
 *      当第一次用到本类时，静态代码块执行唯一的一次。
 *      静态内容总是优先于非静态，所以静态代码块比构造方法先执行。
 *
 *  用途：
 *      用来一次性地对静态成员变量进行赋值。
 *      比如jdbc里面配置文件的加载。
 *
 */
public class Demo03_static_block {
    public static void main(String[] args) {
        //首次创建对象的时候才会运行代码块的内容
        Person p1 = new Person();
        Person p2 = new Person();
        /**
         * 所以结果是：代码块的内容只能被执行唯一的一次。
         * 运行代码块的内容
         * 运行构造方法
         * 运行构造方法
         */
    }
}
