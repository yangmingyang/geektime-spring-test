package com.mingYang.Thread.impl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableImpl06 implements Runnable{
    //定义总共有100张票
    private  int ticket=100;
    Lock l = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            l.lock();
            try {
                if (ticket>0){
                    System.out.println(Thread.currentThread().getName()+"第"+ticket+"张票");
                    Thread.sleep(10);
                    ticket--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                l.unlock();
            }
        }
    }
}
