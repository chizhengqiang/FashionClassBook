package com.conan.fashionclassbook.service.impl;

import com.conan.fashionclassbook.commons.Constants;
import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.dao.CategoryMapper;
import com.conan.fashionclassbook.exception.FCBException;
import com.conan.fashionclassbook.pojo.Category;
import com.conan.fashionclassbook.service.ICategoryService;
import com.conan.fashionclassbook.vo.req.CategoryReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ServerResponse<String> insertCategory(CategoryReq categoryReq) throws FCBException {
        categoryReq.validate(false);
        Category category = categoryReq.createCategory();
        int resultCount = categoryMapper.insertSelective(category);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage(Constants.InsertStatusMsg.SUCCESS);
        }
        return ServerResponse.createBySuccessMessage(Constants.InsertStatusMsg.SUCCESS);
    }
}
