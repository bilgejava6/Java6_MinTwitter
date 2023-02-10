package com.muhammet.repository;

import com.muhammet.repository.entity.Comment;
import com.muhammet.utility.MyFactoryRepository;

import javax.persistence.TypedQuery;
import java.util.List;

public class CommentRepository extends MyFactoryRepository<Comment,Long> {
    public CommentRepository(){
        super(new Comment());
    }

    public List<Comment> findByTweetId(Long tweetId){
        TypedQuery<Comment> typedQuery = getEntityManager()
                .createNamedQuery("Comment.findByTweetId", Comment.class);
        typedQuery.setParameter("tweetid",tweetId);
        return typedQuery.getResultList();
    }
}
