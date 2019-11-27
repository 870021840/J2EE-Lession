package com.dgut.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class UserDao {


    /**
    * 查询指定用户名
    */
    public void findUsersBy(String username) throws SQLException {
        //1. 获取数据库链接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "xieman123");
        //2. 创«建statement
        PreparedStatement statement = connection.prepareStatement("select * from user where username = ?");
        statement.setString(1,username);
        //3. 执行sql语句
        ResultSet rs = statement.executeQuery();
        //4. 遍历结果集
        while (rs.next()){
            int id = rs.getInt("id");
            String username1 = rs.getString("username");
            String address = rs.getString("address");
            System.out.println(id+" "+username1+" "+address);
        }
        //4.关闭资源
        rs.close();;
        statement.close();
        connection.close();
    }


    public static void main(String[] args) throws SQLException {
        UserDao  userDao = new UserDao();
        userDao.findUsersBy("yyy");
    }

}
