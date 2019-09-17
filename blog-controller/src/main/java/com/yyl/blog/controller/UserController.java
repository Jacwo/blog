package com.yyl.blog.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yyl.api.UserService;
import com.yyl.blog.utils.ResultMap;
import com.yyl.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
    @ResponseBody
    public ResultMap userInfo(){
        ResultMap resultMap=new ResultMap();
      //  userService.login(user);
        return resultMap;
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public ResultMap register(@RequestBody User user){
        ResultMap resultMap=new ResultMap();
        user.setAvatar("http://hbimg.b0.upaiyun.com/35c1bbf1039fed2470db2891c03a0ccae2ae23ee1d44-pHn81e_fw658");
        userService.register(user);
        resultMap.setData("注册成功");
        return resultMap;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResultMap login(@RequestBody User user){
        ResultMap resultMap=new ResultMap();
        User result=userService.login(user);
        if(result==null){
            resultMap.setCode(500);
            resultMap.setStatus(500);
            return resultMap;
        }
        resultMap.setData(result);
        return resultMap;
    }
}
