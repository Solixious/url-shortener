package com.urlshortener.model.entity;

import com.urlshortener.UrlShortenerUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ShortUrlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private Long id;

    private String urlKey;

    private String urlOriginal;

    public void setId(final Long id) {
        this.id = id;
        this.urlKey = UrlShortenerUtil.getKey(this.id);
    }
}
