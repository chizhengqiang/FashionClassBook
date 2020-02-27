package com.conan.fashionclassbook.dao;

import com.conan.fashionclassbook.pojo.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {

    /**
     * 修改状态
     *
     * @param status
     * @param id
     * @return
     */
    int changeStatusById(@Param("status") Integer status, @Param("id") Integer id);

    /**
     * 获取一个
     *
     * @param id
     * @return
     */
    Book getById(Integer id);

    /**
     * 列表查询
     *
     * @return
     */
    List<Book> findAll();

    int insertSelective(Book record);

    int updateByPrimaryKeySelective(Book record);
}
