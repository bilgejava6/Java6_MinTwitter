package com.muhammet.repository;

import com.muhammet.repository.entity.Comment;
import com.muhammet.utility.MyFactoryRepository;

public class CommentRepository extends MyFactoryRepository<Comment,Long> {
    public CommentRepository(){
        super(new Comment());
    }
}
