package com.mingYang.G03_Thread.impl;

public class MyThread03 extends Thread{

    public MyThread03() {
    }

    public MyThread03(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName());
    }
}
