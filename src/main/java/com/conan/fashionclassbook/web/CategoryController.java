package com.conan.fashionclassbook.web;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.exception.FCBException;
import com.conan.fashionclassbook.service.ICategoryService;
import com.conan.fashionclassbook.vo.req.CategoryReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;


    @PostMapping("/categoryS")
    public ServerResponse<String> addCategory(@RequestBody CategoryReq categoryReq) throws FCBException {
        ServerResponse<String> response = categoryService.insertCategory(categoryReq);
        return response;
    }
}
