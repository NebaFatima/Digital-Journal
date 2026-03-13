package com.neba.blogapp.controller;

import com.neba.blogapp.model.Article;
import com.neba.blogapp.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("articles", articleService.getAllArticles());
        return "index";
    }

    @PostMapping("/add")
    public String addArticle(@RequestParam String title,
                             @RequestParam String content) {

        articleService.addArticle(new Article(
                System.currentTimeMillis(),
                title,
                content
        ));

        return "redirect:/";
    }
    @PostMapping("/delete/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return "redirect:/";
    }
}