package com.conan.fashionclassbook.web;

import com.conan.fashionclassbook.commons.Const;
import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.pojo.User;
import com.conan.fashionclassbook.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
@Api(tags = "LoginController-登陆相关接口", description = "提供用户登录相关的 Rest API")
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * 用户登陆
     *
     * @param nickname
     * @param password
     * @return
     */
    @GetMapping("/login")
    @ApiOperation("用户登陆接口")
    public ServerResponse<User> login(@RequestParam(value = "nickname") String nickname,
                                      @RequestParam(value = "password") String password,
                                      HttpSession session) {
        ServerResponse<User> response = userService.login(nickname, password);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @ApiOperation("用户注册接口")
    @PostMapping("/register")
    public ServerResponse<String> register(@RequestBody User user) {
        ServerResponse<String> response = userService.register(user);
        return response;
    }

    /**
     * 退出
     *
     * @param session
     * @return
     */
    @GetMapping("/logout")
    @ApiOperation("用户退出接口")
    public ServerResponse<String> logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccessMessage("退出成功");
    }
}
