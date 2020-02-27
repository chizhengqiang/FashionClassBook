package com.conan.fashionclassbook.utils;

import java.util.UUID;

/**
 * UUID
 */
public class UUIDUtil {

    /**
     *
     * @return
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    /**
     * 获取 32位 UUID
     *
     * @return
     */
    public static String getUUID32() {
        String uuid = getUUID().replaceAll("-", "");
        return uuid;
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
        System.out.println(getUUID32());
    }

}
