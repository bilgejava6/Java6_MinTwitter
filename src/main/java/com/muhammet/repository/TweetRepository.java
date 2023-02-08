package com.muhammet.repository;

import com.muhammet.repository.entity.Tweet;
import com.muhammet.utility.MyFactoryRepository;

public class TweetRepository extends MyFactoryRepository<Tweet,Long> {
    public TweetRepository(){
        super(new Tweet());
    }
}
