package com.instagram_02.board.service;

import com.instagram_02.board.entity.Post;
import com.instagram_02.board.repository.PostRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    EntityManager em;
    @Autowired
    private PostRepository postRepository;

    @Test
    @DisplayName("게시판_전제조회_테스트")
    public void 게시판_전제조회_테스트 () {
        // given
        Post post = Post.builder()
                .id(1L)
                .title("미안해, 감독을 못해서 미안해")
                .content("챔스 조별 4위")
                .userId("Erik ten Hag")
                .build();


        postService.save(post);

        // when
        List<Post> posts = postService.findAll();

        // then
        assertNotNull(posts);
        assertFalse(posts.isEmpty());
    }

}
