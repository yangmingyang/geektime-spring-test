package com.mingyang.collector.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 *  java.util.LinkedHashSet集合 extends HashSet集合
 *  LinkedHashSet集合特点：
 *      1.底层是一个哈希表（数组+链表/红黑树）+链表；多了一条链表（记录元素的存储顺序），保证元素的有序
 */
public class Demo03LinkedHashSet {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("www");
        set.add("abc");
        set.add("abc");
        set.add("dd");
        System.out.println(set);//[dd, abc, www]  结果是无序，并且不允许有重复

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("www");
        linkedHashSet.add("abc");
        linkedHashSet.add("abc");
        linkedHashSet.add("dd");
        System.out.println(linkedHashSet);//[www, abc, dd] 结果是有序的，并且也允许有重复

    }
}
