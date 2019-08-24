package com.mingYang.G03_Thread.impl;

public class RunnableImpl01 implements Runnable {
    @Override
    public void run() {
        System.out.println("我开启的新线程");
    }
}
