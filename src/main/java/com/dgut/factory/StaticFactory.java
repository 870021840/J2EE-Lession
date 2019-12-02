package com.dgut.factory;

import com.dgut.service.IAccountService;
import com.dgut.service.impl.AccountServiceImpl;

public class StaticFactory {

    public static IAccountService createAccountService(){
        return new AccountServiceImpl();
    }

    public static void main(String[] args) {
        IAccountService accountService = StaticFactory.createAccountService();
        System.out.println(accountService);
    }
}
