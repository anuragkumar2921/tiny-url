package com.savio.tinyurl.service;

import com.savio.tinyurl.dto.UrlResponseDto;

/**
 * Created by anurag on 17/2/21.
 */
public interface UrlService {
    UrlResponseDto generateTinyUrl(String inputUrl);

    String fetchOriginalUrl(String key);
}
