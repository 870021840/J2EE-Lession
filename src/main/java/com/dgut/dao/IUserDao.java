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

    /**
     * 根据用户id查找用户
     * @param id
     * @return
     */
    public  User findUserByID(Integer id);


    /**
     * 插入用户
     * @param user 用户
     * @return 影响行数
     */
    public int inserUser(User user);


    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */

    int deleteUser(Integer id);


    /**
     * 根据名称模糊查询
     */
    List<User> findByName(String username);

    /**
     * 根据名称模糊查询
     */
    List<User> findByName2(String username);


    /**
     * 查询总记录条数
     */
    int findTotal();

}
