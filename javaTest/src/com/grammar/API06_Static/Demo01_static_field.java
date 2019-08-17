package com.grammar.API06_Static;

/**
 *  如果一个成员变量使用了static关键字，那么这个变量不再属于对象自己，而是属于所在的类。多个对象共享同一份数据。
 */
public class Demo01_static_field {
    public static void main(String[] args) {
        Student student1 = new Student("张三丰",103);
        //注意：这个root属性只要赋值一次，则其他对象也可以使用该对象
        student1.room ="广州1班";

        System.out.println(student1.getId()+":"+student1.getName()+":"+student1.getAge()+":"+student1.room);
        //0:张三丰:103:广州1班

        Student student2 = new Student("张无忌",23);
        System.out.println(student2.getId()+":"+student2.getName()+":"+student2.getAge()+":"+student2.room);
        //1:张无忌:23:广州1班

    }
}
