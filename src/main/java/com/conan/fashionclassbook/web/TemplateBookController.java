package com.conan.fashionclassbook.web;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.pojo.TemplateBook;
import com.conan.fashionclassbook.service.TemplateBookService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Api(tags = "TemplateBookController-纪念册模版相关接口", description = "提供纪念册模版相关的 Rest API")
public class TemplateBookController {

    @Autowired
    TemplateBookService templateBookService;

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("/templateBooks")
    @ApiOperation("查询所有的纪念册接口")
    public ServerResponse<List<TemplateBook>> findAll() {
        ServerResponse<List<TemplateBook>> response = templateBookService.findAll();
        return response;
    }

    /**
     * 分页查询
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/templateBooks/{page}/{size}")
    @ApiOperation("分页查询纪念册接口")
    public ServerResponse<PageInfo<TemplateBook>> findPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        ServerResponse<PageInfo<TemplateBook>> response = templateBookService.findPage(page, size);
        return response;
    }

    /**
     * 增加纪念册接口
     *
     * @param templateBook
     * @return
     */
    @PostMapping("/templateBooks")
    @ApiOperation("增加纪念册接口")
    public ServerResponse<String> save(@RequestBody TemplateBook templateBook) {
        ServerResponse<String> response = templateBookService.insert(templateBook);
        return response;
    }

    /**
     * 修改纪念册接口
     *
     * @param templateBook
     * @return
     */
    @PutMapping("/templateBooks")
    @ApiOperation("修改纪念册接口")
    public ServerResponse<String> update(@RequestBody TemplateBook templateBook) {
        ServerResponse<String> response = templateBookService.update(templateBook);
        return response;
    }

    /**
     * 删除一个
     *
     * @param id
     * @return
     */
    @DeleteMapping("/templateBooks/{id}")
    @ApiOperation("删除纪念册接口")
    public ServerResponse<String> deleteOne(@PathVariable Integer id) {
        ServerResponse<String> response = templateBookService.deleteOne(id);
        return response;
    }
}
