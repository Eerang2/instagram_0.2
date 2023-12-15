package com.instagram_02.board.command;

import com.instagram_02.board.entity.Post;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostCommand {
    private String title;
    private String content;
    private String userId;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .userId(userId)
                .build();
    }
}
