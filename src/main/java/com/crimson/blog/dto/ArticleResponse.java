package com.crimson.blog.dto;

import com.crimson.blog.model.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class ArticleResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDate publicationDate;
    private LocalDateTime createdAt;

    public static ArticleResponse fromEntity(Article article){
        return ArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .publicationDate(article.getPublicationDate())
                .createdAt(article.getCreatedAt())
                .build();
    }
}
