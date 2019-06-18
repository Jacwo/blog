package com.yyl.blog.controller;

import com.yyl.blog.conf.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * leapstack author:yangyuanliang Date:2019-06-18 Time:17:17
 **/
@Controller
public class TagController {

    @RequestMapping("/getAllTags")
    @ResponseBody
    public ResultMap getAllTags(){
        ResultMap resultMap=new ResultMap();
        return resultMap;
    }
}
