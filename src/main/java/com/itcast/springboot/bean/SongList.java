package com.itcast.springboot.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 歌单库
 */
@ApiModel("歌单")
public class SongList {
    @ApiModelProperty("歌单id")
    private Integer slid;
    @ApiModelProperty("歌曲链接")
    private String songLink;
    @ApiModelProperty("歌名")
    private String songName;
    @ApiModelProperty("歌曲类型")
    private Integer songType;

    public SongList() {
    }

    public SongList(Integer slid, String songLink, String songName, Integer songType) {
        this.slid = slid;
        this.songLink = songLink;
        this.songName = songName;
        this.songType = songType;
    }

    public Integer getSlid() {
        return slid;
    }

    public void setSlid(Integer slid) {
        this.slid = slid;
    }

    public String getSongLink() {
        return songLink;
    }

    public void setSongLink(String songLink) {
        this.songLink = songLink;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Integer getSongType() {
        return songType;
    }

    public void setSongType(Integer songType) {
        this.songType = songType;
    }

    @Override
    public String toString() {
        return "SongList{" +
                "slid=" + slid +
                ", songLink='" + songLink + '\'' +
                ", songName='" + songName + '\'' +
                ", songType=" + songType +
                '}';
    }
}
