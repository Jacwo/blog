package com.yyl.dao;

import com.yyl.model.*;

import java.util.List;

public interface CommentDao {

    List<Comment> getCommentByArticleID(Integer articleId);

    void addComment(AddComment addComment);

    List<OtherCommentInfo> getOtherComments(Integer id);

    void addThirdComment(AddThirdComment addThirdComment);
}
