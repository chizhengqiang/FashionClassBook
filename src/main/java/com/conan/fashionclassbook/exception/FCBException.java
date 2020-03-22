package com.conan.fashionclassbook.exception;

import lombok.Getter;

@Getter
public class FCBException extends RuntimeException {

    public FCBException(String message) {
        super(message);
    }

}
