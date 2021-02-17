package com.savio.tinyurl.repository;

import com.savio.tinyurl.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by anurag on 17/2/21.
 */
@Repository
public interface UrlRepository extends JpaRepository<Url,Long> {
    Optional<Url> findByTinyUrl(String tinyUrl);
}
