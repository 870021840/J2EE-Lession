package com.dgut.factory;

import com.dgut.service.IAccountService;
import com.dgut.service.impl.AccountServiceImpl;

public class InstanceFactory {

    public IAccountService createAccountService(){
        return new AccountServiceImpl();
    }

    public static void main(String[] args) {
        /*
        <bean id="factory" class = "com.dgut.factory.InstanceFactory"/>
        * */
        InstanceFactory factory = new InstanceFactory();
        IAccountService accountService = factory.createAccountService();
    }
}
