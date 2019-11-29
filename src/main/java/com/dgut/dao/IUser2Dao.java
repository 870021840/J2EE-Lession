package com.dgut.dao;

import com.dgut.domain.User;
import com.dgut.domain.User2;
import com.dgut.sqlProvider.UserSqlBuilder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.io.IOException;
import java.util.List;
@CacheNamespace
public interface IUser2Dao {

    /**
     * 查找所有用户
     * @throws IOException
     */
    public List<User2> findAllUser2() throws IOException;


    @Select(value = "select * from user")
    @Results(id = "wusuowei2",value={
            @Result(id = true,column = "id",property = "uid"),
            @Result(property = "accounts",
                    many = @Many(select="com.dgut.dao.IAccountDao.findByUid",
                            fetchType = FetchType.LAZY),
                    column = "id"
            )
    })
    public List<User2> findAllUser3() throws IOException;



//    @Insert(value = "")
    @Insert("insert into user(username,address) values(#{username},#{address}) ")
    @Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
    public int insertUser(User user);


    @Select(value = "select * from user where id = 41")
    public User findID41User();


    @Select("select * from user left join account on user.id = account.uid")
//    @Results(
//            @Result(column = "username",property = "username"),
//            @Result(property = "accounts",c)
//
//    )
    public List<User> findAllUser();


    @SelectProvider(type = UserSqlBuilder.class,method = "buildGetUsersByName")
    public List<User> findSQL(String username,String address);
}
