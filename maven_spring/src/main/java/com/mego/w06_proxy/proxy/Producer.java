package com.mego.w06_proxy.proxy;

public class Producer implements IProducer{

    public void saleProduct(Float money) {
        System.out.println("拿到钱了，销售产品出去了" + money);
    }
}
