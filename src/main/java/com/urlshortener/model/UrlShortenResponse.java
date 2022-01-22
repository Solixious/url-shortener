package com.urlshortener.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UrlShortenResponse {

    private String shortUrl;
    private String errorCode;
}
