package com.dgut.dao;

import com.dgut.domain.User;
import java.io.IOException;
import java.util.List;

public interface IUserDao {

    /**
     * 查找所有用户
     * @throws IOException
     */
    public List<User> findAllUser() throws IOException;
}
