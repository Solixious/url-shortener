package com.urlshortener.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RedirectUrlResponse {

    private String redirectUrl;
    private String errorCode;
}
