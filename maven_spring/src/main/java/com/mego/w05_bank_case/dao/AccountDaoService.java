package com.mego.w05_bank_case.dao;

import com.mego.w05_bank_case.model.Account;

import java.util.List;

/**
    该类主要是用来直接操作数据库
 */
public interface AccountDaoService {
    public List<Account> findAllAccount();
}
