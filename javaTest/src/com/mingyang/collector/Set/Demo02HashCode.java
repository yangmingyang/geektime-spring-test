package com.mingyang.collector.Set;

import org.junit.Test;

/**
 *  哈希值：是一个十进制的整数，由系统随机给出（就是对象的地址值，是一个逻辑地址，是模拟出来得到地址，不是数据实际存储的物理地址）
 *  在Object类有一个方法，可以获取对象的哈希值
 *  int hashCode() 返回该对象的哈希码值
 *  hashCode方法的源码：
 *      public native int hashCode();
 *      native:代表该方法调用的是本地操作系统的方法
 *
 */
public class Demo02HashCode extends  Object{

    @Test
    public void demo1(){
        wife w = new wife();
        System.out.println(w.hashCode());//结果是一个随机的整数2025864991

        //String类也重写了hashCode方法
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}
