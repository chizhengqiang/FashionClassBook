package com.conan.fashionclassbook.dao;

import com.conan.fashionclassbook.pojo.Banner;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerMapper {

    Banner getById(Long id);

    List<Banner> findAll();

    int insertSelective(Banner record);

    int updateByPrimaryKeySelective(Banner record);

    /**
     * 修改状态
     *
     * @param status
     * @param id
     * @return
     */
    int changeStatusById(@Param("status") Integer status, @Param("id") Long id);

}