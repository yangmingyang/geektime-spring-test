package com.mingyang.throwable;

import java.util.Objects;

public class Demo04Object {
    public static void main(String[] args) {
        method(null);
    }

    public static void method(Object obj){
        /*if (obj==null){
            throw new NullPointerException("对象为空异常");
        }*/
        //可以简化为
        Objects.requireNonNull(obj,"对象为空异常");
    }
}
