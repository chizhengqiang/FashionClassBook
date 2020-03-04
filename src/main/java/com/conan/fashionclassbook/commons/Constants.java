package com.conan.fashionclassbook.commons;

public class Constants {


    public static class CommonsMsg {

        public static class InsertStatusMsg {

            public static final String SUCCESS = "添加成功";

            public static final String FAIR = "添加失败";
        }

        public static class DeleteStatusMsg {

            public static final String SUCCESS = "删除成功";

            public static final String FAIR = "删除失败";
        }

        public static class UpdateStatusMsg {
            public static final String SUCCESS = "修改成功";
            public static final String FAIR = "修改失败";
        }
    }

    public static class SuccessMsg {

        public static final String LOGIN_SUCCESS = "登陆成功";
    }

    public static class ErrorMsg {

        public static final String REQUEST_PARAM_ERROR = "请求参数错误";

        public static final String CAN_NOT_FIND_RECORD = "找不到数据记录";

        public static final String CAN_NOT_FIND_BANNER_RECORD = "该记录不存在";

        public static class Customer {
            public static final String ID_CANNOT_BE_EMPTY = "用户ID不能为空";
            public static final String NICKNAME_CANNOT_BE_EMPTY = "用户昵称不能为空";
            public static final String PASSWORD_CANNOT_BE_EMPTY = "密码不能为空";
            public static final String TYPE_CANNOT_BE_EMPTY = "用户类型不能为空";
            public static final String NICKNAME_CANNOT_BE_EXIST = "该用户不存在";
            public static final String NICKNAME_PASSWORD_CANNOT_BE_ERROR = "用户或密码错误";
        }

        /**
         * 分类
         */
        public static class Category {
            public static final String ID_CANNOT_BE_EMPTY = "分类Id不能为空";
            public static final String NAME_CANNOT_BE_EMPTY = "分类名称不能为空";
            public static final String PARENT_ID_CANNOT_BE_EMPTY = "分类上级不能为空";
            public static final String CAN_NOT_FIND_RECORD = "该分类记录不存在";
        }

        /**
         * 商品
         */
        public static class Goods {
            public static final String ID_CANNOT_BE_EMPTY = "商品Id不能为空";
            public static final String NAME_CANNOT_BE_EMPTY = "商品名称不能为空";
            public static final String COVER_IMG_CANNOT_BE_EMPTY = "商品封面图不能为空";
            public static final String PRICE_CANNOT_BE_EMPTY = "商品价格不能为空";
            public static final String FLAG_CANNOT_BE_EMPTY = "商品是否打折不能为空";
            public static final String CAN_NOT_FIND_RECORD = "该商品记录不存在";
            public static final String CATEGORY_ID_CANNOT_BE_EMPTY = "商品分类不能为空";
        }
    }
}
