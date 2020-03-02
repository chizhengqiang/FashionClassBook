package com.conan.fashionclassbook.dao;

import com.conan.fashionclassbook.pojo.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {

    int insertSelective(Customer record);

    int updateByPrimaryKeySelective(Customer record);

    Customer findByNicknameAndPassword(@Param("nickname") String nickname, @Param("password") String md5Password);

    String getUUIDByNickName(String nickname);

    List<Customer> findAll();

    int changeStatusById(@Param("status") Integer status, @Param("id") Long id);

    Customer getById(Long id);

    int getCountByNickname(String nickname);
}
