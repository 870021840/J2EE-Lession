package com.dgut;

import com.dgut.dao.IAccountDao;
import com.dgut.dao.IUserDao;
import com.dgut.domain.Account;
import com.dgut.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisTest {

    @Test
    public void testFindAll() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//        // 1.获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
         // 2.打开一个session（链接）
        SqlSession session = sqlSessionFactory.openSession();
        // 3. mybatis实现接口
        IUserDao userDao = session.getMapper(IUserDao.class);
        // 4.查找所有用户
        List<User> allUser = userDao.findAllUser();

        System.out.println(allUser);

        session.close();

        inputStream.close();
    }


    @Test
    public void testFindAllAccount() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 1.获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2.打开一个session（链接）
        SqlSession session = sqlSessionFactory.openSession();
        // 3. mybatis实现接口
        IAccountDao userDao = session.getMapper(IAccountDao.class);
        // 4.查找所有用户
        List<Account> allAccount = userDao.findAllAccount();

        System.out.println(allAccount);

        session.close();

        inputStream.close();
    }
}

