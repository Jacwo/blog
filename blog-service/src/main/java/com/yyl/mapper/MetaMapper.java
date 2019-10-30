package com.yyl.mapper;


import com.yyl.model.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface MetaMapper {
    @Select("select id as _id,views,likes,comments from meta where article_id=#{articleId}")
    Meta getTagByArticleID(Integer articleId);
    @Update("update meta set likes =likes+1 where article_id=#{id}")
    void updateLikes(LikeUser likeUser);
    @Update("update meta set comments =comments+1 where article_id=#{article_id}")
    void updateComment(AddComment addComment);
    @Insert("insert into meta(likes,views,comments,article_id) values(#{likes},#{views},#{comments},#{articleId})")
    void create(Meta meta);
    @Update("update meta set views=#{views} where article_id=#{articleId}")
    void updateViews(Integer articleId, String views);
}
