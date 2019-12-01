package com.mego.w07_bank_proxy.service;

import com.mego.w07_bank_proxy.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAllAccount();

    Account getAccount();

    void updateAccount(Integer id, Double balance);

    void transfer();
}
