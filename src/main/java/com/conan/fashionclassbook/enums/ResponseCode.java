package com.conan.fashionclassbook.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by czq on 2017/10/18.
 */
@Getter
@AllArgsConstructor
public enum ResponseCode {

    SUCCESS(0, "SUCCESS"),
    ERROR(1, "ERROR");

    private final int code;
    private final String desc;
}
