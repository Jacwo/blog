package com.yyl.dao.impl;

import com.yyl.dao.CommentDao;
import com.yyl.dao.TagDao;
import com.yyl.mapper.CommentMapper;
import com.yyl.mapper.TagMapper;
import com.yyl.model.*;
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

    @Override
    public void addComment(AddComment addComment) {
        commentMapper.addComment(addComment);
    }

    @Override
    public List<OtherCommentInfo> getOtherComments(Integer id) {
        return commentMapper.getOtherComments(id);
    }

    @Override
    public void addThirdComment(AddThirdComment addThirdComment) {
        commentMapper.addThirdComment(addThirdComment);
    }
}
