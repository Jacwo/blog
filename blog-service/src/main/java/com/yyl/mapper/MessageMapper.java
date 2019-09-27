package com.yyl.mapper;

import com.yyl.model.MessageDto;
import com.yyl.model.MoneyDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * author:yangyuanliang Date:2019-09-27 Time:13:38
 *  * {"email":"1@qq.com","name":"","phone":"","content":"12123"}
 **/
public interface MessageMapper {
    @Insert("insert into message(email,name,phone,content) values(#{email},#{name},#{phone},#{content})")
    void addMessage(MessageDto message);
    @Select("select * from money")
    List<MoneyDto> getMoneyList();
}
