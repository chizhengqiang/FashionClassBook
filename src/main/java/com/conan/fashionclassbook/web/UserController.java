package com.conan.fashionclassbook.web;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.pojo.User;
import com.conan.fashionclassbook.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Api(tags = "UserController-用户相关接口", description = "提供用户相关的 Rest API")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 分页
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/users/{page}/{size}")
    @ApiOperation("分页列表查询")
    public ServerResponse<PageInfo<User>> findPage(@PathVariable(value = "page") Integer page, @PathVariable(value = "size") Integer size) {
        ServerResponse<PageInfo<User>> response = userService.findPage(page, size);
        return response;
    }

    /**
     *
     * @return
     */
    @GetMapping("/users")
    @ApiOperation("用户列表")
    public ServerResponse<List<User>> findAll() {
        ServerResponse<List<User>> response = userService.findAll();
        return response;
    }

    /**
     * 根据Id 获取对象
     *
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    @ApiOperation("根据id获取用户信息接口")
    public ServerResponse<User> findById(@PathVariable("id") Integer id) {
        ServerResponse<User> response = userService.getById(id);
        return response;
    }

    @PostMapping("/users")
    @ApiOperation("增加用户信息接口")
    public ServerResponse<String> insert(@RequestBody User user) {
        ServerResponse<String> response = userService.insert(user);
        return response;
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @PutMapping("/users")
    @ApiOperation("修改用户信息接口")
    public ServerResponse<String> update(@RequestBody User user) {
        ServerResponse<String> response = userService.update(user);
        return response;
    }

    /**
     * 删除用户信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/users/{id}")
    @ApiOperation("删除用户信息接口")
    public ServerResponse<String> delete(@PathVariable("id") Integer id) {
        ServerResponse<String> response = userService.deleteOne(id);
        return response;
    }
}
