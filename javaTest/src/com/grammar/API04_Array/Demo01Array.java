package com.grammar.API04_Array;

/**
 *  题目：定义一个数组，用来存储3个Person对象。
 *      数组有一个缺点：一旦创建，程序运行期间长度不可以发生改变。
 */
public class Demo01Array {
    public static void main(String[] args) {
        Person[] lists = new Person[2];
        //这样写去赋值是错误的：lists[0].setName("赵丽颖");
        /*lists[0].setName("赵丽颖");
        lists[1].setName("范冰冰");*/

        //因为一个lists[0]代表是一个对象
        lists[0] = new Person("赵丽颖",28);
        lists[1] = new Person("范冰冰",35);
        //lists[3] = new Person("范冰冰",35);//这样赋值会报数组越界的错误：Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
        System.out.println(lists);//注意：数组打印出来的是一个地址值
    }
}
