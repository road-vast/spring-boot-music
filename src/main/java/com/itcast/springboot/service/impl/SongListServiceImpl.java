package com.itcast.springboot.service.impl;

import com.itcast.springboot.bean.SongList;
import com.itcast.springboot.bean.User;
import com.itcast.springboot.mapper.SongListMapper;
import com.itcast.springboot.mapper.UserMapper;
import com.itcast.springboot.service.SongListService;
import com.itcast.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//对抛出的任何异常都进行自动回滚
@Transactional(rollbackFor = Exception.class)
public class SongListServiceImpl implements SongListService {

    @Autowired
    SongListMapper songListMapper;

    @Override
    public SongList getSongListById(Integer slid) {
        SongList songList = songListMapper.getSongListById(slid);
        return songList;
    }

    @Override
    public List<SongList> getSongListsByIds(List<Integer> slids) {
        return songListMapper.getSongListsByIds(slids);
    }

    @Override
    public List<SongList> getSongListsRand(List<Integer> sts) {
        return songListMapper.getSongListsRand(sts);
    }

    @Override
    public Integer deleteSongList(Integer slid) {
        Integer result = songListMapper.deleteSongList(slid);
        return result;
    }

    @Override
    public SongList insertSongList(SongList songList) {
        songListMapper.insertSongList(songList);
        return songList;
    }

    @Override
    public SongList updateSongList(SongList songList) {
        songListMapper.updateSongList(songList);
        return songList;
    }
}
