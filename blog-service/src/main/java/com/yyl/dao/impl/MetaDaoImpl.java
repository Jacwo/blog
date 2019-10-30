package com.yyl.dao.impl;

import com.yyl.dao.MetaDao;
import com.yyl.dao.TagDao;
import com.yyl.mapper.MetaMapper;
import com.yyl.mapper.TagMapper;
import com.yyl.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MetaDaoImpl implements MetaDao {
    @Autowired
    private MetaMapper metaMapper;

    @Override
    public Meta getMetaByArticleID(Integer articleId) {
        return metaMapper.getTagByArticleID(articleId);
    }

    @Override
    public void updateLikes(LikeUser likeUser) {
        metaMapper.updateLikes(likeUser);
    }

    @Override
    public void updateComment(AddComment addComment) {
        metaMapper.updateComment(addComment);
    }

    @Override
    public void create(Meta meta) {
        metaMapper.create(meta);
    }

    @Override
    public void updateViews(Integer articleId, String views) {
        metaMapper.updateViews(articleId,views);
    }
}
