package com.dgut;

import com.dgut.dao.IAccountDao;
import com.dgut.domain.Account;
import com.dgut.domain.User;
import com.dgut.service.IAccountService;
import com.dgut.service.impl.AccountServiceImpl;
import com.sun.prism.shader.Solid_RadialGradient_REFLECT_AlphaTest_Loader;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void testTrans() throws Exception {
        Account a1 = new Account("xiaoming",1000f);
        Account a2 = new Account("xiaohong",1000f);
//        IAccountService accountService = new AccountServiceImpl();
//        accountService.trans(a1,a2,200);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        IAccountDao accountDao = (IAccountDao) applicationContext.getBean("accountDao");
        System.out.println(accountDao);
//        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
//
//        IAccountService accountService2 = (IAccountService) applicationContext.getBean("accountService");
//        System.out.println(accountService+" "+accountService2);


        IAccountService accountService3 = (IAccountService) applicationContext.getBean("accountService3");
        System.out.println(accountService3);

        IAccountService accountService02 = (IAccountService) applicationContext.getBean("accountService02");

        accountService02.trans(a1,a2,400);


        Object num = applicationContext.getBean("num");
        System.out.println(num);

        /*
        *
        * */
//        String str = new String("123");
//        int length = str.length();
//        int num = Integer.parseInt("123");
//        accountService.trans(a1,a2,400);
//        System.out.println(applicationContext);

        Object length = applicationContext.getBean("length");
        System.out.println(length);


        /* new user();*/
        User user = (User) applicationContext.getBean("user");
        System.out.println("user"+user);

        User use2 = (User) applicationContext.getBean("user2");
        System.out.println("user"+use2);

    }
}
