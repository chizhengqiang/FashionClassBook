package com.conan.fashionclassbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.conan.fashionclassbook.dao")
public class FashionClassBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(FashionClassBookApplication.class, args);
    }

}
