package com.mego.w08_springAop.ctrl;

import com.mego.w08_springAop.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AccountCtrl {
    @Test
    public void test01(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("w08_springAop.xml");
        AccountService accountService = (AccountService) classPathXmlApplicationContext.getBean("accountService");
        accountService.saveAccount();
    }
}
