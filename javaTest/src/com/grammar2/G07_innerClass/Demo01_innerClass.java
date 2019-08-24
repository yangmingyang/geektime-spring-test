package com.grammar2.G07_innerClass;

/**
 *  如果一个事物的内部包含另一个事务，那么这就是一个类内部包含另外一个类。
 *  例如：身体和心脏的关系。又如：汽车和发动机的关系。
 *
 *  分类：
 *      1.成员内部类
 *      2.局部内部类（包含匿名内部类）
 *
 *  成员内部类的定义格式：
 *  修饰符 class 外部类名称{
 *      修饰符 class 内部类名称{
 *          //...
 *      }
 *      //...
 *  }
 *
 *  注意：内用外，随意访问；外用内，需要内部类对象。
 *
 *  如何使用成员内部类？有两种方式：
 *      1.间接方式：在外部类的方法当中，使用内部类；然后main方法只是调用外部类的方法。
 *      2.直接方法：公式：
 *          类名称 对象名 = new 类名称();
 *          外部类名称.内部类名称 对象名 = new 外部类名称().new 内部类名称();
 */
public class Demo01_innerClass {
    public static void main(String[] args) {
        Demo011_body obj = new Demo011_body();
        obj.setName("ymy");

        //思考内部类如何使用
        //1.间接方式：在外部类的方法当中，使用内部类；然后main方法只是调用外部类的方法。
        obj.methedBody();

        System.out.println("===========================");

        //2.直接方法
        Demo011_body.Heart heart = new Demo011_body().new Heart();
        heart.beat();
    }
}
