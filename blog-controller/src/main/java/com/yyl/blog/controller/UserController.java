package com.yyl.blog.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yyl.api.UserService;
import com.yyl.blog.utils.HttpClientUtil;
import com.yyl.blog.utils.ResultMap;
import com.yyl.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/api/user")
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    @ResponseBody
    public ResultMap getUser(@RequestParam("code") String code){
        ResultMap resultMap=new ResultMap();
        String url="https://github.com/login/oauth/access_token?client_id=4b8e4dd18ee36f991386&" +
                "client_secret=117548602c30104262bc7c8ffb9e37f319a031a5&code=1f0476760564e35ce689code="+code;
        String s = HttpClientUtil.doGet(url, 3000);
        String data = HttpClientUtil.doGet("https://api.github.com/user?access_token=" + s, 3000);
        System.out.println(data);
        resultMap.setData(data);
        //转跳到 GitHub 用户授权页面， client_id 必须传
        //其他参数如果有需要就传，例如我这里需要获取用户的邮箱信息，就加了一个 scope=user:email
        //最终拼成的URL如下:
        //https://github.com/login/oauth/authorize?client_id=myclient_id&scope=user:email
        //当用户同意授权后，链接地址就会转跳到 我们配置页面内的 Authorization callback URL 所填写的URL地址，
        // 并且会带上一个 code参数，这个参数在后面获取用户token是必须的一个参数。
        //获取到这个code参数后，我会将这个code传到服务器的后台，然后后台调用
        // https://github.com/login/oauth/access_token 这个api，
        // 传入 client_id, client_secret, code 这三个参数，可以获取到一个 access_token。
        //
        //获取到 access_token 后， 再调用
        // https://api.github.com/user?access_token=access_token 这个API，
        // 就可以获取到基本的用户信息了。 用户的基本信息内容如下所示， 根据第一步传入的不同的 scope，
        // 获取到的用户信息也是不同的。博客后台使用 login 字段作为用户的唯一标示，因为email 可能为空，
        // 之前用email发生了一些bug。
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
