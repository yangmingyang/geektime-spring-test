package com.mego.w01_bean.factory;

import com.mego.w01_bean.service.impl.AccountServiceImpl;

/**
 第三种：使用工厂中的静态方法创建对象（使用某个类中的静态方法创建对象，并存入spring容器）
 <bean id="accountService2" class="com.mego.w01_bean.factory.StaticFactory" factory-method="getAccountService"></bean>
 */
public class StaticFactory {
    public static AccountServiceImpl getAccountService(){
        System.out.println("来调用StaticFactory静态方法，生成对象");
        return new AccountServiceImpl();
    }
}
