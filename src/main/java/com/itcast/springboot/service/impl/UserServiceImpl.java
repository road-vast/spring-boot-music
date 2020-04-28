package com.itcast.springboot.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itcast.springboot.bean.Friend;
import com.itcast.springboot.bean.User;
import com.itcast.springboot.mapper.UserMapper;
import com.itcast.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
//对抛出的任何异常都进行自动回滚
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    //增
    @Override
    public User insertUser(User user) {
        userMapper.insertUser(user);
        return user;
    }

    @Override
    public Integer insertUsers(List<User> users) {
        return userMapper.insertUsers(users);
    }

    //删
    @Override
    public Integer deleteUser(Integer uid) {
        Integer result = userMapper.deleteUser(2);
        return result;
    }
    //查
    //通过id查询
    @Override
    public User getUserById(Integer uid) {
        User user = userMapper.getUserById(uid);
        return user;
    }
    //查询所有
    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }
    //通过id查询user和userDyna
    @Override
    public User getUserAndDynaById(Integer uid) {
        return userMapper.getUserAndDynaById(uid);
    }
    //使用分步查询和延迟查询实现查询user，按是否需要查询userDyna
    @Override
    public User getUserAndDynaByIdStep(Integer uid) {
        return userMapper.getUserAndDynaByIdStep(uid);
    }

    //通过id查询出user和对应的friends列表
    @Override
    public User getUserAndFriendsById(Integer uid) {
        return userMapper.getUserAndFriendsById(uid);
    }
    //使用分页查询查询所有
    @Override
    public List<User> getUsersPage(int pageNum, int pageSize, int navigatepage) {
        //pageNum:当前页码；pageSize：每页记录数
        Page<Object> pageHelper = PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.getUsersPage();
        //第二个参数表示要连续显示多少页
        PageInfo<User> info = new PageInfo<>(users, navigatepage);
        for (User user:
             users) {
            System.out.println(user);
        }
        //连续显示的页数
        int[] nums = info.getNavigatepageNums();
        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
        //显示上一页和下一页
        System.out.println(info.getPrePage());
        System.out.println(info.getNextPage());
        return users;
    }

    @Override
    public List<User> getUsersByIds(List<Integer> uids) {
        return userMapper.getUsersByIds(uids);
    }

    //改
    @Override
    public User updateUser(User user) {
        userMapper.updateUser(user);
        return user;
    }
}
