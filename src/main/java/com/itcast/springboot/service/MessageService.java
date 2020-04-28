package com.itcast.springboot.service;

import com.itcast.springboot.bean.Message;
import com.itcast.springboot.mapper.MessageMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MessageService {
    //增
    public Message insertMessage(Message message);

    //删
    public Integer deleteMessage(Integer mid);

    //查
    public Message getMessageById(Integer mid);
    //根据传进来的用户id和好友id查询消息的互传详细信息
    public List<Message> getMessages(Integer uid, Integer fid);

    //改
    public Message updateMessage(Message message);
}
