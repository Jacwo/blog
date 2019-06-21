package com.yyl.api;


import com.yyl.model.Meta;


public interface MetaService {
    Meta getMetaByArticleID(Integer articleId);
}
