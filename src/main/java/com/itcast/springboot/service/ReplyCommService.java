package com.itcast.springboot.service;

import com.itcast.springboot.bean.OtherComm;
import com.itcast.springboot.bean.ReplyComm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyCommService {
    //增
    public ReplyComm insertReplyComm(ReplyComm replyComm);
    //删
    public Integer deleteReplyComm(Integer rcid);
    //查
    public ReplyComm getReplyCommById(Integer rcid);
    //查询回复评论具体信息
    public List<ReplyComm> getReplyComms(List<Integer> rcids);

    //改
    public ReplyComm updateReplyComm(ReplyComm replyComm);
}
