//package com.News.CountryInfo.Services;
//
//import com.News.CountryInfo.Article;
//import com.News.CountryInfo.Repository.ArticleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ArticleService {
//    @Autowired
//    private ArticleRepository articleRepository;
//
//    public List<Article> getAllArticles() {
//        return articleRepository.findAll();
//    }
//
//    public Article getArticleById(Long id) {
//        return articleRepository.findById(id).orElse(null);
//    }
//
//    public void saveArticle(Article article) {
//        articleRepository.save(article);
//    }
//
//    public void deleteArticle(Long id) {
//        articleRepository.deleteById(id);
//    }
//}
