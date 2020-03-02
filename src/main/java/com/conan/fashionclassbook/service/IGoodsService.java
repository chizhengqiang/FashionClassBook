package com.conan.fashionclassbook.service;


import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.exception.FCBException;
import com.conan.fashionclassbook.vo.req.GoodsReq;
import com.conan.fashionclassbook.vo.resp.GoodsResp;

import java.util.List;

public interface IGoodsService {

    List<GoodsResp> findAll() throws FCBException;

    ServerResponse<GoodsResp> getById(Long id) throws FCBException;

    ServerResponse<String> insertGoods(GoodsReq req) throws FCBException;

    ServerResponse<String> updateGoods(GoodsReq req) throws FCBException;

    ServerResponse<String> deleteById(Long id) throws FCBException;
}
