package com.grammar.API04_Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *  需求：
 *      生成6个1-33之间的随机整数，添加到集合，并遍历集合。
 */
public class Demo05ArrayList_Random {
    public static void main(String[] args) {
        //先生成随机数
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        //6.fori快捷键
        for (int i = 0; i < 6 ; i++) {
            //Integer num = random.nextInt(33)+1;
            list.add(random.nextInt(33)+1);
        }
        System.out.println(list);
    }

    /**
     * 要求自定义4个人对象，添加到集合，并遍历
     */
    @Test
    public void demo01(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("a",20));
        list.add(new Person("b",21));
        list.add(new Person("c",22));
        list.add(new Person("d",23));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName()+"="+list.get(i).getAge());
        }
    }

    /**
     * 要求：
     *      定义以指定格式打印集合的方法（ArrayList类型作为参数），使用{ }括起集合，使用@分隔每个元素。
     *      格式参数{元素@元素@元素}
     */
    @Test
    public void demo02(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        String str ="{";
        for (int i = 0; i < list.size(); i++) {
            //重点是这个判断，如果不是最后一个元素，则都要使用@进行拼接
            if(i<list.size()-1){
                str +=list.get(i)+"@";
            }else{
                str +=list.get(i)+"}";
            }
        }
        System.out.println(str);
    }
}
