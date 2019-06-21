package com.yyl.mapper;


import com.yyl.model.Comment;
import com.yyl.model.Tag;
import com.yyl.model.TagQuery;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface CommentMapper {

    @Select(" select id as _id ,article_id,content,is_top,likes,user_id,state,is_handle,create_time,update_time" +
            " from comment where article_id=#{articleId}")
    List<Comment> getCommentByArticleID(Integer articleId);
}
