package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.User;

import java.util.List;

/**
 * 用户表的service接口
 */
public interface IUserService extends IService<User> {
    /**
     * 根据用户名查询用户对象
     */
    public IPage<User> selectUserPage(int pageNum, int pageSize, String param);

    public int addUser(User user);

    public int editUser(User user);

    public User queryUserById(Integer id);

    public int delUserById(Integer id);

    /**
     * 查询所有供应商
     * @return
     */
    public List<User> queryUserList();

    User queryUserByUsername(User queryUser);
}