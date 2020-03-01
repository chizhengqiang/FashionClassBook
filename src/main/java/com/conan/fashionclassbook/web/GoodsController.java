package com.conan.fashionclassbook.web;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.exception.FCBException;
import com.conan.fashionclassbook.service.IGoodsService;
import com.conan.fashionclassbook.vo.req.GoodsReq;
import com.conan.fashionclassbook.vo.resp.GoodsResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @GetMapping("/goods/{id}")
    public ServerResponse<GoodsResp> getById(@PathVariable Long id) throws FCBException {
        ServerResponse<GoodsResp> response = goodsService.getById(id);
        return response;
    }

    @PostMapping("/goods")
    public ServerResponse<String> addGoods(@RequestBody GoodsReq req) throws FCBException {
        ServerResponse<String> response = goodsService.insertGoods(req);
        return response;
    }

    @PutMapping("/goods")
    public ServerResponse<String> editGoods(@RequestBody GoodsReq req) throws FCBException {
        ServerResponse<String> response = goodsService.updateGoods(req);
        return response;
    }

    @DeleteMapping("/goods/{id}")
    public ServerResponse<String> deleteById(@PathVariable Long id) throws FCBException{
        ServerResponse<String> response = goodsService.deleteById(id);
        return response;
    }
}
