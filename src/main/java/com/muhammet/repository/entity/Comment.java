package com.muhammet.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tblcomment")
@NamedQueries({
        @NamedQuery(name = "Comment.findByTweetId",
                query = "SELECT c from Comment  c where c.tweetid = :tweetid")
})
public class Comment  extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long tweetid;
    /**
     * Tweet için yapılan yorum id
     */
    Long commentid;
    /**
     * Tweet e ya da Yorum yapan Başka bir kişiye yorum yapan kişi
     */
    Long userid;
    @Column(length = 280)
    String comment;
    Long commentdate;

}
