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
@RequestMapping("/article")
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

    @RequestMapping("/getArticleDetail")
    @ResponseBody
    public ResultMap getArticleDetail(@RequestBody  ArticleDetailInput articleDetailInput){
        ResultMap resultMap=new ResultMap();
        ArticleDetailDto articleDetailDto = articleService.getArticleDetail(articleDetailInput.getId());

        resultMap.setData(articleDetailDto);
        return resultMap;
    }
}
