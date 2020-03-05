package com.conan.fashionclassbook.service;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.vo.req.CustomerReq;
import com.conan.fashionclassbook.vo.resp.CustomerResp;

public interface ICustomerService {

    ServerResponse<String> login(String nickname, String password);

    ServerResponse<String> register(CustomerReq req);

    ServerResponse<CustomerResp> getById(Long id);

    ServerResponse<String> deleteById(Long id);
}
