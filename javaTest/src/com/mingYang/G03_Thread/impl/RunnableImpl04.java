package com.mingYang.G03_Thread.impl;

public class RunnableImpl04 implements Runnable{
    //定义总共有100张票
    private  int ticket=100;
    @Override
    public void run() {
        while (true){
            ticketMethod();
        }
    }

    public synchronized void ticketMethod(){
        if (this.ticket>0){
            System.out.println(Thread.currentThread().getName()+"第"+ticket+"张票");
            this.ticket--;
        }
    }
}
