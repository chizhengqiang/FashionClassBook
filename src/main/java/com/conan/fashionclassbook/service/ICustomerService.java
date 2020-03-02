package com.conan.fashionclassbook.service;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.exception.FCBException;
import com.conan.fashionclassbook.vo.req.CustomerReq;
import com.conan.fashionclassbook.vo.resp.CustomerResp;

public interface ICustomerService {

    ServerResponse<String> login(String nickname, String password) throws FCBException;

    ServerResponse<String> register(CustomerReq req) throws FCBException;

    ServerResponse<CustomerResp> getById(Long id) throws FCBException;

    ServerResponse<String> deleteById(Long id) throws FCBException;
}
