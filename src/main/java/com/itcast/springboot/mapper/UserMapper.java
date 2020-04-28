package com.itcast.springboot.mapper;

import com.itcast.springboot.bean.User;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    //增
    public Integer insertUser(User user);
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
    //通过id查询出user和对应的friends列表
    public User getUserAndFriendsById(Integer uid);
    //使用分步查询和延迟查询实现查询user，按是否需要查询userDyna
    public User getUserAndDynaByIdStep(Integer uid);
    //使用分步查询和延迟查询实现查询users，按是否需要查询userDyna
    public List<User> getUsersAndDynaByIds(@Param("uids") List<Integer> uids);
    //使用分页查询查询所有
    public List<User> getUsersPage();
    //in查询：多个id获取多个用户信息
    public List<User> getUsersByIds(@Param("uids") List<Integer> uids);

    //改
    public Integer updateUser(User user);
}
