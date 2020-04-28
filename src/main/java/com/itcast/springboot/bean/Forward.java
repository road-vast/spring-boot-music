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

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("转发")
public class Forward {
    @ApiModelProperty("转发id")
    private Integer fwid;
    @ApiModelProperty("用户动态id")
    private Integer userdynaId;
    @ApiModelProperty("用户id")
    private String username;
    @ApiModelProperty("用户名")
    private Integer userId;
    @ApiModelProperty("转发时间")
    //入参格式化
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //出参格式化
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date fwdate;
    @ApiModelProperty("用户信息")
    private List<User> users;
}
