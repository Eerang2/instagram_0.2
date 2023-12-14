package com.instagram_02.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "user_id")
    private String userId;

    @Column(nullable = false, name = "title")
    private String title;

    @Column(nullable = false, name = "content")
    private String content;




}
