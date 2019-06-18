package com.yyl.service;

import com.yyl.api.UserService;
import com.yyl.model.User;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class UserServiceImpl implements UserService {
    public void login(User user) {
        System.out.println(" login success");
    }
}
