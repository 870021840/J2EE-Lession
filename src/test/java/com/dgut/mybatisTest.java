package com.dgut;

import com.dgut.dao.IAccountDao;
import com.dgut.dao.IUser2Dao;
import com.dgut.dao.IUserDao;
import com.dgut.domain.Account;
import com.dgut.domain.User;
import com.dgut.domain.User2;
import com.dgut.queryVO.UserVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.nio.cs.US_ASCII;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisTest {

    SqlSession session;
    InputStream inputStream;
    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//        // 1.获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2.打开一个session（链接）
        session = sqlSessionFactory.openSession();
    }

    @After
    public void destroy() throws IOException {
        session.close();
        inputStream.close();
    }

    @Test
    public void testFindAll() throws IOException {

        // 3. mybatis实现接口
        IUserDao userDao = session.getMapper(IUserDao.class);
        // 4.查找所有用户
        List<User> allUser = userDao.findAllUser();

        System.out.println(allUser);

    }


    @Test
    public void testFindAllAccount() throws IOException {
        // 3. mybatis实现接口
        IAccountDao userDao = session.getMapper(IAccountDao.class);
        // 4.查找所有用户
        List<Account> allAccount = userDao.findAllAccount();

        System.out.println(allAccount);

    }


    @Test
    public void testFindUserByID() throws IOException {
        // 3. mybatis实现接口
        IUserDao userDao = session.getMapper(IUserDao.class);
        // 4.查找所有用户
        User user = userDao.findUserByID(41);

        System.out.println(user);
    }


    @Test
    public void testinsert() throws IOException {
        User user = new User();
        user.setUsername("东莞理工学院");
        user.setAddress("松山湖1号");

        // 3. mybatis实现接口
        IUserDao userDao = session.getMapper(IUserDao.class);
        // 4.查找所有用户
        int i = userDao.inserUser(user);

        System.out.println(i+"  "+ user);
        //对于增删改操作需要手动提交一下
//        session.commit();
    }

    @Test
    public void testUpdate() throws IOException {
        User user = new User();
        user.setId(106);
        user.setUsername("东莞理工学院111");
        user.setAddress("松山湖2号");


        // 3. mybatis实现接口
        IUserDao userDao = session.getMapper(IUserDao.class);
        // 4.查找所有用户
        int i = userDao.updateUser(user);

        System.out.println(i+"  "+ user);

    }


    @Test
    public void testDelete() throws IOException {
        // 3. mybatis实现接口
        IUserDao userDao = session.getMapper(IUserDao.class);
        // 4.查找所有用户
        int i = userDao.deleteUser(106);
    }


    @Test
    public void findByName() throws IOException {
        // 3. mybatis实现接口
        IUserDao userDao = session.getMapper(IUserDao.class);
        // 4.查找所有用户
        List<User> users = userDao.findByName("%yy%");
        System.out.println(users);
    }

    @Test
    public void findByName2() throws IOException {
        // 3. mybatis实现接口
        IUserDao userDao = session.getMapper(IUserDao.class);
        // 4.查找所有用户
        List<User> users = userDao.findByName2("' or '1'='1");
        System.out.println(users);
    }

    @Test
    public void findTotal() throws IOException {
        // 3. mybatis实现接口
        IUserDao userDao = session.getMapper(IUserDao.class);
        // 4.查找所有用户
        int total = userDao.findTotal();
        System.out.println(total);
    }

    @Test
    public void findByNameAndSex() throws IOException {
        // 3. mybatis实现接口
        IUserDao userDao = session.getMapper(IUserDao.class);
        // 4.查找所有用户
        List<User> users = userDao.findByNameAndSex("%yy%", "男");
        System.out.println(users);
    }

    @Test
    public void findByNameAndSex2() throws IOException {
        UserVo vo = new UserVo();
        vo.setUsername("%yy%");
        vo.setSex("男");
        // 3. mybatis实现接口
        IUserDao userDao = session.getMapper(IUserDao.class);
        // 4.查找所有用户
        List<User> users = userDao.findByNameAndSex2(vo);
        System.out.println(users);
    }

    @Test
    public void findAllUser2() throws IOException {
        // 3. mybatis实现接口
        IUser2Dao userDao = session.getMapper(IUser2Dao.class);
        // 4.查找所有用户
        List<User2> users = userDao.findAllUser2();
        System.out.println(users);
    }
}

