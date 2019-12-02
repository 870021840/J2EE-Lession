package com.dgut.dao.impl;

import com.dgut.dao.IAccountDao;
import com.dgut.domain.Account;
import com.dgut.service.IAccountService;

public class AccountDaoImpl implements IAccountDao {

    public void trans(Account from, Account to, float money) throws Exception {
        System.out.println("mybatis 实现");
    }
}
