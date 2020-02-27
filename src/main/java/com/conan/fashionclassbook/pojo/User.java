package com.conan.fashionclassbook.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import java.util.Date;

@Data
@ApiModel("用户实体类")
@ToString
public class User {

    private Integer id;
    private String nickname;
    private String username;
    private String password;
    private String telephone;
    private String uuid;
    private String headImg;
    private String weChat;
    private String weibo;
    private String qq;
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