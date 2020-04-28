package com.itcast.springboot.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("互传消息表")
public class Message {
    @ApiModelProperty("互传消息id")
    private Integer mid;
    @ApiModelProperty("发送用户id")
    private Integer sendUserId;
    @ApiModelProperty("发送者用户名")
    private String sendUsername;
    @ApiModelProperty("接收用户id")
    private Integer receUserId;
    @ApiModelProperty("接收者用户名")
    private String receUsername;
    @ApiModelProperty("消息内容")
    private String mConn;
    @ApiModelProperty("消息互传时间")
    //入参格式化
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //出参格式化
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date mdate;
}
