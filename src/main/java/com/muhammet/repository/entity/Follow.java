package com.muhammet.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/**
 *  Benim Takip ettğim kişileri bulmak için
 *  select * from tblfollow where userid=?
 *  Beni Takip eden kişileri bulmak için
 *  select * from tblfollow where followingid=?
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tblfollow")
public class Follow extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * Takip eden Kişi ID si dir.
     */
    Long followerid; // Takip eden kişi
    /**
     * Takip edilen Kişinin ID si dir.
     */
    Long followingid; // Takip edilen kişinin id si
}
