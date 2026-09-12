package com.crimson.blog.dto;

import com.crimson.blog.model.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ArticleListItemResponse {
    private Long id;
    private String title;
    private String excerpt;
    private LocalDate publicationDate;

    private static final int EXCERPT_LENGTH = 220;

    public static ArticleListItemResponse fromEntity(Article article){
        String content = article.getContent() == null ? "" : article.getContent().trim();
        String excerpt = content.length() > EXCERPT_LENGTH ? content.substring(0, EXCERPT_LENGTH).trim() + "..." : content;

        return ArticleListItemResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .excerpt(excerpt)
                .publicationDate(article.getPublicationDate())
                .build();
    }
}
