package com.conan.fashionclassbook.service;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.pojo.Book;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IBookService {

    ServerResponse<String> deleteOne(Integer id);

    ServerResponse<List<Book>> findAll();

    ServerResponse<String> insert(Book book);

    ServerResponse<String> update(Book book);

    ServerResponse<PageInfo<Book>> findPage(Integer page, Integer size);
}
