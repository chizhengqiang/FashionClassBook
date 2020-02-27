package com.conan.fashionclassbook.service;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.pojo.User;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface UserService {

    /**
     * 登陆
     *
     * @param nickname
     * @param password
     * @return
     */
    ServerResponse<User> login(String nickname, String password);

    /**
     * 注册
     * @param User
     * @return
     */
    ServerResponse<String> register(User User);

    ServerResponse<PageInfo<User>> findPage(Integer page, Integer size);

    ServerResponse<List<User>> findAll();

    ServerResponse<User> getById(Integer id);

    ServerResponse<String> update(User user);

    ServerResponse<String> deleteOne(Integer id);

    ServerResponse<String> insert(User user);
}
