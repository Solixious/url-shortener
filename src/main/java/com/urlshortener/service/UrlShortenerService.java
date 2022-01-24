package com.urlshortener.service;

import com.urlshortener.model.entity.ShortUrlEntity;
import com.urlshortener.repository.UrlShortenerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;

@Service
@Slf4j
public class UrlShortenerService {

    @Autowired
    private UrlShortenerRepository repository;

    @Autowired
    private EnvUtil envUtil;

    public String getShortUrl(final String url) throws Exception {
        try {
            ShortUrlEntity entity = ShortUrlEntity.builder().urlOriginal(url).build();
            repository.save(entity);
            return envUtil.getServerUrlPrefix() + "api/" +entity.getUrlKey();
        } catch (UnknownHostException e) {
            log.error("An error occurred while retrieving hostname.", e);
            throw e;
        }
    }

    public String getRedirectUrl(final String key) {
        ShortUrlEntity entity = repository.findByUrlKey(key).orElseThrow();
        return entity.getUrlOriginal();
    }
}
