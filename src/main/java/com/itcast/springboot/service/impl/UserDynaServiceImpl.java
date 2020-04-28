package com.itcast.springboot.service.impl;

import com.itcast.springboot.bean.*;
import com.itcast.springboot.mapper.*;
import com.itcast.springboot.service.FriendService;
import com.itcast.springboot.service.UserDynaService;
import com.itcast.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
//对抛出的任何异常都进行自动回滚
@Transactional(rollbackFor = Exception.class)
public class UserDynaServiceImpl implements UserDynaService {

    @Autowired
    UserDynaMapper userDynaMapper;

    @Autowired
    ForwardMapper forwardMapper;

    @Autowired
    GiveLikeMapper giveLikeMapper;

    @Autowired
    FriendMapper friendMapper;

    @Autowired
    OtherCommMapper otherCommMapper;

    @Override
    public UserDyna insertSongList(UserDyna userDyna) {
        userDynaMapper.insertUserDyna(userDyna);
        return userDyna;
    }

    @Override
    public Integer deleteSongList(Integer udid) {
        return userDynaMapper.deleteUserDyna(udid);
    }

    @Override
    public UserDyna getSongListById(Integer udid) {
        return userDynaMapper.getUserDynaById(udid);
    }

    @Override
    public List<UserDyna> getUserDynasByIn(List<Integer> userIds) {
        return userDynaMapper.getUserDynasByIn(userIds);
    }

    @Override
    public List<UserDyna> getUserDynasByDate(String uddate) {
        return userDynaMapper.getUserDynasByDate(uddate);
    }

    //查询好友动态和各种信息
    @Override
    public List<UserDyna> getFdsAndOthers(Integer uid) {
        List<UserDyna> fds = null;
        List<Integer> fids = new ArrayList<>();
        //好友姓名
        List<String> usernames = new ArrayList<>();

        if (uid != null) {      //查询当天的所有好友动态
            //获取好友信息
            List<Friend> friendsmsg = friendMapper.getFriendsAndNames(uid);
            //是否存在好友
            if (friendsmsg.isEmpty()) {
                return null;
            }
            //封装好友的id和姓名
            for (Friend fmsg :
                    friendsmsg) {
                fids.add(fmsg.getFriendid());
                usernames.add(fmsg.getUsername());
            }
            //查询好友的动态
            fds = userDynaMapper.getUserDynasByIn(fids);
        }else{      //查询当天所有用户动态
            //查询出今天的日期
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();//得到日历的e799bee5baa6e4b893e5b19e31333335316532实例
            calendar.setTime(date);//将现在的时间赋值给Calendar对象
            int c_year = calendar.get(Calendar.YEAR);//取得年份
            int c_month = calendar.get(Calendar.MONTH)+1;//取得月份
            int c_day = calendar.get(Calendar.DAY_OF_MONTH);//取得日期
            String uddate = c_year + "-" + c_month + "-" + c_day;
            System.out.println(uddate);
            fds = userDynaMapper.getUserDynasByDate(uddate);
            for (UserDyna fd :
                    fds) {
                fids.add(fd.getUserId());
                usernames.add(fd.getUsername());
            }
        }
        if (fds.isEmpty()){
            return null;
        }
        //封装好友动态的id
        List<Integer> fdids = new ArrayList<Integer>();
        for (UserDyna fd :
                fds) {
            fdids.add(fd.getUdid());
        }
        //获取转发次数
        List<Integer> fwCounts = forwardMapper.getCountsByUserDynasId(fdids);
        //获取点赞次数
        List<Integer> glCounts = giveLikeMapper.getLikeNumsByUserDynasId(fdids);
        //获取评论人数
        List<Integer> ocCounts = otherCommMapper.getOtherCommNumsByUserDynaIds(fdids);
        //获取用户转发详细信息
        List<Forward> forwards = forwardMapper.getForwardsAndNamesByIds(fdids);
        //获取用户点赞详细信息
        List<GiveLike> giveLikes = giveLikeMapper.getGiveLikesAndNamesByIds(fdids);
        //获取用户评论详细信息
        List<OtherComm> otherComms = otherCommMapper.getOtherCommsAndReplyCommsByUserDynasIds(fdids);
        //封装到userDyna中
        for (int i = 0; i < fds.size(); i++) {
            //用户动态信息
            UserDyna fd = fds.get(i);
            //将对应的名字封装到好友动态中
            for (int j = 0; j < fids.size(); j++) {
                if (fd.getUserId() == fids.get(j)) {
                    fd.setUsername(usernames.get(j));
                }
            }
            //封装对应的转发数量
            fd.setFwCount(fwCounts.get(i));
            //封装对应的点赞数量
            fd.setGlCount(glCounts.get(i));
            //封装对应的评论人数
            fd.setOcCount(ocCounts.get(i));
            //封装一条好友动态对应的转发信息
            List<Forward> forwards1 = new ArrayList<>();
            for (int j = 0; j < forwards.size(); j++) {
                //好友动态id和转发的动态id相同
                if (forwards.get(j).getUserdynaId() == fd.getUdid()) {
                    //添加到转发队列中
                    forwards1.add(forwards.get(j));
                }
            }
            fd.setForwards(forwards1);

            //封装一条好友动态对应的点赞信息
            List<GiveLike> givelikes1 = new ArrayList<>();
            for (int j = 0; j < giveLikes.size(); j++) {
                //好友动态id和转发的动态id相同
                if (giveLikes.get(j).getUserdynaId() == fd.getUdid()) {
                    //添加到转发队列中
                    givelikes1.add(giveLikes.get(j));
                }
            }
            fd.setGiveLikes(givelikes1);

            //封装一条好友动态对应的评论信息
            List<OtherComm> otherComms1 = new ArrayList<>();
            for (int j = 0; j < otherComms.size(); j++) {
                //好友动态id和转发的动态id相同
                if (otherComms.get(j).getUserdynaId() == fd.getUdid()) {
                    //添加到转发队列中
                    otherComms1.add(otherComms.get(j));
                }
            }
            fd.setOtherComms(otherComms1);
        }
        return fds;
    }

    @Override
    public UserDyna updateSongList(UserDyna userDyna) {
        userDynaMapper.updateUserDyna(userDyna);
        return userDyna;
    }
}
