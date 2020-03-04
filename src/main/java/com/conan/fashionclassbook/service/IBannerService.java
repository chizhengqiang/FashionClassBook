package com.conan.fashionclassbook.service;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.exception.FCBException;
import com.conan.fashionclassbook.vo.req.BannerReq;
import com.conan.fashionclassbook.vo.resp.BannerResp;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IBannerService {

    ServerResponse<List<BannerResp>> findAll() throws FCBException;

    ServerResponse<PageInfo<BannerResp>> findPage(Integer page, Integer size) throws FCBException;

    ServerResponse<BannerResp> getById(Long id) throws FCBException;

    ServerResponse<String> createBanner(BannerReq request) throws FCBException;

    ServerResponse<String> updateBanner(BannerReq req) throws FCBException;

    ServerResponse<String> deleteOne(Long id) throws FCBException;

    ServerResponse<String> deleteByIds(List<Long> ids) throws FCBException;
}
