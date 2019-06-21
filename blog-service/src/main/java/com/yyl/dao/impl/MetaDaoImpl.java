package com.yyl.dao.impl;

import com.yyl.dao.MetaDao;
import com.yyl.dao.TagDao;
import com.yyl.mapper.MetaMapper;
import com.yyl.mapper.TagMapper;
import com.yyl.model.Meta;
import com.yyl.model.Tag;
import com.yyl.model.TagQuery;
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
}
