package com.conan.fashionclassbook.service;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.pojo.Book;
import com.conan.fashionclassbook.vo.req.BookReq;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IBookService {

    ServerResponse<String> deleteOne(Integer id);

    ServerResponse<List<Book>> findAll();

    ServerResponse<String> insert(BookReq req);

    ServerResponse<String> update(BookReq req);

    ServerResponse<PageInfo<Book>> findPage(Integer page, Integer size);
}
