package com.conan.fashionclassbook.service;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.exception.FCBException;
import com.conan.fashionclassbook.vo.req.BookUserInfoReq;
import com.conan.fashionclassbook.vo.resp.BookUserInfoResp;

public interface IBookUserInfoService {

    ServerResponse<BookUserInfoResp> findAll(BookUserInfoReq req);

    ServerResponse<String> insert(BookUserInfoReq req) throws FCBException;
}
