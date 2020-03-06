package com.conan.fashionclassbook.vo.req;

import com.conan.fashionclassbook.commons.Constants;
import com.conan.fashionclassbook.enums.StatusEnum;
import com.conan.fashionclassbook.pojo.Customer;
import com.conan.fashionclassbook.utils.MD5Util;
import com.conan.fashionclassbook.utils.UUIDUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

@Data
public class CustomerReq {

    private Integer id;
    private String nickname;
    private String username;
    private String password;
    private String gender;
    private String telephone;
    private String uuid;
    private String headImg;
    private String email;
    private String school;
    private String clazz;
    private String signature;
    private String description;
    private Integer type;
    private Integer status;
    private Date createTime;
    private Date lastTime;

    public String validate(boolean isExit) {
        if (isExit && id == null) {
            return Constants.ErrorMsg.Customer.ID_CANNOT_BE_EMPTY;
        }
        if (!isExit && StringUtils.isBlank(nickname)) {
            return Constants.ErrorMsg.Customer.NICKNAME_CANNOT_BE_EMPTY;
        }
        if (!isExit && StringUtils.isBlank(password)) {
            return Constants.ErrorMsg.Customer.PASSWORD_CANNOT_BE_EMPTY;
        }
        if (!isExit && type == null) {
            return Constants.ErrorMsg.Customer.TYPE_CANNOT_BE_EMPTY;
        }
        return null;
    }

    public Customer createCustomer() {
        Customer customer = new Customer();
        return insertOrEditCustomer(customer);
    }

    public Customer updateCustomer() {
        Customer customer = new Customer();
        customer.setId(id);
        return insertOrEditCustomer(customer);
    }

    /**
     * @param customer
     * @return
     */
    public Customer insertOrEditCustomer(Customer customer) {
        customer.setNickname(nickname);
        customer.setUsername(username);
        String uuid = UUIDUtil.getUUID32();
        customer.setUuid(uuid);
        customer.setPassword(MD5Util.MD5EncodeUtf8(uuid, password));
        customer.setHeadImg(headImg);
        customer.setTelephone(telephone);
        customer.setEmail(email);
        customer.setSchool(school);
        customer.setClazz(clazz);
        customer.setSignature(signature);
        customer.setDescription(description);
        customer.setType(type);
        customer.setStatus(StatusEnum.NORMAL_STATUS.getCode());
        return customer;
    }
}
