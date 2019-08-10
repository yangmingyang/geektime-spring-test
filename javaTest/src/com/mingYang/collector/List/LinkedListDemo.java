package com.mingYang.collector.List;

import org.junit.Test;

import java.util.LinkedList;

/**
 * LinkedList集合的特点：
 * 1.查询慢，增删快。底层实现是链表结构
 * 2.里面包含了大量的首尾操作方法
 * 注意：使用LinkedList特有的方法，不能使用多态
 *
 */
public class LinkedListDemo {

    @Test
    public void demo01(){
        LinkedList<String> linked = new LinkedList<>();
        linked.add("I");
        linked.add("love");
        linked.add("you");
        System.out.println(linked);

        System.out.println("=================================");

        linked.addFirst("mingYang");
        //linked.push("mingYang");
        System.out.println(linked);

        System.out.println("=================================");
        linked.addLast("jiaoLi");
        System.out.println(linked);

        if(!linked.isEmpty()){
            System.out.println(linked.getFirst());
            System.out.println(linked.getLast());
        }

        System.out.println("=================================");
        linked.clear();
        System.out.println(linked);



    }



}
