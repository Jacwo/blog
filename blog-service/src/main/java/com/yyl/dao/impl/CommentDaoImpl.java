package com.yyl.dao.impl;

import com.yyl.dao.CommentDao;
import com.yyl.dao.TagDao;
import com.yyl.mapper.CommentMapper;
import com.yyl.mapper.TagMapper;
import com.yyl.model.Comment;
import com.yyl.model.Tag;
import com.yyl.model.TagQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getCommentByArticleID(Integer articleId) {
        List<Comment> comments = commentMapper.getCommentByArticleID(articleId);
        return comments;
    }
}
