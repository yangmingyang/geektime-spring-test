package com.mingYang.Thread;

/**
 *  static void sleep(long millis)
 *           在指定的毫秒数内让当前正在执行的线程休眠（暂停执行），此操作受到系统计时器和调度程序精度和准确性的影响。
 */
public class Demo05ThreadSleep {
    public static void main(String[] args) {
        for (int i=1;i<10;i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
