package com.savio.tinyurl.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by anurag on 17/2/21.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UrlResponseDto {
    private String originalUrl;
    private String tinyUrl;
}
