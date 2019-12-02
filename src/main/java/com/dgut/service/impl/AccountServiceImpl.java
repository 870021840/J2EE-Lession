package com.dgut.service.impl;

import com.dgut.dao.IAccountDao;
import com.dgut.dao.impl.AccountDaoImpl;
import com.dgut.domain.Account;
import com.dgut.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void trans(Account from, Account to, float money) throws Exception {
        accountDao.trans(from,to,money);
    }
}
