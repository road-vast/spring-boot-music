package com.itcast.springboot.service.impl;

import com.itcast.springboot.bean.Friend;
import com.itcast.springboot.bean.User;
import com.itcast.springboot.mapper.FriendMapper;
import com.itcast.springboot.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FriendServiceImpl implements FriendService {
    @Autowired
    FriendMapper friendMapper;
    @Override
    public Friend insertFriend(Friend friend) {
        friendMapper.insertFriend(friend);
        return friend;
    }

    @Override
    public Integer deleteFriend(Integer fid) {
        return friendMapper.deleteFriend(fid);
    }

    @Override
    public Integer deleteFriendByUidAndFid(Integer uid, Integer friendId) {
        return friendMapper.deleteFriendByUidAndFid(uid, friendId);
    }

    @Override
    public Friend getFriendById(Integer fid) {
        return friendMapper.getFriendById(fid);
    }

    @Override
    public List<Friend> getFriendsAndNames(Integer uid) {
        return friendMapper.getFriendsAndNames(uid);
    }

    @Override
    public Friend updateFriend(Friend friend) {
        friendMapper.updateFriend(friend);
        return friend;
    }
}
