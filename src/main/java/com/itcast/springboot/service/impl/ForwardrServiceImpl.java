package com.itcast.springboot.service.impl;

import com.itcast.springboot.bean.Forward;
import com.itcast.springboot.bean.OtherComm;
import com.itcast.springboot.mapper.ForwardMapper;
import com.itcast.springboot.mapper.OtherCommMapper;
import com.itcast.springboot.service.ForwardService;
import com.itcast.springboot.service.OtherCommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//对抛出的任何异常都进行自动回滚
@Transactional(rollbackFor = Exception.class)
public class ForwardrServiceImpl implements ForwardService {

    @Autowired
    ForwardMapper forwardMapper;

    @Override
    public Forward insertForward(Forward forward) {
        forwardMapper.insertForward(forward);
        return forward;
    }

    @Override
    public Integer deleteForward(Integer fwid) {
        return forwardMapper.deleteForward(fwid);
    }

    @Override
    public Forward getForward(Integer fwid) {
        return forwardMapper.getForward(fwid);
    }

    @Override
    public Integer getCountByUserDynaId(Integer udid) {
        return forwardMapper.getCountByUserDynaId(udid);
    }

    @Override
    public List<Integer> getCountsByUserDynasId(List<Integer> udids) {
        return forwardMapper.getCountsByUserDynasId(udids);
    }

    @Override
    public List<Forward> getForwardsAndUsersById(List<Integer> udid) {
        return forwardMapper.getForwardsAndUsersById(udid);
    }

    @Override
    public List<Forward> getForwardsById(List<Integer> udids) {
        return forwardMapper.getForwardsById(udids);
    }

    @Override
    public List<Forward> getForwardsAndNames(List<Integer> udids) {
        return forwardMapper.getForwardsAndNamesByIds(udids);
    }

    @Override
    public Forward updateForward(Forward forward) {
        forwardMapper.updateForward(forward);
        return forward;
    }
}
