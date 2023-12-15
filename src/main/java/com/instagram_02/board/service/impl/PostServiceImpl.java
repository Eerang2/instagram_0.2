package com.instagram_02.board.service.impl;

import com.instagram_02.board.entity.Post;
import com.instagram_02.board.repository.PostRepository;
import com.instagram_02.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public void update(Long id, Post post) {
        postRepository.findById(id).orElseThrow(RuntimeException::new);
        postRepository.save(post.changePostId(id));
    }
}
