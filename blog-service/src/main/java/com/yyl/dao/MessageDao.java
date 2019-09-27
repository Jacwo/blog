package com.yyl.dao;

import com.yyl.model.MessageDto;
import com.yyl.model.MoneyDto;

import java.util.List;

/**
 * author:yangyuanliang Date:2019-09-27 Time:13:36
 **/
public interface MessageDao {

    void addMessage(MessageDto message);

    List<MoneyDto> getMoneyList();
}
