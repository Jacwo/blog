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
import java.util.Stack;

@Controller
@RequestMapping("/api/message")
public class MessageController {

    @Reference
    private MessageService messageService;

    @RequestMapping(value = "/addMessage", method = RequestMethod.POST)
    @ResponseBody
    public ResultMap addMessage(@RequestBody MessageDto message) {
        ResultMap resultMap = new ResultMap();
        messageService.addMessage(message);
        return resultMap;
    }

    /**
     * [
     * ['用户名', '金额', '留言'],
     * ['row 1; column 1', 'row 1; column 2', 'row 1; column 3']
     * <p>
     * ]
     *
     * @return
     */
    @RequestMapping(value = "/getMoneyList", method = RequestMethod.POST)
    @ResponseBody
    public ResultMap getMoneyList() {
        ResultMap resultMap = new ResultMap();
        List<List<String>> listList = new ArrayList<>();

        List<MoneyDto> moneylist = messageService.getMoneyList();
        for (MoneyDto messageDto : moneylist) {
            List<String> list = new ArrayList<>();
            list.add(messageDto.getName());
            list.add(messageDto.getMoney());
            list.add(messageDto.getContent());
            listList.add(list);
        }
        resultMap.setData(listList);
        /*messageService.addMessage(message);*/
        return resultMap;
    }
    public static String decodeString(String s) {
        StringBuilder sb=new StringBuilder();
        Stack<String> stack=new Stack();
        StringBuilder sb2 = null;
        for(int i=0;i<s.length();i++){
            if('['==s.charAt(i)){
                stack.push(sb.toString());
                sb=new StringBuilder();
            }else if(']'==s.charAt(i)){
                StringBuilder tmp=new StringBuilder();
                for(int j=0;j< Integer.valueOf(sb2.toString());j++){
                    tmp.append(sb);
                }
                sb=new StringBuilder(stack.isEmpty()?"":stack.pop()+tmp);

            }else if(Character.isDigit(s.charAt(i))){
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(s.charAt(i));
                if (Character.isDigit(s.charAt(i + 1))) {
                    continue;
                }
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public static String convert(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = null;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                stringBuilder.append(s.charAt(i));
            } else {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(s.charAt(i));
                if (Character.isDigit(s.charAt(i + 1))) {
                    continue;
                }
            }
            if (sb != null) {
                for (int j = 0; j < Integer.valueOf(sb.toString()) - 1; j++) {
                    stringBuilder.append(s.charAt(i + 1));
                }
            }
            sb = null;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }
}
