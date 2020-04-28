package com.itcast.springboot.mapper;

import com.itcast.springboot.bean.Forward;
import com.itcast.springboot.bean.GiveLike;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiveLikeMapper {
    //增
    public Integer insertLike(GiveLike like);
    //删
    public Integer deleteLike(Integer lid);
    //查
    public GiveLike getLikeById(Integer lid);
    //多个count查询：多个用户动态id查询对应评论人数
    public List<Integer> getLikeNumsByUserDynasId(@Param("userdynasId") List<Integer> udids);
    //级联查询：多个用户动态id查询评论信息和评论用户信息
    public List<GiveLike> getLikesAndUsersByUserDynasId(@Param("userdynasId") List<Integer> udids);
    //多个用户动态id获取点赞详细信息
    public List<GiveLike> getGiveLikesAndNamesByIds(@Param("userdynaIds") List<Integer> udids);
    //改
    public Integer updateLike(GiveLike like);
}
