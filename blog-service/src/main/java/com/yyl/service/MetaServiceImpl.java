package com.yyl.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.yyl.api.MetaService;
import com.yyl.dao.MetaDao;
import com.yyl.model.Meta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MetaServiceImpl implements MetaService {
    @Autowired
    private MetaDao metaDao;
    @Override
    public Meta getMetaByArticleID(Integer articleId) {
        return metaDao.getMetaByArticleID(articleId);
    }

    @Override
    @Transactional
    public void updateViews(Integer articleId, String views) {
        metaDao.updateViews(articleId, views);
    }


}
