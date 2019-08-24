package com.mingYang.G08_lambda.Interfaces.Impl;

import com.mingYang.G08_lambda.Interfaces.People;

public class Father implements People {

    @Override
    public void speak() {
        System.out.printf("杨铭洋会说话");
    }
}
