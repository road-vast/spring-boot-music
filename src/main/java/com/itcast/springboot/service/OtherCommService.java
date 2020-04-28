package com.itcast.springboot.service;

import com.itcast.springboot.bean.OtherComm;
import com.itcast.springboot.bean.UserDyna;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OtherCommService {
    //增
    public OtherComm insertOtherComm(OtherComm otherComm);
    //删
    public Integer deleteOtherComm(Integer ocid);
    //查
    public OtherComm getOtherCommById(Integer ocid);
    //多个count查询：多个用户动态id查询对应评论人数
    public List<Integer> getOtherCommNumsByUserDynaIds(List<Integer> udids);
    //级联查询：多个用户动态id查询评论信息和评论用户信息
    public List<OtherComm> getOtherCommsAndUsersByUserDynasId(List<Integer> udids);
    //多个用户动态id查询评论详细信息
    public List<OtherComm> getOtherCommsAndNamesByIds(List<Integer> udids);
    //级联查询：查询用户评论对应的回复详细信息
    public List<OtherComm> getOtherCommsAndReplyCommsByUserDynasIds(List<Integer> udids);

    //改
    public OtherComm updateOtherComm(OtherComm otherComm);
}
