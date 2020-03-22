package com.conan.fashionclassbook.vo.req;

import com.conan.fashionclassbook.commons.Constants;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

@Data
public class BookUserInfoReq {
    private Integer id;
    private Integer bookId;
    private Integer userId;
    private String username;
    private String headImg;
    private String signature;
    private String gender;
    private Date birthday;
    private String voice;
    private String telephone;
    private String email;
    private String wechat;
    private String weibo;
    private String blog;
    private String constellation;
    private String zodiac;
    private String dream;
    private String profile;
    private String address;
    private String favoriteColors;
    private String peopleOfAdmiration;
    private String favoriteSinger;
    private String mantra;
    private String favoriteSport;
    private String favoriteMovie;
    private String favoritePeople;
    private String favoriteNovels;
    private String favoritePoetryAuthor;
    private String favoriteAnimals;
    private String fearedAnimals;
    private String moniker;
    private String taboo;
    private String wish;
    private String guestBook;
    private String details;
    private Byte status;
    private Date createTime;
    private Date lastTime;

    public String edit(Boolean edit) {
        if (edit && id == null) {
            return Constants.ErrorMsg.BookUserInfo.ID_CANNOT_BE_EMPTY;
        }
        if(!edit && StringUtils.isBlank(username )){
            return Constants.ErrorMsg.BookUserInfo.USERNAME_CANNOT_BE_EMPTY;
        }
        if(!edit && userId == null) {
            return Constants.ErrorMsg.BookUserInfo.USERID_CANNOT_BE_EMPTY;
        }
        return null;
    }
}
