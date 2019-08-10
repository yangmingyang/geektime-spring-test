package com.mingYang.lambda.main;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeStream01 {
    /**
     * 使用场景：
     * 1.在数据库中查出一个List<Map<String,Object>>对象
     * 2.然后需要对着个List对象进行重组，
     * 3.两个不同的List<Map<String,Object>>
     *
     */

    @Test
    public void demo01(){
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for (int i=1;i<9;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("id",i);
            map.put("name","张三丰"+i);
            list.add(map);
        }
        Stream<Map<String, Object>> s1 = list.stream();
        list.stream().forEach(map-> System.out.println(map));

        List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
        for (int i=1;i<5;i++){
            Map<String,Object> map2 = new HashMap<>();
            map2.put("id",i);
            map2.put("grade",i+60);
            list2.add(map2);
        }
        list2.stream().forEach(s-> System.out.println(s));
/**
 *  List<Map<Object, Object>> resultList = oneList.stream().map(map -> twoList.stream()
 *                 .filter(m -> Objects.equals(m.get("id"), map.get("id")))
 *                 .findFirst().map(m -> {
 *                     map.putAll(m);
 *                     map.put("grade",90);
 *                     return map;
 *                 }).orElse(null))
            *                 .filter(Objects::nonNull).collect(Collectors.toList());
 */
      /* List<Map<String, Object>> resultList2 = list.stream().map(m->{
                    m.put("grade",0);
                    for (int i=0;i<list2.size();i++){
                        if(m.get("id").equals(list2.get(i).get("id"))){
                            m.put("grade",list2.get(i).get("grade"));
                            break;
                        }
                    }
                    return m;
                }).collect(Collectors.toList());*/
        List<Map<String, Object>> resultList2 = list.stream().map(m->{
            m.put("grade",0);
            list2.stream().filter(m2->Objects.equals(m.get("id"), m2.get("id"))).forEach(s-> m.put("grade",s.get("grade")));
            return m;
        }).collect(Collectors.toList());
        resultList2.stream().forEach(s-> System.out.println(s));
    }

    @Test
    public void demo2(){
        Map<String,Object> h1 = new HashMap<>();
        h1.put("12","fdsa");
        h1.put("123","fdsa");
        h1.put("124","fdsa");
        h1.put("125","fdsa");

        Map<String,Object> h2 = new HashMap<>();
        h2.put("h12","fdsa");
        h2.put("h123","fdsa");
        h2.put("h124","fdsa");
        h2.put("h125","fdsa");

        Map<String,Object> h3 = new HashMap<>();
        h3.put("h312","fdsa");
        h3.put("h3123","fdsa");
        h3.put("h3124","fdsa");
        h3.put("h3125","fdsa");

        List<Map<String,Object>> lists = new ArrayList<>();
        lists.add(h1);
        lists.add(h2);
        lists.add(h3);

        /*Map<String, Object> merged = lists.stream()
                .map(Map::entrySet)
                .flatMap(Set::stream)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));*/
        Map<String, Object> merged = lists.stream()
                .map(Map::entrySet)
                .flatMap(Set::stream)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        merged.entrySet().stream().forEach(s-> System.out.println(s));


    }


    @Test
    public void demo3(){
        List<Map<Object, Object>> oneList = new ArrayList<>();
        Map<Object, Object> oneMap1 = new HashMap<>();
        oneMap1.put("id", 111);
        oneMap1.put("userName", "何金荣");

//        Map<Object, Object> twoMap = new HashMap<>();
//        twoMap.put("id", 222);
//        twoMap.put("userName", "Hejinrong");

        oneList.add(oneMap1);
//        oneList.add(twoMap);

        List<Map<Object, Object>> twoList = new ArrayList<>();
        Map<Object, Object> threeMap = new HashMap<>();
        threeMap.put("id", 1112);
        threeMap.put("userName", "何金荣");

        Map<Object, Object> fourMap = new HashMap<>();
        fourMap.put("id", 333);
        fourMap.put("userName", "Hejinrong");

        twoList.add(threeMap);
        twoList.add(fourMap);

        List<Map<Object, Object>> resultList = oneList.stream().map(map -> twoList.stream()
                .filter(m -> Objects.equals(m.get("id"), map.get("id")))
                .findFirst().map(m -> {
                    map.putAll(m);
                    map.put("grade",90);
                    return map;
                }).orElse(null))
                .filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(resultList.size());
    }
}
