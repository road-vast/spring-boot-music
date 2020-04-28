package com.itcast.springboot.service.impl;

import com.itcast.springboot.bean.OtherComm;
import com.itcast.springboot.bean.ReplyComm;
import com.itcast.springboot.mapper.OtherCommMapper;
import com.itcast.springboot.mapper.ReplyCommMapper;
import com.itcast.springboot.service.OtherCommService;
import com.itcast.springboot.service.ReplyCommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//对抛出的任何异常都进行自动回滚
@Transactional(rollbackFor = Exception.class)
public class ReplyCommServiceImpl implements ReplyCommService {

    @Autowired
    ReplyCommMapper replyCommMapper;

    @Override
    public ReplyComm insertReplyComm(ReplyComm replyComm) {
        replyCommMapper.insertReplyComm(replyComm);
        return replyComm;
    }

    @Override
    public Integer deleteReplyComm(Integer rcid) {
        return replyCommMapper.deleteReplyComm(rcid);
    }

    @Override
    public ReplyComm getReplyCommById(Integer rcid) {
        return replyCommMapper.getReplyCommById(rcid);
    }

    @Override
    public List<ReplyComm> getReplyComms(List<Integer> rcids) {
        return replyCommMapper.getReplyComms(rcids);
    }

    @Override
    public ReplyComm updateReplyComm(ReplyComm replyComm) {
        replyCommMapper.updateReplyComm(replyComm);
        return replyComm;
    }
}
