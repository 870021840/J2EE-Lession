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


}
