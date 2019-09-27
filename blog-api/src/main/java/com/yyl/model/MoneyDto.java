package com.yyl.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

/**
 * author:yangyuanliang Date:2019-09-27 Time:15:40
 **/
@Setter
@Getter
public class MoneyDto implements Serializable {
    private Integer id;
    private String name;
    private String money;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
}

