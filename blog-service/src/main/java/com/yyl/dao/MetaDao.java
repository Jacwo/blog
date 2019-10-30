package com.yyl.dao;

import com.yyl.model.*;

import java.util.List;

public interface MetaDao {

    Meta getMetaByArticleID(Integer articleId);

    void updateLikes(LikeUser likeUser);

    void updateComment(AddComment addComment);

    void create(Meta meta);

    void updateViews(Integer articleId, String views);
}
