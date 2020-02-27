package com.conan.fashionclassbook.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {

    NORMAL_STATUS(0, "正常"),
    DELETE_STATUS(9 , "删除")
    ;
    private int code;
    private String desc;

}
