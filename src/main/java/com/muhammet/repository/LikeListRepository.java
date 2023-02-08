package com.muhammet.repository;

import com.muhammet.repository.entity.LikeList;
import com.muhammet.utility.MyFactoryRepository;

public class LikeListRepository extends MyFactoryRepository<LikeList,Long> {
    public LikeListRepository(){
        super(new LikeList());
    }
}
