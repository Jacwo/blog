package com.yyl.blog.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yyl.api.MapService;
import com.yyl.blog.utils.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author:yangyuanliang Date:2019-10-24 Time:11:30
 **/
@Controller("/api/map")
public class MapController {
    @Reference
    private MapService mapService;
    @RequestMapping("getMapList")
    @ResponseBody
    public ResultMap getMapList(){

        ResultMap resultMap=new ResultMap();
        resultMap.setData(mapService.getMapList());
        return resultMap;
    }
}
