package com.dgut.dao;

import com.dgut.domain.User;
import com.dgut.domain.User2;

import java.io.IOException;
import java.util.List;

public interface IUser2Dao {

    /**
     * 查找所有用户
     * @throws IOException
     */
    public List<User2> findAllUser2() throws IOException;

}
