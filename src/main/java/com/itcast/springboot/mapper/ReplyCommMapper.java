package com.itcast.springboot.mapper;

import com.itcast.springboot.bean.OtherComm;
import com.itcast.springboot.bean.ReplyComm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyCommMapper {
    //增
    public Integer insertReplyComm(ReplyComm replyComm);
    //删
    public Integer deleteReplyComm(Integer rcid);
    //查
    public ReplyComm getReplyCommById(Integer rcid);
    //查询回复评论具体信息
    public List<ReplyComm> getReplyComms(@Param("rcids") List<Integer> rcids);

    //改
    public Integer updateReplyComm(ReplyComm replyComm);
}
