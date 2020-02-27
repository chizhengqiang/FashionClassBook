package com.conan.fashionclassbook.service;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.pojo.TemplateBook;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TemplateBookService {


    /**
     * 列表
     *
     * @return
     */
    ServerResponse<List<TemplateBook>> findAll();

    /**
     * 删除
     *
     * @param id
     * @return
     */
    ServerResponse<String> deleteOne(Integer id);

    /**
     * 分页查询
     *
     * @param page
     * @param size
     * @return
     */
    ServerResponse<PageInfo<TemplateBook>> findPage(Integer page, Integer size);

    /**
     * 增加
     *
     * @param templateBook
     * @return
     */
    ServerResponse<String> insert(TemplateBook templateBook);

    /**
     * 修改
     *
     * @param templateBook
     * @return
     */
    ServerResponse<String> update(TemplateBook templateBook);
}
