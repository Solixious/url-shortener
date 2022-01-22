package com.urlshortener.service;

public class UrlShortenerUtil {

    private static final char[] CHAR_SET =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private static final Long OFFSET = 1_000_000_000L;

    public static String getKey(final Long id) {
        StringBuilder sb = new StringBuilder();
        long num = OFFSET + id;
        int length = CHAR_SET.length;
        while(num > 0) {
            int rem = (int)(num % length);
            num = num / length;
            sb.append(CHAR_SET[rem]);
        }
        return sb.toString();
    }
}
