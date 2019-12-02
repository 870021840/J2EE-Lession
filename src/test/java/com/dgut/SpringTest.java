package com.dgut;

import com.dgut.dao.IAccountDao;
import com.dgut.domain.Account;
import com.dgut.service.IAccountService;
import com.dgut.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void testTrans() throws Exception {
//        Account a1 = new Account("xiaoming",1000f);
//        Account a2 = new Account("xiaohong",1000f);
//        IAccountService accountService = new AccountServiceImpl();
//        accountService.trans(a1,a2,200);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        IAccountDao accountDao = (IAccountDao) applicationContext.getBean("accountDao");
        System.out.println(accountDao);
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
        System.out.println(accountService);
//        System.out.println(applicationContext);
    }
}
