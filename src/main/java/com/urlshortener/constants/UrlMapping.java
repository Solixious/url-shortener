package com.urlshortener.constants;

public interface UrlMapping {
    String SHORTEN = "/api/shorten";
    String GET_ORIGINAL = "/api/{key}";
    String REDIRECT = "/{key}";
}
