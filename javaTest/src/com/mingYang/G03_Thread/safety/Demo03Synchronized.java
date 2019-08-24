package com.mingYang.G03_Thread.safety;

import com.mingYang.G03_Thread.impl.RunnableImpl04;

/**
 *  解决线程安全问题的第二种方案：使用同步方法
 *  使用步骤：
 *      1.把访问了共享数据的代码抽取出来，放到一个方法中
 *      2.在方法上添加synchronized修饰符
 *
 *  格式：定义方法的格式
 *  修饰符 synchronized 返回值类型 方法名（参数列表）{
 *      可能会出现线程安全问题的代码（访问了共享数据的代码）
 *  }
 *
 */
public class Demo03Synchronized {
    public static void main(String[] args) {
        /**
         *  定义一个不同方法
         *  同步方法也会把方法内部的代码锁住
         *  只让一个线程执行
         *
         *  同步方法的锁对象是谁？
         *  答：就是实现类对象 new RunnableImpl04(),也就是this
         *
         */
        RunnableImpl04 run = new RunnableImpl04();
        Thread t0 = new Thread(run);
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        t0.start();
        t1.start();
        t2.start();
    }

}
