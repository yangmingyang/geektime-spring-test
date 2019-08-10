package com.mingYang.Thread.safety;



/**
 *  等待唤醒案例：线程之间的通信
 *      创建一个顾客线程（消费者）：告知老板要的包子的种类和数量，调用wait方法，放弃cpu的执行，进入到WAITING状态（无限等待）
 *      创建一个老板线程（生产者）：花了5秒做包子，做好包子之后，调用notify方法，唤醒顾客吃包子
 *
 *  注意：
 *      1.顾客和老板线程必须的使用同步代码块包裹起来，保证等待和唤醒只能有一个在执行
 *      2.同步使用的锁对象必须保证唯一
 *      3.只有锁对象才能调用wait和notify方法
 *
 *  Object类中的方法
 *       void wait()  在其他线程调用此对象的 notify() 方法或 notifyAll() 方法前，导致当前线程等待。
 *
 */
public class Demo06WaitAndNotify {
    public static void main(String[] args) {
        Object obj = new Object();
        //消费者线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("消费者：我要买包子了");
                    synchronized (obj) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("消费者：我知道了，谢谢老板的包子");
                    System.out.println("======================================");
                }
            }
        }).start();

        //老板的线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("老板：5秒后我做好了包子了");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj){
                        obj.notify();
                    }
                }
            }
        }).start();
    }

}
