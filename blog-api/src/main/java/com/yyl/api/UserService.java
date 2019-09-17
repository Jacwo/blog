package com.yyl.api;


import com.yyl.model.User;

public interface UserService {
    User login(User user);

    void register(User user);
}
