package com.yyl.dao;

import com.yyl.model.LikeUser;

import java.util.List;

/**
 * author:yangyuanliang Date:2019-09-09 Time:14:33
 **/
public interface LikeUserDao {
    void  likeUser(LikeUser likeUser);
    List<LikeUser> getTotalLikes();
}
