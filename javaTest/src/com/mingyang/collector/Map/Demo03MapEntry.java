package com.mingyang.collector.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo03MapEntry {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("冷锋","龙小云");
        map.put("杨过","小龙女");
        map.put("谢霆锋","张柏芝");
        System.out.println(map);

        System.out.println("=======================");

        Set<Map.Entry<String,String>> set = map.entrySet();
        //迭代器循环读取和增强for循环读取
        Iterator<Map.Entry<String,String>> it = set.iterator();
        while (it.hasNext()){
            Map.Entry<String, String> entry = it.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println("=======================");
        //增强for
        for(Map.Entry<String,String> entry : set){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
