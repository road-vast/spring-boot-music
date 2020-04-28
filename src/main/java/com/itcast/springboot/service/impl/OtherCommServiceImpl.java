package com.itcast.springboot.service.impl;

import com.itcast.springboot.bean.OtherComm;
import com.itcast.springboot.mapper.OtherCommMapper;
import com.itcast.springboot.service.OtherCommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//对抛出的任何异常都进行自动回滚
@Transactional(rollbackFor = Exception.class)
public class OtherCommServiceImpl implements OtherCommService {

    @Autowired
    OtherCommMapper otherCommMapper;


    @Override
    public OtherComm insertOtherComm(OtherComm otherComm) {
        otherCommMapper.insertOtherComm(otherComm);
        return otherComm;
    }

    @Override
    public Integer deleteOtherComm(Integer ocid) {
        return otherCommMapper.deleteOtherComm(ocid);
    }

    @Override
    public OtherComm getOtherCommById(Integer ocid) {
        return otherCommMapper.getOtherCommById(ocid);
    }

    @Override
    public List<Integer> getOtherCommNumsByUserDynaIds(List<Integer> udids) {
        return otherCommMapper.getOtherCommNumsByUserDynaIds(udids);
    }

    @Override
    public List<OtherComm> getOtherCommsAndUsersByUserDynasId(List<Integer> udids) {
        return otherCommMapper.getOtherCommsAndUsersByUserDynasId(udids);
    }

    @Override
    public List<OtherComm> getOtherCommsAndNamesByIds(List<Integer> udids) {
        return otherCommMapper.getOtherCommsAndNamesByIds(udids);
    }

    @Override
    public List<OtherComm> getOtherCommsAndReplyCommsByUserDynasIds(List<Integer> udids) {
        return otherCommMapper.getOtherCommsAndReplyCommsByUserDynasIds(udids);
    }

    @Override
    public OtherComm updateOtherComm(OtherComm otherComm) {
        otherCommMapper.updateOtherComm(otherComm);
        return otherComm;
    }
}
