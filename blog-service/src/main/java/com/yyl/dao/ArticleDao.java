package com.yyl.dao;

import com.yyl.model.Article;
import com.yyl.model.ArticleDetailDto;
import com.yyl.model.ArticleQuery;

import java.util.List;


public interface ArticleDao {
    List<Article> getArticleList(ArticleQuery articleQuery);

    ArticleDetailDto getArticleById(Integer article_id);

    Integer createArticle(Article article);
}
