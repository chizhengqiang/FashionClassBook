package com.conan.fashionclassbook.service;


import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.vo.req.GoodsReq;
import com.conan.fashionclassbook.vo.resp.GoodsResp;

import java.util.List;

public interface IGoodsService {

    List<GoodsResp> findAll() ;

    ServerResponse<GoodsResp> getById(Long id) ;

    ServerResponse<String> insertGoods(GoodsReq req) ;

    ServerResponse<String> updateGoods(GoodsReq req) ;

    ServerResponse<String> deleteById(Long id) ;
}
