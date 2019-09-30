package com.yyl.blog.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yyl.api.RedisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author:yangyuanliang Date:2019-09-16 Time:14:28
 **/
@Controller
@RequestMapping("/api/test")
public class TestController {
    @Reference
    private RedisService redisService;
    @RequestMapping("testRedis")
    @ResponseBody
    public String testRedis(){
        redisService.set("2222","@22222");
        return redisService.get("2222");
    }


}
