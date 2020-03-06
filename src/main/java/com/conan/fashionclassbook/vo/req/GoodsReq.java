package com.conan.fashionclassbook.vo.req;

import com.conan.fashionclassbook.commons.Constants;
import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.enums.StatusEnum;
import com.conan.fashionclassbook.pojo.Goods;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GoodsReq {

    private Long id;
    private String name;
    private String coverImg;//封面
    private Long categoryId;
    private BigDecimal price;
    private Double discount; //折扣，例如9.5折
    private String desc;//介绍
    private Boolean flag;//是否打折
    private Integer status;
    private Date createTime;
    private Date lastTime;

    /**
     * @param isEdit true 编辑
     */
    public String validate(Boolean isEdit) {
        if (isEdit && id == null) {
            return Constants.ErrorMsg.Goods.ID_CANNOT_BE_EMPTY;
        }
        if (!isEdit && (StringUtils.isEmpty(name))) {
            return Constants.ErrorMsg.Goods.NAME_CANNOT_BE_EMPTY;
        }
        if (!isEdit && StringUtils.isEmpty(coverImg)) {
            return Constants.ErrorMsg.Goods.COVER_IMG_CANNOT_BE_EMPTY;
        }
        if (!isEdit && categoryId == null) {
            return Constants.ErrorMsg.Goods.CATEGORY_ID_CANNOT_BE_EMPTY;
        }
        if (!isEdit && price == null) {
            return Constants.ErrorMsg.Goods.PRICE_CANNOT_BE_EMPTY;
        }
        if (!isEdit && flag == null) {
            return Constants.ErrorMsg.Goods.FLAG_CANNOT_BE_EMPTY;
        }
        return null;
    }

    public Goods createGoods() {
        Goods goods = new Goods();
        createOrEdit(goods);
        return goods;
    }

    public Goods updateGoods() {
        Goods goods = new Goods();
        goods.setId(id);
        createOrEdit(goods);
        return goods;
    }

    private Goods createOrEdit(Goods goods) {
        goods.setName(name);
        goods.setCoverImg(coverImg);
        goods.setCategoryId(categoryId);
        goods.setPrice(price);
        goods.setDiscount(discount);
        goods.setFlag(flag);
        goods.setStatus(StatusEnum.NORMAL_STATUS.getCode());
        return goods;
    }
}
