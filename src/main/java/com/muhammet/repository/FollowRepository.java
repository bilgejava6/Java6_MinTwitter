package com.muhammet.repository;

import com.muhammet.repository.entity.Follow;
import com.muhammet.utility.MyFactoryRepository;

public class FollowRepository extends MyFactoryRepository<Follow,Long> {
    public FollowRepository(){
        super(new Follow());
    }
}
