package com.conan.fashionclassbook.service;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.exception.FCBException;
import com.conan.fashionclassbook.vo.req.CustomerReq;

public interface ICustomerService {

    ServerResponse<String> insertCustomer(CustomerReq customerReq) throws FCBException;

    ServerResponse<String> login(String nickname, String password) throws FCBException;

    ServerResponse<String> register(CustomerReq req) throws FCBException;
}
