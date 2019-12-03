package com.mego.w08_springAop.service.impl;

import com.mego.w08_springAop.service.AccountService;

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
