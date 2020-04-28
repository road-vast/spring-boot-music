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
 * 其他用户评论表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户评论")
public class OtherComm {
    @ApiModelProperty("用户评论id")
    private Integer ocid;
    @ApiModelProperty("用户评论内容")
    private String commCon;
    @ApiModelProperty("用户动态id")
    private Integer userdynaId;
    @ApiModelProperty("评论人id")
    private Integer ocUserId;
    @ApiModelProperty("评论人用户名")
    private String ocUsername;
    @ApiModelProperty("被评论人id")
    private Integer userId;
    @ApiModelProperty("被评论人用户名")
    private String username;
    @ApiModelProperty("评论时间")
    //入参格式化
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //出参格式化
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date ocdate;
    @ApiModelProperty("用户评论")
    private List<ReplyComm> replyComms;

    @ApiModelProperty("用户信息")
    private List<User> users;
}
