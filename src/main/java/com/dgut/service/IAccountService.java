package com.dgut.service;

import com.dgut.domain.Account;

public interface IAccountService {


    /**
     * 转账业务
     * @param from 转账的人
     * @param to   收账的人
     * @param money 交易的金额
     */
    public void trans(Account from, Account to, float money) throws Exception;

}
