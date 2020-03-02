package com.conan.fashionclassbook.service;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.exception.FCBException;
import com.conan.fashionclassbook.vo.req.CategoryReq;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.NotNull;

/**
 *
 */
public interface ICategoryService {

    ServerResponse<String> insertCategory(CategoryReq categoryReq) throws FCBException;

    ServerResponse<String> updateCategory(CategoryReq categoryReq) throws FCBException;

    public ServerResponse<String> deleteById(Long id) throws FCBException;
}
