package com.conan.fashionclassbook.dao;

import com.conan.fashionclassbook.pojo.TemplateBook;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemplateBookMapper {


    List<TemplateBook> findAll();

    int insertSelective(TemplateBook record);

    TemplateBook getById(Integer id);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TemplateBook record);

    int changeStatusById(@Param("status") Integer status, @Param("id") Integer id);

}
