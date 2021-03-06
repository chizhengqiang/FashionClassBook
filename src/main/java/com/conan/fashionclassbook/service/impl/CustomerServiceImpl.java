package com.conan.fashionclassbook.service.impl;

import com.conan.fashionclassbook.commons.Constants;
import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.dao.CustomerMapper;
import com.conan.fashionclassbook.enums.StatusEnum;
import com.conan.fashionclassbook.pojo.Customer;
import com.conan.fashionclassbook.service.ICustomerService;
import com.conan.fashionclassbook.utils.MD5Util;
import com.conan.fashionclassbook.utils.UUIDUtil;
import com.conan.fashionclassbook.vo.req.CustomerReq;
import com.conan.fashionclassbook.vo.resp.CustomerResp;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;

//    @Autowired
//    private RedisTemplate redisTemplate;

    /**
     * 登陆
     *
     * @param nickname
     * @param password
     * @return token
     * @
     */
    @Override
    public ServerResponse<Customer> login(String nickname, String password) {
        int resultCount = customerMapper.getCountByNickname(nickname);
        if (resultCount <= 0) {
            return ServerResponse.createByErrorMessage(Constants.ErrorMsg.Customer.NICKNAME_CANNOT_BE_EXIST);
        }
        //盐
        String uuid = customerMapper.getUUIDByNickName(nickname);
        String md5Password = MD5Util.MD5EncodeUtf8(uuid, password);
        Customer customer = customerMapper.findByNicknameAndPassword(nickname, md5Password);
        if (customer == null) {
            return ServerResponse.createByErrorMessage(Constants.ErrorMsg.Customer.NICKNAME_PASSWORD_CANNOT_BE_ERROR);
        }
        String token = UUIDUtil.getUUID32();
        customer.setPassword(StringUtils.EMPTY);
//        redisTemplate.opsForValue().set(token, customer, 1, TimeUnit.HOURS);
        return ServerResponse.createBySuccess(Constants.SuccessMsg.LOGIN_SUCCESS, customer);
    }

    /**
     * 注册
     *
     * @param req
     * @return
     * @
     */
    @Override
    @Transactional
    public ServerResponse<String> register(CustomerReq req) {
        String errorMsg = req.validate(false);
        if (errorMsg != null) {
            return ServerResponse.createByErrorMessage(errorMsg);
        }
        Customer customer = req.createCustomer();
        int resultCount = customerMapper.insertSelective(customer);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage(Constants.CommonsMsg.InsertStatusMsg.SUCCESS);
        }
        return ServerResponse.createBySuccessMessage(Constants.CommonsMsg.InsertStatusMsg.FAIR);
    }

    /**
     * 获取
     *
     * @param id
     * @return
     * @
     */
    @Override
    public ServerResponse<CustomerResp> getById(Long id) {
        Customer customer = customerMapper.getById(id);
        if (customer == null) {
            return ServerResponse.createByErrorMessage(Constants.ErrorMsg.Customer.NICKNAME_CANNOT_BE_EXIST);
        }
        CustomerResp customerResp = new CustomerResp();
        BeanUtils.copyProperties(customer, customerResp);
        return ServerResponse.createBySuccess(customerResp);
    }

    @Override
    @Transactional
    public ServerResponse<String> deleteById(Long id) {
        Customer customer = customerMapper.getById(id);
        if (customer == null) {
            return ServerResponse.createByErrorMessage(Constants.ErrorMsg.Customer.NICKNAME_CANNOT_BE_EXIST);
        }
        int resultCount = customerMapper.changeStatusById(StatusEnum.DELETE_STATUS.getCode(), id);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage(Constants.CommonsMsg.DeleteStatusMsg.SUCCESS);
        }
        return ServerResponse.createByErrorMessage(Constants.CommonsMsg.DeleteStatusMsg.FAIR);
    }

    @Override
    public ServerResponse<CustomerResp> findPage(CustomerResp customerResp, Integer page, Integer size) {
        return null;
    }

    @Override
    public ServerResponse<List<CustomerResp>> findAll(CustomerResp customerResp) {
        List<CustomerResp> customerRespList = Lists.newArrayList();
        List<Customer> customerList = customerMapper.findAll();
        customerList.stream().forEach(customer -> {
            CustomerResp resp = new CustomerResp();
            BeanUtils.copyProperties(customer, resp);
            customerRespList.add(resp);
        });
        return ServerResponse.createBySuccess(customerRespList);
    }
}
