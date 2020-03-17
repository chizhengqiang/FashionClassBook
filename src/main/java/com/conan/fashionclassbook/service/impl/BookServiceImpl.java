package com.conan.fashionclassbook.service.impl;

import com.conan.fashionclassbook.commons.Constants;
import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.enums.StatusEnum;
import com.conan.fashionclassbook.dao.BookMapper;
import com.conan.fashionclassbook.pojo.Book;
import com.conan.fashionclassbook.service.IBookService;
import com.conan.fashionclassbook.vo.req.BookReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 纪念册业务层
 */
@Slf4j
@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    BookMapper bookMapper;

    /**
     * 删除一个
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public ServerResponse<String> deleteOne(Integer id) {
        Book book = bookMapper.getById(id);
        if (book == null) {
            return ServerResponse.createByErrorMessage("该纪念册不存在");
        }
        int resultCount = bookMapper.changeStatusById(StatusEnum.DELETE_STATUS.getCode(), id);
        if (resultCount <= 0) {
            return ServerResponse.createByErrorMessage(Constants.CommonsMsg.DeleteStatusMsg.FAIR);
        }
        return ServerResponse.createBySuccessMessage(Constants.CommonsMsg.DeleteStatusMsg.SUCCESS);
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
     * @param req
     * @return
     */
    @Override
    @Transactional
    public ServerResponse<String> insert(BookReq req) {
        String errorMsg = req.validate(false);
        if(errorMsg != null) {
            return ServerResponse.createByErrorMessage(errorMsg);
        }
        Book book = new Book();
        BeanUtils.copyProperties(req, book);
        int resultCount = bookMapper.insertSelective(book);
        if (resultCount <= 0) {
            return ServerResponse.createByErrorMessage(Constants.CommonsMsg.InsertStatusMsg.FAIR);
        }
        return ServerResponse.createBySuccessMessage(Constants.CommonsMsg.InsertStatusMsg.SUCCESS);
    }

    /**
     * 修改
     *
     * @param req
     * @return
     */
    @Override
    @Transactional
    public ServerResponse<String> update(BookReq req) {
        String errorMsg = req.validate(true);
        if(errorMsg != null) {
            return ServerResponse.createByErrorMessage(errorMsg);
        }
        Book book = new Book();
        BeanUtils.copyProperties(req, book);
        int resultCount = bookMapper.updateByPrimaryKeySelective(book);
        if (resultCount <= 0) {
            return ServerResponse.createByErrorMessage(Constants.CommonsMsg.UpdateStatusMsg.FAIR);
        }
        return ServerResponse.createBySuccessMessage(Constants.CommonsMsg.UpdateStatusMsg.SUCCESS);
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
