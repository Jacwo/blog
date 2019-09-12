package com.yyl.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * author:yangyuanliang Date:2019-09-12 Time:11:14
 **/
@Getter
@Setter
public class TimeLine implements Serializable {
    private String _id;
    private Integer state;
    private String title;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
}
