package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Meta implements Serializable {
    private Integer likes;
    private Integer views;
    private Integer comments;
    private Integer articleId;
}
