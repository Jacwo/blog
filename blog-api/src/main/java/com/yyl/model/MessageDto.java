package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * author:yangyuanliang Date:2019-09-27 Time:13:31
 * {"email":"1@qq.com","name":"","phone":"","content":"12123"}
 **/
@Setter
@Getter
public class MessageDto implements Serializable {
    private String email;
    private String name;
    private String phone;
    private String content;
}
