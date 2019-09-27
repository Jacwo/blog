package com.yyl.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.yyl.api.MessageService;
import com.yyl.dao.MessageDao;
import com.yyl.model.MessageDto;
import com.yyl.model.MoneyDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * author:yangyuanliang Date:2019-09-27 Time:13:35
 **/
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;
    @Override
    public void addMessage(MessageDto message) {
        messageDao.addMessage(message);
    }

    @Override
    public List<MoneyDto> getMoneyList() {
        return messageDao.getMoneyList();
    }
}
