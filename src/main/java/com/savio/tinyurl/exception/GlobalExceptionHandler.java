package com.savio.tinyurl.exception;

import com.savio.tinyurl.dto.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

/**
 * Created by anurag on 17/2/21.
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private static final String ENTITY_NOT_FOUND = "ENTITY_NOT_FOUND";

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleEntityNotFoundException(EntityNotFoundException ex) {
        log.error("EntityNotFoundException: {}", ex.getMessage(), ex);
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ENTITY_NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }
}
