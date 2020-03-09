package com.conan.fashionclassbook.web;

import com.conan.fashionclassbook.commons.Constants;
import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.pojo.Customer;
import com.conan.fashionclassbook.service.ICustomerService;
import com.conan.fashionclassbook.vo.req.CustomerReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Api(tags = "LoginController-登陆相关接口", description = "提供用户登录相关的 Rest API")
public class LoginController {

    @Autowired
    ICustomerService customerService;
//    @Autowired
//    RedisTemplate redisTemplate;

    /**
     * 用户登陆
     *
     * @param nickname
     * @param password
     * @return
     */
    @GetMapping("/login")
    @ApiOperation("用户登陆接口")
    public ServerResponse<Customer> login(@RequestParam(value = "nickname") String nickname,
                                          @RequestParam(value = "password") String password) {
        ServerResponse<Customer> response = customerService.login(nickname, password);
        return response;
    }

    /**
     * 注册
     *
     * @param req
     * @return
     */
    @ApiOperation("用户注册接口")
    @PostMapping("/register")
    public ServerResponse<String> register(@RequestBody CustomerReq req) {
        ServerResponse<String> response = customerService.register(req);
        return response;
    }

    /**
     * 退出
     *
     * @param token
     * @return
     */
    @GetMapping("/logout")
    @ApiOperation("用户退出接口")
    public ServerResponse<String> logout(String token) {
        //清除token
//        redisTemplate.delete(token);
        return ServerResponse.createBySuccessMessage(Constants.SuccessMsg.LOGOUT_SUCCESS);
    }
}
