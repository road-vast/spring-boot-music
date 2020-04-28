package com.itcast.springboot.service;

import com.itcast.springboot.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserService {
    //增
    public User insertUser(User user);
    //实现批量插入
    public Integer insertUsers(List<User> users);

    //删
    public Integer deleteUser(Integer uid);
    //查
    //通过id查询
    public User getUserById(Integer uid);
    //查询所有
    public List<User> getUsers();
    //通过id查询user和userDyna
    public User getUserAndDynaById(Integer uid);
    //使用分步查询和延迟查询实现查询user，按是否需要查询userDyna
    public User getUserAndDynaByIdStep(Integer uid);
    //通过id查询出user和对应的friends列表
    public User getUserAndFriendsById(Integer uid);
    //使用分页查询查询所有
    public List<User> getUsersPage(int pageNum, int pageSize, int navigatepage);
    //in查询：多个id获取多个用户信息
    public List<User> getUsersByIds(List<Integer> uids);

    //改
    public User updateUser(User user);

}
