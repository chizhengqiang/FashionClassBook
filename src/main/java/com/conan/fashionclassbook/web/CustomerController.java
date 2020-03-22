package com.conan.fashionclassbook.web;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.service.ICustomerService;
import com.conan.fashionclassbook.vo.req.CustomerReq;
import com.conan.fashionclassbook.vo.resp.CustomerResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@CrossOrigin
@RestController
@Api(tags = "CustomerController-用户相关接口", description = "提供用户相关的 Rest API")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/customers/{page}/{size}")
    public ServerResponse<CustomerResp> findPage(@RequestParam("customerResp") CustomerResp customerResp,
                                                @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        ServerResponse<CustomerResp> response = customerService.findPage(customerResp, page, size);
        return response;
    }

    @GetMapping("/customers")
    public ServerResponse<List<CustomerResp>> findAll(CustomerResp customerResp) {
        ServerResponse<List<CustomerResp>> response = customerService.findAll(customerResp);
        return response;
    }

    @GetMapping("/customers/{id}")
    @ApiOperation("获取一个用户")
    public ServerResponse<CustomerResp> getById(@PathVariable @NotNull Long id) {
        ServerResponse<CustomerResp> response = customerService.getById(id);
        return response;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/customers/{id}")
    @ApiOperation("删除一个用户")
    public ServerResponse<String> deleteById(@PathVariable @NotNull Long id) {
        ServerResponse<String> response = customerService.deleteById(id);
        return response;
    }
}
