package com.instagram_02.board.service;

import com.instagram_02.board.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    void update(Long id, Post post);

    Post findById(Long id);

    void save(Post post);

    void deleteById(Long id);
}
