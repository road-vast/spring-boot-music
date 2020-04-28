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
@ApiModel("好友列表")
public class Friend {
    @ApiModelProperty("好友列表id")
    private Integer fid;
    @ApiModelProperty("用户id")
    private Integer userId;
    @ApiModelProperty("好友id")
    private Integer friendid;
    @ApiModelProperty("好友名")
    private String username;

    @ApiModelProperty("用户动态id")
    private List<UserDyna> userDynas;
}
