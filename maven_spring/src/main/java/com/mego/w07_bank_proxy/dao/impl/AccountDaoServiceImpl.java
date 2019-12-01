package com.mego.w07_bank_proxy.dao.impl;

import com.mego.w07_bank_proxy.dao.AccountDaoService;
import com.mego.w07_bank_proxy.model.Account;
import com.mego.w07_bank_proxy.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoServiceImpl implements AccountDaoService {

    private QueryRunner queryRunner;

    private ConnectionUtils connectionUtils;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public List<Account> findAllAccount() {
        try {
            //return queryRunner.query("select * from account",new BeanListHandler<Account>(Account.class));
           return queryRunner.query(connectionUtils.getThreadConnection(),"select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Integer id, double balance) {
        try {
            queryRunner.update(connectionUtils.getThreadConnection(),"update account set balance=? where id=?",balance,id);
            System.out.println("更新成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account getAccount(String name) {
        try {
            List<Account> list = queryRunner.query(connectionUtils.getThreadConnection(),"select * from account where name=?", new BeanListHandler<Account>(Account.class), name);
            if (list.size()>0){
                return list.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
