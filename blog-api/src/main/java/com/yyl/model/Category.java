package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Category {
    private String desc;
    private String _id;
    private String name;
    private Date create_time;
    private Date update_time;
}
