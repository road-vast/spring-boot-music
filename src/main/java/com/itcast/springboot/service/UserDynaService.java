package com.itcast.springboot.service;

import com.itcast.springboot.bean.SongList;
import com.itcast.springboot.bean.UserDyna;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface UserDynaService {
    //增
    public UserDyna insertSongList(UserDyna userDyna);
    //删
    public Integer deleteSongList(Integer udid);
    //查
    public UserDyna getSongListById(Integer udid);
    //in查询：查询好友动态信息
    public List<UserDyna> getUserDynasByIn(List<Integer> userIds);
    //通过日期查询出所有的动态信息
    public List<UserDyna> getUserDynasByDate(String uddate);
    //查询好友动态和其他详细信息
    public List<UserDyna> getFdsAndOthers(Integer uid);

    //改
    public UserDyna updateSongList(UserDyna userDyna);
}
