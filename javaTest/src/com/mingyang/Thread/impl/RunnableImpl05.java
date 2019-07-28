package com.mingyang.Thread.impl;

public class RunnableImpl05 implements Runnable{
    //定义总共有100张票
    private static int ticket=100;
    @Override
    public void run() {
        while (true){
            ticketMethod();
        }
    }

    public static synchronized void ticketMethod(){
        if (ticket>0){
            System.out.println(Thread.currentThread().getName()+"第"+ticket+"张票");
            ticket--;
        }
    }
}
