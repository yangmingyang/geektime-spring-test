package com.mingYang.G01_collector.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *  Map集合的第一种遍历方式：通过键找值的方式
 *  Map集合中的方法：
 *      Set<k> keySet() 返回此映射中包含的键的 Set 视图。
 *  实现的步骤：
 *      1.使用Map集合中的方法keySet(),把Map集合所有的key取出来，存储到一个Set集合中
 *      2.遍历set集合，获取Map集合中的每一个key
 *      3.通过Map集合中的方法get(key)，通过key找到value
 */
public class Demo02KeySet {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("猪仔哥",175);
        map.put("铭峰哥哥",174);

        //两种方式遍历
        Set<String> key = map.keySet();
        //迭代器
        Iterator<String> it = key.iterator();
        while (it.hasNext()){
            String ke = it.next();
            System.out.println("key:"+ke+" value:"+map.get(ke));
        }

        System.out.println("==========================");
        //增强for循环
        for(String k : map.keySet()){
            System.out.println("key:"+k+" value:"+map.get(k));
        }
    }
}
