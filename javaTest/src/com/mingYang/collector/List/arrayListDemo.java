package com.mingYang.collector.List;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List数组特有几个方法
 * 特别要注意，ArrayList集合查询是很快的，增加/删除操作就很慢了，要注意使用场景，不能随意
 * 底层的操作就是每次新增或者删除一个元素，都是要创建一个新的数组去覆盖旧的数组
 * 有个疑问：ArrayList是多线程的吗？是多线程是否就意味着不安全？
 * add();
 * remove();
 * set();
 *
 * 注意：防止数组索引越界异常
 *
 */
public class arrayListDemo {

    @Test
    public void method01(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list.toString());

        /**
         * 可以指定位置添加元素
         */
        list.add(3,"名扬");
        System.out.println(list);

        /**
         * 删除数组中的某一个元素
         */
        String removeStr = list.remove(2);
        System.out.println(removeStr);
        System.out.println(list);

        /**
         * 替换元素中某一个元素
         */
        list.set(1,"A");
        System.out.println(list);

        //list集合遍历的三种方式
        System.out.println("========普通for遍历==========================");
        /**
         * 普通for循环
         */
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        System.out.println("======增强for循环============================");

        /**
         * 增强for循环
         */
        for(String s : list){
            System.out.println(s);
        }

        System.out.println("======迭代器============================");

        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

}
