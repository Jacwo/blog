package com.yyl.dao;

import com.yyl.model.User;

public interface UserDao {
    User login(User user);
    User findById(Integer id);

    void register(User user);
}
