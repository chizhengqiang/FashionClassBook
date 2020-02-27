package com.conan.fashionclassbook.service;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.exception.FCBException;
import com.conan.fashionclassbook.vo.req.BannerCreateReq;
import com.conan.fashionclassbook.vo.resp.BannerResp;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IBannerService {


    public ServerResponse<List<BannerResp>> findAll() throws FCBException;

    public ServerResponse<PageInfo<BannerResp>> findPage(Integer page, Integer size) throws FCBException;

    public ServerResponse<BannerResp> getById(Long id) throws FCBException;

    ServerResponse<String> createBanner(BannerCreateReq request) throws FCBException;

    ServerResponse<String> updateBanner(BannerCreateReq req) throws FCBException;

    ServerResponse<String> deleteOne(Long id) throws FCBException;

    ServerResponse<String> deleteByIds(List<Long> ids) throws FCBException;
}
