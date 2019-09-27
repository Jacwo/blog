package com.yyl.api;

import com.yyl.model.MessageDto;
import com.yyl.model.MoneyDto;

import java.util.List;

/**
 * author:yangyuanliang Date:2019-09-27 Time:13:34
 **/
public interface MessageService {
    void addMessage(MessageDto message);

    List<MoneyDto> getMoneyList();
}
