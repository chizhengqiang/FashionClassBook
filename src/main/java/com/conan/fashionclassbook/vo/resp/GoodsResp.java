package com.conan.fashionclassbook.vo.resp;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GoodsResp {

    private Long id;
    private String title;
    private String coverImg;
    private BigDecimal price;
    private Double discount; //折扣，例如9.5折
    private String desc;//介绍
    private Boolean flag;//是否打折
    private Integer status;
    private Date createTime;
    private Date lastTime;
}
