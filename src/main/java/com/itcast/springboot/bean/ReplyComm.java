package com.itcast.springboot.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 回复评论表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("回复评论")
public class ReplyComm {
    @ApiModelProperty("回复评论id")
    private Integer rcid;
    @ApiModelProperty("回复用户id")
    private Integer rcUserId;
    @ApiModelProperty("回复人用户名")
    private String rcUserName;
    @ApiModelProperty("对应评论id")
    private Integer othercommId;
    @ApiModelProperty("被回复用户id")
    private Integer userId;
    @ApiModelProperty("被回复人用户名")
    private String userName;
    @ApiModelProperty("回复内容")
    private String rcCon;
    @ApiModelProperty("回复日期")
    //入参格式化
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //出参格式化
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date rcDate;
}
