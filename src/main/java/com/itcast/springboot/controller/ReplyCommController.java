package com.itcast.springboot.controller;

import com.itcast.springboot.bean.ReplyComm;
import com.itcast.springboot.service.ReplyCommService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "回复评论相关的请求")
@RestController
public class ReplyCommController {

    @Autowired
    ReplyCommService replyCommService;

    @ApiOperation("通过id查询回复评论信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "rcid", value = "回复评论id")
    )
    //通过id查询
    @GetMapping("/replyComm/{rcid}")
    public ReplyComm getReplyCommById(@PathVariable("rcid") Integer rcid){
        return replyCommService.getReplyCommById(rcid);
    }
    //查询回复评论具体信息
    @ApiOperation("查询回复评论具体信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "rcids", value = "多个回复评论id")
    )
    @GetMapping("replyComms/{rcids}")
    public List<ReplyComm> getReplyComms(@PathVariable("rcids") List<Integer> rcids){
        return replyCommService.getReplyComms(rcids);
    }

    //通过id进行删除
    @ApiOperation("删除评论信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "rcid", value = "回复评论id")
    )
    @DeleteMapping("/replyComm/{rcid}")
    public Integer deleteReplyComm(@PathVariable("rcid") Integer rcid) {
        return replyCommService.deleteReplyComm(rcid);
    }

    @ApiOperation("添加评论信息")
    @PostMapping("/replyComm")
    public ReplyComm insertReplyComm(ReplyComm replyComm){
        return replyCommService.insertReplyComm(replyComm);

    }

    @ApiOperation("更改评论信息")
    @PutMapping("/replyComm")
    public ReplyComm updateReplyComm(ReplyComm replyComm){
        System.out.println(replyComm.toString());
        return replyCommService.updateReplyComm(replyComm);
    }
}
