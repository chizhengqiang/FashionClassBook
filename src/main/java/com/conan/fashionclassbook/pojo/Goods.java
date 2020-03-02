package com.conan.fashionclassbook.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Goods implements Serializable {

    private Long id;
    private String name;
    private String coverImg;
    private Long categoryId;
    private BigDecimal price;
    private Double discount; //折扣，例如9.5折
    private String desc;//介绍
    private Boolean flag;//是否打折
    private Integer status;
    private Date createTime;
    private Date lastTime;
}
