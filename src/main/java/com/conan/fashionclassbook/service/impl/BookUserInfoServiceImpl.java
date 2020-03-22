package com.conan.fashionclassbook.service.impl;

import com.conan.fashionclassbook.commons.Constants;
import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.dao.BookUserInfoMapper;
import com.conan.fashionclassbook.exception.FCBException;
import com.conan.fashionclassbook.pojo.BookUserInfo;
import com.conan.fashionclassbook.service.IBookUserInfoService;
import com.conan.fashionclassbook.vo.req.BookUserInfoReq;
import com.conan.fashionclassbook.vo.resp.BookUserInfoResp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookUserInfoServiceImpl implements IBookUserInfoService {

    @Autowired
    BookUserInfoMapper bookUserInfoMapper;

    /**
     * @param req
     * @return
     */
    @Override
    public ServerResponse<BookUserInfoResp> findAll(BookUserInfoReq req) {
        return null;
    }

    /**
     * @param req
     * @return
     */
    @Override
    public ServerResponse<String> insert(BookUserInfoReq req) throws FCBException {
        String errorMsg = req.edit(false);
        if (errorMsg != null) {
            throw new FCBException(errorMsg);
        }
        BookUserInfo bookUserInfo = new BookUserInfo();
        BeanUtils.copyProperties(req, bookUserInfo);
        int resultCount = bookUserInfoMapper.insertSelective(bookUserInfo);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage(Constants.CommonsMsg.InsertStatusMsg.SUCCESS);
        }
        return ServerResponse.createByErrorMessage(Constants.CommonsMsg.InsertStatusMsg.FAIR);
    }
}
