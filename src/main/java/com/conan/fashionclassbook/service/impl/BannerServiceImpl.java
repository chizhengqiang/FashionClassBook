package com.conan.fashionclassbook.service.impl;

import com.conan.fashionclassbook.commons.Constants;
import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.dao.BannerMapper;
import com.conan.fashionclassbook.enums.StatusEnum;
import com.conan.fashionclassbook.pojo.Banner;
import com.conan.fashionclassbook.service.IBannerService;
import com.conan.fashionclassbook.vo.req.BannerReq;
import com.conan.fashionclassbook.vo.resp.BannerResp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 轮播图业务层
 */
@Slf4j
@Service
public class BannerServiceImpl implements IBannerService {

    @Autowired
    private BannerMapper bannerMapper;

    /**
     * @return
     */
    @Override
    public ServerResponse<List<BannerResp>> findAll() {
        List<Banner> list = bannerMapper.findAll();
        List<BannerResp> bannerRespList = Lists.newArrayList();
        BeanUtils.copyProperties(list, bannerRespList);
        return ServerResponse.createBySuccess(bannerRespList);
    }

    @Override
    public ServerResponse<PageInfo<BannerResp>> findPage(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Banner> list = bannerMapper.findAll();
        List<BannerResp> bannerRespList = Lists.newArrayList();
        BeanUtils.copyProperties(list, bannerRespList);
        PageInfo<BannerResp> pageInfo = new PageInfo<>(bannerRespList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse<BannerResp> getById(Long id) {
        Banner banner = bannerMapper.getById(id);
        if (banner == null) {
            return ServerResponse.createByErrorMessage(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }
        BannerResp bannerResp = new BannerResp();
        BeanUtils.copyProperties(banner, bannerResp);
        log.info("bannerResp : {}", bannerResp);
        return ServerResponse.createBySuccess(bannerResp);
    }

    /**
     * @param request
     * @return
     */
    @Override
    @Transactional
    public ServerResponse<String> createBanner(BannerReq request) {
        if (!request.createValidate()) {
            return ServerResponse.createByErrorMessage(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        int result = bannerMapper.insertSelective(request.createBanner());
        if (result > 0) {
            return ServerResponse.createBySuccess(Constants.CommonsMsg.InsertStatusMsg.SUCCESS);
        }
        return ServerResponse.createByErrorMessage(Constants.CommonsMsg.InsertStatusMsg.FAIR);
    }

    /**
     * 修改
     *
     * @param req
     * @return
     * @throws FCBException
     */
    @Override
    @Transactional
    public ServerResponse<String> updateBanner(BannerReq req) {
        if (!req.updateValidate()) {
            return ServerResponse.createByErrorMessage(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        int result = bannerMapper.updateByPrimaryKeySelective(req.updateBanner());
        if (result > 0) {
            return ServerResponse.createBySuccess(Constants.CommonsMsg.InsertStatusMsg.SUCCESS);
        }
        return ServerResponse.createByErrorMessage(Constants.CommonsMsg.InsertStatusMsg.FAIR);
    }

    /**
     * @param id
     * @return
     * @throws FCBException
     */
    @Override
    @Transactional
    public ServerResponse<String> deleteOne(Long id) {
        Banner banner = bannerMapper.getById(id);
        if (banner == null) {
            return ServerResponse.createByErrorMessage(Constants.ErrorMsg.CAN_NOT_FIND_BANNER_RECORD);
        }
        int result = bannerMapper.changeStatusById(StatusEnum.DELETE_STATUS.getCode(), id);
        if (result > 0) {
            return ServerResponse.createBySuccess(Constants.CommonsMsg.DeleteStatusMsg.SUCCESS);
        }
        return ServerResponse.createByErrorMessage(Constants.CommonsMsg.DeleteStatusMsg.FAIR);
    }

    @Override
    @Transactional
    public ServerResponse<String> deleteByIds(List<Long> ids){
        // TODO 删除选中
        return null;
    }


}
