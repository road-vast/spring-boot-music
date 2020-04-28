package com.itcast.springboot.controller;

import com.itcast.springboot.bean.OtherComm;
import com.itcast.springboot.bean.UserDyna;
import com.itcast.springboot.service.OtherCommService;
import com.itcast.springboot.service.UserDynaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户评论相关的请求")
@RestController
public class OtherCommController {

    @Autowired
    OtherCommService otherCommService;

    //通过id查询
    @ApiOperation("通过id查询用户评论")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "ocid", value = "用户评论id")
    )
    @GetMapping("/othercomm/{ocid}")
    public OtherComm getOtherCommById(@PathVariable("ocid") Integer ocid){
        return otherCommService.getOtherCommById(ocid);
    }
    //多个count查询：多个用户动态id查询对应评论人数
    @ApiOperation("多个count查询：多个用户动态id查询对应评论人数")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "udids", value = "多个用户动态id")
    )
    @GetMapping("/othercommNums/{udids}")
    public List<Integer> getOtherCommNumsByUserDynaIds(@PathVariable("udids") List<Integer> udids){
        return otherCommService.getOtherCommNumsByUserDynaIds(udids);
    }
    //级联查询：多个用户动态id查询对应评论信息和评论用户信息
    @ApiOperation("级联查询：多个用户动态id查询对应评论信息和评论用户信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "udids", value = "多个用户动态id")
    )
    @GetMapping("/othercommsAndUsers/{udids}")
    public List<OtherComm> getOtherCommsAndUsersByUserDynasId(@PathVariable("udids") List<Integer> udids){
        return otherCommService.getOtherCommsAndUsersByUserDynasId(udids);
    }
    //多个用户动态id查询评论详细信息
    @ApiOperation("多个用户动态id查询评论详细信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "udids", value = "多个用户动态id")
    )
    @GetMapping("/otherCommsAndNames/{udids}")
    public List<OtherComm> getOtherCommsAndNamesByIds(@PathVariable("udids") List<Integer> udids){
        return otherCommService.getOtherCommsAndNamesByIds(udids);
    }
    //级联查询：查询用户评论对应的回复详细信息
    @ApiOperation("级联查询：查询用户评论对应的回复详细信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "udids", value = "多个用户动态id")
    )
    @GetMapping("/otherCommsAndReplyComms/{udids}")
    public List<OtherComm> getOtherCommsAndReplyCommsByUserDynasIds(@PathVariable("udids") List<Integer> udids){
        return otherCommService.getOtherCommsAndReplyCommsByUserDynasIds(udids);
    }


    //通过id进行删除
    @ApiOperation("通过id删除用户评论")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "ocid", value = "用户评论id")
    )
    @DeleteMapping("/othercomm/{ocid}")
    public Integer deleteOtherComm(@PathVariable("ocid") Integer ocid) {
        return otherCommService.deleteOtherComm(ocid);
    }

    @ApiOperation("添加用户评论")
    @PostMapping("/othercomm")
    public OtherComm insertOtherComm(OtherComm otherComm){
        return otherCommService.insertOtherComm(otherComm);

    }

    @ApiOperation("更新用户评论")
    @PutMapping("/othercomm")
    public OtherComm updateOtherComm(OtherComm otherComm){
        System.out.println(otherComm.toString());
        return otherCommService.updateOtherComm(otherComm);
    }
}
