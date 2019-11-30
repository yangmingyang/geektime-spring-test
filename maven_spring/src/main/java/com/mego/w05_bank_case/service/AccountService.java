package com.mego.w05_bank_case.service;

import com.mego.w05_bank_case.model.Account;
import java.util.List;

public interface AccountService {
    List<Account> findAllAccount();

    Account getAccount();

    void updateAccount(Integer id ,Double balance);

    void transfer();
}
