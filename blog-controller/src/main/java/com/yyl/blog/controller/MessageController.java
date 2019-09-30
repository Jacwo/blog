package com.yyl.blog.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yyl.api.MessageService;
import com.yyl.api.UserService;
import com.yyl.blog.utils.HttpClientUtil;
import com.yyl.blog.utils.JacksonJsonUtil;
import com.yyl.blog.utils.ResultMap;
import com.yyl.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/message")
public class MessageController {

    @Reference
    private MessageService messageService;

    @RequestMapping(value = "/addMessage",method = RequestMethod.POST)
    @ResponseBody
    public ResultMap addMessage(@RequestBody MessageDto message){
        ResultMap resultMap=new ResultMap();
        messageService.addMessage(message);
        return resultMap;
    }

    /**
     *         [
     *         ['用户名', '金额', '留言'],
     *         ['row 1; column 1', 'row 1; column 2', 'row 1; column 3']
     *
     *       ]
     * @return
     */
    @RequestMapping(value = "/getMoneyList",method = RequestMethod.POST)
    @ResponseBody
    public ResultMap getMoneyList(){
        ResultMap resultMap=new ResultMap();
        List<List<String>> listList=new ArrayList<>();

        List<MoneyDto> moneylist=messageService.getMoneyList();
        for(MoneyDto messageDto:moneylist){
            List<String> list=new ArrayList<>();
            list.add(messageDto.getName());
            list.add(messageDto.getMoney());
            list.add(messageDto.getContent());
            listList.add(list);
        }
        resultMap.setData(listList);
        /*messageService.addMessage(message);*/
        return resultMap;
    }

}
