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
 */
public class Demo01_innerClass {
    public static void main(String[] args) {
        Demo011_body obj = new Demo011_body();
        obj.setName("ymy");
        obj.methedBody();
        //思考内部类如何使用
    }
}
