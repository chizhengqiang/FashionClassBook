package com.conan.fashionclassbook.service;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.exception.FCBException;
import com.conan.fashionclassbook.vo.req.CategoryReq;

/**
 *
 */
public interface ICategoryService {

    ServerResponse<String> insertCategory(CategoryReq categoryReq) throws FCBException;
}
