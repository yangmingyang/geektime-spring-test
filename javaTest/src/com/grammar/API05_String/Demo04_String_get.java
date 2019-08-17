package com.grammar.API05_String;

/**
 *  String类当中与获取相关的常用方法：
 *      public int length():获取字符串当中含有的字符个数，拿到字符串长度。
 *      public String concat(String str):将当前字符串和参数字符串拼接成为返回值得到一个新的字符串。
 *      public char charAt(int index):获取指定索引位置的单个字符。（索引从0开始）
 *      public int indexOf(String str):查找参数字符串在本字符串当中首次出现的索引位置，如果没有则返回-1值。
 *
 *
 */
public class Demo04_String_get {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(str.length());//5

        String s = ",mingYang";
        String str2 = str.concat(s);
        /**
         * 注意一点：java的字符串是不会改变的，str2是一个全新的字符串。str和s都不会改变的，还是原来的值。
         */
        System.out.println(str2);//hello,mingYang

        char c = str2.charAt(1);
        System.out.println(c);//e

        int index = str2.indexOf("ming");
        System.out.println(index);//6
    }
}
