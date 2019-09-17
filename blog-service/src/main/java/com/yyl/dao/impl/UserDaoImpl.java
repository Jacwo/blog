package com.yyl.dao.impl;

import com.yyl.dao.UserDao;
import com.yyl.mapper.UserMapper;
import com.yyl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public void register(User user) {
        userMapper.register(user);
    }
}
