package com.urlshortener.repository;

import com.urlshortener.model.entity.ShortUrlEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlShortenerRepository extends CrudRepository<ShortUrlEntity, Long> {

    Optional<ShortUrlEntity> findByUrlKey(String urlKey);
}
