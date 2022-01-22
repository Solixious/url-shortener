package com.urlshortener.controller;

import com.urlshortener.service.UrlShortenerService;
import com.urlshortener.constants.UrlMapping;
import com.urlshortener.model.RedirectUrlResponse;
import com.urlshortener.model.UrlShortenRequest;
import com.urlshortener.model.UrlShortenResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UrlShortenerController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @PostMapping(UrlMapping.SHORTEN)
    public UrlShortenResponse shortenUrl(@RequestBody final UrlShortenRequest request) {
        try {
            return UrlShortenResponse.builder().shortUrl(urlShortenerService.getShortUrl(request.getUrl())).build();
        } catch (Exception e) {
            log.error("An exception occurred while shortening url.", e);
            return UrlShortenResponse.builder().errorCode("URL_SHORTENER_ERROR").build();
        }
    }

    @GetMapping(UrlMapping.REDIRECT)
    public RedirectUrlResponse redirectUrl(@PathVariable final String key) {
        try {
            return RedirectUrlResponse.builder().redirectUrl(urlShortenerService.getRedirectUrl(key)).build();
        } catch (Exception e) {
            log.error("An exception occurred while fetching redirect url.", e);
            return RedirectUrlResponse.builder().errorCode("URL_REDIRECT_ERROR").build();
        }
    }
}
