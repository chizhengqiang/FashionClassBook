package com.conan.fashionclassbook.web;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.exception.FCBException;
import com.conan.fashionclassbook.pojo.Banner;
import com.conan.fashionclassbook.service.IBannerService;
import com.conan.fashionclassbook.vo.req.BannerCreateReq;
import com.conan.fashionclassbook.vo.resp.BannerResp;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Api(tags = "BannerController-轮播图相关接口", description = "提供轮播图相关的 Rest API")
public class BannerController {

    @Autowired
    IBannerService bannerService;

    @GetMapping("/banners/{page}/{size}")
    @ApiOperation("分页查询轮播图列表")
    public ServerResponse<PageInfo<BannerResp>> findPage(@PathVariable(value = "page") Integer page,
                                                         @PathVariable(value = "size") Integer size) throws FCBException {
        ServerResponse<PageInfo<BannerResp>> response = bannerService.findPage(page, size);
        return response;
    }

    /**
     * 轮播图列表
     *
     * @return
     */
    @GetMapping("/banners")
    @ApiOperation("查询所有轮播图接口")
    public ServerResponse<List<BannerResp>> findAll() throws FCBException {
        ServerResponse<List<BannerResp>> response = bannerService.findAll();
        return response;
    }

    /**
     * @param req
     * @return
     */
    @PostMapping("/banners")
    @ApiOperation("增加轮播图接口")
    public ServerResponse<String> createBanner(@RequestBody BannerCreateReq req) throws FCBException {
        return bannerService.createBanner(req);
    }

    /**
     * @param req
     * @return
     */
    @PutMapping("/banners")
    @ApiOperation("修改轮播图接口")
    public ServerResponse<String> editBanner(@RequestBody BannerCreateReq req) throws FCBException {
        return bannerService.updateBanner(req);
    }


    @DeleteMapping("/banners/{id}")
    @ApiOperation("根据Id删除轮播图接口")
    public ServerResponse<String> deleteById(@PathVariable("id") Long id) throws FCBException {
        return bannerService.deleteOne(id);
    }

    /**
     * @param ids
     * @return
     * @throws FCBException
     */
    @DeleteMapping("/banners")
    @ApiOperation("根据Id删除轮播图接口")
    public ServerResponse<String> deleteByIds(@RequestParam List<Long> ids) throws FCBException {
        return bannerService.deleteByIds(ids);
    }


    @GetMapping("/banners/{id}")
    @ApiOperation("根据Id获取轮播图接口")
    public ServerResponse<BannerResp> findById(@PathVariable("id") Long id) throws FCBException {
        ServerResponse<BannerResp> response = bannerService.getById(id);
        return response;
    }

}