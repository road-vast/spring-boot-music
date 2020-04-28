package com.itcast.springboot.controller;

import com.itcast.springboot.bean.Friend;
import com.itcast.springboot.service.FriendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "好友列表相关的请求")
@RestController
public class FriendController {

    @Autowired
    FriendService friendService;

    //通过id查询
    @ApiOperation("通过id查询好友列表")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "fid", value = "好友列表id")
    )
    @GetMapping("/friend/{fid}")
    public Friend getFriendById(@PathVariable("fid") Integer fid){
        return friendService.getFriendById(fid);
    }
    //通过id查询对应好友的id和姓名
    @ApiOperation("通过id查询对应好友的id和姓名")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "uid", value = "用户id")
    )
    @GetMapping("/friendsAndNames/{uid}")
    public List<Friend> getFriendsAndNames(Integer uid){
        return  friendService.getFriendsAndNames(uid);
    }

    //通过id进行删除
    @ApiOperation("通过id删除好友")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "fid", value = "好友列表id")
    )
    @DeleteMapping("/friend/{fid}")
    public Integer deleteFriend(@PathVariable("fid") Integer fid) {
        return friendService.deleteFriend(fid);
    }

    //取消关注：通过用户id和好友id删除friend表对应信息
    @ApiOperation("取消关注：通过用户id和好友id删除friend表对应信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id"),
            @ApiImplicitParam(name = "friendId", value = "好友id")
    })
    @DeleteMapping("/friend/{uid}/{friendId}")
    public Integer deleteFriendByUidAndFid(@PathVariable("uid") Integer uid, @PathVariable("friendId") Integer friendId){
        return  friendService.deleteFriendByUidAndFid(uid, friendId);
    }

    @ApiOperation("添加好友")
    @PostMapping("/friend")
    public Friend insertFriend(Friend friend){
        return friendService.insertFriend(friend);

    }

    @ApiOperation("更新好友列表")
    @PutMapping("/friend")
    public Friend updateFriend(Friend friend){
        return friendService.updateFriend(friend);
    }
}
