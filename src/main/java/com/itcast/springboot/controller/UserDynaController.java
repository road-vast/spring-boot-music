package com.itcast.springboot.controller;

import com.itcast.springboot.bean.SongList;
import com.itcast.springboot.bean.UserDyna;
import com.itcast.springboot.mapper.UserDynaMapper;
import com.itcast.springboot.service.SongListService;
import com.itcast.springboot.service.UserDynaService;
import com.itcast.springboot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Api(tags = "用户动态相关的请求")
@RestController
public class UserDynaController {

    @Autowired
    UserDynaService userDynaService;

    //通过id查询
    @ApiOperation("通过id查询用户动态")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "udid", value = "用户动态id")
    )
    @GetMapping("/userdyna/{udid}")
    public UserDyna getSongListById(@PathVariable("udid") Integer udid){
        UserDyna userDyna = userDynaService.getSongListById(udid);
        return userDyna;
    }
    //in查询：通过用户id动态查询用户动态信息
    @ApiOperation("in查询：通过用户id动态查询用户动态信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "userIds", value = "多个用户id")
    )
    @GetMapping("/userdynas/{userIds}")
    public List<UserDyna> getUserDynasByIn(@PathVariable("userIds") List<Integer> userIds){
        return userDynaService.getUserDynasByIn(userIds);
    }
    //通过日期查询出所有的动态信息
    @ApiOperation("通过日期查询出所有的动态信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "uddate", value = "用户动态时间")
    )
    @GetMapping("/userdynas/uddate/{uddate}")
    public List<UserDyna> getUserDynasByDate(@PathVariable("uddate") String uddate){
        return userDynaService.getUserDynasByDate(uddate);
    }
    //查询好友动态和其他详细信息
    @ApiOperation("通过用户id查询好友动态和各种信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "uid", value = "用户id")
    )
    @GetMapping("/FdsAndOthers/{uid}")
    public List<UserDyna> getFdsAndOthers(@PathVariable("uid") Integer uid){
        return userDynaService.getFdsAndOthers(uid);
    }

    //查询查询当天所有用户动态和其他详细信息
    @ApiOperation("查询当天所有用户动态和其他详细信息")
    @GetMapping("/AlldsAndOthers")
    public List<UserDyna> getFdsAndOthers(){
        Integer uid = null;
        return userDynaService.getFdsAndOthers(uid);
    }

    //通过id进行删除
    @ApiOperation("通过id删除用户动态")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "udid", value = "用户动态id")
    )
    @DeleteMapping("/userdyna/{udid}")
    public Integer deleteSongList(@PathVariable("udid") Integer udid) {
        Integer result = userDynaService.deleteSongList(udid);
        return result;
    }

    @ApiOperation("增加用户动态")
    @PostMapping("/userdyna")
    public UserDyna insertuUserdDyna(UserDyna userDyna){
        UserDyna result = userDynaService.insertSongList(userDyna);
        return result;
    }

    @ApiOperation("更改用户动态")
    @PutMapping("/userdyna")
    public UserDyna updateUserDyna(UserDyna userDyna){
        System.out.println(userDyna.toString());
        userDynaService.updateSongList(userDyna);
        return userDyna;
    }
}
