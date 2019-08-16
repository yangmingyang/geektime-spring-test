package com.grammar.API04_Array;

import java.util.ArrayList;

/**
 *  ArrayList集合常用的方法：
 *      public boolean add(E e):向集合当中添加元素，参数的类型和泛型一致。
 *      public E get(int index):从集合当中获取元素，参数是索引编号，返回值就是对应位置的元素。
 *      public E remove(int index):从集合当中删除元素，参数是索引编号，返回值就是被删除掉的元素。
 *      public int size():获取集合的尺寸长度，返回值是集合中包含的元素个数。
 */
public class Demo03ArrayListMethod {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        System.out.println("获取到的第一个元素："+list.get(0));

        String remove = list.remove(0);
        System.out.println("删除的元素：" + remove);
        System.out.println(list);

        System.out.println("集合的长度"+list.size());

        //快捷键方式：list.fori
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("===================");
        ////使用增强for循环遍历
        for (String s : list){
            System.out.println(s);
        }
    }
}
