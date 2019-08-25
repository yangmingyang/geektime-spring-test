package com.grammar3.G01_Object;

/**
 *  Person类默认继承了Object类，所以可以使用Object类的equals方法
 *  boolean equals(Object obj) 指示其他某个对象是否与此对象“相等”。
 *  equals方法的源码：
 *      public boolean equals(Object obj) {
 *         return (this == obj);
 *     }
 *     参数：
 *          Object obj:可以传递任意的对象；
 *          == 比较运算符，返回的是一个布尔值 true false；
 *          基本数据类型：比较的是值；
 *          引用数据类型：比较的是两个对象的地址值；
 *     this是谁？ 那个对象调用的方法，方法中的this就是那个对象；p1调用的equals方法，所以this就是p1；
 *     obj是谁？ 传递过来的参数p2;
 *     this == obj   --> p1==p2
 *
 *  Object类的equals方法，默认比较的是两个对象的地址值，没有意义；
 *  所以我们要重写equals方法，比较两个对象的属性（name,age）;
 *  问题：
 *      隐藏着一个多态
 *          多态的弊端：无法使用子类特有的内容（属性和方法）
 *          解决方法：可以使用向下转型（强转）把obj类型转换我Person;
 *
 */
public class Demo01_object {
    public static void main(String[] args) {
        Person p1 = new Person("小洋");
        Person p2 = new Person("小明");
        boolean b = p1.equals(p2);
        System.out.println(b);

        System.out.println("=================");

        p2=p1;
        boolean b1 = p1.equals(p2);
        System.out.println(b1);

    }
}
