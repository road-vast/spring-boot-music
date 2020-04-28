package com.itcast.springboot.service;

import com.itcast.springboot.bean.Forward;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ForwardService {
    //增
    public Forward insertForward(Forward forward);
    //删
    public Integer deleteForward(Integer fwid);
    //查
    public Forward getForward(Integer fwid);
    //count查询：通过用户动态id查询被转发的数量
    public Integer getCountByUserDynaId(Integer udid);
    //多个count查询：多个用户动态id查询被转发的次数
    public List<Integer> getCountsByUserDynasId(List<Integer> udids);
    //级联查询：动态查询转发信息和对应用户信息
    public List<Forward> getForwardsAndUsersById(List<Integer> udid);
    //多个用户动态id获取对应转发信息
    public List<Forward> getForwardsById(List<Integer> udids);
    //查询转发信息id、用户动态id、转发人名字、转发日期
    public List<Forward> getForwardsAndNames(List<Integer> udids);

    //改
    public Forward updateForward(Forward forward);
}
