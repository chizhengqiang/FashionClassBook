package com.conan.fashionclassbook.vo.req;

import com.conan.fashionclassbook.commons.Constants;
import com.conan.fashionclassbook.enums.StatusEnum;
import com.conan.fashionclassbook.pojo.Banner;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

@Data
public class BannerReq {

    private Long id;
    private String title;
    private String url;
    private String desc;
    private Integer type;
    private Integer status;
    private Date createTime;
    private Date lastTime;

    public String validate(Boolean edit) {
        if (edit && id == null) {
            return Constants.ErrorMsg.Banner.ID_CANNOT_BE_EMPTY;
        }
        if (!edit && StringUtils.isBlank(url)) {
            return Constants.ErrorMsg.Banner.URL_CANNOT_BE_EMPTY;
        }
        return null;
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
