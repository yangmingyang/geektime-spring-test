package com.mego.w01_bean.service.impl;

import com.mego.w01_bean.dao.Account;
import com.mego.w01_bean.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    public List<Account> getAccounts() {
        System.out.println("来获取到所有的账号信息");
        return null;
    }
}
