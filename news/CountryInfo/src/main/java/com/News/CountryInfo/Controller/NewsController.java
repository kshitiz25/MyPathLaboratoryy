package com.News.CountryInfo.Controller;

import com.News.CountryInfo.Services.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/headlines")
    public String getTopHeadlines() {
        return newsService.getTopHeadlines();
    }
    @GetMapping("/headlines1")
    public String getTopHeadlines1() {
        return newsService.getTopHeadlines1();
    }
    @GetMapping("/headlines2")
    public String getTopHeadlines2() {
        return newsService.getTopHeadlines2();
    }
}


