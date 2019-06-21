package com.yyl.api;

import com.yyl.model.Article;
import com.yyl.model.ArticleDetailDto;
import com.yyl.model.ArticleQuery;

import java.util.List;


public interface ArticleService {
    List<Article> getArticleList(ArticleQuery articleQuery);

    ArticleDetailDto getArticleDetail(Integer article_id);
}
