package com.dgut.service.impl;

import com.dgut.dao.IAccountDao;
import com.dgut.dao.impl.AccountDaoImpl;
import com.dgut.domain.Account;
import com.dgut.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    /*
      account = new AccountDaoImpl();
    * new AccountServiceImpl(account)
    * */

    public AccountServiceImpl() {
    }

    public AccountServiceImpl(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void my_init(){
        System.out.println("init");
    }

    public void my_destroy(){
        System.out.println("destroy");
    }

    public void trans(Account from, Account to, float money) throws Exception {
        accountDao.trans(from,to,money);
    }
}
