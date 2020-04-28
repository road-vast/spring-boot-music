package com.itcast.springboot.service.impl;

import com.itcast.springboot.bean.Message;
import com.itcast.springboot.mapper.MessageMapper;
import com.itcast.springboot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;

    @Override
    public Message insertMessage(Message message) {
        messageMapper.insertMessage(message);
        return message;
    }

    @Override
    public Integer deleteMessage(Integer mid) {
        return messageMapper.deleteMessage(mid);
    }

    @Override
    public Message getMessageById(Integer mid) {
        return messageMapper.getMessageById(mid);
    }

    @Override
    public List<Message> getMessages(Integer uid, Integer fid) {
        return messageMapper.getMessages(uid, fid);
    }

    @Override
    public Message updateMessage(Message message) {
        messageMapper.updateMessage(message);
        return message;
    }
}
