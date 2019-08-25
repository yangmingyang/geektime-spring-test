package com.grammar3.G01_Object;

import java.util.Objects;

public class Demo02_object {
    public static void main(String[] args) {
        //String a = "abc";
        String a =null;
        String b = "aBc";
        //System.out.println(a.equals(b));//报错java.lang.NullPointerException

        //改进，可以用
        System.out.println(b.equals(a));

        boolean equals = Objects.equals(a, b);
        System.out.println(equals);

    }
}
