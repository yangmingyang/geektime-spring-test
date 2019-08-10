package com.mingYang.collector.Set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * set接口的特点：
 *      1.不可以有重复的元素
 *      2.没有索引，没有带索引的方法，所以也不能使用普通的for循环遍历
 * HashSet集合实现了Set接口
 * HashSet的特点：
 *      1.不可以有重复的元素
 *      2.没有索引，没有带索引的方法，所以也不能使用普通的for循环遍历
 *      3.是一个无序的集合，存储元素和取出的元素的顺序有可能不一样
 *      4.底层是一个哈希表结构（查询的速度非常的快）
 */
public class Demo01HashSet {

    @Test
    public void demo1(){
        Set<String> set = new HashSet<>();
        set.add("a");
        //不存储重复的元素，就算有添加重复的元素，也会自动过滤掉
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");

        //迭代器遍历
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("================================");
        //增强for循环
        for(String s : set){
            System.out.println(s);
        }

    }
}
