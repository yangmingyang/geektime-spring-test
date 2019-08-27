package com.grammar.API05_String;

public class Demo10_String_Integer {
    public static void main(String[] args) {
        String i ="1.0";
        Integer integer = Integer.getInteger(i);
        System.out.println(integer);

        //空字符串要做一个判断
        //String str ="";
        String str = "10";
        //使用1.0都会报错
        //String str = "1.0";
        if(!str.equals("")){
            int i1 = Integer.parseInt(str);
            System.out.println(i1);
        }

        //System.out.println(Integer.parseInt(i));
    }
}
