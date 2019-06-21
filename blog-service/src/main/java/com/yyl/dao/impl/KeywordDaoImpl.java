package com.yyl.dao.impl;

import com.yyl.dao.KeywordDao;
import com.yyl.dao.TagDao;
import com.yyl.mapper.KeywordMapper;
import com.yyl.mapper.TagMapper;
import com.yyl.model.Keyword;
import com.yyl.model.Tag;
import com.yyl.model.TagQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KeywordDaoImpl implements KeywordDao {
    @Autowired
    private KeywordMapper keywordMapper;

    @Override
    public List<Keyword> getKeywordByArticleID(Integer articleId) {
        return keywordMapper.getKeywordByArticleID(articleId);
    }
}
