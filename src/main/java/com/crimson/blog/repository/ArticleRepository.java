package com.crimson.blog.repository;

import com.crimson.blog.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByOrderByPublicationDateDescIdDesc();
}
