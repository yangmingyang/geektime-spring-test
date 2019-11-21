package com.mego.w05_bank_case.service;

import com.mego.w05_bank_case.model.Account;
import java.util.List;

public interface AccountService {
    public List<Account> findAllAccount();

    public Account getAccount();
}
