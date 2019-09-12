package com.yyl.dao.impl;

import com.yyl.dao.ArticleDao;
import com.yyl.mapper.ArticleMapper;
import com.yyl.model.Article;
import com.yyl.model.ArticleDetailDto;
import com.yyl.model.ArticleQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleDaoImpl implements ArticleDao {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public List<Article> getArticleList(ArticleQuery articleQuery) {
        return articleMapper.getArticleList(articleQuery);
    }

    @Override
    public ArticleDetailDto getArticleById(Integer article_id) {
        return articleMapper.getArticleById(article_id);
    }

    @Override
    public Integer createArticle(Article article) {
        return articleMapper.createArticle(article);
    }

    @Override
    public Integer getTotalArticleCount() {
        List<Article> totalArticleCount = articleMapper.getTotalArticleCount();
        return totalArticleCount.size();
    }
}
