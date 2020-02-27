package com.conan.fashionclassbook.dao;

import com.conan.fashionclassbook.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findByNicknameAndPassword(@Param("nickname") String nickname, @Param("password") String md5Password);

    String getUUIDByNickName(String nickname);

    List<User> findAll();

    int changeStatusById(@Param("status") Integer status, @Param("id") Integer id);

    User getById(Integer id);

    int getCountByNickname(String nickname);

    int getCountByTelephone(String telephone);

    int getCountByExistNickname(@Param("nickname") String nickname, @Param("id") Integer id);

    int getCountByExistTelephone(@Param("telephone") String telephone, @Param("id") Integer id);

}