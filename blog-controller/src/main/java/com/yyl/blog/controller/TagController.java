package com.yyl.blog.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yyl.api.RedisService;
import com.yyl.api.TagService;
import com.yyl.blog.utils.IpUtils;
import com.yyl.blog.utils.ResultMap;
import com.yyl.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("/api/tag")
public class TagController {
    @Reference
    private TagService tagService;
    @Reference
    private RedisService redisService;
    private ConcurrentHashMap<String,Integer> timesMap=new ConcurrentHashMap<>();
    @RequestMapping("getTagList")
    @ResponseBody
    public ResultMap getTagList(TagQuery tagQuery, HttpServletRequest request){
        ResultMap resultMap=new ResultMap();
        tagQuery.setPageNum(tagQuery.getPageNum()-1);
        String key="total";
        List<Tag> tags = tagService.getTagList(tagQuery);
        PageData pageData=new PageData();
        pageData.setList(tags);
        String remoteHost = IpUtils.getIpAddress(request);
        String s = redisService.get(key);
        if(s!=null){
            if(timesMap.containsKey(remoteHost)){
                pageData.setCount(Integer.valueOf(s));
            }else{
                int time=Integer.valueOf(s);
                time++;
                timesMap.put(remoteHost,time);
                redisService.set(key,String.valueOf(time));
                pageData.setCount(time);
            }
        }else{
            Integer time=tagService.selectTotal();
            if(!timesMap.containsKey(remoteHost)) {
                time++;
                timesMap.put(remoteHost,time);
            }
            redisService.set(key,String.valueOf(time));
            pageData.setCount(time);
        }

        resultMap.setData(pageData);
        return resultMap;
    }
}
