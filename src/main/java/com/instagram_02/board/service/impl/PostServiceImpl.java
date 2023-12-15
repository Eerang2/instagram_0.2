package com.instagram_02.board.service.impl;

import com.instagram_02.board.entity.Post;
import com.instagram_02.board.repository.PostRepository;
import com.instagram_02.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public void update(Long id, Post post) {
        postRepository.findById(id).orElseThrow(RuntimeException::new);
        postRepository.save(post.changePostId(id));
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
