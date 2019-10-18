package com.yyl.service;

import com.yyl.api.UserService;
import com.yyl.dao.UserDao;
import com.yyl.model.User;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    @Transactional
    public void register(User user) {
         userDao.register(user);
    }
}
