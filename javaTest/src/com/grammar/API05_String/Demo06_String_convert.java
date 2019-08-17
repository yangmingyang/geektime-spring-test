package com.grammar.API05_String;

/**
 *  String当中与转换相关的常用方法有：
 *      public char[] toCharArray():将当前字符串拆分成为字符数组作为返回值。
 *      public byte[] getBytes():将当前字符串底层的字节数组。
 *      public String replace(CharSequence oldString,CharSequence newString):将所有出现的老字符串替换成新的字符串，返回
 *                                                                           替换之后的结果新字符串。
 *
 */
public class Demo06_String_convert {
    public static void main(String[] args) {
        String str ="hello,mingYang,";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        //这个方法会在IO流中经常使用到，把字符串转化为字节
        byte[] bytes = str.getBytes();
        System.out.println(bytes);

        //注意是 将所有出现的老字符串替换成新的字符串，返回替换之后的结果新字符串。
        String replace = str.replace(",", ":");
        System.out.println(replace);//hello:mingYang:
    }
}
