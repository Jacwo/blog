package com.yyl.api;

import com.yyl.model.*;

import java.util.List;


public interface ArticleService {
    List<Article> getArticleList(ArticleQuery articleQuery);

    ArticleDetailDto getArticleDetail(Integer article_id);

    void likeArticle(LikeUser likeUser);

    void addComment(AddComment addComment);

    void addThirdComment(AddThirdComment addThirdComment);

    void addArticle(Article article);

    Integer getTotalArticleCount();
}
