package com.yyl.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.yyl.api.TagService;
import com.yyl.dao.TagDao;
import com.yyl.model.Tag;
import com.yyl.model.TagQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDao tagDao;
    @Override
    public List<Tag> getTagList(TagQuery tagQuery) {
        return tagDao.getTagList(tagQuery);
    }

    @Override
    public List<Tag> getTagByArticleID(Integer articleId) {
        return tagDao.getTagByArticleID(articleId);
    }

    @Override
    public Integer selectTotal() {
        return tagDao.selectTotal();
    }

    @Override
    public void saveIP(String remoteHost, String city) {
        tagDao.saveIP(remoteHost, city);
    }

    @Override
    public boolean queryByIp(String remoteHost) {

        return tagDao.queryByIp(remoteHost);
    }
}
