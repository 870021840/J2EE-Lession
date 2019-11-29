package com.dgut;

import com.dgut.dao.IAccountDao;
import com.dgut.dao.IUser2Dao;
import com.dgut.dao.IUserDao;
import com.dgut.domain.Account;
import com.dgut.domain.User;
import com.dgut.domain.User2;
import com.dgut.queryVO.QueryVO;
import com.dgut.queryVO.UserVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.validator.PublicClassValidator;
import sun.nio.cs.US_ASCII;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class mybatisTest {

    SqlSessionFactory sqlSessionFactory;
    SqlSession session;
    InputStream inputStream;
    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//        // 1.获取sqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
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
        for (User user : allUser){
            System.out.println(user);
        }


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

    @Test
    public void findByUser() throws IOException {
        User user =new User();
        user.setId(41);
//        user.setUsername("yyy");
        // 3. mybatis实现接口
        IUserDao userDao = session.getMapper(IUserDao.class);
        List<User> users = userDao.findByUser(user);
        System.out.println(users);
    }

    @Test
    public void findByQvo() throws IOException {
        QueryVO vo = new QueryVO();
        vo.setUsername("%王%");
//        List list = new ArrayList();
//        list.add(45);
//        list.add(46);
//        list.add(48);
//        vo.setIds(list);
        
        
//        user.setUsername("yyy");
        // 3. mybatis实现接口
        IUserDao userDao = session.getMapper(IUserDao.class);
        List<User> users = userDao.findByQvo(vo);
        System.out.println(users);
    }


    @Test
    public void findUsersWithRoles() throws IOException {
        // 3. mybatis实现接口
        IUserDao userDao = session.getMapper(IUserDao.class);
        List<User> users = userDao.findUsersWithRoles();
        for (User user: users){
            System.out.println(user);
        }
    }

    @Test
    public void findAllAccount() throws IOException {
        // 3. mybatis实现接口
        IAccountDao accountDao = session.getMapper(IAccountDao.class);
        List<Account> all = accountDao.findAll();

        User user = all.get(0).getUser();
        System.out.println(user);

//        for (Account account:all){
//            System.out.println(account.getUser().getUsername());
//        }
    }

    @Test
    public void findUsersWithAccounts2(){
        IUserDao userDao = session.getMapper(IUserDao.class);
        List<User> usersWithAccounts2 = userDao.findUsersWithAccounts2();

        //需求:只需要显示第一个用户信息的账户信息
        List<Account> accounts = usersWithAccounts2.get(0).getAccounts();
        System.out.println(accounts);

        List<Account> accounts2 = usersWithAccounts2.get(1).getAccounts();
        System.out.println(accounts2);
    }


    @Test
    public void testCache(){
        IUserDao userDao = session.getMapper(IUserDao.class);
        User user = userDao.findUserByID(41);
        System.out.println(user);

        //做其他的操作
        User user2 = userDao.findUserByID(41);
        System.out.println(user == user2);

    }

    @Test
    public void testCache2(){
        IUserDao userDao = session.getMapper(IUserDao.class);
        User user = userDao.findUserByID(41);
        System.out.println(user);
        session.close();

        session = sqlSessionFactory.openSession();
        userDao = session.getMapper(IUserDao.class);

        //做其他的操作
        User user2 = userDao.findUserByID(41);
        System.out.println(user2);
        System.out.println(user == user2);
    }

    @Test
    public void testAnno() throws IOException {
        IUser2Dao userDao = session.getMapper(IUser2Dao.class);
        List<User2> list = userDao.findAllUser3();
        for (User2 user: list){
//            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void insertUser(){
        User user = new User();
        user.setUsername("aaa");
        user.setAddress("bbb");
        IUser2Dao userDao = session.getMapper(IUser2Dao.class);
        userDao.insertUser(user);
        System.out.println(user);
    }

    @Test
    public void findID41User(){
        IUser2Dao mapper = session.getMapper(IUser2Dao.class);
        User user = mapper.findID41User();
        System.out.println(user);
        session.close();

        SqlSession session1 = sqlSessionFactory.openSession();
        IUser2Dao user2Dao = session1.getMapper(IUser2Dao.class);
        User user1 = user2Dao.findID41User();
        System.out.println(user1);
    }

    @Test
    public void findAllUser(){
        IUser2Dao mapper = session.getMapper(IUser2Dao.class);
        List<User> allUser = mapper.findAllUser();
        System.out.println(allUser);
    }

    @Test
    public void findSQL(){
        IUser2Dao mapper = session.getMapper(IUser2Dao.class);
        List<User> users = mapper.findSQL("yyy", "aa");
        System.out.println(users);
    }
}

