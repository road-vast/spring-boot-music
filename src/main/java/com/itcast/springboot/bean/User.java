package com.itcast.springboot.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 微信用户基本信息
 */
@ApiModel("用户")
public class User {
    @ApiModelProperty("用户id")
    private Integer uid;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("session")
    private String sessionKey;
    //微信头像
    @ApiModelProperty("微信头像")
    private String avatarUrl;
    @ApiModelProperty("性别")
    private Integer gender;
    @ApiModelProperty("国家")
    private String country;
    @ApiModelProperty("省份")
    private String province;
    @ApiModelProperty("城市")
    private String city;
    @ApiModelProperty("语言")
    private String lang;
    @ApiModelProperty("用户动态")
    private List<UserDyna> userDynas;
    @ApiModelProperty("好友列表")
    private List<Friend> friends;

    public User() {
    }

    public User(Integer uid, String username, String sessionKey, String avatarUrl, Integer gender, String country, String province, String city, String lang) {
        this.uid = uid;
        this.username = username;
        this.sessionKey = sessionKey;
        this.avatarUrl = avatarUrl;
        this.gender = gender;
        this.country = country;
        this.province = province;
        this.city = city;
        this.lang = lang;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public List<UserDyna> getUserDynas() {
        return userDynas;
    }

    public void setUserDynas(List<UserDyna> userDynas) {
        this.userDynas = userDynas;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gender=" + gender +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", lang='" + lang + '\'' +
                ", userDynas=" + userDynas +
                ", friends=" + friends +
                '}';
    }
}
