package com.yyl.blog.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yyl.api.ArticleService;
import com.yyl.blog.utils.ResultMap;
import com.yyl.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/article")
public class ArticleController {
    @Reference
    private ArticleService articleService;

    @RequestMapping("getArticleList")
    @ResponseBody
    public ResultMap getArticleList(ArticleQuery articleQuery){
        ResultMap resultMap=new ResultMap();
        articleQuery.setPageNum(articleQuery.getPageNum()-1);
        List<Article> articlesList = articleService.getArticleList(articleQuery);
        PageData pageData=new PageData();
        pageData.setList(articlesList);
        pageData.setCount(articlesList.size());
        resultMap.setData(pageData);
        return resultMap;
    }
    @RequestMapping("likeArticle")
    @ResponseBody
    public ResultMap likeArticle(@RequestBody LikeUser likeUser){
        ResultMap resultMap=new ResultMap();
        articleService.likeArticle(likeUser);
        return resultMap;
    }

    /***
     * {"article_id":"5d405a1896cf541789792486","user_id":"5d75ec65662d5e73c62cbae7","content":"test"}
     * @param addComment
     * @return
     */
    @RequestMapping("addComment")
    @ResponseBody
    public ResultMap addComment(@RequestBody AddComment addComment){
        ResultMap resultMap=new ResultMap();
        articleService.addComment(addComment);

        return resultMap;
    }
    @RequestMapping("addThirdComment")
    @ResponseBody
    public ResultMap addThirdComment(@RequestBody AddThirdCommentInput addThirdCommentInput){
        ResultMap resultMap=new ResultMap();
        AddThirdComment addThirdComment=new AddThirdComment();
        addThirdComment.setTo_user_id(addThirdCommentInput.getTo_user().get_id());
        addThirdComment.setArticle_id(addThirdCommentInput.getArticle_id());
        addThirdComment.setComment_id(addThirdCommentInput.getComment_id());
        addThirdComment.setContent(addThirdCommentInput.getContent());
        addThirdComment.setUser_id(addThirdCommentInput.getUser_id());
        addThirdComment.setUser_id(addThirdComment.getUser_id());
        articleService.addThirdComment(addThirdComment);

        return resultMap;
    }


    @RequestMapping("/getArticleDetail")
    @ResponseBody
    public ResultMap getArticleDetail(@RequestBody  ArticleDetailInput articleDetailInput){
        ResultMap resultMap=new ResultMap();
        ArticleDetailDto articleDetailDto = articleService.getArticleDetail(articleDetailInput.getId());

        resultMap.setData(articleDetailDto);
        return resultMap;
    }
}
