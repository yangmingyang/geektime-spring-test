package com.grammar.API05_String;

/**
 *  == 是进行对象的地址值比较，如果确实需要字符串的内容比较，可以使用两个方法：
 *      public boolean equals(Object obj):参数可以是任意对象，只有参数是一个字符串并且内容相同的才会给true;否则返回false
 *          注意：
 *              1.任何对象都能用Object进行接收。
 *              2.equals方法具有对称性，也就是a.equals(b) 和 b.equals(a)效果是一样的。
 *              3.如果比较双方一个常量一个变量，推荐吧常量字符串写在前面。
 *                  推荐："abc".equals(str)    不推荐：str.equals("abc")
 *                  原因：变量str的值一旦为null,就会报空指针异常
 *
 *      public boolean equalsIgnoreCase(String str): 忽略大小写，进行内容比较。
 */
public class Demo03_String_equals {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        char[] chars ={'a','b','c'};
        String str3 = new String(chars);
        //参数可以是任意对象，只有参数是一个字符串并且内容相同的才会给true;否则返回false
        System.out.println(str1.equals(str2));//true
        System.out.println(str1.equals(str3));//true
        System.out.println(str2.equals(str3));//true

        System.out.println("============================");
        String str4 = "hello";
        //推荐写法 如果比较双方一个常量一个变量，推荐吧常量字符串写在前面。原因：变量str的值一旦为null,就会报空指针异常
        System.out.println("hello".equals(str4));

        //不推荐写法
        System.out.println(str4.equals("hello"));

    }
}
