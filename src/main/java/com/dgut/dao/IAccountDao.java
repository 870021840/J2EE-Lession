package com.dgut.dao;

import com.dgut.domain.Account;
import org.apache.ibatis.annotations.Select;
import sun.awt.geom.AreaOp;

import java.util.List;

public interface IAccountDao {

    /**
     * 查找所有账户信息
     */
//    @Select(value = "select * from account")
    public List<Account> findAllAccount();


    //    查询账户信息同时查询用户信息
    public List<Account> findAll();

    public List<Account> findByUid(String uid);

}
