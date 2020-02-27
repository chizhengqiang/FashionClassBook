package com.conan.fashionclassbook.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleEnum {
    NORMAL_ROLE(0, "普通用户"),
    DELETED_ROLE(1, "超级管理员");

    private int code;
    private String desc;
}
