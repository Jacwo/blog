package com.yyl.mapper;

import com.yyl.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {
    @Select(value = "select id as _id,name,email,avatar from users where  email=#{email} and password=#{password}")
    User login(User user);
    @Select(value = "select id as _id,name,email,avatar from users where  id=#{id}")
    User findById(Integer id);
    @Insert("insert into users (name,password,email,avatar)values(#{name},#{password},#{email},#{avatar})")
    void register(User user);
}
