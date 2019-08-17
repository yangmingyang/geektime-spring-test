package com.grammar.API05_String;

/**
 *  java.lang.String类代表字符串。
 *  API文档中说：Java程序中的所有字符串字面值（如："abc"）都作为此类的实例实现。
 *  其实就是说：程序当中所有的双引号字符串，都是String类的对象。（就算没有new,也照样是String类的对象）
 *
 *  字符串的特点：
 *      1.字符床的内容永不可变。【重点】
 *      2.正式因为字符串不可改变，所以字符串是可以共享使用的。
 *      3.字符串效果上相当于是char[]字符数组，但是底层原理是byte[]字节数组。
 *
 *  创建字符串的常见3+1种方式。
 *  1.三种构造方法：
 *      public String():创建一个空白字符串，不含有任何内容。
 *      public String(char[] array):根据字符数组的内容，来创建对应的字符串。
 *      public String(byte[] array):根据字节数组的内容，来创建对应的字符串。
 *  2.一种直接创建:
 *      String str = "hello"; //右边直接用双引号
 *      注意：直接写上双引号，就是字符串对象。
 */
public class Demo01_String {
    public static void main(String[] args) {
        //public String():创建一个空白字符串，不含有任何内容。
        String str1 = new String();
        System.out.println("第一个字符串："+str1);

        //public String(char[] array):根据字符数组的内容，来创建对应的字符串。
        char[] chars = {'a','b','c'};
        String str2 = new String(chars);
        System.out.println("第二个字符串："+str2);

        //public String(byte[] array):根据字节数组的内容，来创建对应的字符串。
        byte[] bytes = {97,98,99};//注意：数组的形式都是用{ } 中括号
        String str3 = new String(bytes);
        System.out.println("第三个字符串："+str3);

        String str4 = "abc";
        System.out.println("第四个字符串："+str4);
    }
}
