package com.mingYang.Thread.impl;

public class RunnableImpl03 implements Runnable{
    //定义一锁对象,锁对象可以是任意的对象
    Object obj = new Object();
    //定义总共有100张票
    private  int ticket=100;
    @Override
    public void run() {
        while (true){
            synchronized (obj){
                if (ticket>0){
                    System.out.println(Thread.currentThread().getName()+"第"+ticket+"张票");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket--;
                }
            }
        }
    }
}
