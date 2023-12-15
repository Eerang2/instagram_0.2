package com.instagram_02.board.service;

import com.instagram_02.board.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private EntityManager em;

    @DisplayName("게시판_전제조회_테스트")
    @Transactional
    @Test
    public void 게시판_전체조회_테스트() {
        // given
        Post post = Post.builder()
                .userId("00001")
                .content("test")
                .title("test")
                .build();

        em.persist(post);
        em.flush();
        em.clear();

        System.out.println(post);
        // when
        List<Post> posts = postService.findAll();

        // then
        assertNotNull(posts);
        assertFalse(posts.isEmpty());
    }
}
