package com.conan.fashionclassbook.web;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.exception.FCBException;
import com.conan.fashionclassbook.service.IGoodsService;
import com.conan.fashionclassbook.vo.req.GoodsReq;
import com.conan.fashionclassbook.vo.resp.GoodsResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@Api(tags = "GoodsController-商品相关接口", description = "提供商品相关的 Rest API")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @GetMapping("/goods/{id}")
    @ApiOperation("获取一个")
    public ServerResponse<GoodsResp> getById(@PathVariable Long id) throws FCBException {
        ServerResponse<GoodsResp> response = goodsService.getById(id);
        return response;
    }

    @PostMapping("/goods")
    @ApiOperation("增加")
    public ServerResponse<String> addGoods(@RequestBody GoodsReq req) throws FCBException {
        ServerResponse<String> response = goodsService.insertGoods(req);
        return response;
    }

    @PutMapping("/goods")
    @ApiOperation("修改一个")
    public ServerResponse<String> editGoods(@RequestBody GoodsReq req) throws FCBException {
        ServerResponse<String> response = goodsService.updateGoods(req);
        return response;
    }

    @DeleteMapping("/goods/{id}")
    @ApiOperation("删除")
    public ServerResponse<String> deleteById(@PathVariable Long id) throws FCBException {
        ServerResponse<String> response = goodsService.deleteById(id);
        return response;
    }
}
