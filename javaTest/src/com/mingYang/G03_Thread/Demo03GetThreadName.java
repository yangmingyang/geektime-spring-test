package com.mingYang.G03_Thread;

import com.mingYang.G03_Thread.impl.MyThread02;

/**
 *  获取线程名称的两种方式
 *      1.static Thread currentThread() 返回对当前正在执行的线程对象的引用。
 *      2.String getName() 返回该线程的名称。
 *
 */
public class Demo03GetThreadName {
    public static void main(String[] args) {
        MyThread02 myThread02 = new MyThread02();
        myThread02.start();//Thread-0
        new MyThread02().start();//Thread-1
        System.out.println(Thread.currentThread().getName());//主线程的名称：main
    }
}
