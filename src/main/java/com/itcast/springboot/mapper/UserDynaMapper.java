package com.itcast.springboot.mapper;

import com.itcast.springboot.bean.UserDyna;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDynaMapper {
    //增
    public Integer insertUserDyna(UserDyna userDyna);

    //删
    public Integer deleteUserDyna(Integer udid);

    //查
    public UserDyna getUserDynaById(Integer udid);
    //通过userId查询
    //通过级联查询获取用户动态和对应的用户评论内容
    public UserDyna getUserDynaByUserId(Integer userId);
    //in查询：查询好友动态详细信息
    public List<UserDyna> getUserDynasByIn(@Param("userIds") List<Integer> userIds);
    //通过日期查询出所有的动态信息
    public List<UserDyna> getUserDynasByDate(String uddate);

    //改
    public Integer updateUserDyna(UserDyna userDyna);
}
