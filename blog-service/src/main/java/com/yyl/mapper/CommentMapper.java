package com.yyl.mapper;


import com.yyl.model.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface CommentMapper {

    @Select(" select id as _id ,article_id,content,is_top,likes,user_id,state,is_handle,create_time,update_time" +
            " from comment where article_id=#{articleId}")
    List<Comment> getCommentByArticleID(Integer articleId);
    @Insert("insert into comment (article_id,user_id,content) values (#{article_id},#{user_id},#{content})")
    void addComment(AddComment addComment);
    @Select(" select id as _id ,content,user_id,to_user_id" +
            " from third_comment where comment_id=#{id}")
    List<OtherCommentInfo> getOtherComments(Integer id);
    @Insert("insert into third_comment (comment_id,user_id,content,to_user_id) " +
            "values (#{comment_id},#{user_id},#{content},#{to_user_id})")
    void addThirdComment(AddThirdComment addThirdComment);
}
