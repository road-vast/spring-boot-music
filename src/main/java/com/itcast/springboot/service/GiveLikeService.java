package com.itcast.springboot.service;

import com.itcast.springboot.bean.GiveLike;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GiveLikeService {
    //增
    public GiveLike insertLike(GiveLike like);
    //删
    public Integer deleteLike(Integer lid);
    //查
    public GiveLike getLikeById(Integer lid);
    //多个count查询：多个用户动态id查询对应点赞人数
    public List<Integer> getLikeNumsByUserDynaIds(List<Integer> udids);
    //级联查询：多个用户动态id查询点赞用户信息
    public List<GiveLike> getLikesAndUsersByUserDynasId(List<Integer> udids);
    //多个用户动态id获取点赞详细信息
    public List<GiveLike> getGiveLikesAndNamesByIds(List<Integer> udids);

    //改
    public GiveLike updateLike(GiveLike like);
}
