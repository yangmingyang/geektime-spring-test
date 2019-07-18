package com.mingyang.lambda.Interfaces.Impl;

import com.mingyang.lambda.Interfaces.People;

public class Father implements People {

    @Override
    public void speak() {
        System.out.printf("杨铭洋会说话");
    }
}
