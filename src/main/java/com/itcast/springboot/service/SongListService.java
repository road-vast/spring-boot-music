package com.itcast.springboot.service;

import com.itcast.springboot.bean.SongList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SongListService {
    //增
    public SongList insertSongList(SongList songList);

    //删
    public Integer deleteSongList(Integer slid);

    //查
    public SongList getSongListById(Integer slid);
    //in查询，查询多首歌曲信息
    public List<SongList> getSongListsByIds(List<Integer> slids);
    //根据用户的听歌类型随机抽取出20首歌曲
    public List<SongList> getSongListsRand(List<Integer> sts);

    //改
    public SongList updateSongList(SongList songList);
}
