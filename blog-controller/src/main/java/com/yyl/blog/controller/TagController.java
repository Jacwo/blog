package com.yyl.blog.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yyl.api.ArticleService;
import com.yyl.api.TagService;
import com.yyl.blog.utils.ResultMap;
import com.yyl.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/tag")
public class TagController {
    @Reference
    private TagService tagService;

    @RequestMapping("getTagList")
    @ResponseBody
    public ResultMap getTagList(TagQuery tagQuery){
        ResultMap resultMap=new ResultMap();
        tagQuery.setPageNum(tagQuery.getPageNum()-1);
        List<Tag> tags = tagService.getTagList(tagQuery);
        PageData pageData=new PageData();
        pageData.setList(tags);
        pageData.setCount(tags.size());
        resultMap.setData(pageData);
        return resultMap;
    }
}
