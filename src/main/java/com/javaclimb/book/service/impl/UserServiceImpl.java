package com.javaclimb.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.book.entity.User;
import com.javaclimb.book.mapper.UserMapper;
import com.javaclimb.book.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户service实现类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<User> selectUserPage(int pageNum, int pageSize, String param) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("username", param);
        }
        Page<User> page = new Page<>(pageNum, pageSize);
        return userMapper.selectPage(page, queryWrapper);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int editUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public User queryUserById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public int delUserById(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public List<User> queryUserList() {
        return userMapper.selectList(null);
    }

    /**
     * 根据用户名查询用户对象
     *
     * @param user
     */
    @Override
    public User queryUserByUsername(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        return userMapper.selectOne(wrapper);
    }
}
