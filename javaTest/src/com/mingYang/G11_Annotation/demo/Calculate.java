package com.mingYang.G11_Annotation.demo;

public class Calculate {

    @Check
    public void add(){
        System.out.println(1+0);
    }

    @Check
    public void subtract(){
        System.out.println(3-1);
    }

    @Check
    public void multiply(){
        System.out.println(1*3);
    }

    @Check
    public void divide(){
        System.out.println(4/0);
    }
}
