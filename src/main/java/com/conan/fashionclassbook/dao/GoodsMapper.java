package com.conan.fashionclassbook.dao;

import com.conan.fashionclassbook.pojo.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {

    List<Goods> findAll();

    Goods getById(Long id);

    int insertSelective(Goods record);

    int updateByPrimaryKeySelective(Goods record);

    int changeStatusById(@Param("status") Integer status, @Param("id") Long id);
}
