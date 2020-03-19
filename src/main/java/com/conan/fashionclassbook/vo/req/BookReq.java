package com.conan.fashionclassbook.vo.req;

import com.conan.fashionclassbook.commons.Constants;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

@Data
public class BookReq {

    private Long id;
    private Long customerId; //用户Id
    private String name;//名称
    private String coverImg; //图片
    private String school;
    private String clazz;
    private String desc; //说明
    private Integer status; //状态 0正常， 9 删除
    private Date createTime; //创建时间
    private Date lastTime; //最后一次更新时间

    /**
     * 校验
     * @param edit
     * @return
     */
    public String validate(Boolean edit) {
        if(edit && id == null) {
            return Constants.ErrorMsg.Book.ID_CANNOT_BE_EMPTY;
        }
        if(!edit && customerId == null) {
            return Constants.ErrorMsg.Book.CUSTOMERID_CANNOT_BE_EMPTY;
        }
        if(!edit && StringUtils.isBlank(name)) {
            return Constants.ErrorMsg.Book.NAME_CANNOT_BE_EMPTY;
        }
        if(!edit && StringUtils.isBlank(school)) {
            return Constants.ErrorMsg.Book.SCHOOL_CANNOT_BE_EMPTY;
        }
        if(!edit && StringUtils.isBlank(clazz)) {
            return Constants.ErrorMsg.Book.CLASS_CANNOT_BE_EMPTY;
        }

        return null;
    }
}
