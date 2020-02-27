package com.conan.fashionclassbook.service.impl;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.enums.RoleEnum;
import com.conan.fashionclassbook.enums.StatusEnum;
import com.conan.fashionclassbook.dao.UserMapper;
import com.conan.fashionclassbook.pojo.User;
import com.conan.fashionclassbook.service.UserService;
import com.conan.fashionclassbook.utils.MD5Util;
import com.conan.fashionclassbook.utils.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 登陆
     *
     * @param nickname
     * @param password
     * @return
     */
    @Override
    public ServerResponse<User> login(String nickname, String password) {
        int resultCount = userMapper.getCountByNickname(nickname);
        if (resultCount <= 0) {
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        //盐
        String uuid = userMapper.getUUIDByNickName(nickname);
        String md5Password = MD5Util.MD5EncodeUtf8(uuid, password);
        User user = userMapper.findByNicknameAndPassword(nickname, md5Password);
        if (user == null) {
            return ServerResponse.createByErrorMessage("用户或密码错误");
        }
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登陆成功",user);
    }

    /**
     * 注册
     *
     * @param User
     * @return
     */
    @Override
    public ServerResponse<String> register(User User) {
        String uuid = UUIDUtil.getUUID32().toUpperCase();
        User.setUuid(uuid);
        String md5Password = MD5Util.MD5EncodeUtf8(uuid, User.getPassword());
        User.setPassword(md5Password);
        User.setStatus(StatusEnum.NORMAL_STATUS.getCode());
        User.setType(RoleEnum.NORMAL_ROLE.getCode());
        int resultCount = userMapper.insert(User);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("添加成功");
        }
        return ServerResponse.createByErrorMessage("添加失败");
    }

    /**
     * 分页列表查询
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public ServerResponse<PageInfo<User>> findPage(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<User> userList = userMapper.findAll();
        //TODO 上千上万条数据的时候会慢
        userList.stream().forEach(x -> x.setPassword(StringUtils.EMPTY));
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public ServerResponse<List<User>> findAll() {
        List<User> userList = userMapper.findAll();
        //TODO 上千上万条数据的时候会慢
        userList.stream().forEach(x -> x.setPassword(StringUtils.EMPTY));
        return ServerResponse.createBySuccess(userList);
    }

    /**
     * 获取一个对象
     *
     * @param id
     * @return
     */
    @Override
    public ServerResponse<User> getById(Integer id) {
        User user = userMapper.getById(id);
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess(user);
    }

    /**
     * 修改
     *
     * @param user
     * @return
     */
    @Override
    public ServerResponse<String> update(User user) {
        int resultCount = userMapper.getCountByExistNickname(user.getNickname(), user.getId());
        if (resultCount > 0) {
            return ServerResponse.createByErrorMessage("用户名已存在");
        }
        resultCount = userMapper.getCountByExistTelephone(user.getTelephone(), user.getId());
        if (resultCount > 0) {
            return ServerResponse.createByErrorMessage("手机号已存在");
        }
        String uuid = UUIDUtil.getUUID32().toUpperCase();
        user.setUuid(uuid);
        String md5Password = MD5Util.MD5EncodeUtf8(uuid, user.getPassword());
        user.setPassword(md5Password);
        resultCount = userMapper.updateByPrimaryKeySelective(user);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("修改成功");
        }
        return ServerResponse.createByErrorMessage("修改失败");
    }

    /**
     * 删除一个
     *
     * @param id
     * @return
     */
    @Override
    public ServerResponse<String> deleteOne(Integer id) {
        User user = userMapper.getById(id);
        if (user == null) {
            return ServerResponse.createBySuccessMessage("用户不存在");
        }
        int resultCount = userMapper.changeStatusById(StatusEnum.DELETE_STATUS.getCode(), id);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }

    /**
     * 添加
     *
     * @param user
     * @return
     */
    @Override
    public ServerResponse<String> insert(User user) {
        int resultCount = userMapper.getCountByNickname(user.getNickname());
        if (resultCount > 0) {
            return ServerResponse.createByErrorMessage("用户名已存在");
        }
        resultCount = userMapper.getCountByTelephone(user.getTelephone());
        if (resultCount > 0) {
            return ServerResponse.createByErrorMessage("手机号已存在");
        }
        String uuid = UUIDUtil.getUUID32().toUpperCase();
        String password = MD5Util.MD5EncodeUtf8(uuid, user.getPassword());
        user.setPassword(password);
        user.setUuid(uuid);
        resultCount = userMapper.insertSelective(user);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("添加成功");
        }
        return ServerResponse.createByErrorMessage("添加失败");
    }


}
