package com.conan.fashionclassbook.service;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.vo.req.BannerReq;
import com.conan.fashionclassbook.vo.resp.BannerResp;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IBannerService {

    ServerResponse<List<BannerResp>> findAll();

    ServerResponse<PageInfo<BannerResp>> findPage(Integer page, Integer size);

    ServerResponse<BannerResp> getById(Long id);

    ServerResponse<String> createBanner(BannerReq request);

    ServerResponse<String> updateBanner(BannerReq req);

    ServerResponse<String> deleteOne(Long id);

    ServerResponse<String> deleteByIds(List<Long> ids);
}
