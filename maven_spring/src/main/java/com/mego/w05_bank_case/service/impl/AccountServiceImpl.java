package com.mego.w05_bank_case.service.impl;

import com.mego.w05_bank_case.dao.AccountDaoService;
import com.mego.w05_bank_case.model.Account;
import com.mego.w05_bank_case.service.AccountService;
import com.mego.w05_bank_case.utils.TransactionManager;

import java.util.List;

/**
 * 账号的业务层实现类
 * 事务控制应该都是在业务层
 * 思考：如果没有aop帮我们处理了这些事务，那么我们每次去写代码都需要自己去处理这些事务，是非常麻烦的。
 */
public class AccountServiceImpl implements AccountService {

    private AccountDaoService accountDaoService;
    private TransactionManager txManager;

    public void setAccountDaoService(AccountDaoService accountDaoService) {
        this.accountDaoService = accountDaoService;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public List<Account> findAllAccount() {
        return accountDaoService.findAllAccount();
    }

    public Account getAccount() {
        return null;
    }

    public void updateAccount(Integer id, Double balance) {
        try {
            //1.开启事务
            txManager.beginTransaaction();
            //2.执行操作
            accountDaoService.update(id,balance);
            //3.提交事务
            txManager.commit();
            //4.返回结果
        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
        }finally {
            //6.释放连接
            txManager.release();
        }

    }

    public void transfer() {
        try {
            //1.开启事务
            txManager.beginTransaaction();
            //2.执行操作
            //银行转账的逻辑两个人
            Account source = accountDaoService.getAccount("ming");
            Account target = accountDaoService.getAccount("jiao");
            //查询出A的余额
            //查询出B的余额
            //减少A的余额
            //增加B的余额
            accountDaoService.update(source.getId(),source.getBalance()-100);
            //这个人为出一点错误，整个事务就会回滚，但要注意，能回滚，是因为他们是在同一个线程上的。如果不是同一个线程不行的
            //int i = 5/0;
            accountDaoService.update(target.getId(),target.getBalance()+100);
            //3.提交事务
            txManager.commit();
        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
        }finally {
            //6.释放连接
            txManager.release();
        }

    }
}
