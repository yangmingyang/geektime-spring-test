package com.mego.w05_bank_case.ctrl;

import com.mego.w05_bank_case.model.Account;
import com.mego.w05_bank_case.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountCtrl {

    @Test
    public void test01(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("w05_bank_case.xml");
        AccountService accountService = (AccountService) classPathXmlApplicationContext.getBean("accountService");
        List<Account> accountList = accountService.findAllAccount();
        for (Account account : accountList){
            System.out.println(account);
        }
    }

    @Test
    public void test02(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("w05_bank_case.xml");
        AccountService accountService = (AccountService) classPathXmlApplicationContext.getBean("accountService");
        accountService.updateAccount(1,900.00);
    }

    @Test
    public void test03(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("w05_bank_case.xml");
        AccountService accountService = (AccountService) classPathXmlApplicationContext.getBean("accountService");
        accountService.transfer();
    }
}
