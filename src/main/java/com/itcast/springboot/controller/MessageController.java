package com.itcast.springboot.controller;

import com.itcast.springboot.bean.Message;
import com.itcast.springboot.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "消息互传相关的请求")
@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    //通过id查询
    @ApiOperation("通过id查询消息内容")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "mid", value = "消息列表id")
    )
    @GetMapping("/message/{mid}")
    public Message getMessageById(@PathVariable("mid") Integer mid){
        return messageService.getMessageById(mid);
    }
    //根据传进来的用户id和好友id查询消息的互传详细信息
    @ApiOperation("根据传进来的用户id和好友id查询消息的互传详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id"),
            @ApiImplicitParam(name = "fid", value = "好友id"),
    })
    @GetMapping("/message/{uid}/{fid}")
    public List<Message> getMessages(@PathVariable("uid")Integer uid, @PathVariable("fid") Integer fid){
        return messageService.getMessages(uid, fid);
    }

    //通过id进行删除
    @ApiOperation("通过id删除消息内容")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "mid", value = "消息列表id")
    )
    @DeleteMapping("/message/{mid}")
    public Integer deleteMessage(@PathVariable("mid") Integer mid) {
        return messageService.deleteMessage(mid);
    }

    @ApiOperation("添加消息内容")
    @PostMapping("/message")
    public Message insertMessage(Message message){
        return messageService.insertMessage(message);

    }

    @ApiOperation("更新消息内容")
    @PutMapping("/message")
    public Message updateMessage(Message message){
        System.out.println(message.toString());
        return messageService.updateMessage(message);
    }
}
