package com.conan.fashionclassbook.pojo;

import com.conan.fashionclassbook.enums.StatusEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel("轮播图实体类")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Banner implements Serializable {

    @ApiModelProperty("主键Id")
    private Long id;

    @ApiModelProperty("名称")
    private String title; //标题

    @ApiModelProperty("图片地址")
    private String url; //地址

    @ApiModelProperty("图片说明")
    private String desc;//图片说明

    @ApiModelProperty("类型 0,小程序, app，1，web")
    private Integer type; //类型 0,小程序, app，1，web

    @ApiModelProperty("状态 0 正常 9 删除")
    private Integer status;// 状态 0 正常 9 删除

    @ApiModelProperty("创建时间")
    private Date createTime;// 创建时间

    @ApiModelProperty("最后一次更新时间")
    private Date lastTime; // 最后一次更新时间
}
