package com.conan.fashionclassbook.web;

import com.conan.fashionclassbook.commons.ServerResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/index")
    public ServerResponse index() {
        return ServerResponse.createBySuccess();
    }
}
