package com.javaclimb.book.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.book.entity.User;

import java.util.List;


public interface IUserService extends IService<User> {

    public IPage<User> selectUserPage(int pageNum, int pageSize, String param);

    public int addUser(User user);

    public int editUser(User user);

    public User queryUserById(Integer id);

    public int delUserById(Integer id);

    public List<User> queryUserList();

    User queryUserByUsername(User queryUser);
}