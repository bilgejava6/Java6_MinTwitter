package com.muhammet.service;

import com.muhammet.repository.TweetRepository;
import com.muhammet.repository.entity.Tweet;
import com.muhammet.utility.MyFactoryService;

public class TweetService extends MyFactoryService<TweetRepository, Tweet,Long> {
    public TweetService(){
        super(new TweetRepository());
    }
}
