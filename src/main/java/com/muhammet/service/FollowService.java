package com.muhammet.service;

import com.muhammet.repository.FollowRepository;
import com.muhammet.repository.entity.Follow;
import com.muhammet.utility.MyFactoryService;

public class FollowService extends MyFactoryService<FollowRepository, Follow,Long> {
    public FollowService(){
        super(new FollowRepository());
    }
}
