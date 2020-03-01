package com.conan.fashionclassbook.vo.resp;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerResp {

    private Integer id;
    private String nickname;
    private String username;
    private String password;
    private String telephone;
    private String uuid;
    private String headImg;
    private String email;
    private String school;
    private String clazz;
    private String signature;
    private String description;
    private Integer type;
    private Integer status;
    private Date createTime;
    private Date lastTime;
}
