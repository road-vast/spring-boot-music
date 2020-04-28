package com.itcast.springboot.mapper;

import com.itcast.springboot.bean.GiveLike;
import com.itcast.springboot.bean.OtherComm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OtherCommMapper {
    //增
    public Integer insertOtherComm(OtherComm otherComm);
    //删
    public Integer deleteOtherComm(Integer ocid);
    //查
    public OtherComm getOtherCommById(Integer ocid);
    //多个count查询：多个用户动态id查询对应评论人数
    public List<Integer> getOtherCommNumsByUserDynaIds(@Param("userdynasId") List<Integer> udids);
    //级联查询：多个用户动态id查询评论信息和评论用户信息
    public List<OtherComm> getOtherCommsAndUsersByUserDynasId(@Param("userdynasId") List<Integer> udids);
    //多个用户动态id查询评论详细信息
    public List<OtherComm> getOtherCommsAndNamesByIds(@Param("userdynaIds") List<Integer> udids);
    //级联查询：查询用户评论对应的回复详细信息
    public List<OtherComm> getOtherCommsAndReplyCommsByUserDynasIds(@Param("userdynaIds") List<Integer> udids);

    //改
    public Integer updateOtherComm(OtherComm otherComm);
}
