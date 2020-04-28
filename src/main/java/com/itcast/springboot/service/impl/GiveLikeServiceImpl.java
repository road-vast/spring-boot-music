package com.itcast.springboot.service.impl;

import com.itcast.springboot.bean.GiveLike;
import com.itcast.springboot.mapper.GiveLikeMapper;
import com.itcast.springboot.service.GiveLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//对抛出的任何异常都进行自动回滚
@Transactional(rollbackFor = Exception.class)
public class GiveLikeServiceImpl implements GiveLikeService {

    @Autowired
    GiveLikeMapper givelikeMapper;

    @Override
    public GiveLike insertLike(GiveLike like) {
        givelikeMapper.insertLike(like);
        return like;
    }

    @Override
    public Integer deleteLike(Integer lid) {
        return givelikeMapper.deleteLike(lid);
    }

    @Override
    public GiveLike getLikeById(Integer lid) {
        return givelikeMapper.getLikeById(lid);
    }

    @Override
    public List<Integer> getLikeNumsByUserDynaIds(List<Integer> udids) {
        return givelikeMapper.getLikeNumsByUserDynasId(udids);
    }

    @Override
    public List<GiveLike> getLikesAndUsersByUserDynasId(List<Integer> udids) {
        return givelikeMapper.getLikesAndUsersByUserDynasId(udids);
    }

    @Override
    public List<GiveLike> getGiveLikesAndNamesByIds(List<Integer> udids) {
        return givelikeMapper.getGiveLikesAndNamesByIds(udids);
    }

    @Override
    public GiveLike updateLike(GiveLike like) {
        givelikeMapper.updateLike(like);
        return like;
    }
}
