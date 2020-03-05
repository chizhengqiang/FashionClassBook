package com.conan.fashionclassbook.service;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.vo.req.CategoryReq;

/**
 *
 */
public interface ICategoryService {

    ServerResponse<String> insertCategory(CategoryReq categoryReq);

    ServerResponse<String> updateCategory(CategoryReq categoryReq);

    ServerResponse<String> deleteById(Long id);
}
