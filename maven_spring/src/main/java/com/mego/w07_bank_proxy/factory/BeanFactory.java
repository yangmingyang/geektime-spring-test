package com.mego.w07_bank_proxy.factory;

import com.mego.w07_bank_proxy.service.AccountService;
import com.mego.w07_bank_proxy.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {
    private AccountService accountService;

    private TransactionManager txManager;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public final void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public AccountService getAccountService() {
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnObject = null;
                try {
                    //1.开启事务
                    txManager.beginTransaaction();
                    //2.执行操作
                    //accountDaoService.update(id,balance);
                    returnObject = method.invoke(accountService,args);
                    //3.提交事务
                    txManager.commit();
                    //4.返回结果
                }catch (Exception e){
                    //5.回滚操作
                    System.out.println("程序发生错误，执行回滚操作");
                    txManager.rollback();
                }finally {
                    //6.释放连接
                    txManager.release();
                }
                return returnObject;
            }
        });
    }
}
