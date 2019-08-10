package com.mingYang.Thread.safety;

import com.mingYang.Thread.impl.RunnableImpl06;

/**
 *  解决线程安全问题的第三种方案：使用Lock锁
 *  java.util.concurrent.locks 接口
 *  Lock 实现提供了比使用 synchronized 方法和语句可获得的更广泛的锁定操作。
 *
 *  java.util.concurrent.locks.ReentrantLock类 implement Lock接口
 *
 *  Lock接口中的方法：
 *       void lock() 获取锁。
 *       void unlock() 释放锁。
 *
 *  使用步骤：
 *      1.在成员位置创建一个ReentrantLock对象
 *      2.在可能会出现安全问题的代码前调用Lock接口中的lock获取锁
 *      3.在可能会出现安全问题的代码后调用Lock接口中的方法unlock释放锁
 */
public class Demo05Lock {
    public static void main(String[] args) {
        RunnableImpl06 run = new RunnableImpl06();
        Thread t0 = new Thread(run);
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        t0.start();
        t1.start();
        t2.start();
    }
}
