package com.yyl.dao.impl;

import com.yyl.dao.TagDao;
import com.yyl.dao.UserDao;
import com.yyl.mapper.TagMapper;
import com.yyl.mapper.UserMapper;
import com.yyl.model.ArticleTagInfo;
import com.yyl.model.Tag;
import com.yyl.model.TagQuery;
import com.yyl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagDaoImpl implements TagDao {
    @Autowired
    private TagMapper tagMapper;
    @Override
    public List<Tag> getTagList(TagQuery tagQuery) {
        return tagMapper.getTagList(tagQuery);
    }

    @Override
    public List<Tag> getTagByArticleID(Integer articleId) {
        return tagMapper.getTagByArticleID(articleId);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagMapper.getTagByName(name);
    }

    @Override
    public void create(ArticleTagInfo articleTagInfo) {
        tagMapper.create(articleTagInfo);
    }
}
