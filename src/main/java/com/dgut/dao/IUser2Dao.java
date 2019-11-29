package com.dgut.dao;

import com.dgut.domain.User;
import com.dgut.domain.User2;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.io.IOException;
import java.util.List;

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

}
