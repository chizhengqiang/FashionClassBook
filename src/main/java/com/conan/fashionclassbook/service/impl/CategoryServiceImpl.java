package com.conan.fashionclassbook.service.impl;

import com.conan.fashionclassbook.commons.Constants;
import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.dao.CategoryMapper;
import com.conan.fashionclassbook.enums.StatusEnum;
import com.conan.fashionclassbook.exception.FCBException;
import com.conan.fashionclassbook.pojo.Category;
import com.conan.fashionclassbook.service.ICategoryService;
import com.conan.fashionclassbook.vo.req.CategoryReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.NotNull;

@Slf4j
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    /**
     * 增加
     *
     * @param categoryReq
     * @return
     * @throws FCBException
     */
    @Override
    @Transactional
    public ServerResponse<String> insertCategory(CategoryReq categoryReq) throws FCBException {
        categoryReq.validate(false);
        Category category = categoryReq.createCategory();
        int resultCount = categoryMapper.insertSelective(category);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage(Constants.CommonsMsg.InsertStatusMsg.SUCCESS);
        }
        return ServerResponse.createByErrorMessage(Constants.CommonsMsg.InsertStatusMsg.FAIR);
    }

    /**
     * 修改
     *
     * @param categoryReq
     * @return
     * @throws FCBException
     */
    @Override
    @Transactional
    public ServerResponse<String> updateCategory(CategoryReq categoryReq) throws FCBException {
        categoryReq.validate(true);
        Category category = categoryReq.updateCategory();
        int resultCount = categoryMapper.updateByPrimaryKeySelective(category);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage(Constants.CommonsMsg.InsertStatusMsg.SUCCESS);
        }
        return ServerResponse.createByErrorMessage(Constants.CommonsMsg.InsertStatusMsg.FAIR);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws FCBException
     */
    @Override
    @Transactional
    public ServerResponse<String> deleteById(Long id) throws FCBException {
        Category category = categoryMapper.getById(id);
        if (category == null) {
            throw new FCBException(Constants.ErrorMsg.Category.CAN_NOT_FIND_RECORD);
        }
        int resultCount = categoryMapper.changeStatusById(StatusEnum.DELETE_STATUS.getCode(), id);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage(Constants.CommonsMsg.DeleteStatusMsg.SUCCESS);
        }
        return ServerResponse.createByErrorMessage(Constants.CommonsMsg.DeleteStatusMsg.FAIR);
    }
}
