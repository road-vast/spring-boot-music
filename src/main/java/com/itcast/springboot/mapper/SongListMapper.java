package com.itcast.springboot.mapper;

import com.itcast.springboot.bean.SongList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SongListMapper {
    //增
    public Integer insertSongList(SongList songList);
    //删
    public Integer deleteSongList(Integer slid);
    //查
    public SongList getSongListById(Integer slid);
    //根据用户的听歌类型随机抽取出20首歌曲
    public List<SongList> getSongListsRand(@Param("songTypes") List<Integer> sts);

    //in查询，查询多首歌曲信息
    public List<SongList> getSongListsByIds(@Param("slids") List<Integer> slids);

    //改
    public Integer updateSongList(SongList songList);
}
