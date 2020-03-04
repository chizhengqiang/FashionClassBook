package com.conan.fashionclassbook.service.impl;

import com.conan.fashionclassbook.commons.Constants;
import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.dao.GoodsMapper;
import com.conan.fashionclassbook.enums.StatusEnum;
import com.conan.fashionclassbook.exception.FCBException;
import com.conan.fashionclassbook.pojo.Goods;
import com.conan.fashionclassbook.service.IGoodsService;
import com.conan.fashionclassbook.vo.req.GoodsReq;
import com.conan.fashionclassbook.vo.resp.GoodsResp;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsResp> findAll() throws FCBException {

        //TODO
        List<Goods> goods = goodsMapper.findAll();
        List<GoodsResp> goodsResps = Lists.newArrayList();
        return goodsResps;
    }

    @Override
    public ServerResponse<GoodsResp> getById(Long id) throws FCBException {
        if (id == null) {
            throw new FCBException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        Goods goods = goodsMapper.getById(id);
        if (goods == null) {
            throw new FCBException(Constants.ErrorMsg.Goods.CAN_NOT_FIND_RECORD);
        }
        GoodsResp goodsResp = new GoodsResp();
        BeanUtils.copyProperties(goods, goodsResp);
        return ServerResponse.createBySuccess(goodsResp);
    }


    @Override
    @Transactional
    public ServerResponse<String> insertGoods(GoodsReq req) throws FCBException {
        req.validate(false); //校验
        Goods goods = req.createGoods();
        int resultCount = goodsMapper.insertSelective(goods);
        if (resultCount > 0) {
            return ServerResponse.createBySuccess(Constants.CommonsMsg.InsertStatusMsg.SUCCESS);
        }
        return ServerResponse.createByErrorMessage(Constants.CommonsMsg.InsertStatusMsg.FAIR);
    }

    @Override
    @Transactional
    public ServerResponse<String> updateGoods(GoodsReq req) throws FCBException {
        req.validate(true);
        Goods goods = req.updateGoods();
        int resultCount = goodsMapper.updateByPrimaryKeySelective(goods);
        if (resultCount > 0) {
            return ServerResponse.createBySuccess(Constants.CommonsMsg.UpdateStatusMsg.SUCCESS);
        }
        return ServerResponse.createByErrorMessage(Constants.CommonsMsg.UpdateStatusMsg.FAIR);
    }

    @Override
    @Transactional
    public ServerResponse<String> deleteById(Long id) throws FCBException {
        if (id == null) {
            throw new FCBException(Constants.ErrorMsg.Goods.ID_CANNOT_BE_EMPTY);
        }
        Goods goods = goodsMapper.getById(id);
        if (goods == null) {
            throw new FCBException(Constants.ErrorMsg.Goods.CAN_NOT_FIND_RECORD);
        }
        int resultCount = goodsMapper.changeStatusById(StatusEnum.DELETE_STATUS.getCode(), id);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage(Constants.CommonsMsg.DeleteStatusMsg.SUCCESS);
        }
        return ServerResponse.createByErrorMessage(Constants.CommonsMsg.DeleteStatusMsg.FAIR);
    }
}
