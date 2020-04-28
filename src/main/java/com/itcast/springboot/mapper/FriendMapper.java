package com.itcast.springboot.mapper;

import com.itcast.springboot.bean.Friend;
import com.itcast.springboot.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendMapper {
    //增
    public Integer insertFriend(Friend friend);
    //删
    public Integer deleteFriend(Integer fid);
    //取消关注：通过用户id和好友id删除friend表对应信息
    public Integer deleteFriendByUidAndFid(@Param("userId") Integer uid, @Param("friendId") Integer friendId);

    //查
    public Friend getFriendById(Integer fid);
    //通过id查询对应好友的id和姓名
    public List<Friend> getFriendsAndNames(Integer uid);

    //改
    public Integer updateFriend(Friend friend);
}
