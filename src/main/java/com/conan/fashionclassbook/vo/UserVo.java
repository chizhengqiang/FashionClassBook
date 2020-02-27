package com.conan.fashionclassbook.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "user")
public class UserVo {

    @Id
    @Column(name = "id")
    private Long id;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("昵称")
    private String nickname;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("手机号")
    private String telephone; //手机号
    @ApiModelProperty("QQ")
    private String QQ; //QQ
    @ApiModelProperty("email")
    private String email; //email
    @ApiModelProperty("微信")
    private String wechat; //微信
    @ApiModelProperty("微博")
    private String weibo; //微博
    @ApiModelProperty("毕业学校")
    private String school;// 毕业学校
    @ApiModelProperty("所在班级")
    private String clazz; //毕业班级
    @ApiModelProperty("个人签名")
    private String signature;//个人签名
    @ApiModelProperty("简介")
    private String description;//简介
    @ApiModelProperty("类型 默认0 普通用户 1 :超级管理员")
    private String type; //类型 默认0 普通用户 1 :超级管理员
    @ApiModelProperty("状态 0:正常 9 删除")
    private String status ;// 状态
    @ApiModelProperty("创建时间")
    private Date createTime ;// 创建时间
    @ApiModelProperty("最后一次更新时间")
    private Date lastTime; // 最后一次更新时间
}
