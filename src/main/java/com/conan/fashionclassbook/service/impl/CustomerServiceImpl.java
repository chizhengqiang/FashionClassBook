package com.conan.fashionclassbook.service.impl;

import com.conan.fashionclassbook.commons.Constants;
import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.dao.CustomerMapper;
import com.conan.fashionclassbook.exception.FCBException;
import com.conan.fashionclassbook.pojo.Customer;
import com.conan.fashionclassbook.service.ICustomerService;
import com.conan.fashionclassbook.utils.MD5Util;
import com.conan.fashionclassbook.utils.UUIDUtil;
import com.conan.fashionclassbook.vo.req.CustomerReq;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public ServerResponse<String> insertCustomer(CustomerReq customerReq) throws FCBException {
        return null;
    }

    /**
     * 登陆
     *
     * @param nickname
     * @param password
     * @return token
     * @throws FCBException
     */
    @Override
    public ServerResponse<String> login(String nickname, String password) throws FCBException {
        int resultCount = customerMapper.getCountByNickname(nickname);
        if (resultCount <= 0) {
            throw new FCBException(Constants.ErrorMsg.Customer.NICKNAME_CANNOT_BE_EXIST);
        }
        //盐
        String uuid = customerMapper.getUUIDByNickName(nickname);
        String md5Password = MD5Util.MD5EncodeUtf8(uuid, password);
        Customer customer = customerMapper.findByNicknameAndPassword(nickname, md5Password);
        if (customer == null) {
            throw new FCBException(Constants.ErrorMsg.Customer.NICKNAME_PASSWORD_CANNOT_BE_ERROR);
        }
        String token = UUIDUtil.getUUID32();
        customer.setPassword(StringUtils.EMPTY);
        redisTemplate.opsForValue().set(token, customer, 1, TimeUnit.HOURS);
        return ServerResponse.createBySuccess("登陆成功", token);
    }

    /**
     * 注册
     *
     * @param req
     * @return
     * @throws FCBException
     */
    @Override
    public ServerResponse<String> register(CustomerReq req) throws FCBException {
        req.validate(false);
        Customer customer = req.createCustomer();
        int resultCount = customerMapper.insertSelective(customer);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage(Constants.InsertStatusMsg.SUCCESS);
        }
        return ServerResponse.createBySuccessMessage(Constants.InsertStatusMsg.FAIR);
    }
}
