package com.itcast.springboot.controller;

import com.itcast.springboot.bean.User;
import com.itcast.springboot.bean.UserDyna;
import com.itcast.springboot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 在参数前面加上一个@RequestBody,表示传进来的是一个json数据
 */
@Api(tags = "用户相关的请求")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    //查
    //通过id查询
    //对方法中参数进行设置
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id")
    })
    //对方法取别名
    @ApiOperation("通过id获取用户信息")
    @GetMapping("/user/{uid}")
    public User getUserById(@PathVariable("uid") Integer uid){
        User user = userService.getUserById(uid);
        return user;
    }
    //查询所有
    @ApiOperation("获取所有用户信息")
    @GetMapping("/users")
    public List<User> getUsers() throws IOException {
        List<User> users = userService.getUsers();
        return users;
    }
    //级联查询：通过id查询user和userDyna
    @ApiOperation("级联查询：获取用户和对应用户动态信息")
    @GetMapping("userAndDyna/{uid}")
    public User getUserAndDynaById(@PathVariable("uid") Integer uid){
        return userService.getUserAndDynaById(uid);
    }

    //通过id查询出user和对应的friends表
    @ApiOperation("级联查询：获取用户和对应friends表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id")
    })
    @GetMapping("/userAndFriends/{uid}")
    public User getUserAndFriendsById(@PathVariable("uid") Integer uid){
        return userService.getUserAndFriendsById(uid);
    }

    //分步查询：使用分步查询和延迟查询实现查询user，按是否需要查询userDyna
    @ApiOperation("分步查询：获取用户和用户动态信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id"),
    })
    @GetMapping("userAndDynaByStep/{uid}")
    public String getUserAndDynaByIdStep(@PathVariable("uid") Integer uid){
        //得到的不是一个User对象
        User user = userService.getUserAndDynaByIdStep(uid);
        System.out.println(user.getClass());
        List<UserDyna> userDynas = userService.getUserAndDynaByIdStep(uid).getUserDynas();
        System.out.println(userDynas);
        return user.toString();
    }

    //使用分页查询查询所有
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数"),
            @ApiImplicitParam(name = "navigatepage", value = "连续显示的页码")
    })
    @ApiOperation("分页查询：获取部分用户信息")
    @GetMapping("/usersPage/{pageNum}/{pageSize}/{navigatepage}")
    public List<User> getUsersPage(@PathVariable("pageNum") Integer pageNum,
                                   @PathVariable("pageSize") Integer pageSize,
                                   @PathVariable("navigatepage") Integer navigatepage){
        //当前页码
//        int pageNum = 3;
        //每页记录数
//        int pageSize = 5;
        //连续显示的页码
//        int navigatepage = 5;
        List<User> users = userService.getUsersPage(pageNum, pageSize, navigatepage);
        return users;
    }
    //in查询：多个id获取多个用户信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uids", value = "多个用户id")
    })
    @ApiOperation("in查询：多个id获取多个用户信息")
    @GetMapping("/users/{uids}")
    public List<User> getUsersByIds(@PathVariable("uids") List<Integer> uids){
        return userService.getUsersByIds(uids);
    }

    //通过id进行删除
    @ApiOperation("通过id删除用户")
    @DeleteMapping("/user/{uid}")
    public Integer deleteUser(@PathVariable("uid") Integer uid) {
        Integer result = userService.deleteUser(uid);
        return result;
    }

    //增
    @ApiOperation("增加用户")
    @PostMapping("/user")
    public User insertUser(@RequestBody User user){
        User result = userService.insertUser(user);
        return result;
    }
    //实现批量插入
    @ApiOperation("批量增加用户")
    @PostMapping("/users")
    public Integer insertUsers(@RequestBody List<User> users){
        User user1 = new User(null, "王五", "sessionKey",
                "avatarUrl", 1, "中国", "广东", "汕尾","zh_CN");
        User user2 = new User(null, "赵六", "sessionKey",
                "avatarUrl", 1, "中国", "广东", "汕头","zh_CN");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        return userService.insertUsers(list);
    }
    //改
    @ApiOperation("修改用户信息")
    @PutMapping("/user")
    public User updateUser(@RequestBody User user){
        System.out.println(user.toString());
        userService.updateUser(user);
        return user;
    }

}
