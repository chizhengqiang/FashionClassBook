package com.conan.fashionclassbook.pojo;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
public class BookUserInfo implements Serializable {

    @Id
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
}