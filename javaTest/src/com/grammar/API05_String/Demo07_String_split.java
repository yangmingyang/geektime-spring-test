package com.grammar.API05_String;

/**
 *  分割字符串的方法：
 *      public String[] split(String regex)：按照参数的规则，将字符串切分成为若干部分。
 *  注意事项：
 *      split方法的参数其实是一个“正则表达式”，以后要学习一下正则表达式。
 *      今天要注意：如果按照英文句点“.”进行切分，必须写“\\.”(两个反斜杆)
 */
public class Demo07_String_split {
    public static void main(String[] args) {
        String str ="aaa,bbb,ccc";
        String[] arrays = str.split(",");
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
        System.out.println("===================");

        String str2 ="xxx.yyyy.sss";
        String[] split = str2.split("\\.");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }
}
