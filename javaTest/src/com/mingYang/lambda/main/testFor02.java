package com.mingYang.lambda.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class testFor02 {
    public static void main(String[] args) {
        // 使用曾强for循环迭代
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        for(String str : list){
            if(str.length()>3)
                System.out.println(str);
        }

        // 使用forEach()结合匿名内部类迭代
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                if (s.length()>3){
                    System.out.println(s);
                }
            }
        });

        /**
         * 为什么这里可以直接使用s1去调用？
         */
        // 使用forEach()结合Lambda表达式迭代
        list.forEach(s1->{
            if(s1.length()>3){
                System.out.println(s1);
            }
        });
    }
}
