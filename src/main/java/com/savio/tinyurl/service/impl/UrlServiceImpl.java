package com.savio.tinyurl.service.impl;

import com.google.common.hash.Hashing;
import com.savio.tinyurl.dto.UrlResponseDto;
import com.savio.tinyurl.entity.Url;
import com.savio.tinyurl.repository.UrlRepository;
import com.savio.tinyurl.service.UrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * Created by anurag on 17/2/21.
 */
@Service
@Slf4j
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlRepository urlRepository;

    @Override
    public UrlResponseDto generateTinyUrl(String inputUrl) {
        Date currentDate = new Date();
        String encodedUrl = encodeUrl(inputUrl);
        Url url = urlRepository.save(mapToUrl(inputUrl, encodedUrl, currentDate));
        return new UrlResponseDto(url.getOriginalUrl(), url.getTinyUrl());
    }

    @Override
    public String fetchOriginalUrl(String key) {
        Url url = urlRepository.findByTinyUrl(key)
                .orElseThrow(() -> new EntityNotFoundException("No Long url found for the tiny url : " + key));
        return url.getOriginalUrl();
    }

    private String encodeUrl(String longUrl)
    {
        return Hashing.murmur3_32()
                .hashString(longUrl, StandardCharsets.UTF_8)
                .toString();
    }

    private Url mapToUrl(String inputUrl, String encodedUrl, Date date) {
        return Url.builder()
                .tinyUrl(encodedUrl)
                .originalUrl(inputUrl)
                .createdDate(date)
                .updatedDate(date)
                .build();
    }


}
