package com.conan.fashionclassbook.service.impl;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.enums.StatusEnum;
import com.conan.fashionclassbook.dao.BookMapper;
import com.conan.fashionclassbook.pojo.Book;
import com.conan.fashionclassbook.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 纪念册业务层
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    /**
     * 删除一个
     *
     * @param id
     * @return
     */
    @Override
    public ServerResponse<String> deleteOne(Integer id) {
        Book book = bookMapper.getById(id);
        if (book == null) {
            return ServerResponse.createByErrorMessage("该纪念册不存在");
        }
        int resultCount = bookMapper.changeStatusById(StatusEnum.DELETE_STATUS.getCode(), id);
        if (resultCount <= 0) {
            return ServerResponse.createByErrorMessage("删除失败");
        }
        return ServerResponse.createBySuccessMessage("删除成功");
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public ServerResponse<List<Book>> findAll() {
        List<Book> bookList = bookMapper.findAll();
        return ServerResponse.createBySuccess(bookList);
    }

    /**
     * 增加
     *
     * @param book
     * @return
     */
    @Override
    public ServerResponse<String> insert(Book book) {
        int resultCount = bookMapper.insertSelective(book);
        if (resultCount <= 0) {
            return ServerResponse.createByErrorMessage("添加失败");
        }
        return ServerResponse.createBySuccessMessage("添加成功");
    }

    /**
     * 修改
     *
     * @param book
     * @return
     */
    @Override
    public ServerResponse<String> update(Book book) {
        int resultCount = bookMapper.updateByPrimaryKeySelective(book);
        if (resultCount <= 0) {
            return ServerResponse.createByErrorMessage("修改失败");
        }
        return ServerResponse.createBySuccessMessage("修改成功");
    }

    /**
     * 分页列表
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public ServerResponse<PageInfo<Book>> findPage(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Book> bookList = bookMapper.findAll();
        PageInfo<Book> bookPageInfo = new PageInfo<>(bookList);
        return ServerResponse.createBySuccess(bookPageInfo);
    }
}
