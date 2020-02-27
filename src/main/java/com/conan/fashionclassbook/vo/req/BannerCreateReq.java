package com.conan.fashionclassbook.vo.req;

import com.conan.fashionclassbook.enums.StatusEnum;
import com.conan.fashionclassbook.pojo.Banner;
import lombok.Data;

import java.util.Date;

@Data
public class BannerCreateReq {

    private Long id;
    private String title;
    private String url;
    private String desc;
    private Integer type;
    private Integer status;
    private Date createTime;
    private Date lastTime;

    public boolean createValidate() {
        return url != null && type != null;
    }

    public boolean updateValidate() {
        return id != null && url != null && type != null;
    }

    /**
     * create banner
     *
     * @return
     */
    public Banner createBanner() {
        Banner banner = new Banner();
        return createOrEditBanner(banner);
    }

    public Banner updateBanner() {
        Banner banner = new Banner();
        banner.setId(id);
        return createOrEditBanner(banner);
    }

    private Banner createOrEditBanner(Banner banner) {
        banner.setTitle(this.title);
        banner.setUrl(this.url);
        banner.setDesc(this.desc);
        banner.setType(this.type);
        banner.setStatus(StatusEnum.NORMAL_STATUS.getCode());
        banner.setCreateTime(new Date());
        banner.setLastTime(new Date());
        return banner;
    }
}
