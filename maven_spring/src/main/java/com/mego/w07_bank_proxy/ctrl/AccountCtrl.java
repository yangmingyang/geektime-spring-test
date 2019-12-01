package com.mego.w07_bank_proxy.ctrl;

import com.mego.w07_bank_proxy.model.Account;
import com.mego.w07_bank_proxy.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountCtrl {

    @Test
    public void test01(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("w07_bank_proxy.xml");
        AccountService accountService = (AccountService) classPathXmlApplicationContext.getBean("accountServiceProxy");
        List<Account> accountList = accountService.findAllAccount();
        for (Account account : accountList){
            System.out.println(account);
        }
    }

    @Test
    public void test02(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("w07_bank_proxy.xml");
        AccountService accountService = (AccountService) classPathXmlApplicationContext.getBean("accountServiceProxy");
        accountService.updateAccount(1,900.00);
    }

    @Test
    public void test03(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("w07_bank_proxy.xml");
        AccountService accountService = (AccountService) classPathXmlApplicationContext.getBean("accountServiceProxy");
        accountService.transfer();
    }
}
