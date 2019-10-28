package com.yyl.mapper;

import com.yyl.model.LikeUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * author:yangyuanliang Date:2019-09-09 Time:14:34
 **/
public interface LikeUserMappper {
    @Insert("insert into like_users (article_id,user_id) values (#{user_id},#{id})")
    void likeUser(LikeUser likeUser);
    @Select("select * from like_users")
    List<LikeUser> getTotalLikes();
}
