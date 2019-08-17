package com.grammar.API05_String;

/**
 *  字符串常量池：程序当中直接写上的双引号字符串，就在字符串常量池中。
 *      注意：
 *          对于基本数据类型来说，==是进行数值的比较。
 *          对于引用类型来说，==是进行【地址值】的比较。
 */
public class Demo02_StringPool {
    public static void main(String[] args) {
        /**
         * str1和str2的值都是在字符串常量池中，还因为他们的值相等，所以这两个对象的地址值其实是引用了同一个地址值。
         */
        String str1 = "abc";
        String str2 = "abc";

        char[] chars = {'a','b','c'};
        //而str3对象的创建不是在字符串常量池中，所以创建出来的对象不相等
        String str3 = new String(chars);

        System.out.println(str1==str2);//true
        System.out.println(str1==str3);//false
        System.out.println(str2==str3);//false

        char[] chars2 = {'a','b','c'};
        String str4 = new String(chars2);
        System.out.println(str3==str4);//false   因为这两个对象不是同一个对象


        /**
         * 注意:下面是基本类型对应的包装类
         *  *  基本类型      包装类（引用类型，包装类都位于java.lang包下）
         *  *  byte          Byte
         *  *  short         Short
         *  *  int           Integer [特殊]
         *  *  long          Long
         *  *  float         Float
         *  *  double        Double
         *  *  char          Character [特殊]
         *  *  boolean       Boolean
         */
        Integer i1 =10;
        Integer i2 =10;
        System.out.println(i1==i2);//true

        char c1 = 'a';
        char c2 = 'a';
        System.out.println(c1==c2);//true
        //从上面两个例子可以验证：对于基本数据类型来说，==是进行数值的比较。

    }
}
