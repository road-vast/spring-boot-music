package com.itcast.springboot.controller;

import com.itcast.springboot.bean.SongList;
import com.itcast.springboot.service.SongListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "歌单列表相关的请求")
@RestController
public class SongListController {

    @Autowired
    SongListService songListService;

    //通过id查询
    @ApiOperation("通过id查询歌单信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "slid", value = "歌单id")
    )
    @GetMapping("/songlist/{slid}")
    public SongList getSongListById(@PathVariable("slid") Integer slid){
        SongList songList = songListService.getSongListById(slid);
        return songList;
    }
    //in查询，查询多首歌曲信息
    @ApiOperation("in查询，查询多首歌曲信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "slids", value = "多个歌单id")
    )
    @GetMapping("/songlists/{slids}")
    public List<SongList> getSongListsByIds(@PathVariable("slids") List<Integer> slids){
        return songListService.getSongListsByIds(slids);
    }
    //根据用户的听歌类型随机抽取出20首歌曲
    @ApiOperation("根据用户的听歌类型随机抽取出20首歌曲")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "sts", value = "多个歌曲类型")
    )
    @GetMapping("/songListsRand/{sts}")
    public List<SongList> getSongListsRand(@PathVariable("sts") List<Integer> sts){
        return songListService.getSongListsRand(sts);
    }


    @ApiOperation("通过id删除歌单")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "slid", value = "歌单id")
    )
    //通过id进行删除
    @DeleteMapping("/songlist/{slid}")
    public Integer deleteSongList(@PathVariable("slid") Integer slid) {
        Integer result = songListService.deleteSongList(slid);
        return result;
    }

    @ApiOperation("增加歌单")
    @PostMapping("/songlist")
    public SongList insertSongList(SongList songList){
        SongList result = songListService.insertSongList(songList);
        return result;
    }

    @ApiOperation("修改歌单")
    @PutMapping("/songlist")
    public SongList updateSongList(SongList songList){
        System.out.println(songList.toString());
        songListService.updateSongList(songList);
        return songList;
    }
}
