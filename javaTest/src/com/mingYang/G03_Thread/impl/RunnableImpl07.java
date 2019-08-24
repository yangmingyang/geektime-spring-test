package com.mingYang.G03_Thread.impl;

public class RunnableImpl07 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
