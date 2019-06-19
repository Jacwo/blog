package com.yyl.mapper;

import com.yyl.model.User;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {
    @Select(value = "select * from users where  username=#{username} and password=#{password}")
    void login(User user);
}
