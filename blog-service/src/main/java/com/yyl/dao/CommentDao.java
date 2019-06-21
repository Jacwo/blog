package com.yyl.dao;

import com.yyl.model.Comment;
import com.yyl.model.Tag;
import com.yyl.model.TagQuery;

import java.util.List;

public interface CommentDao {

    List<Comment> getCommentByArticleID(Integer articleId);
}
