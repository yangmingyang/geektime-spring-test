package com.mego.w07_bank_proxy.dao;

import com.mego.w07_bank_proxy.model.Account;

import java.util.List;

/**
    该类主要是用来直接操作数据库
 */
public interface AccountDaoService {
    List<Account> findAllAccount();

    void update(Integer id, double balance);

    Account getAccount(String name);
}
