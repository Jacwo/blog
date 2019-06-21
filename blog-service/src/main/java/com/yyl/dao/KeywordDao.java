package com.yyl.dao;

import com.yyl.model.Keyword;
import com.yyl.model.Tag;
import com.yyl.model.TagQuery;

import java.util.List;

public interface KeywordDao {

    List<Keyword> getKeywordByArticleID(Integer articleId);
}
