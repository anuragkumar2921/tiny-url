package com.savio.tinyurl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by anurag on 17/2/21.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto {
    private String errorCode;
    private String message;
}
