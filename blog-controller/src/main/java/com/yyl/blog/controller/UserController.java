package com.yyl.blog.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yyl.api.UserService;
import com.yyl.blog.utils.ResultMap;
import com.yyl.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/user")
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
    public ResultMap login(@RequestBody User user){
        ResultMap resultMap=new ResultMap();
       // User user=new User();
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
