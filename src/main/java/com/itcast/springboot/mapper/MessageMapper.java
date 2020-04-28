package com.itcast.springboot.mapper;

import com.itcast.springboot.bean.Message;
import com.itcast.springboot.bean.OtherComm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {
    //增
    public Integer insertMessage(Message message);
    //删
    public Integer deleteMessage(Integer mid);
    //查
    public Message getMessageById(Integer mid);
    //根据传进来的用户id和好友id查询消息的互传详细信息
    public List<Message> getMessages(@Param("uid")Integer uid, @Param("friendId") Integer fid);

    //改
    public Integer updateMessage(Message message);
}
