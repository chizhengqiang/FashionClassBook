package com.conan.fashionclassbook.vo.resp;

import lombok.Data;

import java.util.Date;

@Data
public class BannerResp {

    private Long id;
    private String name;
    private String url;
    private String desc;
    private Integer status;
    private Integer type;
    private Date createTime;
    private Date lastTime;
}
