package com.yyl.dao.impl;

import com.yyl.dao.MessageDao;
import com.yyl.mapper.MessageMapper;
import com.yyl.model.MessageDto;
import com.yyl.model.MoneyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author:yangyuanliang Date:2019-09-27 Time:13:36
 *
 * @author yangyuanliang*/
@Repository
public class MessageImpl implements MessageDao {
    @Autowired
    private MessageMapper messageMapper;
    @Override
    public void addMessage(MessageDto message) {
        messageMapper.addMessage(message);
    }

    @Override
    public List<MoneyDto> getMoneyList() {
        return messageMapper.getMoneyList();
    }
}
