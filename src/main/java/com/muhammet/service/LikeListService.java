package com.muhammet.service;

import com.muhammet.repository.LikeListRepository;
import com.muhammet.repository.entity.LikeList;
import com.muhammet.utility.MyFactoryService;

public class LikeListService extends MyFactoryService<LikeListRepository, LikeList,Long> {
    public LikeListService(){
        super(new LikeListRepository());
    }
}
