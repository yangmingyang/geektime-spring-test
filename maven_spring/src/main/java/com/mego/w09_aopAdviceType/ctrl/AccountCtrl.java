package com.mego.w09_aopAdviceType.ctrl;

import com.mego.w09_aopAdviceType.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AccountCtrl {
    @Test
    public void test01(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("w09_aopAdviceType.xml");
        AccountService accountService = (AccountService) classPathXmlApplicationContext.getBean("accountService");
        accountService.saveAccount();
    }
}
