package com.muhammet.service;

import com.muhammet.repository.CommentRepository;
import com.muhammet.repository.entity.Comment;
import com.muhammet.utility.MyFactoryService;

public class CommentService extends MyFactoryService<CommentRepository, Comment,Long> {
    public CommentService(){
        super(new CommentRepository());
    }
}
