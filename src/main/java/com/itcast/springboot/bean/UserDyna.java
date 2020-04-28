package com.itcast.springboot.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 用户动态表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户动态")
public class UserDyna {
    @ApiModelProperty("用户动态id")
    private Integer udid;
    @ApiModelProperty("歌单id")
    private Integer songlistId;
    @ApiModelProperty("用户动态内容")
    private String dynaCon;
    @ApiModelProperty("用户id")
    private Integer userId;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("发表日期")
    //入参格式化
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //出参格式化
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date uddate;
    @ApiModelProperty("转发次数")
    private Integer fwCount;
    @ApiModelProperty("点赞次数")
    private Integer glCount;
    @ApiModelProperty("评论人数")
    private Integer ocCount;
    @ApiModelProperty("转发信息")
    private List<Forward> forwards;
    @ApiModelProperty("点赞信息")
    private List<GiveLike> giveLikes;
    @ApiModelProperty("歌单信息")
    private List<SongList> songLists;
    @ApiModelProperty("用户评论信息")
    private List<OtherComm> otherComms;
}
