package com.conan.fashionclassbook.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class UserBook implements Serializable {

    private Long id;
    private Long userId; // 用户 id
    private Long bookId; //纪念册 Id
    private String username; //姓名
    private String headImg;// 头像
    private String gender ;//性别
    private Date birthday; //生日
    private String telephone; //手机号
    private String email ;// email
    private String wechat ;//微信
    private String weibo; // 微博
    private String blog ;// 博客
    private String constellation ;//星座
    private String zodiac ;//生肖
    private String dream; //梦想
    private String profile; //个人主页
    private String address; //地址
    private String favoriteColors; //喜欢的颜色
    private String peopleOfAdmiration; //敬佩的人物
    private String favoriteSinger; //喜欢的歌手
    private String favoriteBand; //喜欢的乐队
    private String mantra; //口头禅
    private String favoriteSport; //最喜欢的运动
    private String favoriteMovie; //最喜欢的电影
    private String favoritePeople; //最想见的人
    private String favoriteNovels; //最喜欢的小说
    private String favoritePoetryAuthor; //最喜欢的诗词作者
    private String FavoriteAnimals; //最喜欢的动物
    private String fearedAnimals; //最怕怕的动物
    private String moniker; //外号
    private String taboo; //忌讳
    private String wish; //愿望
    private String guestBook;// 留言
    private String details;// 备注
    private Integer status ;// 状态 0 正常， 9 :删除
    private Date createTime ;//创建时间
    private Date lastTime ; // 最后一次修改时间
}
