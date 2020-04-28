package com.itcast.springboot.controller;

import com.itcast.springboot.bean.GiveLike;
import com.itcast.springboot.service.GiveLikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "点赞相关的请求")
@RestController
public class GiveLikeController {

    @Autowired
    GiveLikeService likeService;

    //通过id查询
    @ApiOperation("通过id查询点赞")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "lid", value = "点赞id")
    )
    @GetMapping("/like/{lid}")
    public GiveLike getLikeById(@PathVariable("lid") Integer lid){
        return likeService.getLikeById(lid);
    }
    //多个count查询：多个用户动态id查询对应点赞数量
    @ApiOperation("多个count查询：多个用户动态id查询对应点赞数量")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "udids", value = "多个用户动态id")
    )
    @GetMapping("/likeNums/{udids}")
    public List<Integer> getLikeNumsByUserDynaIds(@PathVariable("udids") List<Integer> udids){
        return likeService.getLikeNumsByUserDynaIds(udids);
    }
    //级联查询：多个用户动态id查询对应点赞信息和点赞用户信息
    @ApiOperation("级联查询：多个用户动态id查询对应点赞信息和点赞用户信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "udids", value = "多个用户动态id")
    )
    @GetMapping("/likessAndUsers/{udids}")
    public List<GiveLike> getLikessAndUsersByUserDynasId(@PathVariable("udids") List<Integer> udids){
        return likeService.getLikesAndUsersByUserDynasId(udids);
    }
    //多个用户动态id获取点赞详细信息
    @ApiOperation("多个用户动态id获取点赞详细信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "udids", value = "多个用户动态id")
    )
    @GetMapping("/giveLikesAndNames/{udids}")
    public List<GiveLike> getGiveLikesAndNamesByIds(@PathVariable("udids") List<Integer> udids){
        return likeService.getGiveLikesAndNamesByIds(udids);
    }

    //通过id进行删除
    @ApiOperation("通过id删除点赞")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "lid", value = "点赞id")
    )
    @DeleteMapping("/like/{lid}")
    public Integer deleteLike(@PathVariable("lid") Integer lid) {
        return likeService.deleteLike(lid);
    }

    @ApiOperation("添加点赞")
    @PostMapping("/like")
    public GiveLike insertLike(GiveLike like){
        return likeService.insertLike(like);

    }

    @ApiOperation("更新点赞")
    @PutMapping("/like")
    public GiveLike updateLike(GiveLike like){
        return likeService.updateLike(like);
    }
}
