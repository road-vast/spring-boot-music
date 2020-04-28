package com.itcast.springboot.mapper;

import com.itcast.springboot.bean.Forward;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForwardMapper {
    //增
    public Integer insertForward(Forward forward);
    //删
    public Integer deleteForward(Integer fwid);
    //查
    public Forward getForward(Integer fwid);
    //count查询：通过用户动态id查询被转发的数量
    public Integer getCountByUserDynaId(@Param("userdynaId") Integer udid);
    //多个count查询：多个用户动态id查询被转发的次数
    public List<Integer> getCountsByUserDynasId(@Param("userdynasId") List<Integer> udids);
    //级联查询：多个用户动态id查询对应转发信息和对应用户信息
    public List<Forward> getForwardsAndUsersById(@Param("userdynaIds") List<Integer> udids);
    //多个用户动态id获取对应转发信息
    public List<Forward> getForwardsById(@Param("userdynaIds") List<Integer> udids);
    //查询转发信息id、用户动态id、转发人名字、转发日期
    public List<Forward> getForwardsAndNamesByIds(@Param("userdynaIds") List<Integer> udids);

    //改
    public Integer updateForward(Forward forward);
}
