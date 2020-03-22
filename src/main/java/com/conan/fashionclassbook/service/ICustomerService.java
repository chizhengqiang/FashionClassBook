package com.conan.fashionclassbook.service;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.pojo.Customer;
import com.conan.fashionclassbook.vo.req.CustomerReq;
import com.conan.fashionclassbook.vo.resp.CustomerResp;

import java.util.List;

public interface ICustomerService {

    ServerResponse<Customer> login(String nickname, String password);

    ServerResponse<String> register(CustomerReq req);

    ServerResponse<CustomerResp> getById(Long id);

    ServerResponse<String> deleteById(Long id);

    ServerResponse<CustomerResp> findPage(CustomerResp customerResp, Integer page, Integer size);

    ServerResponse<List<CustomerResp>> findAll(CustomerResp customerResp);
}
