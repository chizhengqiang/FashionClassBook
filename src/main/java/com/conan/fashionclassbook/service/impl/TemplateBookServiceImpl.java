package com.conan.fashionclassbook.service.impl;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.enums.StatusEnum;
import com.conan.fashionclassbook.dao.TemplateBookMapper;
import com.conan.fashionclassbook.pojo.TemplateBook;
import com.conan.fashionclassbook.service.TemplateBookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TemplateBookServiceImpl implements TemplateBookService {

    @Autowired
    TemplateBookMapper templateBookMapper;

    /**
     * 查询列表
     *
     * @return
     */
    @Override
    public ServerResponse<List<TemplateBook>> findAll() {
        List<TemplateBook> templateBookList = templateBookMapper.findAll();
        return ServerResponse.createBySuccess(templateBookList);
    }

    /**
     * 删除一个
     *
     * @param id
     * @return
     */
    public ServerResponse<String> deleteOne(Integer id) {
        TemplateBook templateBook = templateBookMapper.getById(id);
        if (templateBook == null) {
            return ServerResponse.createByErrorMessage("该纪念册不存在");
        }
        int resultCount = templateBookMapper.changeStatusById(StatusEnum.DELETE_STATUS.getCode(), id);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");

    }

    /**
     * 分页查询
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public ServerResponse<PageInfo<TemplateBook>> findPage(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<TemplateBook> templateBookList = templateBookMapper.findAll();
        PageInfo<TemplateBook> templateBookPageInfo = new PageInfo<>(templateBookList);
        return ServerResponse.createBySuccess(templateBookPageInfo);
    }


    /**
     * 增加
     *
     * @param templateBook
     * @return
     */
    @Override
    public ServerResponse<String> insert(TemplateBook templateBook) {
        int resultCount = templateBookMapper.insertSelective(templateBook);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("添加成功");
        }
        return ServerResponse.createByErrorMessage("添加失败");
    }

    /**
     * 修改
     *
     * @param templateBook
     * @return
     */
    @Override
    public ServerResponse<String> update(TemplateBook templateBook) {
        int resultCount = templateBookMapper.updateByPrimaryKeySelective(templateBook);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("修改成功");
        }
        return ServerResponse.createByErrorMessage("修改失败");
    }
}
