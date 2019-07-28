package com.mingyang.Thread;

import com.mingyang.Thread.impl.MyThread03;

/**
 * 设置线程名称的两种方式：
 *      1. void setName(String name)  改变线程名称，使之与参数 name 相同。
 *      2.创建一个带参数的构造方法，参数传递线程的名称；调用父类的带参构造方法，把线程名称传递给父类，让父类（Thread）给子线程起一个名字
 *          Thread(String name)  分配新的 Thread 对象。
 */
public class Demo04SetThreadName {
    public static void main(String[] args) {
        /*MyThread03 myThread03= new MyThread03();
        myThread03.setName("mingyangThread");
        myThread03.start();*/

        //第二种方式
        MyThread03 myThread03= new MyThread03("xiaoyangThread");
        myThread03.start();
    }
}
