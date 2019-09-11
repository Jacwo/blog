package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class Category implements Serializable {
    private String desc;
    private Integer _id;
    private String name;
    private Date create_time;
    private Date update_time;
}
