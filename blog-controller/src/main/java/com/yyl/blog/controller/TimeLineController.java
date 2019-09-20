package com.yyl.blog.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yyl.api.TimeLineService;
import com.yyl.blog.utils.ResultMap;
import com.yyl.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * author:yangyuanliang Date:2019-09-12 Time:11:06
 **/
@Controller
@RequestMapping("/api/time")
public class TimeLineController {
    @Reference
    private TimeLineService timeLineService;
    @RequestMapping("getTimeList")
    @ResponseBody
    public ResultMap getTimeList(TimeLineQuery timeLineQuery){
        ResultMap resultMap=new ResultMap();
        List<TimeLine> timeLineList = timeLineService.getTimeLineList(timeLineQuery);
        PageData pageData=new PageData();
        pageData.setList(timeLineList);
        pageData.setCount(timeLineList.size());
        resultMap.setData(pageData);
        return resultMap;
    }
}
