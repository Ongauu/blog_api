package com.crimson.blog.controller;

import com.crimson.blog.dto.ArticleListItemResponse;
import com.crimson.blog.dto.ArticleRequest;
import com.crimson.blog.dto.ArticleResponse;
import com.crimson.blog.service.ArticleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/articles")
public class AdminArticleController {
    private final ArticleService articleService;

    public AdminArticleController(ArticleService articleService){
        this.articleService = articleService;
    }

    @GetMapping
    public List<ArticleListItemResponse> getAllArticles(){
        return articleService.getAllArticles();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ArticleResponse createArticle(@Valid @RequestBody ArticleRequest request){
        return articleService.createArticle(request);
    }

    @PutMapping("/{id}")
    public ArticleResponse updateArticle(@PathVariable Long id,
                                         @Valid @RequestBody ArticleRequest request){
        return articleService.updateArticle(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArticle(@PathVariable Long id){
        articleService.deleteArticle(id);
    }
}
