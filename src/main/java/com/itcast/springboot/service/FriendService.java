package com.itcast.springboot.service;

import com.itcast.springboot.bean.Friend;
import com.itcast.springboot.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FriendService {
    //增
    public Friend insertFriend(Friend friend);

    //删
    public Integer deleteFriend(Integer fid);
    //取消关注：通过用户id和好友id删除friend表对应信息
    public Integer deleteFriendByUidAndFid(Integer uid, Integer friendId);

    //查
    public Friend getFriendById(Integer fid);
    //通过id查询对应好友的id和姓名
    public List<Friend> getFriendsAndNames(Integer uid);

    //改
    public Friend updateFriend(Friend friend);
}
