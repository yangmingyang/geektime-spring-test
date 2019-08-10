package com.mingYang.lambda.Interfaces;

@FunctionalInterface
public interface People {
    /**
     * 说明：
     * 函数接口通过@FunctionalInterface标识，函数接口只能定义一个没有实现的接口。绝对不能有第二个，这个函数接口的特性
     */
    void speak();
}
