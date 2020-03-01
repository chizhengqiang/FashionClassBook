package com.conan.fashionclassbook.web;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.exception.FCBException;
import com.conan.fashionclassbook.service.ICustomerService;
import com.conan.fashionclassbook.vo.req.CustomerReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/customers")
    public ServerResponse<String> addCustomer(@RequestBody CustomerReq customerReq)
            throws FCBException {
        ServerResponse<String> response = customerService.insertCustomer(customerReq);
        return response;
    }
}
