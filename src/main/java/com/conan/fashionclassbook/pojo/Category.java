package com.conan.fashionclassbook.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Category implements Serializable {
    private Long id;
    private String name;
    private Long parentId;
    private Integer status;
    private Date createTime;
    private Date lastTime;
}
