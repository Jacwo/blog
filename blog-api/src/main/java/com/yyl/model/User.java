package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable {
    private Integer _id;
    private String name;
    private String password;
    private String email;
    private String avatar;

}
