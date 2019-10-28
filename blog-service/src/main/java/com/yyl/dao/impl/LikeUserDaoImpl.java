package com.yyl.dao.impl;

import com.yyl.dao.LikeUserDao;
import com.yyl.mapper.LikeUserMappper;
import com.yyl.model.LikeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author:yangyuanliang Date:2019-09-09 Time:14:33
 **/
@Repository
public class LikeUserDaoImpl implements LikeUserDao {
    @Autowired
    private LikeUserMappper likeUserMappper;
    @Override
    public void likeUser(LikeUser likeUser) {

        likeUserMappper.likeUser(likeUser);
    }

    @Override
    public List<LikeUser> getTotalLikes() {
        return likeUserMappper.getTotalLikes();
    }
}
