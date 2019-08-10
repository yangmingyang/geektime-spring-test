package com.mingYang.collector.Map;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * java.lang.Object
 *      --java.util.AbstractMap<K,V>
 *           --java.util.HashMap<K,V>
 *              --java.util.LinkedHashMap<K,V>
 *   LinkedHashMap
 *      哈希表和链表实现的Map接口，具有可预测的迭代顺序。
 *      底层原理：
 *          哈希表+链表（记录元素的顺序）
 *
 */
public class Demo04LinkedHashMap {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("a","a");
        map.put("c","c");
        map.put("b","b");
        System.out.println(map);//{a=a, b=b, c=c}无序的
        System.out.println("==================================");
        LinkedHashMap<String,String> linked = new LinkedHashMap<>();
        linked.put("a","a");
        linked.put("c","c");
        linked.put("b","b");
        System.out.println(linked);//{a=a, c=c, b=b}有序的
    }
}
