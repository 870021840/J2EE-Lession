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
import sun.nio.cs.US_ASCII;

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


    @Test
    public void testFindUserByID() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 1.获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2.打开一个session（链接）
        SqlSession session = sqlSessionFactory.openSession();
        // 3. mybatis实现接口
        IUserDao userDao = session.getMapper(IUserDao.class);
        // 4.查找所有用户
        User user = userDao.findUserByID(41);

        System.out.println(user);

        session.close();

        inputStream.close();
    }


    @Test
    public void testinsert() throws IOException {
        User user = new User();
        user.setUsername("东莞理工学院");
        user.setAddress("松山湖1号");

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 1.获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2.打开一个session（链接）
        SqlSession session = sqlSessionFactory.openSession(true);
        // 3. mybatis实现接口
        IUserDao userDao = session.getMapper(IUserDao.class);
        // 4.查找所有用户
        int i = userDao.inserUser(user);

        System.out.println(i+"  "+ user);
        //对于增删改操作需要手动提交一下
//        session.commit();

        session.close();

        inputStream.close();
    }

    @Test
    public void testUpdate() throws IOException {
        User user = new User();
        user.setId(106);
        user.setUsername("东莞理工学院111");
        user.setAddress("松山湖2号");

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 1.获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2.打开一个session（链接）
        SqlSession session = sqlSessionFactory.openSession(true);
        // 3. mybatis实现接口
        IUserDao userDao = session.getMapper(IUserDao.class);
        // 4.查找所有用户
        int i = userDao.updateUser(user);

        System.out.println(i+"  "+ user);

        session.close();

        inputStream.close();
    }


    @Test
    public void testDelete() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 1.获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2.打开一个session（链接）
        SqlSession session = sqlSessionFactory.openSession(true);
        // 3. mybatis实现接口
        IUserDao userDao = session.getMapper(IUserDao.class);
        // 4.查找所有用户
        int i = userDao.deleteUser(106);

        session.close();

        inputStream.close();
    }
}

