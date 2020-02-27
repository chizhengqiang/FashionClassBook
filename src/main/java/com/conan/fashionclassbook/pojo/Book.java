package com.conan.fashionclassbook.pojo;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
public class Book {

    private Long id;
    private Long userId; //用户Id
    private String name;//名称
    private String title; //标题
    private String image; //图片
    private BigDecimal price;//价格
    private String desc; //说明
    private Integer status; //状态 0正常， 9 删除
    private Date createTime; //创建时间
    private Date lastTime; //最后一次更新时间
}
