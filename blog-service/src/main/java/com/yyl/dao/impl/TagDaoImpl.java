package com.yyl.dao.impl;

import com.yyl.dao.TagDao;
import com.yyl.dao.UserDao;
import com.yyl.mapper.TagMapper;
import com.yyl.mapper.UserMapper;
import com.yyl.model.*;
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

    @Override
    public Integer selectTotal() {
        return tagMapper.selectTotal();
    }

    @Override
    public void saveIP(String remoteHost, String city) {
        tagMapper.saveIP(remoteHost,city);
    }

    @Override
    public boolean queryByIp(String remoteHost) {
        List<String> maps=tagMapper.queryByIp( remoteHost);
        if(maps.size()>0){
            return true;
        }
        return false;
    }
}
