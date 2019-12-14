package com.mego.w10_annotation_aop.ctrl;

import com.mego.w10_annotation_aop.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AccountCtrl {
    @Test
    public void test01(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("w10_annotation_aop.xml");
        AccountService accountService = (AccountService) classPathXmlApplicationContext.getBean("accountService");
        accountService.saveAccount();
    }

}
