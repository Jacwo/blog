package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;

}
