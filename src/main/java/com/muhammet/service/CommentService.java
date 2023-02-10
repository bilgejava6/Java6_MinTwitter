package com.muhammet.service;

import com.muhammet.repository.CommentRepository;
import com.muhammet.repository.entity.Comment;
import com.muhammet.utility.MyFactoryService;

import java.util.List;

public class CommentService extends MyFactoryService<CommentRepository, Comment,Long> {
    public CommentService(){
        super(new CommentRepository());
    }

    public List<Comment> findByTweetId(Long tweetId){
        return getRepository().findByTweetId(tweetId);
    }
}
