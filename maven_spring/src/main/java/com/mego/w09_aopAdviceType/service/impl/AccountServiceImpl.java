package com.mego.w09_aopAdviceType.service.impl;

import com.mego.w09_aopAdviceType.service.AccountService;

public class AccountServiceImpl implements AccountService {

    public void saveAccount() {
        System.out.println("新增成功");
    }

    public Integer updateAccount(int i) {
        System.out.println("更新成功");
        return i;
    }

    public void deleteAccount() {
        System.out.println("删除成功");
    }
}
