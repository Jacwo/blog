package com.yyl.dao;

import com.yyl.model.Meta;
import com.yyl.model.Tag;
import com.yyl.model.TagQuery;

import java.util.List;

public interface MetaDao {

    Meta getMetaByArticleID(Integer articleId);
}
