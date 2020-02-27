package com.conan.fashionclassbook.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class TypeEnum {

    @Getter
    @AllArgsConstructor
    public enum softwareType {
        APP_SOFTWARE_TYPE(0, "小程序、APP"),
        WEB_SOFTWARE_TYPE(1, "web");

        private int code;
        private String desc;
    }
}
