package com.conan.fashionclassbook.web;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.service.UserBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Service;

@CrossOrigin
@RestController
@Api(tags = "UserBookController-用户纪念册相关接口", description = "提供用户纪念册相关的 Rest API")
public class UserBookController {

    @Autowired
    UserBookService userBookService;

    @GetMapping("/userBooks")
    @ApiOperation("用户纪念册列表查询")
    public ServerResponse findAll() {
        return ServerResponse.createBySuccess();
    }
}
