package com.conan.fashionclassbook.vo.req;

import com.conan.fashionclassbook.commons.Constants;
import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.enums.StatusEnum;
import com.conan.fashionclassbook.pojo.Category;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

@Data
public class CategoryReq {

    private Long id;
    private String name;
    private Long parentId;
    private Integer status;
    private Date createTime;
    private Date lastTime;

    public ServerResponse<String> validate(Boolean isExit) {
        if (isExit && id == null) {
            return ServerResponse.createByErrorMessage(Constants.ErrorMsg.Category.ID_CANNOT_BE_EMPTY);
        }
        if (!isExit && StringUtils.isEmpty(name)) {
            return ServerResponse.createByErrorMessage(Constants.ErrorMsg.Category.NAME_CANNOT_BE_EMPTY);
        }
        if (!isExit && parentId == null) {
            return ServerResponse.createByErrorMessage(Constants.ErrorMsg.Category.PARENT_ID_CANNOT_BE_EMPTY);
        }
        return ServerResponse.createBySuccess();
    }

    public Category createCategory() {
        Category category = new Category();
        return insertOrEdit(category);
    }


    public Category updateCategory() {
        Category category = new Category();
        category.setId(id);
        return insertOrEdit(category);
    }


    public Category insertOrEdit(Category category) {
        category.setName(name);
        category.setParentId(parentId);
        category.setStatus(StatusEnum.NORMAL_STATUS.getCode());
        return category;
    }


}
