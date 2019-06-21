package com.yyl.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.yyl.api.MetaService;
import com.yyl.model.Meta;

@Service
public class MetaServiceImpl implements MetaService {

    @Override
    public Meta getMetaByArticleID(Integer articleId) {
        return null;
    }
}
