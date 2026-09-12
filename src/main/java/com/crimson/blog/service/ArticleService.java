package com.crimson.blog.service;

import com.crimson.blog.dto.ArticleListItemResponse;
import com.crimson.blog.dto.ArticleRequest;
import com.crimson.blog.dto.ArticleResponse;
import com.crimson.blog.exception.ResourceNotFoundException;
import com.crimson.blog.model.Article;
import com.crimson.blog.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    public List<ArticleListItemResponse> getAllArticles(){
        return articleRepository.findAllByOrderByPublicationDateDescIdDesc().stream()
                .map(ArticleListItemResponse::fromEntity)
                .toList();
    }

    public ArticleResponse createArticle(ArticleRequest request){
        Article article = Article.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .publicationDate(request.getPublicationDate())
                .build();

        return ArticleResponse.fromEntity(articleRepository.save(article));
    }

    public ArticleResponse getArticleById(Long id){
        return ArticleResponse.fromEntity(findOrThrow(id));
    }

    public ArticleResponse updateArticle(Long id, ArticleRequest request){
        Article article = findOrThrow(id);

        article.setTitle(request.getTitle());

        article.setContent(request.getContent());

        article.setPublicationDate(request.getPublicationDate());

        return ArticleResponse.fromEntity(articleRepository.save(article));
    }

    public void deleteArticle(Long id){
        Article article = findOrThrow(id);

        articleRepository.delete(article);
    }

    private Article findOrThrow(Long id){
        return articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article not found with id " + id));
    }
}
