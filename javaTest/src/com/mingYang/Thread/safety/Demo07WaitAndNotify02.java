package com.mingYang.Thread.safety;

/**
 *  进入到TimeWaiting(计时等待)有两种方式
 *      1.使用sleep(long m)方法，在毫秒值结束之后，线程睡醒进入到Runnable/Blocked状态
 *      2.使用wait(long m)方法，wait方法如果在毫秒值结束之后，还没有被notify唤醒，就会自动醒来，线程睡醒进入到Runnable/Blocked状态
 *
 */
public class Demo07WaitAndNotify02 {
    public static void main(String[] args) {
        Object obj = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (obj){
                        try {
                            System.out.println("准备睡眠5秒");
                            obj.wait(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("睡醒后执行");
                        System.out.println("===========");
                    }
                }
            }
        }).start();
    }
}
