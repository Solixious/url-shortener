package com.urlshortener.service;

import com.urlshortener.model.entity.ShortUrlEntity;
import com.urlshortener.repository.UrlShortenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlShortenerService {

    @Autowired
    private UrlShortenerRepository repository;

    public String getShortUrl(final String url) {
        ShortUrlEntity entity = ShortUrlEntity.builder().urlOriginal(url).build();
        repository.save(entity);
        return entity.getUrlKey();
    }

    public String getRedirectUrl(final String key) {
        ShortUrlEntity entity = repository.findByUrlKey(key).orElseThrow();
        return entity.getUrlOriginal();
    }
}
