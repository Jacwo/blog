package com.yyl.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * author:yangyuanliang Date:2019-10-18 Time:10:42
 **/
@Setter
@Getter
public class Project implements Serializable {
    private Integer _id;
    private String title;
    private String url;
    private String img;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date start_time;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date end_time;
}
