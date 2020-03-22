package com.conan.fashionclassbook.dao;

import com.conan.fashionclassbook.pojo.BookUserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface BookUserInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(BookUserInfo record);

    int insertSelective(BookUserInfo record);

    BookUserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookUserInfo record);

    int updateByPrimaryKey(BookUserInfo record);
}