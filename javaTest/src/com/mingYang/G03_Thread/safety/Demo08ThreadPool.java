package com.mingYang.G03_Thread.safety;

import com.mingYang.G03_Thread.impl.RunnableImpl07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  线程池：JDK1.5之后提供
 *  java.util.concurrent.Executors：线程池的工厂类，用来生产线程池
 *  Executors类中的静态方法：
 *      static ExecutorService newFixedThreadPool(int nThreads)  创建一个可重用固定线程数的线程池
 *      参数：
 *          int nThreads:创建线程池中包含的线程数量
 *      返回值：
 *          ExecutorService接口，返回的是ExecutorService接口的实现类对象，我们可以使用ExecutorService接口接收（面向接口编程）
 *
 *  java.util.concurrent.ExecutorService : 线程池接口
 *      1.用来从线程池中获取线程，调用start方法，执行线程任务
 *          submit(Runnable task)  提交一个 Runnable 任务用于执行
 *      2.关闭/销毁线程池的方法：
 *          void shutdown()
 *
 *  线程池的使用步骤：
 *      1.使用线程池的工厂类Executors里面提供的静态方法newFixedThreadPool生产一个指定线程数量的线程池
 *      2.创建一个类，实现Runnable接口，重写run方法，设置线程任务
 *      3.调用ExecutorService中的方法submit，传递线程任务（实现类），开启线程，执行run方法
 *      4.调用ExecutorService中的方法shutdown销毁线程池（不建议执行）
 *
 */
public class Demo08ThreadPool {
    public static void main(String[] args) {
        //自动补全前面的变量快捷键是ctrl+alt+v
        //自动补全属性名称 : Ctrl + Alt + f
        //复制上一行是ctrl+d
        //1.使用线程池的工厂类Executors里面提供的静态方法newFixedThreadPool生产一个指定线程数量的线程池
        ExecutorService ex = Executors.newFixedThreadPool(2);
        //3.调用ExecutorService中的方法submit，传递线程任务（实现类），开启线程，执行run方法
        ex.submit(new RunnableImpl07());
        ex.submit(new RunnableImpl07());
        ex.submit(new RunnableImpl07());
        //4.调用ExecutorService中的方法shutdown销毁线程池（不建议执行）
        ex.shutdown();
        //线程池已经关闭的情况下再来调用submit方法就会报错了
        // ex.submit(new RunnableImpl07());
    }
}
