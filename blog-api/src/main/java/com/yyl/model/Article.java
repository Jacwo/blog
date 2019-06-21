package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class Article  implements Serializable {
    private Integer _id;
    private String title;
    private Meta meta;
    private List<String> tags;
    private String desc;
    private String img_url;
    private Date create_time;
}
