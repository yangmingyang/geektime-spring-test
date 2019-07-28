package com.mingyang.Thread.safety;

import com.mingyang.Thread.impl.RunnableImpl03;

/**
 *  卖票案例出现了线程安全问题
 *  卖出了不存在的票和重复的票
 *
 *  解决线程安全问题的第一种方案：使用同步代码块
 *  格式：
 *      synchronized(锁对象){
 *          可能会出现的线程安全问题的代码（访问了共享数据的代码）
 *      }
 *
 *  注意：
 *      1.通过代码块中的锁对象，可以使用任意的对象
 *      2.但是必须保证多个线程使用了锁对象是同一个
 *      3.锁对象作用：
 *          把同步代码块锁住，只让一个线程在同步代码块中执行
 *
 */
public class Demo02Synchronized {
    public static void main(String[] args) {
        /**
         *  同步技术的原理：
         *      使用了一个锁对象，这个锁对象叫同步锁，也叫对象监视器
         *      3个线程一起抢夺cpu的执行权，谁抢到了谁执行run方法进行卖票
         *
         *      t0抢到了cpu的执行权，执行run方法，遇到synchronized代码块
         *      这时t0会检查synchronized代码块是否有锁对象
         *      发现有，就会获取到锁对象，进入到同步中执行
         *
         *      t1抢到了cpu的执行权，执行run方法，遇到synchronized代码块
         *      这时t1会检查synchronized代码块是否有锁对象
         *      发现没有，t1就会进入阻塞状态，会一直等待t0线程归还锁对象
         *      一直到t0线程执行完同步中的代码，会把锁对象归还给同步代码块
         *      t1才能获取到锁对象进入到同步代码中执行
         *
         *      总结：同步中的线程，没有执行完毕不会释放锁，同步外的线程没有锁进不去同步
         */
        RunnableImpl03 run = new RunnableImpl03();
        Thread t0 = new Thread(run);
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        t0.start();
        t1.start();
        t2.start();
    }
}
