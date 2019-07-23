package com.mingyang.collector.main;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo01 {
    /**
     * Collector是所有集合的父类，所以需要先先学该类的共性方法
     * 集合的数据结构有哪几种呢？
     * 1.栈结构：特点：先进后出，类似子弹夹
     * 2.队列的结构： 特点：先进先出
     * 3.数组结构： 特点：查询快，增删慢
     * 为什么数组查询快？ 因为数组的地址是连续的，我们可以通过数组的首地址查到数组，通过数组的索引可以快速查找到某一个元素
     * 增删慢的原因：数组的长度是固定的，我们想要增加或者删除一个元素，必须创建一个新的数组，把源数组复制过来
     * 4.链表结构： 特点：查询慢，增删快
     * 查询慢的原因：链表中的地址是不连续的，每次查询元素，都必须从头开始查起
     * 增删快的原因：链表结构，增加或者是删除一个元素，对链表的整体结构都没有什么影响，所以增删快
     * 5.红黑树结构： 特点：趋近于平衡树，查询的速度非常快，查询叶子节点最大次数和最小次数都不能超过2倍
     */
    @Test
    public  void demo01(){
        //new 对象指向其父类，这在java中叫多态
        Collection<String> e = new ArrayList();
        e.add("范冰冰");
        e.add("李冰冰");

        //循环的几种方式
        //第一种：增强for循环，只能针对集合和数组进行遍历，其他类型的数据是不能使用增强for循环的
        for (String str : e){
            System.out.println(str);
        }
        System.out.println("=============================");
        //第二种方式；迭代器循环读取
        Iterator<String> it = e.iterator();
        while (it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
    }

}
