package com.instagram_02.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "user_id", length = 20, nullable = false)
    private String userId;


    public Post changePostId(Long postId) {
        this.id = postId;
        return this;
    }


    //CREATE TABLE POSTS
    //(
    //    ID      BIGINT AUTO_INCREMENT
    //        PRIMARY KEY,
    //    TITLE   VARCHAR(255) NOT NULL,
    //    CONTENT TEXT         NOT NULL,
    //    USER_ID VARCHAR(20)  NOT NULL
    //);
}

