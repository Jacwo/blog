package com.yyl.blog.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yyl.api.UserService;
import com.yyl.blog.conf.ResultMap;
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


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResultMap login(@RequestParam("username") String username,@RequestParam("password")String password){
        ResultMap resultMap=new ResultMap();
        User userInfo=new User();
        //  userService.login(user);
        return resultMap;
    }
}
