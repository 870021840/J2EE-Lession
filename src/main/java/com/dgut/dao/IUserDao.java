package com.dgut.dao;

import com.dgut.domain.User;
import com.dgut.queryVO.QueryVO;
import com.dgut.queryVO.UserVo;

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


    /**
     * 根据用户名、性别查询用户信息
     */

    List<User> findByNameAndSex(String username,String sex);


    /**
     * 根据用户名、性别查询用户信息
     */

    List<User> findByNameAndSex2(UserVo vo);


    /**
     * 多条件查询 id如果不为空时可以根据id查询，如果username不同空时还要加入username作为条件。
     */
    public List<User> findByUser(User user);



    /**
     * 多条件查询
     * SELECT * FROM USERS WHERE username LIKE '%张%' AND id IN (10,89,16)
     */
    public List<User> findByQvo(QueryVO vo);


    /**
     * 查询所有的用户以及他们关联的角色
     * @return
     */
    public  List<User> findUsersWithRoles();


    /**
     * 查询所有用户，同时获取出每个用户下的所有账户信息(延迟加载)
     */
    public List<User> findUsersWithAccounts2();



}
