package com.mingYang.Thread.impl;

public class MyThread02 extends Thread{
    @Override
    public void run() {
        //第一种方式
        String threadName = getName();
        System.out.println(threadName);//Thread-0
        //第二种方式
        Thread threadName2 = Thread.currentThread();
        System.out.println(threadName2.getName());
    }
}
