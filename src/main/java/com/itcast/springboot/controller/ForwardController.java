package com.itcast.springboot.controller;

import com.itcast.springboot.bean.Forward;
import com.itcast.springboot.service.ForwardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "转发相关的请求")
@RestController
public class ForwardController {

    @Autowired
    ForwardService forwardService;

    //通过id查询
    @ApiOperation("通过id查询转发信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fwid", value = "转发id")
    })
    @GetMapping("/forward/{fwid}")
    public Forward getForward(@PathVariable("fwid") Integer fwid){
        return forwardService.getForward(fwid);
    }

    //count查询：通过用户动态id获取被转发的次数
    @ApiOperation("count查询：通过用户动态id获取被转发的次数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "udid", value = "用户动态id")
    })
    @GetMapping("/forwardCount/{udid}")
    public Integer getCountByUserDynaId(@PathVariable("udid") Integer udid){
        return forwardService.getCountByUserDynaId(udid);
    }
    //多个count查询：多个用户动态id查询被转发的次数
    @ApiOperation("多个count查询：多个用户动态id查询被转发的次数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "udids", value = "多个用户动态id")
    })
    @GetMapping("/forwardCounts/{udids}")
    public List<Integer> getCountsByUserDynasId(@PathVariable("udids") List<Integer> udids){
        return forwardService.getCountsByUserDynasId(udids);
    }
    //级联查询：动态查询转发信息和对应用户信息
    @ApiOperation("级联查询：多个用户动态id查询对应转发信息和对应用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "udids", value = "多个用户动态id")
    })
    @GetMapping("/forwardsAndUsers/{udids}")
    public List<Forward> getForwardsAndUsersById(@PathVariable("udids") List<Integer> udids){
        return forwardService.getForwardsAndUsersById(udids);
    }
    //多个用户动态id获取对应转发信息
    @ApiOperation("多个用户动态id获取对应转发信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "udids", value = "多个用户动态id")
    })
    @GetMapping("/forwards/{udids}")
    public List<Forward> getForwardsById(@PathVariable("udids") List<Integer> udids){
        return  forwardService.getForwardsById(udids);
    }
    //查询转发信息id、用户动态id、转发人名字、转发日期
    @ApiOperation("查询转发信息id、用户动态id、转发人名字、转发日期")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "udids", value = "多个用户动态id")
    })
    @GetMapping("/forwardsAndNames/{udids}")
    public List<Forward> getForwardsAndNames(@PathVariable("udids") List<Integer> udids){
        return forwardService.getForwardsAndNames(udids);
    }

    //通过id进行删除
    @ApiOperation("通过id删除转发信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fwid", value = "转发id")
    })
    @DeleteMapping("/forward/{fwid}")
    public Integer deleteForward(@PathVariable("fwid") Integer fwid) {
        return forwardService.deleteForward(fwid);
    }

    @ApiOperation("增加转发")
    @PostMapping("/insertforward")
    public Forward insertForward(Forward forward){
        return forwardService.insertForward(forward);
    }

    @ApiOperation("更新转发")
    @PutMapping("/updateforward")
    public Forward updateForward(Forward forward){
        System.out.println(forward.toString());
        return forwardService.updateForward(forward);
    }
}
