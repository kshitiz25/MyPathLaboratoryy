package com.News.CountryInfo.Services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {

    @Value("${newsapi.url}")
    private String newsApiUrl;

    @Value("${newsapi.url1}")
    private String newsApiUrl1;

    @Value("${newsapi.url2}")
    private String newsApiUrl2;

    @Value("${newsapi.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public NewsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getTopHeadlines() {
        String url = String.format("%s", newsApiUrl);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }
    public String getTopHeadlines1() {
        String url = String.format("%s", newsApiUrl1);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }

    public String getTopHeadlines2() {
        String url = String.format("%s", newsApiUrl2);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }

}

