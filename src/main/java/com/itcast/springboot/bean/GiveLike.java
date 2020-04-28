package com.itcast.springboot.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("点赞表")
public class GiveLike {
    @ApiModelProperty("点赞id")
    private Integer lid;
    @ApiModelProperty("用户动态id")
    private Integer userdynaId;
    @ApiModelProperty("用户id")
    private Integer userId;
    @ApiModelProperty("用户名")
    private  String username;

    @ApiModelProperty("用户信息")
    private List<User> users;
}
