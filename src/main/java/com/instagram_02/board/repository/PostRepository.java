package com.instagram_02.board.repository;

import com.instagram_02.board.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
