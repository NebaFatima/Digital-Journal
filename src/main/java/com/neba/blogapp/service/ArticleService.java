package com.neba.blogapp.service;

import com.neba.blogapp.model.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    private final List<Article> articles = new ArrayList<>();

    public List<Article> getAllArticles() {
        return articles;
    }

    public void addArticle(Article article) {
        articles.add(article);
    }
    public void deleteArticle(Long id) {
        articles.removeIf(article -> article.getId().equals(id));
    }
}