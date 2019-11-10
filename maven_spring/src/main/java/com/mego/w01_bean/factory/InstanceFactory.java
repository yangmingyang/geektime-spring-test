package com.mego.w01_bean.factory;

import com.mego.w01_bean.service.impl.AccountServiceImpl;

/**
 该类的作用：
    模拟jar包中的方法。这里有点模糊：
        使用某个类中的方法创建对象，并存入spring容器
 <bean id="instanceFactory" class="com.mego.w01_bean.factory.InstanceFactory"></bean>
 <bean id="accountService1" factory-bean="instanceFactory" factory-method="getAccountService"></bean>
 */
public class InstanceFactory {
    public AccountServiceImpl getAccountService(){
        System.out.println("来调用InstanceFactory中的getAccountService方法了");
        return new AccountServiceImpl();
    }
}
