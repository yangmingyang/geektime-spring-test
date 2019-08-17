package com.grammar.API07_Arrays;

import java.util.Arrays;

/**
 *  需求：
 *      请使用Arrays相关的API,将一个随机字符串中的所有字符升序排序，并倒序打印。
 */
public class Demo02_Arrays_practise {
    public static void main(String[] args) {
        String str ="gjkjekojgieohliehaHIDHHEI344";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.println(chars[i]);
        }
    }
}
