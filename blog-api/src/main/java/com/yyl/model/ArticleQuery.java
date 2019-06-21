package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ArticleQuery extends BaseQuery implements Serializable {
    private String keyword;
    private String likes;
    private Integer tag_id;
    private Integer category_id;
    private  Integer state;
}
