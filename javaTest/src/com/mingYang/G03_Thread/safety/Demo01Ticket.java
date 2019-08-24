package com.mingYang.G03_Thread.safety;

import com.mingYang.G03_Thread.impl.RunnableImpl02;

/**
 *  模拟多窗口卖票的场景，因为共享了数据，所以就有线程安全的问题
 *
 */
public class Demo01Ticket {
    public static void main(String[] args) {
        RunnableImpl02 run = new RunnableImpl02();
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);
        t1.start();
        t2.start();
        t3.start();
    }
}
