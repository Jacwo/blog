package com.yyl.blog.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yyl.api.ArticleService;
import com.yyl.api.RedisService;
import com.yyl.blog.utils.IpUtils;
import com.yyl.blog.utils.ResultMap;
import com.yyl.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("/article")
public class ArticleController {
    protected final static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Reference
    private ArticleService articleService;
    @Reference
    private RedisService redisService;
    private ConcurrentHashMap<String,Integer> timesMap=new ConcurrentHashMap<>();
    @RequestMapping("getArticleList")
    @ResponseBody
    public ResultMap getArticleList(ArticleQuery articleQuery){
        ResultMap resultMap=new ResultMap();
        articleQuery.setPageNum((articleQuery.getPageNum()-1)*articleQuery.getPageSize());
        List<Article> articlesList = articleService.getArticleList(articleQuery);
        PageData pageData=new PageData();
        pageData.setList(articlesList);
        pageData.setCount(articleService.getTotalArticleCount());
        resultMap.setData(pageData);
        return resultMap;
    }
    @RequestMapping("likeArticle")
    @ResponseBody
    public ResultMap likeArticle(@RequestBody LikeUser likeUser){
        ResultMap resultMap=new ResultMap();
        articleService.likeArticle(likeUser);
        resultMap.setData("点赞成功");
        return resultMap;
    }
    @RequestMapping("addArticle")
    @ResponseBody
    public ResultMap addArticle(@RequestBody Article article){
        ResultMap resultMap=new ResultMap();
        articleService.addArticle(article);
        resultMap.setData("新增成功");

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
        resultMap.setData("新增成功");
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
    public ResultMap getArticleDetail(@RequestBody ArticleDetailInput articleDetailInput, HttpServletRequest request){
        ResultMap resultMap=new ResultMap();
        String remoteHost = IpUtils.getIpAddress(request);
        String key="articleId:"+articleDetailInput.getId();
        String s = redisService.get(key);
        ArticleDetailDto articleDetailDto = articleService.getArticleDetail(articleDetailInput.getId());
        if(s!=null){
            if(timesMap.containsKey(remoteHost+key)){
                articleDetailDto.getMeta().setViews(Integer.valueOf(s));
            }else{
                int time=Integer.valueOf(s);
                time++;
                timesMap.put(remoteHost+key,time);
                redisService.set(key,String.valueOf(time));
                articleDetailDto.getMeta().setViews(time);
            }
        }else{
            Integer time=articleDetailDto.getMeta().getViews();
            if(!timesMap.containsKey(remoteHost+key)) {
                time++;
                timesMap.put(remoteHost+key,time);
            }
            redisService.set(key,String.valueOf(time));
            articleDetailDto.getMeta().setViews(time);
        }
        resultMap.setData(articleDetailDto);
        System.out.println(remoteHost);

        return resultMap;
    }
}
