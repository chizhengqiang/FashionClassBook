package com.conan.fashionclassbook.web;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.pojo.Book;
import com.conan.fashionclassbook.service.IBookService;
import com.conan.fashionclassbook.vo.req.BookReq;
import com.conan.fashionclassbook.vo.resp.BookResp;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Api(tags = "BookController-纪念册相关接口", description = "提供纪念册相关的 Rest API")
public class BookController {

    @Autowired
    IBookService bookService;

    /**
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/books/{page}/{size}")
    @ApiOperation("分页")
    public ServerResponse findPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        ServerResponse<PageInfo<Book>> response = bookService.findPage(page, size);
        return response;
    }

    @GetMapping("/books")
    @ApiOperation("列表")
    public ServerResponse findAll() {
        ServerResponse<List<Book>> response = bookService.findAll();
        return response;
    }

    @PostMapping("/books")
    @ApiOperation(("增加"))
    public ServerResponse<String> add(@RequestBody BookReq req) {
        ServerResponse<String> response = bookService.insert(req);
        return response;
    }

    @PutMapping("/books")
    @ApiOperation("修改")
    public ServerResponse update(@RequestBody BookReq req) {
        ServerResponse<String> response = bookService.update(req);
        return response;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/books/{id}")
    @ApiOperation("删除")
    public ServerResponse<String> deleteOne(@PathVariable("id") Integer id) {
        ServerResponse<String> response = bookService.deleteOne(id);
        return response;
    }
}
