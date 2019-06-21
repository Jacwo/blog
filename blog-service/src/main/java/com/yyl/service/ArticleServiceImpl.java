package com.yyl.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.yyl.api.ArticleService;
import com.yyl.dao.*;
import com.yyl.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private MetaDao metaDao;
    @Autowired
    private TagDao tagDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private KeywordDao keywordDao;
    @Override
    public List<Article> getArticleList(ArticleQuery articleQuery) {
        List<Article> articleList = articleDao.getArticleList(articleQuery);
        if(articleList!=null){
            for(Article article:articleList){
                List<String> tags=new ArrayList<>();
                List<Tag> tagByArticleID = tagDao.getTagByArticleID(article.get_id());
                if(tagByArticleID!=null){
                    for (Tag tag:tagByArticleID){
                        tags.add(tag.get_id()+"");
                    }
                }
                article.setTags(tags);
                article.setMeta(metaDao.getMetaByArticleID(article.get_id()));
            }
        }
        return articleList;
    }

    @Override
    public ArticleDetailDto getArticleDetail(Integer article_id) {
        ArticleDetailDto articleDetailDto=articleDao.getArticleById(article_id);
        articleDetailDto.setCategory(categoryDao.getCategoryByArticleID(article_id));
        List<Comment> comments = commentDao.getCommentByArticleID(article_id);
        if(comments!=null){
            for(Comment comment:comments){
                comment.setUser(userDao.findById(comment.getUser_id()));
            }
        }
        articleDetailDto.setComments(comments);
        articleDetailDto.setTags(tagDao.getTagByArticleID(article_id));
        List<Keyword> keywords = keywordDao.getKeywordByArticleID(article_id);
        List<String> keys=new ArrayList<>();
        if(keywords!=null){
            for (Keyword keyword:keywords){
                keys.add(keyword.getName());
            }
        }
        articleDetailDto.setKeyword(keys);

        articleDetailDto.setMeta(metaDao.getMetaByArticleID(article_id));
        return articleDetailDto;
    }
}