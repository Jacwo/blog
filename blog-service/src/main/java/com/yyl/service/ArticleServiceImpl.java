package com.yyl.service;
import com.alibaba.dubbo.config.annotation.Service;
import com.yyl.api.ArticleService;
import com.yyl.dao.*;
import com.yyl.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private RedisServiceImpl redisService;
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
    @Autowired
    private LikeUserDao likeUserDao;
    @Override
    public List<Article> getArticleList(ArticleQuery articleQuery) {
        List<Article> newList=new ArrayList<>();
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
                if(articleQuery.getTag_id()!=null){
                    if(!tags.contains(articleQuery.getTag_id()+"")){
                        continue;
                    }
                }
                article.setTags(tags);
                Meta metaByArticleID = metaDao.getMetaByArticleID(article.get_id());
                if(redisService.get("articleId:"+article.get_id())!=null){
                    metaByArticleID.setViews(Integer.valueOf(redisService.get("articleId:"+article.get_id())));
                }
                article.setMeta(metaByArticleID);
                newList.add(article);
            }
        }
        return newList;
    }

    @Override
    public ArticleDetailDto getArticleDetail(Integer article_id) {
        ArticleDetailDto articleDetailDto=articleDao.getArticleById(article_id);
        articleDetailDto.setCategory(categoryDao.getCategoryByArticleID(article_id));
        List<Comment> comments = commentDao.getCommentByArticleID(article_id);
        List<Article> articleList = articleDao.getArticleList();
        Collections.shuffle(articleList);
        articleDetailDto.setArticles(articleList.subList(0,10));
        if(comments!=null){
            for(Comment comment:comments){

                List<OtherComment> otherComments=new ArrayList<>();
                List<OtherCommentInfo> otherCommentInfos=commentDao.getOtherComments(comment.get_id());
                if(otherCommentInfos.size()>0){
                    for (OtherCommentInfo otherCommentInfo:otherCommentInfos){
                        OtherComment otherComment=new OtherComment();
                        otherComment.set_id(otherCommentInfo.get_id());
                        otherComment.setContent(otherCommentInfo.getContent());
                        otherComment.setLikes(0);
                        otherComment.setState(0);
                        otherComment.setUser(userDao.findById(otherCommentInfo.getUser_id()));
                        otherComment.setTo_user(userDao.findById(otherCommentInfo.getTo_user_id()));
                        otherComments.add(otherComment);
                    }
                }
                comment.setOther_comments(otherComments);
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

    @Override
    public void likeArticle(LikeUser likeUser) {
        metaDao.updateLikes(likeUser);
        likeUserDao.likeUser(likeUser);
    }

    @Override
    @Transactional
    public void addComment(AddComment addComment) {
        metaDao.updateComment(addComment);
        commentDao.addComment(addComment);
    }

    @Override
    public void addThirdComment(AddThirdComment addThirdComment) {
        commentDao.addThirdComment(addThirdComment);
    }

    @Override
    @Transactional
    public void addArticle(Article article) {
        article.setNumbers(article.getContent()!=null?article.getContent().length()+"":"0");
        articleDao.createArticle(article);
        Integer articleId=article.get_id();
        TagQuery tagQuery=new TagQuery();
        tagQuery.setPageNum(0);
        tagQuery.setPageSize(1000);
        List<Category> categoryList = categoryDao.getCategoryList();
        List<Tag> tagList = tagDao.getTagList(tagQuery);
        List<String> tags = article.getTags();
        if(tags!=null && tags.size()>0){
            for(String tagName:tags){
                for(Tag tag :tagList){
                    if(tagName.equals(tag.getName())){
                        Tag tagByName = tagDao.getTagByName(tagName);
                        ArticleTagInfo articleTagInfo=new ArticleTagInfo();
                        articleTagInfo.setArticleId(articleId);
                        articleTagInfo.setTagId(tagByName.get_id());
                        tagDao.create(articleTagInfo);
                    }
                }
            }

        }
        List<String> category = article.getCategory();
        if(category!=null && category.size()>0){
            for(String cat:category){
                for(Category category1 :categoryList){
                    if(cat.equals(category1.getName())){
                        Category categoryByName = categoryDao.getCategoryByName(cat);
                        ArticleCategoryInfo articleCategoryInfo=new ArticleCategoryInfo();
                        articleCategoryInfo.setArticleId(articleId);
                        articleCategoryInfo.setCategoryId(categoryByName.get_id());
                        categoryDao.create(articleCategoryInfo);
                    }
                }
            }

        }
        Meta meta=new Meta();
        meta.setComments(0);
        meta.setLikes(0);
        meta.setViews(0);
        meta.setArticleId(articleId);
        metaDao.create(meta);

    }

    @Override
    public Integer getTotalArticleCount() {
        return articleDao.getTotalArticleCount();
    }

    @Override
    public Integer getTotalLikes() {
        return likeUserDao.getTotalLikes().size();
    }
}
