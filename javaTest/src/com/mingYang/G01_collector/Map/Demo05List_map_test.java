package com.mingYang.G01_collector.Map;

import java.util.*;

/**
 *  需求：
 *      定义一个list结合，里面的对象是map对象，存放的是键值对。
 *      思考，如何优化每次都要new一个新的map对象？
 *      因为业务上，map中的key是可以重复，所以需要一个List数组来存放。
 *
 */
public class Demo05List_map_test {
    public static void main(String[] args) {
        //可以给一个默认初始数组长度
        List<Map<String, String>> lists = new ArrayList<>(4);
        Map<String,String> map = new HashMap<>();
        map.put("org.id", "org.id");
        lists.add(map);

        map = new HashMap<>();
        map.put("m.machineNO", "m.machineNO");
        lists.add(map);

        map = new HashMap<>();
        map.put("vih.createTime", "vi.createTime");
        lists.add(map);

        map= new HashMap<>();
        map.put("vih.createTime", "vi.createTime");
        lists.add(map);
        for (Map<String,String> m : lists){
            for (String key : m.keySet()){
                System.out.println(key +"==="+m.get(key));
            }
        }
    }
}
