package com.yyl.service;

import com.yyl.api.UserService;
import com.yyl.dao.UserDao;
import com.yyl.model.User;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public User login(User user) {
        return userDao.login(user);
    }
}
