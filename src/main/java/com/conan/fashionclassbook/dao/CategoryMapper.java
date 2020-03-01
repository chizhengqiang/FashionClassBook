package com.conan.fashionclassbook.dao;

import com.conan.fashionclassbook.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {

    List<Category> findAll();

    Category getById(Long id);

    int insertSelective(Category record);

    int updateByPrimaryKeySelective(Category record);

    int changeStatusById(@Param("status") Integer status, @Param("id") Long id);
}
