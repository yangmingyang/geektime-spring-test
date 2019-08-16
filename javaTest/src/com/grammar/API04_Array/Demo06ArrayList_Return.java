package com.grammar.API04_Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 需求：
 *      用一个大集合存入20个随机数字，然后筛选其中的偶数元素，放到小集合中。
 *      要求：使用自定义的方法来实现筛选。
 */
public class Demo06ArrayList_Return {
    public static void main(String[] args) {
        System.out.println(getList());
    }

    public static List<Integer> getList(){
        List<Integer> list = new ArrayList<>();
        List<Integer> targeList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println(list);
        for (Integer i : list) {
            if (i%2==0){
                targeList.add(i);
            }
        }
        return targeList;
    }
}
