package com.conan.fashionclassbook.web;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.service.IBookUserInfoService;
import com.conan.fashionclassbook.vo.req.BookUserInfoReq;
import com.conan.fashionclassbook.vo.resp.BookUserInfoResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookUserInfoController {

    @Autowired
    IBookUserInfoService bookUserInfoService;

    @GetMapping("/bookUserInfos")
    public ServerResponse<BookUserInfoResp> findAll(BookUserInfoReq req) {

        ServerResponse<BookUserInfoResp> response = bookUserInfoService.findAll(req);
        return response;
    }

    @PostMapping("/bookUserInfos")
    public ServerResponse<String> insert(BookUserInfoReq req) {
        ServerResponse<String> response = bookUserInfoService.insert(req);
        return response;
    }
}
