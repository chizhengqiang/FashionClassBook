package com.conan.fashionclassbook.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 模版
 */
@Data
public class TemplateBook implements Serializable {

    private Long id; //主键
    private String name; //名称
    private String title; //标题
    private String image;// 图片地址
    private BigDecimal price; //价格
    private Integer status;// 状态 0 正常， 9:删除
    private Date createTime; //创建时间
    private Date lastTime; //最后一次修改时间
}
