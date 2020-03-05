package com.conan.fashionclassbook.web;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.service.ICategoryService;
import com.conan.fashionclassbook.vo.req.CategoryReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@CrossOrigin
@RestController
@Api(tags = "CategoryController-分类相关接口", description = "提供分类相关的 Rest API")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;


    @PostMapping("/categoryS")
    @ApiOperation("增加")
    public ServerResponse<String> addCategory(@RequestBody CategoryReq categoryReq)  {
        ServerResponse<String> response = categoryService.insertCategory(categoryReq);
        return response;
    }

    @PutMapping("/categoryS")
    @ApiOperation("修改")
    public ServerResponse<String> updateCategory(@RequestBody CategoryReq categoryReq)  {
        ServerResponse<String> response = categoryService.updateCategory(categoryReq);
        return response;
    }

    @PutMapping("/categoryS/{id}")
    @ApiOperation("删除")
    public ServerResponse<String> updateCategory(@PathVariable @NotNull Long id)  {
        ServerResponse<String> response = categoryService.deleteById(id);
        return response;
    }
}
