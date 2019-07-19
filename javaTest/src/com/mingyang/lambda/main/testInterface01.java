package com.mingyang.lambda.main;

import com.mingyang.lambda.Interfaces.Impl.Father;

public class testInterface01 {
    public static void main(String[] args) {
        Father fa = new Father(){
            @Override
            public void speak() {
                super.speak();
                System.out.printf("my会说");
            }
        };
        System.out.printf(fa.toString());
       // fa.speak();
    }
}
